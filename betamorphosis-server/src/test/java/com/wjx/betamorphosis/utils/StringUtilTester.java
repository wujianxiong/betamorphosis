package com.wjx.betamorphosis.utils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtilTester {

	private final static Logger logger = LoggerFactory.getLogger(StringUtilTester.class);
	
	@Test
	public void testStringUtil(){
		String testStr = "12345abcde";
		String nullStr = null;
		String emptyStr = "";
		String spaceStr = " ";
		
		logger.info("{} is not empty:{};",testStr,StringUtils.isNotEmpty(testStr));
		logger.info("{} is not empty:{};",nullStr,StringUtils.isNotEmpty(nullStr));
		logger.info("{} is not empty:{};",emptyStr,StringUtils.isNotEmpty(emptyStr));
		logger.info("{} is not empty:{};",spaceStr,StringUtils.isNotEmpty(spaceStr));
	}
}
