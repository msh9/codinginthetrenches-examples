package com.mihughes.examples.exceptions.hierarchy;

public class MidLevelException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4262362501457120501L;
	public MidLevelException(String msg, Throwable ex) {
		super(msg, ex);
	}

}
