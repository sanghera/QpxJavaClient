package org.cantor.qpxclient;

import org.cantor.qpxclient.model.request.Passengers;
import org.cantor.qpxclient.model.request.QpxRequestForm;
import org.cantor.qpxclient.model.request.Request;
import org.cantor.qpxclient.model.request.Slice;
import org.cantor.qpxclient.model.response.QpxResponse;
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
		qpxClient = new QpxClient(client, properties);
		buildRequestForm();
	}

	@Test
	public void canFetchDataFromQpxApi() throws Exception {
		QpxResponse qpxResponse = qpxClient.fetchData(requestForm);

		System.out.println(qpxResponse.getTrips().getTripOption().get(0).getSaleTotal());
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
