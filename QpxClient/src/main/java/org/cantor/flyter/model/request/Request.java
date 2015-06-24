package org.cantor.flyter.model.request;

import java.util.List;

public class Request {

	private Passengers passengers;
	private List<Slice> slices;
	private String maxPrice;
	private String saleCountry;
	private boolean refundable;
	private int solutions;

	public Passengers getPassengers() {
		return passengers;
	}

	public void setPassengers(Passengers passengers) {
		this.passengers = passengers;
	}

	public List<Slice> getSlices() {
		return slices;
	}

	public void setSlices(List<Slice> slices) {
		this.slices = slices;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getSaleCountry() {
		return saleCountry;
	}

	public void setSaleCountry(String saleCountry) {
		this.saleCountry = saleCountry;
	}

	public boolean isRefundable() {
		return refundable;
	}

	public void setRefundable(boolean refundable) {
		this.refundable = refundable;
	}

	public int getSolutions() {
		return solutions;
	}

	public void setSolutions(int solutions) {
		this.solutions = solutions;
	}
}
