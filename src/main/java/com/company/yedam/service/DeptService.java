package com.company.yedam.service;

import java.util.ArrayList;

import com.company.yedam.emp.dao.DeptVO;

public interface DeptService {

	void deptInsert(DeptVO vo);
	void deptUpdate(DeptVO vo);
	DeptVO deptSearch(DeptVO vo);
	ArrayList<DeptVO> deptList();
	DeptVO selectone(DeptVO vo);
}
