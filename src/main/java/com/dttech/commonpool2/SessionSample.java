package com.dttech.commonpool2;

public class SessionSample {
	
	private SessionStatus status;
	
	
	public enum SessionStatus {
		INITIALIZING, INITIALIZED,DESTROYED
	}
	
	
	public SessionStatus getStatus() {
		return status;
	}


	public void setStatus(SessionStatus status) {
		this.status = status;
	}
	
	public void init() {
		System.out.println("initializing");
	}
}
