package org.cantor.flyter;


public class RoundTripDto {

	private String tripPrice;
	private TripDto goingTrip;
	private TripDto backTrip;

	public void setTripPrice(String tripPrice) {
		this.tripPrice = tripPrice;
	}

	public void setGoingTrip(TripDto goingTrip) {
		this.goingTrip = goingTrip;
	}

	public void setBackTrip(TripDto backTrip) {
		this.backTrip = backTrip;
	}

	public String getPrice() {
		return tripPrice;
	}

	public TripDto getGoingTrip() {
		return goingTrip;
	}

	public TripDto getBackTrip() {
		return backTrip;
	}
}
