package hello;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.setin.exception.CommonException;
import com.setin.util.DefaultFileUtil;

@Controller
public class GreetingController {
	@RequestMapping("/greeting")
	public String greeting(
			@RequestParam(value = "name", required = false, defaultValue = "F:/사진/") String name,
			Model model) throws CommonException {
		System.out.println(name);
		Map<String, List<File>> files = DefaultFileUtil.getList(new File(name));
		/*
		 * files.get("file").stream().forEach(f -> { System.out.print("file : "
		 * + f.getName()); System.out.println("file size : " + f.length()); });
		 * files.get("directory").stream().forEach(f -> {
		 * System.out.print("file : " + f.getName());
		 * System.out.println(" file size : " + f.length()); });
		 */

		model.addAttribute("files", files.get("file"));
		model.addAttribute("directory", files.get("directory"));

		return "greeting";
	}

	@RequestMapping("/viewFile")
	public void viewFile(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "name", required = false, defaultValue = "F:/사진/") String name,
			Model model) throws CommonException, IOException {
		System.out.println(name);

		File file = new File(name);
		FileInputStream fileInputStream = new FileInputStream(file);

		int i = 0;
		BufferedInputStream bi = new BufferedInputStream(fileInputStream);
		while ((i = bi.read()) != -1) {
			response.getOutputStream().write(i);
		}

	}
}
