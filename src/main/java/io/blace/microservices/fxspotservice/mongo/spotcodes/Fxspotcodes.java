package io.blace.microservices.fxspotservice.mongo.spotcodes;

import org.springframework.data.annotation.Id;

public class Fxspotcodes {

	@Id
	public String id;
	
	private String pair;
	private String source;
	private String code;
	private String url;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPair() {
		return pair;
	}
	public void setPair(String pair) {
		this.pair = pair;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Fxspotcodes [id=" + id + ", pair=" + pair + ", source=" + source + ", code=" + code + ", url=" + url
				+ "]";
	}
	
	
}
