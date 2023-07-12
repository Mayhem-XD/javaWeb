package ch09_Cookie_Session.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDao {
	public Connection getConnection() {			// getConnection(): 데이터베이스 연결을 설정하는 메소드
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/project");	// lookup():""에 바인딩된 DataSource 객체를 검색 
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public User getUser(String uid) {
		User u = null;
		Connection conn = getConnection();		 // 데이터베이스 연결을 설정
		String sql = "select * from users where uid=? and isDeleted=0";			//  SQL 쿼리를 준비
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);		// 쿼리의 첫 번째 매개변수에 사용자 ID를 설정
			ResultSet rs = pstmt.executeQuery();	// 쿼리를 실행하고 결과를 가져옴		ResultSet 객체는 DB쿼리의 결과 테이블 형태의 데이터	
			while (rs.next()) {
				u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							 LocalDate.parse(rs.getString(5)), rs.getInt(6));
			}
			rs.close(); pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public List<User> getUserList() {
		List<User> list = new ArrayList<User>();
		Connection conn = getConnection();
		String sql = "select * from users where isDeleted=0 order by regDate desc, uid";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);		
			while (rs.next()) {
				User u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							 LocalDate.parse(rs.getString(5)), rs.getInt(6));
				list.add(u);
			}
			rs.close(); stmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void insertUser(User u) {
		Connection conn = getConnection();
		String sql = "insert into users values (?, ?, ?, ?, default, default)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUid());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getUname());
			pstmt.setString(4, u.getEmail());
			pstmt.executeUpdate();
			pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(User u) {
		Connection conn = getConnection();
		String sql = "update users set password=?, uname=?, email=?, regDate=? where uid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getPassword());
			pstmt.setString(2, u.getUname());
			pstmt.setString(3, u.getEmail());
			pstmt.setString(4, u.getRegDate().toString());
			pstmt.setString(5, u.getUid());
			pstmt.executeUpdate();
			pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(String uid) {
		Connection conn = getConnection();
		String sql = "update users set isDeleted=1 where uid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.executeUpdate();
			pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateUserWithoutPassword(User u) {
		Connection conn = getConnection();
		String sql = "update users set uname=?, email=? where uid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUname());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getUid());
			pstmt.executeUpdate();
			pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}