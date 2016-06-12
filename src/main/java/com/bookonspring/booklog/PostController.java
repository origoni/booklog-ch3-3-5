package com.bookonspring.booklog;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostDao postDao;

	@GetMapping(value = "/write")
	public String form(Post post) {
		return "form";
	}

	@PostMapping(value = "/write")
	public String write(Post post) {
		post.setCreatedAt(new Date());
		return "redirect:/post/" + postDao.save(post).getId();
	}

	@RequestMapping("/{id}")
	public String view(Model model, @PathVariable int id) {
		Post post = postDao.findOne(id);
		model.addAttribute("post", post);
		return "post";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		List<Post> postList = postDao.findAll();
		model.addAttribute("postList", postList);
		return "list";
	}

	@GetMapping(value = "/{id}/edit") // ①
	public String editor(Model model, @PathVariable int id) {
		Post post = postDao.findOne(id);
		model.addAttribute("post", post);
		return "form"; // ③
	}

	@PostMapping(value = "/{id}/edit") // ②
	public String edit(Post post) {
		return "redirect:/post/" + postDao.save(post).getId();
	}

	@RequestMapping("/{id}/delete")
	public String delete(@PathVariable int id) {
		postDao.delete(id);
		return "redirect:/post/list";
	}
}
