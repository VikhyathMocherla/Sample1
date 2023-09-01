package com.date;

public class NotBefore {

	private String notBeforeDate;

	public String getNotBeforeDate() {
		return notBeforeDate;
	}

	public void setNotBeforeDate(String notBeforeDate) {
		this.notBeforeDate = notBeforeDate;
	}

	public NotBefore(String notBeforeDate) {
		super();
		this.notBeforeDate = notBeforeDate;
	}

	public NotBefore() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "NotBefore [notBeforeDate=" + notBeforeDate + "]";
	}
	
}
