package com.gys.classmanager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
/**
 * Handles requests for the application home page.
 */

@Controller
@SessionAttributes("userid")
public class HomeController {

	@RequestMapping(value = "/header")
	public String header(Model model) {

		return "header";
	}

	@RequestMapping(value = "/footer")
	public String footer(Model model) {

		return "footer";
	}

	@RequestMapping(value = "/joinform")
	public String joinform(Model model) {

		return "joinform";
	}

	@RequestMapping(value = "/")
	public String index(Model model) {

		return "redirect:loginform";
	}

	@RequestMapping(value = "loginform")
	public String loginform(Model model) {

		return "loginform";
	}

	@RequestMapping(value = "/main")
	public String main(Model model) {

		return "main";
	}

	@RequestMapping(value = "/left")
	public String left(Model model) {

		return "left";
	}

	@RequestMapping(value = "/error404")
	public String error404(Model model) {

		return "error404";
	}

}



