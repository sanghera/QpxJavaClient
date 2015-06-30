package org.cantor.flyter;

public class TripDto {

	private long durationInHour;
	private String departureTime;
	private int numberOfStops;

	public double getDurationInHour() {
		return durationInHour;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public int getNumberOfStops() {
		return numberOfStops;
	}

	public void setDurationInHour(long durationInHour) {
		this.durationInHour = durationInHour;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public void setNumberOfStops(int numberOfStops) {
		this.numberOfStops = numberOfStops;
	}
}
