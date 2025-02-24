package com.servlet.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/Servlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String[] jokes = {
	        "Why do Java developers wear glasses? Because they don't C#!",
	        "I told my computer I needed a break, and now it won't stop sending me Kit Kat bars.",
	        "Why don't programmers like nature? It has too many bugs.",
	        "How many programmers does it take to change a light bulb? None, it's a hardware problem.",
	        "Why do programmers prefer dark mode? Because light attracts bugs!",
	        "Why do programmers always mix up Christmas and Halloween? Because Oct 31 = Dec 25!\r\n",
	        "Why don’t programmers like to go outside? The sunlight causes too much glare on their screens!\r\n",
            "Why did the JavaScript developer go to therapy? They had too many unresolved promises!\r\n"
	    };
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    String str1 =	request.getParameter("num1");
	    String str2 =	request.getParameter("num2");
	    String str3 =   request.getParameter("btn1");
 	    
	    //type cast
	    int a = Integer.parseInt(str1);
	    int b = Integer.parseInt(str2);
	    
	    int ans = 0;    
	    if(str3.equals("1")) {
	    	ans = a + b;
	    } else if(str3.equals("2")) {
	    	ans = a - b;
	    } else if(str3.equals("3")) {
	    	ans = a * b;
	    } else if(str3.equals("4")) {
	    	ans = a / b;
	    }
	    
	    int randomIdx = (int) (Math.random() * jokes.length);
	    String randomJoke = jokes[randomIdx];
	    
	    response.sendRedirect("output.jsp?ans=" + ans + "&joke=" + randomJoke);
//	    response.sendRedirect("MyServlet2");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str1 =	request.getParameter("username");
	    String str2 =	request.getParameter("psw");
		
		response.getWriter().append("Served at: DoPost " + str1 + " " + str2);

	}

}
