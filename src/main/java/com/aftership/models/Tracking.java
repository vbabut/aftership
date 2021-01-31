package com.aftership.models;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Tracking{
	 public String slug;
	 
	 @NotEmpty(message="tracking_number cannot be missing or empty")
	 @Size(min=4,max=100,message="tracking_number must be between 4 to 100 characters")
	 private String tracking_number;
	 private String title;
	 public List<String> smses;
	 public List<String> emails;
	 public String order_id;
	 public String order_id_path;
	 @JsonProperty("CustomFields") 
	 public CustomFields custom_fields;
	 public String language;
	 public String order_promised_delivery_date;
	 public String delivery_type;
	 public String pickup_location;
	 public String pickup_note;
	 public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getTracking_number() {
		return tracking_number;
	}
	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getSmses() {
		return smses;
	}
	public void setSmses(List<String> smses) {
		this.smses = smses;
	}
	public List<String> getEmails() {
		return emails;
	}
	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getOrder_id_path() {
		return order_id_path;
	}
	public void setOrder_id_path(String order_id_path) {
		this.order_id_path = order_id_path;
	}
	public CustomFields getCustom_fields() {
		return custom_fields;
	}
	public void setCustom_fields(CustomFields custom_fields) {
		this.custom_fields = custom_fields;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getOrder_promised_delivery_date() {
		return order_promised_delivery_date;
	}
	public void setOrder_promised_delivery_date(String order_promised_delivery_date) {
		this.order_promised_delivery_date = order_promised_delivery_date;
	}
	public String getDelivery_type() {
		return delivery_type;
	}
	public void setDelivery_type(String delivery_type) {
		this.delivery_type = delivery_type;
	}
	public String getPickup_location() {
		return pickup_location;
	}
	public void setPickup_location(String pickup_location) {
		this.pickup_location = pickup_location;
	}
	public String getPickup_note() {
		return pickup_note;
	}
	public void setPickup_note(String pickup_note) {
		this.pickup_note = pickup_note;
	}
	
}