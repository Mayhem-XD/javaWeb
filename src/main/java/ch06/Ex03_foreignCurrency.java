package ch06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Ex03_foreignCurrency
 */
@WebServlet("/ch06/currency")
public class Ex03_foreignCurrency extends HttpServlet {
	static final String[] FOREIGN_CURRENCY = {"USD","EUR","JPY","CNY"};
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() method called.");
		request.setCharacterEncoding("utf-8");
		
		String won_ = request.getParameter("won");
		String currency_ = request.getParameter("currency");
		
		int won = Integer.parseInt(won_);
		double[] currencyRate = {1304.8, 1429.21, 913.18, 180.14};
		int currencyIndex = Integer.parseInt(currency_);
		
		double exchangeAmount = won / currencyRate[currencyIndex];
		String data = String.format("%,d 원 -> ", won);
		data += String.format("%,.2f %s",exchangeAmount ,FOREIGN_CURRENCY[currencyIndex]);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String html = "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset=\"UTF-8\">"
				+ "<title>환율 계산기</title>"
				+ "</head>"
				+ "<body style=\"margin:40px\">"
				+ "	<h1>환율 계산기</h1><hr>"
				+ "	<h3>"+ data +"</h3>"
				+ "	<br>"
				+ "	<button onclick=\"locaion.href='/jw/ch06/foreignCurrency.html'\">재실행</button>"
				+ "</body>"
				+ "</html>";
		
		
		out.print(html);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
