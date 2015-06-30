package org.cantor.flyter.model.response.trips.tripoption.slice;

import java.util.List;

public class Slice {

	private String kind;
	private Integer duration;
	private List<Segment> segment;

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

	public List<Segment> getSegment() {
		return segment;
	}

	public void setSegment(List<Segment> segment) {
		this.segment = segment;
	}
}
