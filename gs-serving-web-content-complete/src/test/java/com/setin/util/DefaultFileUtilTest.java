package com.setin.util;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.setin.exception.CommonException;

public class DefaultFileUtilTest {

	private DefaultFileUtil fileUtil = null;

	@Before
	public void set() {
		fileUtil = new DefaultFileUtil();
	}

	@Test
	public void test() throws CommonException {
		Map<String, List<File>> files = fileUtil.getList(new File("F:/사진/"));

		files.get("file").stream().forEach(f -> {
			System.out.print("file : " + f.getName());
			System.out.println("file size : " + f.length());
		});
		files.get("directory").stream().forEach(f -> {
			System.out.print("file : " + f.getName());
			System.out.println(" file size : " + f.length());
		});

	}
}
