package com.wjx.betamorphosis.config;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Set;

import org.ini4j.Ini;
import org.ini4j.Profile.Section;

import com.wjx.betamorphosis.exceptions.BetaMorphosisServerStartupException;

/**
 * ���������
 * @author wujianxiong
 *
 */
public class BetaConfig implements Serializable,IBetaConfig{

	private static final long serialVersionUID = 1L;

	private int serverPort = 8012;
	
	private volatile String configFilepath;

	/**
	 * �������ļ���ȡ����
	 * @param filePath
	 */
	public void loadFromFile(final String configFilepath) {
		this.configFilepath = configFilepath;
		File file = new File(configFilepath);
		if (!file.exists()) {
			throw new BetaMorphosisServerStartupException("File "+configFilepath+" is not exists");
		}
		//�������ļ�ת��ΪIni����
		try {
			final Ini conf = new Ini(file);
			this.assembleItems(conf);
		}  catch (final IOException e) {
			
		}
	}
	/**
	 * װ����������
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
