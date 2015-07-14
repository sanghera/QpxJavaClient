package org.cantor.qpxclient.model.response.trips;

import org.cantor.qpxclient.model.response.trips.data.Data;
import org.cantor.qpxclient.model.response.trips.tripoption.TripOption;

import java.util.List;

public class Trips {

	private String kind;
	private String requestId;
	private Data data;
	private List<TripOption> tripOption;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public List<TripOption> getTripOption() {
		return tripOption;
	}

	public void setTripOption(List<TripOption> tripOption) {
		this.tripOption = tripOption;
	}
}
