package com.ui.listeners;

import org.apache.logging.log4j.Logger;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.utility.LoggerUtility;
import com.utility.PropertiesUtil;

public class MyRetryUtil implements IRetryAnalyzer {

	Logger logger= LoggerUtility.getLogger(this.getClass());
	private static final int MAX_NUMBERS_OF_RETRY = Integer.parseInt(PropertiesUtil.getProperty("MAX_NUMBERS_OF_RETRY"))  ;
	 private static int current_attempt = 1;

	@Override
	public boolean retry(ITestResult result) {
      
		logger.warn("Retrying to run test. Attempt {}/{}", current_attempt, MAX_NUMBERS_OF_RETRY);
		
		if (current_attempt <= MAX_NUMBERS_OF_RETRY) {
			current_attempt++;

			return true;

		}
		return false;
	}

}
