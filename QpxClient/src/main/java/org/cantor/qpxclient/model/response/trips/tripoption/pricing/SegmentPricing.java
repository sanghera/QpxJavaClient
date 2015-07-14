package org.cantor.qpxclient.model.response.trips.tripoption.pricing;

import java.util.List;

public class SegmentPricing {

	private String kind;
	private String fareId;
	private String segmentId;
	private List<FreeBaggageOption> freeBaggageOption;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getFareId() {
		return fareId;
	}

	public void setFareId(String fareId) {
		this.fareId = fareId;
	}

	public String getSegmentId() {
		return segmentId;
	}

	public void setSegmentId(String segmentId) {
		this.segmentId = segmentId;
	}

	public List<FreeBaggageOption> getFreeBaggageOption() {
		return freeBaggageOption;
	}

	public void setFreeBaggageOption(List<FreeBaggageOption> freeBaggageOption) {
		this.freeBaggageOption = freeBaggageOption;
	}
}
