package ch08_Extenstion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ex04_DestExtenstion
 */
@WebServlet("/ch08/dst4")
public class Ex04_DestExtenstion extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqAddr = (String) request.getAttribute("requestAddr");
		String[] reqFruits = (String[]) request.getAttribute("requestFruits");
		
		HttpSession session = request.getSession();
		String sessAddr = (String) session.getAttribute("sessionAddr");
		String[] sessFruits = (String[]) session.getAttribute("sessionFruits");
		
		ServletContext ctx = getServletContext();
		String appAddr = (String) ctx.getAttribute("applicationAddr");
		String[] appFruits = (String[]) ctx.getAttribute("applicationFruits");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>RequestDispatcher Binding</h1>");
		out.print("<h3>" + reqAddr + "</h3>");
		out.print("<h3>" + sessAddr + "</h3>");
		out.print("<h3>" + appAddr + "</h3>");
		System.out.print("Request scopre: ");
		for(String f: reqFruits)
			System.out.print(f+" ");
		
		System.out.print("Session scopre: ");
		for(String f: sessFruits)
			System.out.print(f+" ");
		
		System.out.print("App scopre: ");
		for(String f: appFruits)
			System.out.print(f+" ");
		
		
	}


}
