package org.cantor.qpxclient.model.request;

public class PermittedDepartureTime {

	private String kind = "qpxexpress#timeOfDayRange";
	private String earliestTime;
	private String latestTime;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getEarliestTime() {
		return earliestTime;
	}

	public void setEarliestTime(String earliestTime) {
		this.earliestTime = earliestTime;
	}

	public String getLatestTime() {
		return latestTime;
	}

	public void setLatestTime(String latestTime) {
		this.latestTime = latestTime;
	}
}
