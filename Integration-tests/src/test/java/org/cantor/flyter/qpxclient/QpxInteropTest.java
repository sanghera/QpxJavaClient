package org.cantor.flyter.qpxclient;

import org.cantor.flyter.QpxClient;
import org.cantor.flyter.QpxResponseParser;
import org.cantor.flyter.RoundTripDto;
import org.cantor.flyter.model.request.Passengers;
import org.cantor.flyter.model.request.QpxRequestForm;
import org.cantor.flyter.model.request.Request;
import org.cantor.flyter.model.request.Slice;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Ignore
@RunWith(MockitoJUnitRunner.class)
public class QpxInteropTest {

	private static Properties properties;

	private QpxRequestForm requestForm;
	private QpxClient qpxClient;

	@BeforeClass
	public static void setupProperties() throws IOException {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classloader.getResourceAsStream("qpxconfig.properties");
		properties = new Properties();
		properties.load(inputStream);
	}

	@Before
	public void setup() {
		Client client = ClientBuilder.newClient();
		requestForm = new QpxRequestForm();
		qpxClient = new QpxClient(client, properties, new QpxResponseParser());
		buildRequestForm();
	}

	@Test
	public void canFetchDataFromQpxApi() {
		List<RoundTripDto> roundTripDtos = qpxClient.fetchData(requestForm);

		RoundTripDto roundTripDto = roundTripDtos.get(0);


		System.out.println(roundTripDto.getPrice());
	}

	private void buildRequestForm() {
		requestForm.setRequest(new Request());
		requestForm.getRequest().setPassengers(new Passengers());
		requestForm.getRequest().getPassengers().setAdultCount(2);
		List<Slice> slices = new ArrayList<>();
		slices.add(new Slice());
		slices.add(new Slice());
		requestForm.getRequest().setSlice(slices);
		Slice goingSlice = requestForm.getRequest().getSlice().get(0);
		Slice returnSlice = requestForm.getRequest().getSlice().get(1);

		goingSlice.setOrigin("YQB");
		goingSlice.setDestination("DUB");
		goingSlice.setDate("2015-12-22");
		goingSlice.setMaxStops(2);

		returnSlice.setOrigin("DUB");
		returnSlice.setDestination("YQB");
		returnSlice.setDate("2016-01-07");
		returnSlice.setMaxStops(2);

		requestForm.getRequest().setSolutions(1);
	}

}
