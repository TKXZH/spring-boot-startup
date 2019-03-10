package com.liujin.springbootstartup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zonghuixu
 */

@Controller
public class IndexController {
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
}
