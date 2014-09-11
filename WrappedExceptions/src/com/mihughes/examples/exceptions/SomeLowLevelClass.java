package com.mihughes.examples.exceptions;

import com.mihughes.examples.exceptions.hierarchy.LowLevelException;

/**
 * I am possible a DAO or repository object
 * @author michael
 *
 */
public class SomeLowLevelClass {
	
	public boolean getSomeData(boolean throwIt) throws LowLevelException {
		if (throwIt) {
			throw new LowLevelException("I am a low level exception");
		} else {
			return throwIt;
		}
	}

}
