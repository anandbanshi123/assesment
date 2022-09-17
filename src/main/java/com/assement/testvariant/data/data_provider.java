package com.assement.testvariant.data;

import org.testng.annotations.DataProvider;

public class data_provider {
	 @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { 1, "a" },
	      new Object[] { 2, "b" },
	    };
	  }
}
