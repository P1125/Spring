package com.company.yedam.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.yedam.emp.dao.EmpDAO;
import com.company.yedam.emp.dao.EmpVO;
import com.company.yedam.service.EmpService;

@Service // @ Component   inheritance. exception handling, bean registration
public class EmpServiceImpl implements EmpService{

	@Autowired EmpDAO empDAO;
	@Override
	public void empInsert(EmpVO vo) {
		empDAO.insert(vo);
		
	}

	@Override
	public void empUpdate(EmpVO vo) {
		empDAO.update(vo);
	}

	@Override
	public void empDelete(EmpVO vo) {
	}

	@Override
	public EmpVO empSearch(EmpVO vo) {
		return empDAO.selectOne(vo.getEmployee_id());		
	}

	@Override
	public ArrayList<EmpVO> empList() {
		return	empDAO.selectList();
		
	}

	@Override
	public EmpVO selectOne(EmpVO vo) {
		
		return empDAO.selectOne(vo.getEmployee_id());
	}

	
}
