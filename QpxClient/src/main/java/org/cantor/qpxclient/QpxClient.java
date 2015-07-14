package org.cantor.qpxclient;

import com.google.gson.Gson;
import org.cantor.qpxclient.exceptions.QpxNoSolutionFoundException;
import org.cantor.qpxclient.exceptions.QpxBadRequestException;
import org.cantor.qpxclient.exceptions.QpxCommunicationException;
import org.cantor.qpxclient.exceptions.QpxUnexpectedInteractionException;
import org.cantor.qpxclient.model.request.QpxRequestForm;
import org.cantor.qpxclient.model.response.QpxResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.Properties;

public class QpxClient {

	private final Client restClient;
	private final String apiKey;
	private final String endpointURL;

	public QpxClient(Client restClient, Properties properties) {
		this.restClient = restClient;
		this.apiKey = properties.getProperty("api_key");
		this.endpointURL = properties.getProperty("endpoint_url");
	}

	public QpxResponse fetchData(QpxRequestForm requestForm)
			throws QpxUnexpectedInteractionException, QpxBadRequestException, QpxCommunicationException, QpxNoSolutionFoundException {

		Invocation.Builder request = this.createRequest();

		Gson gson = new Gson();
		String jsonRequest = gson.toJson(requestForm);

		Response response = request.post(Entity.entity(jsonRequest, MediaType.APPLICATION_JSON_TYPE));

		if (response.getStatus() == Status.OK.getStatusCode()) {
			QpxResponse qpxResponse = gson.fromJson(response.readEntity(String.class), QpxResponse.class);

			handleNoSolutionFound(qpxResponse);

			return qpxResponse;
		}
		else {
			return handleErrorStatus(response);
		}
	}

	private QpxResponse handleErrorStatus(Response response)
			throws QpxBadRequestException, QpxCommunicationException, QpxUnexpectedInteractionException {
		if (response.getStatus() == Status.BAD_REQUEST.getStatusCode()) {
			throw new QpxBadRequestException("Api Key or flight form is invalid");
		}
		else if (response.getStatus() == Status.INTERNAL_SERVER_ERROR.getStatusCode()) {
			throw new QpxCommunicationException("Communication error, unable to fetch data");
		}
		else {
			throw new QpxUnexpectedInteractionException("An unexpected error occurred while interacting with QPX web service");
		}
	}

	private void handleNoSolutionFound(QpxResponse qpxResponse) throws QpxNoSolutionFoundException {
		if (qpxResponse != null && qpxResponse.getTrips() != null && qpxResponse.getTrips()
																				.getData() != null && qpxResponse.getTrips()
																												 .getData()
																												 .getAirport() == null) {
			throw new QpxNoSolutionFoundException("No flight has been found.");

		}
	}

	private Invocation.Builder createRequest() {
		Invocation.Builder request = restClient.target(endpointURL)
											   .path("search")
											   .queryParam("key", apiKey)
											   .request()
											   .accept(MediaType.APPLICATION_JSON_TYPE);
		return request;
	}
}
