package com.aftership.service;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.aftership.models.TrackRoot;
import com.aftership.models.Tracking;

@Service
@Validated
public interface AfterShipService {
	public ResponseEntity<?> createTracking(@Valid TrackRoot json) throws IOException ;
	public ResponseEntity<?> getTracker(String slug,String trackingNumber) throws IOException; 

}
