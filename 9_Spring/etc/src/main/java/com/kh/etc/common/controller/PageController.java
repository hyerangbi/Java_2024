package com.kh.etc.common.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("datail")
	public String movePage(String page, String nick, HttpSession session) {
		switch(page) {
		case "pulbicData":
			return "apiSample";
		case "summernote":
			return "summernote";
		case "chat":
			session.setAttribute("nick", nick);
			return "chat";
		}
		return "redirect:/";
	}
}