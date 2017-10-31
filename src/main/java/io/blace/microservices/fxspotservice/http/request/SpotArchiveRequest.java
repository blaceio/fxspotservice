package io.blace.microservices.fxspotservice.http.request;

import org.threeten.bp.LocalDate;

public class SpotArchiveRequest {

	private LocalDate start;
	private LocalDate end;
	private String pair;
	private String source;
	private String code;
	private String url;
	
	public LocalDate getStart() {
		return start;
	}
	public void setStart(LocalDate start) {
		this.start = start;
	}
	public LocalDate getEnd() {
		return end;
	}
	public void setEnd(LocalDate end) {
		this.end = end;
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
		return "SpotArchiveRequest [start=" + start + ", end=" + end + ", pair=" + pair + ", source=" + source
				+ ", code=" + code + ", url=" + url + "]";
	}
	
}
