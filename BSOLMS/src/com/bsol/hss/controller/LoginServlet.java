package com.bsol.hss.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bsol.hss.bean.Book;
import com.bsol.hss.service.BusinessService;

/**
 * �û���¼
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BusinessService service=new BusinessService();
    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login=request.getParameter("login");
		String register=request.getParameter("register");
//		if(request.getSession().getAttribute("username")!=null) {
//			request.setAttribute("username",request.getSession().getAttribute("username"));
//			List<Book> books=service.findAllBooks();
//			request.setAttribute("books", books);
//			request.getRequestDispatcher("user.jsp").forward(request, response);
//		}
		if(login!=null) {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			boolean result=service.userLogin(username, password);
			if(result) {
				request.getSession().setAttribute("username", username);
				if(service.isManager(username)) {
					request.setAttribute("username", username);
					request.getRequestDispatcher("manager.jsp").forward(request, response);
					//response.sendRedirect("manager.jsp");//�������Ա����
				}else {
					//request.setAttribute("username",username);
					List<Book> books=service.findAllBooks();
					//request.setAttribute("books", books);
					request.getSession().setAttribute("books", books);
					request.getRequestDispatcher("user_2.jsp").forward(request, response);
				//	response.sendRedirect("user.jsp");//�����û�����
				}
			}
			else {
				response.sendRedirect("index.jsp");//��¼��������ҳ
			}
		}else {
			response.sendRedirect("register.jsp"); //����ע��ҳ��
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
