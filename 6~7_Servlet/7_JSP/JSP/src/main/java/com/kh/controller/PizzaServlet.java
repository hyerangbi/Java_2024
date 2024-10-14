package com.kh.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PizzaServlet
 */
public class PizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 인코딩처리
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청 시 전달 값 추출, 데이터가공처리 -> 변수나 객체에 넘겨받은 값을 기록한다.
		String name = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String message = request.getParameter("message");
		
		String pizza = request.getParameter("pizza");
		String[] toppings = request.getParameterValues("topping");
		String[] side = request.getParameterValues("side");
		String payment = request.getParameter("payment");
		
		// 3) 요청처리(db에 sql문 실행 > service > dao)
		
		int price = 0;
		switch(pizza) {
		case "콤비네이션" : price += 5000; break;
		case "포테이토피자" : 
		case "고구마피자" : price += 6000; break;
		default : price += 7000; 
		}
		
		if(toppings != null) {
			for(String topping : toppings) {
				switch(topping) {
				case "고구마무스": 
				case "치즈크러스트":price += 1500; break;
				case "까르보나라" : price += 2000; break;
				default : price += 1000;
				}
			}
		}
		
		// 요청 처리 후 사용자가 보게 될 응답페이지를 만들어서 넘겨주기
		// 응답페이지(jsp)를 선택해서 포워딩
		// 단, 응답페이지에 필요한 데이터가 없다면 담아서 포워딩 할 것
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("message", message);
		
		request.setAttribute("pizza", pizza);
		request.setAttribute("toppings", toppings);
		request.setAttribute("side", side);
		request.setAttribute("payment", payment);
		request.setAttribute("price", price);
		
		//응답할 뷰 선택
		RequestDispatcher view = request.getRequestDispatcher("views/pizza/pizzaPayment.jsp");
		//선택한 뷰가 사용자에게 보여지도록 포워딩
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
