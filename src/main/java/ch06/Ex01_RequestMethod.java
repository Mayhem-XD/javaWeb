package ch06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex01_RequestMethod
 */
@WebServlet("/ch06_reqMethod")
public class Ex01_RequestMethod extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContentType();
		String method = request.getMethod();
		String requestUri = request.getRequestURI();
		String serverName = request.getServerName();
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();
		String data="contextPath: "+contextPath+"\n";
		data += "method: "+method+"\n";
		data += "requestURI:"+requestUri+"\n";
		data += "servername:"+serverName+"\n";
		data += "servletPath:"+servletPath+"\n";
		data += "pathInfo:"+pathInfo+"\n";
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String html = "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "	<meta charset=\"UTF-8\">"
				+ "	<title>HttpServletRequest의 다양한 메소드</title>"
				+ "</head>"
				+ "<body>"
				+ "	<title>HttpServletRequest의 다양한 메소드</title>" 
				+ "<hr>";
		String[] liList = data.split("\n");
		html += "	<ul>";
		for(String li:liList)
			html +=" 	<li>"+li+"</li>";
		html += "    </ul>";
				
		html += "</body>"
					+"</html>";
		out.print(html);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
