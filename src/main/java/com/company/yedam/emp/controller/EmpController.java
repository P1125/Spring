package com.company.yedam.emp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.yedam.emp.dao.DeptVO;
import com.company.yedam.emp.dao.EmpVO;
import com.company.yedam.service.EmpService;

@Controller // @Component�� 媛�����誘� 而댄�щ���멸� ����諛��� 而⑦�몃·��留��� 而⑦�몃·�� 紐⑹�� : 1.而⑦���대�� 鍮��쇰� �깅�, 而⑦�몃·�ы����耳�以���. 留�洹몃��濡�
			// ���ㅽ�⑥����� �몄���������濡� 而⑦�몃·湲곕��.

public class EmpController {
	Logger logger = LoggerFactory.getLogger(EmpController.class);

	@Autowired EmpService empService;
	
	// �ъ��紐⑸�
	@RequestMapping("/empList")
	public String empList(Model model) {
		model.addAttribute("list", empService.empList());

		return "emp/empList";
	}
	@RequestMapping("/deptList")
	public String deptList(HttpServletRequest request) {
	//	request.setAttribute("dlist", deptDAO.selectAll());
		return "emp/deptList";
	}
	
	@PostMapping("/deptList")
	public String deptInsert(DeptVO vo) {
	//	deptDAO.insert(vo);
		return "redirect:deptList";
	}

	// �깅���

	@GetMapping("/empInsert")
	public String empInsert(Model model) {
	//	request.setAttribute("jobList", jobList.selectAll());
	//	request.setAttribute("deptList", deptList.selectAll());

		return "emp/empInsert";
	}

	// �깅�泥�由�
	@PostMapping("/empInsert")
	public String empInsertProc(EmpVO vo) {
		logger.debug(vo.toString());
		empService.empInsert(vo);
		return "redirect:empList";
	}

	// ������
	@GetMapping("/empUpdate")
	public String empUpdate(EmpVO vo, Model model) {
		model.addAttribute("empVO", empService.selectOne(vo));
//		request.setAttribute("jobList", jobList.selectAll());
//		request.setAttribute("deptList", deptList.selectAll());
		return "emp/empInsert";
	}

	// ����泥�由�
	@RequestMapping("/empUpdate")
	public String empUpdateProc(EmpVO vo) {
		logger.debug(vo.toString());
		empService.empUpdate(vo);
		return "redirect:empList";
	}
	// �대��쇱껜��

	// �ъ��寃���
	@RequestMapping("/empSearch")
	public String empSearch(EmpVO vo, Model model) {
		model.addAttribute("list", empService.empSearch(vo));
		return "emp/empSearch";
	}
	@RequestMapping("/deptSearch")
	public String deptSearch(HttpServletRequest request) {
	//	request.setAttribute("deptList", deptDAO.selectAll());
		return "emp/deptList";
	}
	@RequestMapping("/deptUpdate")
	public String deptUdapteProc(DeptVO vo) {
		logger.debug(vo.toString());
	//	deptDAO.update(vo);
		return "redirect:deptList";
	}
	
}
