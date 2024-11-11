package com.kh.etc.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("datail")
	public String movePage(String page) {
		switch(page) {
		case "pulbicData":
			return "apiSample";
		case "summernote":
			return "summernote";
		}
		return "redirect:/";
	}
}
