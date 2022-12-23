package com.ekke.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ekke.controllers.ProcesszorEJBLocal;
import com.ekke.entities.Processzor;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @EJB
    ProcesszorEJBLocal ejbSource;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		if(ejbSource.getList() == null)
			response.getWriter().append("Null lista");
		else
			response.getWriter().append("Lista elemszám: "+ejbSource.getList().size());
		response.getWriter().append("Served at: ").append(request.getContextPath());
		*/
		
		List<Processzor> list = ejbSource.getList();
		for(Processzor p : list) {
			response.getWriter().append("p".toString());
		}
	}

}
