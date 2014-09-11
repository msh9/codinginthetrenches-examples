package com.mihughes.examples.exceptions.hierarchy;

public class TopLevelException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2992623786893040167L;

	public TopLevelException(String msg, Throwable ex) {
		super(msg, ex);
	}
}
