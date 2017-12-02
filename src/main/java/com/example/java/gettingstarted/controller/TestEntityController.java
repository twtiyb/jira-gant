package com.example.java.gettingstarted.controller;

import com.example.java.gettingstarted.entity.WebResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chunchun.xu on 2017/12/2.
 */

@Controller
@RequestMapping("/test")
public class TestEntityController {
	@RequestMapping("/string")
	public String healthy() {
		// Message body required though ignored
		return "Still surviving.";
	}

	@RequestMapping("/json")
	@ResponseBody
	public WebResponse testJson() {
		// Message body required though ignored
		return new WebResponse();
	}

	@RequestMapping("/")
	public String toIndex() {
		// Message body required though ignored
		return "index";
	}
}
