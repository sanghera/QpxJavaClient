package org.cantor.flyter.model.response.trips.tripoption.slice;

public class Leg {

	private String king;
	private String id;
	private String aircraft;
	private String arrivalTime;
	private String departureTime;
	private String origin;
	private String destination;
	private String originTerminal;
	private String destinationTerminal;
	private Integer duration;
	private String operatingDisclosure;
	private Integer onTimePerformance;
	private Integer mileage;
	private String meal;
	private boolean secure;
	private Integer connectionDuration;
	private boolean changePlane;

	public String getKing() {
		return king;
	}

	public void setKing(String king) {
		this.king = king;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAircraft() {
		return aircraft;
	}

	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getOriginTerminal() {
		return originTerminal;
	}

	public void setOriginTerminal(String originTerminal) {
		this.originTerminal = originTerminal;
	}

	public String getDestinationTerminal() {
		return destinationTerminal;
	}

	public void setDestinationTerminal(String destinationTerminal) {
		this.destinationTerminal = destinationTerminal;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getOperatingDisclosure() {
		return operatingDisclosure;
	}

	public void setOperatingDisclosure(String operatingDisclosure) {
		this.operatingDisclosure = operatingDisclosure;
	}

	public Integer getOnTimePerformance() {
		return onTimePerformance;
	}

	public void setOnTimePerformance(Integer onTimePerformance) {
		this.onTimePerformance = onTimePerformance;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public boolean isSecure() {
		return secure;
	}

	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	public Integer getConnectionDuration() {
		return connectionDuration;
	}

	public void setConnectionDuration(Integer connectionDuration) {
		this.connectionDuration = connectionDuration;
	}

	public boolean isChangePlane() {
		return changePlane;
	}

	public void setChangePlane(boolean changePlane) {
		this.changePlane = changePlane;
	}
}
