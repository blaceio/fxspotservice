package io.blace.microservices.fxspotservice.mongo.fxspot;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class FxSpot {

	@Id
	public String id;
	
	private Date date;
	private Date lastupdated;
	private double rate;
	private String pair;
	private String base;
	private String risk;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getLastupdated() {
		return lastupdated;
	}
	public void setLastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getPair() {
		return pair;
	}
	public void setPair(String pair) {
		this.pair = pair;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	
	public String getRisk() {
		return risk;
	}
	public void setRisk(String risk) {
		this.risk = risk;
	}
	@Override
	public String toString() {
		return "FxSpot [id=" + id + ", date=" + date + ", lastupdated=" + lastupdated + ", rate=" + rate + ", pair="
				+ pair + ", base=" + base + ", risk=" + risk + "]";
	}
	    	
}
