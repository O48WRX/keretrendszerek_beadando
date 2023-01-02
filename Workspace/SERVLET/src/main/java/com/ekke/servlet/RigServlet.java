package com.ekke.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ekke.controllers.RigEJBLocal;
import com.ekke.entities.Rig;

/**
 * Servlet implementation class RigServlet
 */
@WebServlet("/RigServlet")
public class RigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@EJB
	RigEJBLocal ejbSource;
	
    public RigServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Rig> list = ejbSource.getList();
		for(Rig p : list) {
			response.getWriter().append(p.toString() + ", ");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int processzor_id = Integer.parseInt(request.getParameter("processzor_id"));
		int ram_id = Integer.parseInt(request.getParameter("ram_id"));
		int vga_id = Integer.parseInt(request.getParameter("vga_id"));
		ejbSource.createRig(processzor_id, ram_id, vga_id);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int processzor_id = Integer.parseInt(request.getParameter("processzor_id"));
		int ram_id = Integer.parseInt(request.getParameter("ram_id"));
		int vga_id = Integer.parseInt(request.getParameter("vga_id"));
		ejbSource.updateRig(id, processzor_id, ram_id, vga_id);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ejbSource.deleteRig(id);
	}

}
