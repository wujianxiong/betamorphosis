package com.wjx.betamorphosis.logger;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
	
	private final static Logger logger = LoggerFactory.getLogger(LoggerTest.class);
	
	@Test
	public void testLogOut(){
		logger.info("»’÷æ ‰≥ˆ:{} {}", "2017-01-01","00:00:00");
	}
}
