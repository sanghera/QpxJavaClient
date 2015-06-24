package org.cantor.flyter.model.request;

import java.util.List;

public class Slice {

	private String kind;
	private String origin;
	private String destination;
	private String date;
	private int maxStops;
	private int maxConnectionDuration;
	private String preferredCabin;
	private PermittedDepartureTime permittedDepartureTime;
	private List<String> permittedCarriers;
	private String alliance;
	private List<String> prohibitedCarriers;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getMaxStops() {
		return maxStops;
	}

	public void setMaxStops(int maxStops) {
		this.maxStops = maxStops;
	}

	public int getMaxConnectionDuration() {
		return maxConnectionDuration;
	}

	public void setMaxConnectionDuration(int maxConnectionDuration) {
		this.maxConnectionDuration = maxConnectionDuration;
	}

	public String getPreferredCabin() {
		return preferredCabin;
	}

	public void setPreferredCabin(String preferredCabin) {
		this.preferredCabin = preferredCabin;
	}

	public PermittedDepartureTime getPermittedDepartureTime() {
		return permittedDepartureTime;
	}

	public void setPermittedDepartureTime(PermittedDepartureTime permittedDepartureTime) {
		this.permittedDepartureTime = permittedDepartureTime;
	}

	public List<String> getPermittedCarriers() {
		return permittedCarriers;
	}

	public void setPermittedCarriers(List<String> permittedCarriers) {
		this.permittedCarriers = permittedCarriers;
	}

	public String getAlliance() {
		return alliance;
	}

	public void setAlliance(String alliance) {
		this.alliance = alliance;
	}

	public List<String> getProhibitedCarriers() {
		return prohibitedCarriers;
	}

	public void setProhibitedCarriers(List<String> prohibitedCarriers) {
		this.prohibitedCarriers = prohibitedCarriers;
	}
}
