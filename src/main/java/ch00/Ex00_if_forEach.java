package ch00;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex00_if_forEach
 */
@WebServlet("/Ex00_if_forEach")
public class Ex00_if_forEach extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Address addr1 = new Address(11111, "수원", "한국");
		Address addr2 = new Address(11112, "병점", "한국");
		Address addr3 = new Address(11113, "동탄", "한국");
		Address addr4 = new Address(11114, "오산", "한국");
		Address addr5 = new Address(21111, "피닉스", "미국");
		Address addr6 = new Address(21112, "생드니", "미국");
	}


}
