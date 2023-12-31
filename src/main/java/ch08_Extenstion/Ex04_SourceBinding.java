package ch08_Extenstion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ex04_SourceBinding
 */
@WebServlet("/ch08/src4")
public class Ex04_SourceBinding extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/jw/ch08/src4 doGet()");
		String[] fruits = "사과,배,감,귤".split(",");
//		Request scope
		request.setAttribute("requestAddr", "경기도 수원시 장안구 영화동 request");
		request.setAttribute("requestFruits", fruits);
//		Session scope
		HttpSession session = request.getSession();
		session.setAttribute("sessionAddr", "경기도 수원시 장안구 영화동 session");
		session.setAttribute("sessionFruits", fruits);
		
//		Application scope
		ServletContext ctx = getServletContext();
		ctx.setAttribute("applicationAddr", "경기도 수원시 장안구 영화동 app");
		ctx.setAttribute("applicationFruits", fruits);
		
		RequestDispatcher rd = request.getRequestDispatcher("/ch08/dst4");
		rd.forward(request, response);
		
	}


}
