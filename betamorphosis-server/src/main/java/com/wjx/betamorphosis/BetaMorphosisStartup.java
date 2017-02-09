package com.wjx.betamorphosis;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wjx.betamorphosis.config.BetaConfig;
import com.wjx.betamorphosis.exceptions.BetaMorphosisServerStartupException;

public class BetaMorphosisStartup {

	private final static Logger logger  =  LoggerFactory.getLogger(BetaMorphosisStartup.class);
	
	public static void main(String[] args) {
		
		final String configFilePath = getConfigFilePath(args);
		final BetaConfig betaConfig = getBetaConfig(configFilePath);
	}

	/**
	 * 获取配置文件配置项
	 * @param configFilePath
	 * @return
	 */
	private static BetaConfig getBetaConfig(String configFilePath) {
		final BetaConfig config = new BetaConfig();
		config.loadFromFile(configFilePath);
		return config;
	}

	/**
	 * 获取配置文件路径
	 * @param args
	 * @return
	 */
	private static String getConfigFilePath(String[] args) {
		
		final Options options = new Options();
		final Option option = new Option("f", true, "Configuration file path");
		options.addOption(option);
		
		final CommandLineParser parser = new PosixParser();
		CommandLine cmd = null;
		try {
			cmd = parser.parse(options, args);
		} catch (final ParseException e) {
			throw new BetaMorphosisServerStartupException("parser command line error",e);
		}
		
		String configFilePath = null;
		if (cmd.hasOption("f")) {
			configFilePath = cmd.getOptionValue("f");
		}else{
			System.err.println("please input the configuration file path by -f option");
			System.exit(1);
		}
		if (StringUtils.isBlank(configFilePath)) {
			throw new BetaMorphosisServerStartupException("Blank file path");
		}
		return configFilePath;
	}

}
