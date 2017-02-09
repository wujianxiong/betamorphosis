package com.wjx.betamorphosis.exceptions;
/**
 * 服务启动异常
 * @author wujianxiong
 *
 */
public class BetaMorphosisServerStartupException extends RuntimeException {

	private static final long serialVersionUID = 1L;


	public BetaMorphosisServerStartupException() {
		super();
	}

	public BetaMorphosisServerStartupException(String message, Throwable e) {
		super(message, e);
	}
	
	public BetaMorphosisServerStartupException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BetaMorphosisServerStartupException(String message) {
		super(message);
	}

	public BetaMorphosisServerStartupException(Throwable cause) {
		super(cause);
	}
	
	

	
	

}
