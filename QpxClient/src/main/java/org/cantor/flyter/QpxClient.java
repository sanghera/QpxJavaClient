package org.cantor.flyter;

import com.google.gson.Gson;
import org.cantor.flyter.exceptions.QpxBadRequestException;
import org.cantor.flyter.exceptions.QpxCommunicationException;
import org.cantor.flyter.exceptions.QpxUnexpectedInteractionException;
import org.cantor.flyter.model.request.QpxRequestForm;
import org.cantor.flyter.model.response.QpxResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.*;

public class QpxClient {

	private final Client restClient;
	private final String apiKey;
	private final String endpointURL;
	private final QpxResponseParser qpxResponseParser;

	public QpxClient(Client restClient, Properties properties, QpxResponseParser qpxResponseParser) {
		this.restClient = restClient;
		this.apiKey = properties.getProperty("api_key");
		this.endpointURL = properties.getProperty("endpoint_url");
		this.qpxResponseParser = qpxResponseParser;
	}

	public Collection<QpxResponse> fetchData(QpxRequestForm requestForm) {
		Invocation.Builder request = this.createRequest();

		Gson gson = new Gson();
		String json = gson.toJson(requestForm);

		List<QpxResponse> tripsFound = new ArrayList<>();

		Response response = request.post(Entity.entity(json, MediaType.APPLICATION_JSON_TYPE));

		if (response.getStatus() == Status.OK.getStatusCode()) {
			Collection<QpxResponse> tripDtos = this.qpxResponseParser.parseResponse(response);
			tripDtos.forEach(tripsFound::add);
		}
		else {
			return handleErrorStatus(response);
		}


		return Collections.unmodifiableCollection(tripsFound);
	}

	private List<QpxResponse> handleErrorStatus(Response response) {
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

	private Invocation.Builder createRequest() {
		Invocation.Builder request = restClient.target(endpointURL)
											   .path("search")
											   .queryParam("key", apiKey)
											   .request()
											   .accept(MediaType.APPLICATION_JSON_TYPE);
		return request;
	}
}
