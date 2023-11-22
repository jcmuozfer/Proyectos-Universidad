package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import es.unex.pi.dao.CategoryDAO;
import es.unex.pi.dao.HostingCategoriesDAO;
import es.unex.pi.dao.HostingDAO;
import es.unex.pi.dao.JDBCCategoryDAOImpl;
import es.unex.pi.dao.JDBCHostingCategoriesDAOImpl;
import es.unex.pi.dao.JDBCHostingDAOImpl;
import es.unex.pi.dao.JDBCUserDAOImpl;
import es.unex.pi.dao.UserDAO;
import es.unex.pi.model.Category;
import es.unex.pi.model.Hosting;
import es.unex.pi.model.HostingCategories;
import es.unex.pi.model.User;
import es.unex.pi.util.Triplet;

/**
 * Servlet implementation class GestionAlojamientos
 */
public class GestionAlojamientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionAlojamientos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger.info("Atendiendo GET");


		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		HostingDAO HostingDAO = new JDBCHostingDAOImpl();
		HostingDAO.setConnection(conn);

		String idHosting = request.getParameter("idHosting");

		Hosting HostingAux = new Hosting();
		HostingAux = HostingDAO.get(Long.parseLong(idHosting));

		HostingCategoriesDAO HostingsCategoriesDAO = new JDBCHostingCategoriesDAOImpl();
		HostingsCategoriesDAO.setConnection(conn);

		CategoryDAO categoryDAO = new JDBCCategoryDAOImpl();
		categoryDAO.setConnection(conn);
		List<Category> categorias = categoryDAO.getAll();

		List<Category> CategoriaPertenece = new ArrayList<Category>();
		List<Category> CategoriaNoPertenece = new ArrayList<Category>();

		List<HostingCategories> aux = HostingsCategoriesDAO.getAll();
		for(Category categoria:categorias) {
			HostingCategories hostingCategoriaAux = HostingsCategoriesDAO.get(HostingAux.getId(), categoria.getId());
			if(hostingCategoriaAux != null) 
				CategoriaPertenece.add(categoria);
			else CategoriaNoPertenece.add(categoria);
		}
		request.setAttribute("CategoriaPertenece",CategoriaPertenece);
		request.setAttribute("CategoriaNoPertenece",CategoriaNoPertenece);
		request.setAttribute("HostingAux",HostingAux);
		

		RequestDispatcher view = request.getRequestDispatcher("EditarAlojamiento.jsp");
		view.forward(request,response);
	}
}
