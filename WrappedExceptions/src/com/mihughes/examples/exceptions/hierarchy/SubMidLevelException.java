package com.mihughes.examples.exceptions.hierarchy;

public class SubMidLevelException extends MidLevelException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1143670915632233489L;
	public SubMidLevelException(String msg, Throwable ex) {
		super(msg, ex);
	}

}
