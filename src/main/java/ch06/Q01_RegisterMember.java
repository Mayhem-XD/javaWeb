package ch06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ch06/register")
public class Q01_RegisterMember extends HttpServlet {
	
//	form 화면을 띄워주는 코드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String html = "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset=\"UTF-8\">"
				+ "<title>등록</title>"
				+ "</head>"
				+ "<body style=\"margin:40px\">"
				+ "	<h1>회원 가입</h1>"
				+ "    <hr>"
				+ "    <form action=\"/jw/ch06/register\" method=\"post\">"
				+ "        <table>"
				+ "            <tr><td>사용자 ID</td><td><input type=\"text\" name=\"uid\"></td></tr>"
				+ "            <tr><td>패스워드</td><td><input type=\"password\" name=\"pwd\"></td></tr>"
				+ "			<tr><td>이름</td><td><input type=\"text\" name=\"uname\"></td></tr>"
				+ "			<tr><td>이메일</td><td><input type=\"text\" name=\"email\"></td></tr>"
				+ "        </table>"
				+ "        <input type=\"submit\" value=\"제출\">"
				+ "    </form>"
				+ "			"
				+ "</body>"
				+ "</html>";
		out.print(html);
		
		
	}

//	입력 결과를 받아서 화면에 보여주는 코드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		
		PrintWriter out = response.getWriter();
		
		String html = "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset=\"UTF-8\">"
				+ "<title>등록</title>"
				+ "</head>"
				+ "<body style=\"margin:40px\">"
				+ "	<h1>회원 가입 결과</h1>"
				+ "    <hr>"
				+ "    <ul>"
				+ "		<li>아이디: "+uid+"</li>"
				+ "		<li>비밀번호: "+pwd+"</li>"
				+ "		<li>이름: "+uname+"</li>"
				+ "		<li>이메일: "+email+"</li>"
				+ "	</ul>"
				+ "	<button onclick=\"location.href='/jw/ch06/register'\">재실행</button>"
				+ "</body>"
				+ "</html>";
		out.print(html);
		
	}

}
