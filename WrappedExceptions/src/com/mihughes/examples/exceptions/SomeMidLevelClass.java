package com.mihughes.examples.exceptions;

import com.mihughes.examples.exceptions.hierarchy.LowLevelException;
import com.mihughes.examples.exceptions.hierarchy.MidLevelException;
import com.mihughes.examples.exceptions.hierarchy.SubMidLevelException;

/**
 * I might be a business or service layer
 * @author michael
 *
 */
public class SomeMidLevelClass {
	
	private SomeLowLevelClass myDependency;

	public SomeMidLevelClass(SomeLowLevelClass myDependency) {
		this.myDependency = myDependency;
	}

	public boolean doInterestingLogic(boolean throwll, boolean throwMe) throws MidLevelException {
		try {
			this.myDependency.getSomeData(throwll);
		} catch (LowLevelException ex) {
			//oops, an exception!
			if (throwMe) {
				throw new SubMidLevelException("My service logic failed due to an exception", ex);
			}
		}
		return true;
	}
}
