package com.pwms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam")
public class ExamController extends BaseController {
	//获取考试题目
	@RequestMapping("/getquestion")
	public String getExamQuestion(int examId, HttpSession session, Model model){
		return null;
	}
	//接受用户答案,保存并处理用户答案
	@RequestMapping("/postanswer")
	public String execUserAnswer(int examId,String[] questions, HttpSession session, Model model){
		return null;
	}
	//查看答案
	@RequestMapping("/getanswer")
	public String getanswer(int examId, HttpSession session, Model model){
		return null;
	}
}
