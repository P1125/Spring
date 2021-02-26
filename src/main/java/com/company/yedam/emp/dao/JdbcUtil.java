package com.company.yedam.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	
	// DB연결 메서드
	public static Connection connect() {
		Connection conn = null;
		try {
	//		Class.forName(dbdriver);
	//		conn =  DriverManager.getConnection (dburl, user, passwd);
		
			//dbcp connection 방식만 달라진다. 
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env"); //was에서 자원을 모아둠 jndi Java Naming and Directory Interface 
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle"); // 데이터소스로부터 커넥션을 읽어냄        META-INF에서 CONTEXT에서 설정함 자원을 디렉토리구조로찾는다
			conn = ds.getConnection(); // DATAsource로부터 getconnection한다
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		return conn;
	}

	public static void disconnect(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void disconnect(PreparedStatement pstmt, Connection conn) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
