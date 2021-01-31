package com.aftership;

import java.io.IOException;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aftership.models.TrackRoot;
import com.aftership.models.Tracking;
import com.aftership.service.AfterShipService;

@RestController
@RequestMapping(path="/tracker")
@Validated
public class AfterShipController {
	static Logger log = Logger.getLogger(AfterShipController.class);

	
	@Autowired
	private AfterShipService afterShipService;
	
	   @GetMapping(path = "/getTracker/{slug}/{trackingNumber}")
	   @CrossOrigin
	   public ResponseEntity<?> getTracker(@PathVariable("slug") @NotNull String slug,@PathVariable String trackingNumber) {
		 HttpHeaders headers = new HttpHeaders();
		
		 try {
			 
				log.info("AfterShipController getTracker started");	
				return afterShipService.getTracker(slug, trackingNumber);
			} catch (IOException e) {
				headers.add("Message", e.getMessage());
				log.error("IOException occured while processing getTracker: "+e.getMessage());
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Internal server error");
			}
			catch (Exception e) {
				headers.add("Message", e.getMessage());
				log.error("Exception occured while processing getTracker: "+e.getMessage());
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Internal server error");
			}
	 		
	    }
		//@PostMapping(path = "/postTracking")
		@PostMapping(path = "/postTracking",produces ={ MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
		@CrossOrigin
		public ResponseEntity<?> createTracking(@Valid @org.springframework.web.bind.annotation.RequestBody TrackRoot tracking) {
//		public ResponseEntity<?> createTracking(@org.springframework.web.bind.annotation.RequestBody String json) {
			 HttpHeaders headers = new HttpHeaders();

			try {
				log.info("postTracking controller started");	
				return afterShipService.createTracking(tracking);
							
			} catch (IOException e) {
				headers.add("Message", e.getMessage());
				log.error("IOException occured while processing posttracking: "+e.getMessage());
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Internal server error");
			}
			catch (Exception e) {
				headers.add("Message", e.getMessage());
				log.error("Exception occured while processing posttracking: "+e.getMessage());
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Internal server error");
			}
		
			
		}

}