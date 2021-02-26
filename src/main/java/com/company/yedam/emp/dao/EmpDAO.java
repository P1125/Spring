package com.company.yedam.emp.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

/*
 * VO : Value Object == EmpDTO, EmoDO, Emp
 * DAO : Data Access Object
 */
@Component 
public class EmpDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	
	
	
	
	
	//전체 조회 select * from employees
	public ArrayList<EmpVO> selectList(){
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		EmpVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql = "SELECT EMPLOYEE_ID,"
						+ " FIRST_NAME,"
						+ " LAST_NAME,"
						+ " EMAIL,"
						+ " PHONE_NUMBER, "
	//					+ " TO_CHAR(HIRE_DATE, 'YYYY-MM') HIRE_DATE," //TO CHAR변환
						+ " HIRE_DATE,"
						+ " JOB_ID,"
						+ " SALARY,"
						+ " COMMISSION_PCT,"
						+ " MANAGER_ID,"
					+ " DEPARTMENT_ID"
					+ " FROM employees"
					+ " ORDER BY EMPLOYEE_ID";
			pstmt = conn.prepareStatement(sql);
		
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new EmpVO();
				vo.setEmployee_id(rs.getString(1));
				vo.setFirst_name(rs.getString("FIRST_NAME"));
				vo.setLast_name(rs.getString("LAST_NAME"));
				vo.setSalary(rs.getString("SALARY"));
				vo.setHire_date(rs.getDate("HIRE_DATE"));
				list.add(vo);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage()); //메세지만 출력가능하다 
		}finally {
			JdbcUtil.disconnect(conn);
		}
		return list;
	}
	//단건 조회 select * from employees where employee_id=? 
	public EmpVO selectOne(String id) {
		EmpVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql = "SELECT EMPLOYEE_ID,"
						+ " FIRST_NAME,"
						+ " LAST_NAME,"
						+ " EMAIL,"
						+ " PHONE_NUMBER, "
						+ " HIRE_DATE,"
						+ " JOB_ID,"
						+ " SALARY,"
						+ " COMMISSION_PCT,"
						+ " MANAGER_ID,"
					+ " DEPARTMENT_ID"
					+ " FROM employees"
					+ " WHERE employee_id=?";
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new EmpVO();
				vo.setEmployee_id(rs.getString("EMPLOYEE_ID"));
				vo.setFirst_name(rs.getString("FIRST_NAME"));
				vo.setLast_name(rs.getString("LAST_NAME"));
				vo.setEmail(rs.getString("EMAIL"));
				
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage()); //메세지만 출력가능하다 
		}finally {
			JdbcUtil.disconnect(conn);
		}
		return vo;
	}
	
	
	
	public void insert(EmpVO vo) {
		try {
			//1. connect(연결)
			conn=JdbcUtil.connect();
			//2.statement(구문) 실행할 sql구문
			String sql = "INSERT  INTO  EMPLOYEES( "
									+ "	EMPLOYEE_ID,"
									+ " FIRST_NAME,"
									+ " LAST_NAME,"
									+ " EMAIL,"
									+ " PHONE_NUMBER,"
									+ " HIRE_DATE,"
									+ " JOB_ID)"
		//							+ " DEPARTMENT_ID,"
								//	+ " MANAGER_ID"
						+ " VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pstmt= conn.prepareStatement(sql); // sql문 준비
			
			//3.execute(실행)
			pstmt.setString(1, vo.getEmployee_id());
			pstmt.setString(2, vo.getFirst_name());
			pstmt.setString(3, vo.getLast_name());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone_number());
			pstmt.setDate(6, vo.getHire_date());
			pstmt.setString(7, vo.getJob_id());
	//		pstmt.setString(8, vo.getDepartment_id());
	//		pstmt.setString(9, vo.getManager_id());
			
			int r = pstmt.executeUpdate();
			System.out.println(r +"건이 등록됨");
			
			//4.resultset(select라면 조회결과처리 없으면 skip)
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5. close(연결해제) 모든 jdbc과정은 이 단계를 거친다.
			JdbcUtil.disconnect(conn);
		}
		
	}
	
	
	public void update(EmpVO vo) {
		try {
			//1. connect(연결)
			JdbcUtil.connect();
			//2.statement(구문) 실행할 sql구문
			
			//3.execute(실행)
			
			//4.resultset(select라면 조회결과처리 없으면 skip)
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5. close(연결해제) 모든 jdbc과정은 이 단계를 거친다.
			JdbcUtil.disconnect(conn);
		}
		
	}
	
	//이메일조회
	public EmpVO selectOneByEmail(String id) {
		EmpVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql = "SELECT EMPLOYEE_ID,"
						+ " FIRST_NAME,"
						+ " LAST_NAME,"
						+ " EMAIL,"
						+ " PHONE_NUMBER ,"
						+ " HIRE_DATE,"
						+ " JOB_ID,"
						+ " SALARY,"
						+ " COMMISSION_PCT,"
						+ " MANAGER_ID,"
					+ " DEPARTMENT_ID"
					+ " FROM employees"
					+ " WHERE EMAIL=?";
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new EmpVO();
				vo.setEmployee_id(rs.getString("EMPLOYEE_ID"));
				vo.setFirst_name(rs.getString("FIRST_NAME"));
				vo.setLast_name(rs.getString("LAST_NAME"));
				vo.setEmail(rs.getString("EMAIL"));
				
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage()); //메세지만 출력가능하다 
		}finally {
			JdbcUtil.disconnect(conn);
		}
		return vo;
	}
	
	
	
	
}
