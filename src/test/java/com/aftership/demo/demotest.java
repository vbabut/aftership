package com.aftership.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.aftership.models.TrackRoot;
import com.aftership.models.Tracking;

public class demotest extends AbstractTest{
	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	 @Test
	   public void createTracking() throws Exception {
		   String uri = "/postTracking";
		   TrackRoot track = new TrackRoot();
		   Tracking tracking = new Tracking();
		   track.setTracking(tracking);
		   track.getTracking().setTracking_number("123456");
		   
		   String inputJson = mapToJson(track);
		   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		   
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
		   String content = mvcResult.getResponse().getContentAsString();
		   assertEquals(content, "Tracking is created successfully");
	   }
	 
}
