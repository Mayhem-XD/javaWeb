package ch09_Cookie_Session.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDao {
	public Connection getConnection() {
		Connection conn=null;
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/project");
			conn = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public User getUser(String uid) {
		Connection conn = getConnection();
		String sql ="select * from users where uid=?";
		User u = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				uid = rs.getString(1);
				String password = rs.getString(2);
				String uname = rs.getString(3);
				String email= rs.getString(4);
				LocalDate regDate = LocalDate.parse(rs.getString(5));
				int isDeleted = rs.getInt(6);
				u = new User(uid,password,uname,email,regDate,isDeleted);
			}
			rs.close(); pstmt.close(); conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	public List<User> getUserList(){
		List<User> list = new ArrayList<User>();
		Connection conn = getConnection();
		String sql ="select * from users where isDeleted=0 ORDER BY regDate, uid";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String uid = rs.getString(1);
				String password = rs.getString(2);
				String uname = rs.getString(3);
				String email= rs.getString(4);
				LocalDate regDate = LocalDate.parse(rs.getString(5));
				int isDeleted = rs.getInt(6);
				User u = new User(uid,password,uname,email,regDate,isDeleted);
				list.add(u);
			}
			rs.close();pstmt.close();conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void updateUser(User u) {
		Connection conn = getConnection();
		String sql =  "update users set uname=?, email=? WHERE uid=?;";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUname());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getUid());
			pstmt.executeUpdate();
			pstmt.close();conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void insertUser(User u) {
		Connection conn = getConnection();
		String sql =  "insert into users values(?,?,?,?,default,default);";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUid());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getUname());
			pstmt.setString(4, u.getEmail());
			pstmt.executeUpdate();
			pstmt.close();conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void deleteUser(String uid) {
		Connection conn = getConnection();
		String sql =  "update users set isdeleted=1 WHERE uid=?;";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.executeUpdate();
			pstmt.close();conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
}
