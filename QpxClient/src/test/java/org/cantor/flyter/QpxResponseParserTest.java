package org.cantor.flyter;


import org.cantor.flyter.model.response.RoundTripDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.willReturn;

@RunWith(MockitoJUnitRunner.class)
public class QpxResponseParserTest {

	private static final int NUMBER_OF_SOLUTIONS = 3;

	@Mock
	private Response response;

	private String jsonResponse;

	private QpxResponseParser responseParser;


	@Before
	public void setup() {
		responseParser = new QpxResponseParser();
		setupJsonResponse();
	}

	@Test
	public void canParseQpxResponse() {
		List<RoundTripDto> tripDtos = responseParser.parseResponse(jsonResponse);

		assertEquals(NUMBER_OF_SOLUTIONS, tripDtos.size());
	}

	@Test
	public void givenAPremadeSolution_whenParsingTheResponse_thenTheElementsAreTransferedInTheRoundTripDto(){
		List<RoundTripDto> tripDtos = responseParser.parseResponse(jsonResponse);
		RoundTripDto roundTripDto = tripDtos.get(0);

		System.out.println(roundTripDto.getPrice());
		System.out.println(roundTripDto.getGoingTrip().getDepartureTime());
		System.out.println(roundTripDto.getBackTrip().getDepartureTime());

	}

	private void setupJsonResponse() {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classloader.getResourceAsStream("QPX_response_example.json");
		Scanner s = new Scanner(inputStream).useDelimiter("\\A");
		jsonResponse = s.hasNext() ? s.next() : "";

		willReturn(jsonResponse).given(response).readEntity(String.class);
	}


}
