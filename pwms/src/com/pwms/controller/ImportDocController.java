package com.pwms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doc")
public class ImportDocController extends BaseController {
	//重要文件列表
	@RequestMapping("/")
	public String index(Model model){
		return null;
	}
	//查看具体的重要文件
	@RequestMapping("/download")
	public String index(int id, Model model){
		return null;
	}
}
