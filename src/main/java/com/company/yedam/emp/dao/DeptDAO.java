package com.company.yedam.emp.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class DeptDAO {

	Connection conn;
	PreparedStatement pstmt;
	
	private static DeptDAO instance;
	
	public static DeptDAO getInstance() {
		if ( instance == null) {
			instance = new DeptDAO();
		}
		return instance;
	}
	
	public ArrayList<DeptVO> selectAll(){
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		DeptVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql = "SELECT "
					+ " department_id, "
					+ " department_name,"
					+ " manager_id"
					+ " FROM departments"
					+ " ORDER BY  department_id";
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new DeptVO();
				vo.setDepartment_id(rs.getString("department_id"));
				vo.setDepartment_name(rs.getString("department_name"));
				vo.setManager_id(rs.getString("manager_id"));
				list.add(vo);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JdbcUtil.disconnect(conn);
		}
		return list;
	}
	
	
	public void update(DeptVO vo) {
		try {
			JdbcUtil.connect();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.disconnect(conn);
		}
		
	}
	
	public void insert(DeptVO vo) {
		try {
			conn=JdbcUtil.connect();
			String sql = "INSERT INTO DEPARTMENTS("
					+ " DEPARTMENT_ID,"
					+ " DEPARTMENT_NAME,"
					+ " MANAGER_ID)"
					+ " VALUES(?,?,?)";
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setString(1, vo.getDepartment_id());
			 pstmt.setString(2, vo.getDepartment_name());
			 pstmt.setString(3, vo.getManager_id());
			 
			 int  r = pstmt.executeUpdate();
			 
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.disconnect(conn);
		}
	}
	
	public DeptVO selectOne(String id) {
		DeptVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql = "SELECT DEPARTMENT_ID,"
					+ " DEPARTMENT_ID"
					+ " FROM departments"
					+ " WHERE department_id=?";
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new DeptVO();
				vo.setDepartment_id(rs.getString("DEPARTMENT_ID"));
			}
		}catch (Exception e) {
			System.out.println(e.getMessage()); 
		}finally {
			JdbcUtil.disconnect(conn);
		}
		return vo;
	}
	
	

}
