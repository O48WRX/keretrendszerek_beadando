package com.ekke.servlet;

import java.io.IOException;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.*;

import com.ekke.controllers.ProcesszorEJBLocal;
import com.ekke.entities.Processzor;

/**
 * Servlet implementation class ProcesszorServlet
 */
@WebServlet("/ProcesszorServlet")
public class ProcesszorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesszorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    @EJB
    ProcesszorEJBLocal ejbSource;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Processzor> list = ejbSource.getList();
		response.setContentType("text/html;charset=UTF-8");
		for(Processzor p : list) {
			response.getWriter().append(p.toString() + ", ");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ar = Integer.parseInt(request.getParameter("ar"));
		String nev = request.getParameter("nev");
		ejbSource.createProcesszor(ar, nev);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int ar = Integer.parseInt(request.getParameter("ar"));
		String nev = request.getParameter("nev");
		ejbSource.updateProcesszor(id, ar, nev);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ejbSource.deleteProcesszor(id);
	}

}
