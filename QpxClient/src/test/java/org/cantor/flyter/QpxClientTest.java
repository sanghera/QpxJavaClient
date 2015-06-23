package org.cantor.flyter;

import org.cantor.flyter.exceptions.QpxBadRequestException;
import org.cantor.flyter.exceptions.QpxCommunicationException;
import org.cantor.flyter.exceptions.QpxUnexpectedInteractionException;
import org.cantor.flyter.model.request.QpxRequestForm;
import org.cantor.flyter.model.response.QpxResponse;
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
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

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
	private QpxResponse aTripDto;
	@Mock
	private QpxResponse anotherTripDto;

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

	@Mock
	private QpxResponseParser qpxResponseParser;

	private List<QpxResponse> tripDtos = Arrays.asList(aTripDto, anotherTripDto);
	private final QpxRequestForm requestForm = new QpxRequestForm();

	private QpxClient qpxClient;

	@Before
	public void setup() {
		willReturn(API_KEY).given(properties).getProperty(API_KEY_PROPERTY);
		willReturn(ENDPOINT_URL).given(properties).getProperty(ENDPOINT_URL_PROPERTY);
		willReturn(tripDtos).given(qpxResponseParser).parseResponse(response);
		qpxClient = new QpxClient(client, properties, qpxResponseParser);
		setupWebServiceCall();
	}

	@Test
	public void givenARequestForm_whenFetchingFlightsInfo_thenAnHttpPostIsMadeToTheWebService(){
		setupRequestForm();
		qpxClient.fetchData(requestForm);

		verify(request).post(any(Entity.class));
	}

	@Test(expected = QpxBadRequestException.class)
	public void givenABadRequestResponse_whenTryingToFetchData_thenQpxBadRequestExceptionIsThrown() {
		willReturn(Status.BAD_REQUEST.getStatusCode()).given(response).getStatus();

		qpxClient.fetchData(requestForm);
	}

	@Test(expected = QpxCommunicationException.class)
	public void givenAServerErrorResponseStatus_whenTryingToFetchData_thenQpxCommunicationExceptionIsThrown() {
		willReturn(Status.INTERNAL_SERVER_ERROR.getStatusCode()).given(response).getStatus();

		qpxClient.fetchData(requestForm);
	}

	@Test(expected = QpxUnexpectedInteractionException.class)
	public void givenAnUnexpectedResponseStatus_whenFetchingData_thenQpxUnexpectedExceptionIsThrown() {
		willReturn(Status.NOT_FOUND.getStatusCode()).given(response).getStatus();

		qpxClient.fetchData(requestForm);
	}

	private void setupRequestForm() {
		requestForm.setOrigin("origin");
		requestForm.setDestination("destination");
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