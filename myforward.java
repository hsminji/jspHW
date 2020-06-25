package com.hansin.database;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myforward extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 전달된 POST parameter 파싱
					String value = req.getParameter("value");
					System.out.print(value);
					String operator = req.getParameter("operator");
					
					// exp 파싱 
					String exp = req.getParameter("exp");
					if(exp == null) {
						exp ="0";
					}
					if(operator!=null && operator.equals("=")) {
						// "=" 연산자일 때	-> 계산
						ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
						try {
							exp = String.valueOf(engine.eval(exp));
						} catch (ScriptException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
					} else {
						// 문자열에 add
						exp += (value==null)?"":value;
						exp += (operator==null)?"":operator;		
						System.out.print(exp);
					}
					
					
					if(operator!=null && operator.equals("C")) {
						exp ="0";
					}
					
					req.setAttribute("exp", exp);
					
					RequestDispatcher rd = req.getRequestDispatcher("myjspexample3.jsp");
					rd.forward(req, resp);
					
	}
}
