package com.pwms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/theory")
public class AdminTheoryController extends BaseController {
	//查看所有的理论经典列表
	@RequestMapping("/alltheory")
	public String getAllTheory(Model model){
		return null;
	}
	//以表单的形式显示理论文章，便于用户修改文章
	@RequestMapping("/modifyview")
	public String modifyview(int id, Model model){
		return null;
	}
	//根据id来修改文章内容
	@RequestMapping("/modify")
	public String modify(int id, Model model){
		return null;
	}
	//删除文章
	@RequestMapping("/delete")
	public String delete(int id, Model model){
		return null;
	}
}
