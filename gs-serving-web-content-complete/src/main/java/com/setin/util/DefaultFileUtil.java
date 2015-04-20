package com.setin.util;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.setin.exception.CommonException;

public class DefaultFileUtil {

	public static Map<String, List<File>> getList(File file) throws CommonException {

		if (file == null) {
			throw new CommonException("Null 을 참조할 수 없습니다.");
		}

		Map<String, List<File>> fileList = new HashMap<>();
		File[] fileArray = file.listFiles();

		List<File> directories = Arrays.asList(fileArray).stream()
				.filter(f -> f.isDirectory()).collect(Collectors.toList());

		List<File> files = Arrays.asList(fileArray).stream()
				.filter(f -> !f.isDirectory()).collect(Collectors.toList());

		fileList.put("directory", directories);
		fileList.put("file", files);

		return fileList;
	}

}
