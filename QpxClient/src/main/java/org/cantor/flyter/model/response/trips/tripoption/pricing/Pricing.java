package org.cantor.flyter.model.response.trips.tripoption.pricing;

import org.cantor.flyter.model.request.Passengers;

import java.util.List;

public class Pricing {

	private String kind;
	private List<Fare> fare;
	private List<SegmentPricing> segmentPricing;
	private String baseFareTotal;
	private String saleFareTotal;
	private String saleTaxTotal;
	private String saleTotal;
	private Passengers passengers;
	private List<Tax> tax;
	private String fareCalculation;
	private String latestTicketingTime;
	private String ptc;
	private boolean refundable;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public List<Fare> getFare() {
		return fare;
	}

	public void setFare(List<Fare> fare) {
		this.fare = fare;
	}

	public List<SegmentPricing> getSegmentPricing() {
		return segmentPricing;
	}

	public void setSegmentPricing(List<SegmentPricing> segmentPricing) {
		this.segmentPricing = segmentPricing;
	}

	public String getBaseFareTotal() {
		return baseFareTotal;
	}

	public void setBaseFareTotal(String baseFareTotal) {
		this.baseFareTotal = baseFareTotal;
	}

	public String getSaleFareTotal() {
		return saleFareTotal;
	}

	public void setSaleFareTotal(String saleFareTotal) {
		this.saleFareTotal = saleFareTotal;
	}

	public String getSaleTaxTotal() {
		return saleTaxTotal;
	}

	public void setSaleTaxTotal(String saleTaxTotal) {
		this.saleTaxTotal = saleTaxTotal;
	}

	public String getSaleTotal() {
		return saleTotal;
	}

	public void setSaleTotal(String saleTotal) {
		this.saleTotal = saleTotal;
	}

	public Passengers getPassengers() {
		return passengers;
	}

	public void setPassengers(Passengers passengers) {
		this.passengers = passengers;
	}

	public List<Tax> getTax() {
		return tax;
	}

	public void setTax(List<Tax> tax) {
		this.tax = tax;
	}

	public String getFareCalculation() {
		return fareCalculation;
	}

	public void setFareCalculation(String fareCalculation) {
		this.fareCalculation = fareCalculation;
	}

	public String getLatestTicketingTime() {
		return latestTicketingTime;
	}

	public void setLatestTicketingTime(String latestTicketingTime) {
		this.latestTicketingTime = latestTicketingTime;
	}

	public String getPtc() {
		return ptc;
	}

	public void setPtc(String ptc) {
		this.ptc = ptc;
	}

	public boolean isRefundable() {
		return refundable;
	}

	public void setRefundable(boolean refundable) {
		this.refundable = refundable;
	}
}
