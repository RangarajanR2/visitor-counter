package org.springframework.visitor_counter.repository;

public class Visitor {
	

	private String ip;
	private String useragent;
	
	public Visitor(String ip, String useragent) {
		this.ip = ip;
		this.useragent = useragent;
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUseragent() {
		return useragent;
	}
	public void setUseragent(String useragent) {
		this.useragent = useragent;
	}
	
	
}
