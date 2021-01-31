package com.aftership.service;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aftership.models.TrackRoot;
import com.aftership.models.Tracking;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class AfterShipServiceImpl implements AfterShipService {
	static Logger log = Logger.getLogger(AfterShipServiceImpl.class);
	@Autowired
	private Environment environment;
	
	@Override
	public ResponseEntity<?> createTracking(TrackRoot tracking) throws IOException {
		 HttpHeaders headers = new HttpHeaders();
		 Response response =null;
		log.info("AfterShipServiceImpl createTracking started");	
		log.info("aftership-api-key in AfterShipServiceImpl createTracking:"+environment.getProperty("aftership-api-key"));
		log.info("aftership-api-URL in AfterShipServiceImpl createTracking:"+environment.getProperty("aftership-api-CreateTracking-URL"));
		
		log.info("AfterShipServiceImpl createTracking tracking number:"+tracking.getTracking().getTracking_number());	
		ObjectMapper mapper = new ObjectMapper();
		String newjson = mapper.writeValueAsString(tracking);
		log.info("AfterShipServiceImpl createTracking newjson from java object:"+newjson);	
			OkHttpClient client = new OkHttpClient().newBuilder()
					  .build();
					MediaType mediaType = MediaType.parse("application/json");
					RequestBody body = RequestBody.create(mediaType, newjson);
					Request request = new Request.Builder()
					  .url(environment.getProperty("aftership-api-CreateTracking-URL"))// calling AfterShip API
					  .method("POST", body)
					  .addHeader("aftership-api-key", environment.getProperty("aftership-api-key"))//Passing the API_KEY generated for user acount
					  .addHeader("Content-Type", "application/json")
					  .build();
					response = client.newCall(request).execute();
					log.debug("AfterShipServiceImpl createTracking response:"+response);	
					//Tracking number not found
					if(response.code()==404){
						log.debug("AfterShipServiceImpl createTracking response 404");
						headers.add("Message", response.message());
						return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body("Failed to create tracker details");
					}
					//If every thing is ok
					if(response.code()==200){
						log.debug("AfterShipServiceImpl createTracking response 200");
						headers.add("Message", response.message());
						return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(response.body());
					}
				
					log.info("AfterShipServiceImpl createTracking ends");
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Internal server error");		
	}

	@Override
	public ResponseEntity<?> getTracker(String slug, String trackingNumber) throws IOException {
		 HttpHeaders headers = new HttpHeaders();
		 Response response =null;
		log.info("aftership-api-key in getTracker:"+environment.getProperty("aftership-api-key"));
		log.info("aftership-api-URL in getTracker:"+environment.getProperty("aftership-api-getTracking-URL"));
		log.info("slug in getTracker:"+slug);
		log.info("trackingNumber in getTracker:"+trackingNumber);
		
		OkHttpClient client = new OkHttpClient();
		HttpUrl.Builder urlBuilder = HttpUrl.parse(environment.getProperty("aftership-api-getTracking-URL")).newBuilder();
		urlBuilder.addPathSegment(slug);
		urlBuilder.addPathSegment(trackingNumber);
		String url = urlBuilder.build().toString();

		Request request = new Request.Builder().header("aftership-api-key", environment.getProperty("aftership-api-key"))//Passing the API_KEY generated for user acount
		                     .url(url)
		                     .build();

		 response = client.newCall(request).execute();
		
		log.info("getTracker response:"+response.code());	
		//Tracking number not found
		if(response.code()==404){
			headers.add("Message", response.message());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body("Failed to get tracker details");
		}
		//If every thing is ok
		if(response.code()==200){
			headers.add("Message", response.message());
			return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(response.body());
		}
		log.info("getTracker ends");	
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Internal server error");
	}
}
