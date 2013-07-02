package com.restclient.domain;

public class Currency {

	String lhs;
	
	String rhs;
	
	String error;
	
	boolean icc;

	public String getLhs() {
		return lhs;
	}

	public void setLhs(String lhs) {
		this.lhs = lhs;
	}

	public String getRhs() {
		return rhs;
	}

	public void setRhs(String rhs) {
		this.rhs = rhs;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public boolean isIcc() {
		return icc;
	}

	public void setIcc(boolean icc) {
		this.icc = icc;
	}
	
	
	
}
