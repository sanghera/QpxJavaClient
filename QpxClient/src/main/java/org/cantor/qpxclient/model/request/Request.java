package org.cantor.qpxclient.model.request;

import java.util.ArrayList;
import java.util.List;

public class Request {

	private Passengers passengers;
	private List<Slice> slice = new ArrayList<>();
	private String maxPrice;
	private String saleCountry;
	private boolean refundable;
	private Integer solutions;

	public Passengers getPassengers() {
		return passengers;
	}

	public void setPassengers(Passengers passengers) {
		this.passengers = passengers;
	}

	public List<Slice> getSlice() {
		return slice;
	}

	public void addSlice(Slice slice) {
		this.slice.add(slice);
	}

	public void setSlice(List<Slice> slice) {
		this.slice = slice;
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

	public Integer getSolutions() {
		return solutions;
	}

	public void setSolutions(Integer solutions) {
		this.solutions = solutions;
	}
}
