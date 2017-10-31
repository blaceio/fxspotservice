package io.blace.microservices.fxspotservice.http.request;

import java.util.Date;

public class FxSpotRequest {

	private Date date;
	private String ccypair;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCcypair() {
		return ccypair;
	}
	public void setCcypair(String ccypair) {
		this.ccypair = ccypair;
	}
	@Override
	public String toString() {
		return "FxSpotRequest [date=" + date + ", ccypair=" + ccypair + "]";
	}
	
}
