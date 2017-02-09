package com.wjx.betamorphosis.file;

import java.io.File;

import org.junit.Test;

public class FileTester {

	@Test
	public void testFile(){
		String path = "f:"+File.separator+"a"+File.separator+"b"+File.separator+"c.txt";
		File file = new File(path);
		File appClassDir = new File(file.getParentFile().getParentFile(), "provided");
		if (!file.exists()) {
			System.err.println("file "+path+" is not exists");
		}
		if (appClassDir.exists() && appClassDir.isDirectory()) {
            // It's a directory,it must be ends with "/"
            System.out.println("appClassDir is :"+appClassDir.getAbsolutePath() + "/");
        }
	}
}
