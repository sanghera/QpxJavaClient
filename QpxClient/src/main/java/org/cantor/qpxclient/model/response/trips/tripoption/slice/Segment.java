package org.cantor.qpxclient.model.response.trips.tripoption.slice;

import java.util.List;

public class Segment {

	private String kind;
	private Integer duration;
	private Flight flight;
	private String id;
	private String cabin;
	private String bookingCode;
	private String bookingCodeCount;
	private String marriedSegmentGroup;
	private List<Leg> leg;
	private Integer connectionDuration;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCabin() {
		return cabin;
	}

	public void setCabin(String cabin) {
		this.cabin = cabin;
	}

	public String getBookingCode() {
		return bookingCode;
	}

	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}

	public String getBookingCodeCount() {
		return bookingCodeCount;
	}

	public void setBookingCodeCount(String bookingCodeCount) {
		this.bookingCodeCount = bookingCodeCount;
	}

	public String getMarriedSegmentGroup() {
		return marriedSegmentGroup;
	}

	public void setMarriedSegmentGroup(String marriedSegmentGroup) {
		this.marriedSegmentGroup = marriedSegmentGroup;
	}

	public List<Leg> getLeg() {
		return leg;
	}

	public void setLeg(List<Leg> leg) {
		this.leg = leg;
	}

	public Integer getConnectionDuration() {
		return connectionDuration;
	}

	public void setConnectionDuration(Integer connectionDuration) {
		this.connectionDuration = connectionDuration;
	}
}
