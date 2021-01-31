package com.aftership.models;

import java.io.File;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
	   public static void main(String args[]) {
	    	
	        try {
	            ObjectMapper om = new ObjectMapper();
	            om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

	            TrackRoot root = om.readValue(new File("test-json.json"), TrackRoot.class);
	            System.out.println(root);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}