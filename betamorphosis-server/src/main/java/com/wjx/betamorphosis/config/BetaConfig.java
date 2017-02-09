package com.wjx.betamorphosis.config;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Set;

import org.ini4j.Ini;
import org.ini4j.Profile.Section;

import com.wjx.betamorphosis.exceptions.BetaMorphosisServerStartupException;

/**
 * 服务端配置
 * @author wujianxiong
 *
 */
public class BetaConfig implements Serializable,IBetaConfig{

	private static final long serialVersionUID = 1L;

	private int serverPort = 8012;
	
	private volatile String configFilepath;

	/**
	 * 从配置文件读取配置
	 * @param filePath
	 */
	public void loadFromFile(final String configFilepath) {
		this.configFilepath = configFilepath;
		File file = new File(configFilepath);
		if (!file.exists()) {
			throw new BetaMorphosisServerStartupException("File "+configFilepath+" is not exists");
		}
		//将配置文件转化为Ini对象
		try {
			final Ini conf = new Ini(file);
			this.assembleItems(conf);
		}  catch (final IOException e) {
			
		}
	}
	/**
	 * 装配配置属性
	 * @param conf
	 */
	private void assembleItems(Ini conf) {
		Section serverSection = conf.get("server");
		Set<String> configKeySet = serverSection.keySet();
	}

	public int getServerPort() {
		return serverPort;
	}
	
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}
	
}
