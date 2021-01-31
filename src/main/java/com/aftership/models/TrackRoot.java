package com.aftership.models;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrackRoot{
	@Valid
	@NotNull
	@JsonProperty("Tracking") 
 public Tracking tracking;

	public Tracking getTracking() {
		return tracking;
	}

	public void setTracking(Tracking tracking) {
		this.tracking = tracking;
	}
}

