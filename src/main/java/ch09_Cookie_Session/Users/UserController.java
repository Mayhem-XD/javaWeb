package ch09_Cookie_Session.Users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserController
 */
@WebServlet({ "/ch09/users/register", "/ch09/users/listView", "/ch09/users/update", "/ch09/users/delete", "/ch09/users/login", "/ch09/users/logout" })
public class UserController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		String[] uri = request.getRequestURI().split("/");
		String action = uri[uri.length-1];
		UserDao uDao = new UserDao();
		HttpSession session = request.getSession();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		
		switch (action) {
		case "list":
			List<User> list = uDao.getUserList();
			request.setAttribute("userList", list);		// 받는 곳에서 쓸 이름, 값
			rd = request.getRequestDispatcher("/ch09/users.listView");
			rd.forward(request, response);
			break;

		}
		
		
		
		}

}
