package org.cantor.qpxclient;

import org.cantor.qpxclient.exceptions.QpxNoSolutionFoundException;
import org.cantor.qpxclient.exceptions.QpxBadRequestException;
import org.cantor.qpxclient.exceptions.QpxCommunicationException;
import org.cantor.qpxclient.exceptions.QpxUnexpectedInteractionException;
import org.cantor.qpxclient.model.request.QpxRequestForm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class QpxClientTest {

	private static final String ENDPOINT_URL = "http://www.endpoint_url.com";
	private static final String API_KEY = "keyPlz";
	private static final String API_KEY_PROPERTY = "api_key";
	private static final String ENDPOINT_URL_PROPERTY = "endpoint_url";

	@Mock
	private Properties properties;

	@Mock
	private Client client;

	@Mock
	private Invocation.Builder request;

	@Mock
	private WebTarget webTarget;

	@Mock
	private Response response;

	private final QpxRequestForm requestForm = new QpxRequestForm();

	private QpxClient qpxClient;

	@Before
	public void setup() {
		willReturn(API_KEY).given(properties).getProperty(API_KEY_PROPERTY);
		willReturn(ENDPOINT_URL).given(properties).getProperty(ENDPOINT_URL_PROPERTY);
		qpxClient = new QpxClient(client, properties);
		setupWebServiceCall();
	}

	@Test
	public void givenARequestForm_whenFetchingFlightsInfo_thenAnHttpPostIsMadeToTheWebService() throws Exception {
		qpxClient.fetchData(requestForm);

		verify(request).post(any(Entity.class));
	}

	@Test(expected = QpxNoSolutionFoundException.class)
	public void givenANoSolutionsFoundResponse_whenFetchingData_thenNoSolutionFoundException() throws Exception {
		givenClientResponse("NoSolutionsFound.json");

		qpxClient.fetchData(requestForm);
	}

	@Test(expected = QpxBadRequestException.class)
	public void givenABadRequestResponse_whenTryingToFetchData_thenQpxBadRequestExceptionIsThrown() throws Exception {
		willReturn(Status.BAD_REQUEST.getStatusCode()).given(response).getStatus();

		qpxClient.fetchData(requestForm);
	}

	@Test(expected = QpxCommunicationException.class)
	public void givenAServerErrorResponseStatus_whenTryingToFetchData_thenQpxCommunicationExceptionIsThrown() throws Exception {
		willReturn(Status.INTERNAL_SERVER_ERROR.getStatusCode()).given(response).getStatus();

		qpxClient.fetchData(requestForm);
	}

	@Test(expected = QpxUnexpectedInteractionException.class)
	public void givenAnUnexpectedResponseStatus_whenFetchingData_thenQpxUnexpectedExceptionIsThrown() throws Exception {
		willReturn(Status.NOT_FOUND.getStatusCode()).given(response).getStatus();

		qpxClient.fetchData(requestForm);
	}

	private void givenClientResponse(String storedResponsePath) {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classloader.getResourceAsStream(storedResponsePath);
		Scanner s = new Scanner(inputStream).useDelimiter("\\A");
		String jsonExample = s.hasNext() ? s.next() : "";

		willReturn(jsonExample).given(response).readEntity(String.class);
	}

	private void setupWebServiceCall() {
		willReturn(webTarget).given(client).target(ENDPOINT_URL);
		willReturn(webTarget).given(webTarget).path("search");
		willReturn(webTarget).given(webTarget).queryParam("key", API_KEY);
		willReturn(request).given(webTarget).request();
		willReturn(request).given(request).accept(MediaType.APPLICATION_JSON_TYPE);
		willReturn(response).given(request).post(any(Entity.class));
		willReturn(Status.OK.getStatusCode()).given(response).getStatus();
	}

}