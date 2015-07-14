package org.cantor.qpxclient.model.response;

// For more info : https://developers.google.com/qpx-express/v1/trips/search

import org.cantor.qpxclient.model.response.trips.Trips;

public class QpxResponse {

	private String kind;
	private Trips trips;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Trips getTrips() {
		return trips;
	}

	public void setTrips(Trips trips) {
		this.trips = trips;
	}
}
