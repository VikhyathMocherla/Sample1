package com.date;

public class NotAfter {

	private String notAfterDate;

	public String getNotAfterDate() {
		return notAfterDate;
	}

	public void setNotAfterDate(String notAfterDate) {
		this.notAfterDate = notAfterDate;
	}

	public NotAfter(String notAfterDate) {
		super();
		this.notAfterDate = notAfterDate;
	}

	public NotAfter() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "NotAfter [notAfterDate=" + notAfterDate + "]";
	}
	
}
