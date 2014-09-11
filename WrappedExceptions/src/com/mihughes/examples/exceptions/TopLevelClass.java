package com.mihughes.examples.exceptions;

import com.mihughes.examples.exceptions.hierarchy.MidLevelException;
import com.mihughes.examples.exceptions.hierarchy.TopLevelException;

/*
 * I might be a controller for some kind of UI
 */
public class TopLevelClass {
	private SomeMidLevelClass myDependency;

	public TopLevelClass(SomeMidLevelClass myDependency) {
		this.myDependency = myDependency;
	}
	
	public String getSomeInterestingView(boolean throwll, boolean throwml, boolean throwme) throws TopLevelException {
		try {
			this.myDependency.doInterestingLogic(throwll, throwml);
		} catch (MidLevelException ex) {
			//failure, we'll rethrow to top level exception handler
			if (throwme) {
				throw new TopLevelException("Rendering failed due to exception", ex);
			}
		}
		return "Success";
	}

}
