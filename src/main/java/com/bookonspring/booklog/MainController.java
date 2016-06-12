package com.bookonspring.booklog;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String viewMain(Model model) {
		model.addAttribute("title", "On Spring Blog");
		model.addAttribute("message", "Hello, World!");
		model.addAttribute("nowDate", new Date());
		return "main";
	}

	@RequestMapping("/messages/{propertiesName}")
	public void getProperties(@PathVariable String propertiesName, HttpServletResponse response) throws IOException {
		OutputStream outputStream = response.getOutputStream();
		Resource resource = new ClassPathResource("/static/messages/" + propertiesName + ".properties");
		InputStream inputStream = resource.getInputStream();

		List<String> readLines = IOUtils.readLines(inputStream);
		IOUtils.writeLines(readLines, null, outputStream);

		IOUtils.closeQuietly(inputStream);
		IOUtils.closeQuietly(outputStream);
	}
}
