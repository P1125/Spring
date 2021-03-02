package com.company.yedam.emp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.yedam.service.DeptService;

@Controller

public class DeptController {
	Logger logger = LoggerFactory.getLogger(DeptController.class);
	
	@Autowired DeptService deptService;
	
	@RequestMapping("/deptList")
	public String deptList(Model model) {
		model.addAttribute("list", deptService.de)
	}
	
	
}
