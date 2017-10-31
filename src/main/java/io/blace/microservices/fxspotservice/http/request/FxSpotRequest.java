package io.blace.microservices.fxspotservice.http.request;

import java.util.Date;

public class FxSpotRequest {

	private Date date;
	private String ccypair;
	private String ccy;
	
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
	
	public String getCcy() {
		return ccy;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	@Override
	public String toString() {
		return "FxSpotRequest [date=" + date + ", ccypair=" + ccypair + ", ccy=" + ccy + "]";
	}
	
}
