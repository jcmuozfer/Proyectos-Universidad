  package es.unex.pi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import es.unex.pi.dao.CategoryDAO;
import es.unex.pi.dao.HostingDAO;
import es.unex.pi.dao.HostingCategoriesDAO;
import es.unex.pi.dao.JDBCCategoryDAOImpl;
import es.unex.pi.dao.JDBCHostingDAOImpl;
import es.unex.pi.dao.JDBCHostingCategoriesDAOImpl;
import es.unex.pi.dao.JDBCUserDAOImpl;
import es.unex.pi.dao.UserDAO;
import es.unex.pi.model.Category;
import es.unex.pi.model.Hosting;
import es.unex.pi.model.HostingCategories;
import es.unex.pi.model.User;
import es.unex.pi.util.Triplet;

import jakarta.servlet.RequestDispatcher;

import java.sql.Connection;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		logger.info("Atendiendo GET");

		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		UserDAO userDAO = new JDBCUserDAOImpl();
		userDAO.setConnection(conn);

		HostingDAO HostingDAO = new JDBCHostingDAOImpl();
		HostingDAO.setConnection(conn);

		CategoryDAO categoryDAO = new JDBCCategoryDAOImpl();
		categoryDAO.setConnection(conn);

		HostingCategoriesDAO HostingsCategoriesDAO = new JDBCHostingCategoriesDAOImpl();
		HostingsCategoriesDAO.setConnection(conn);


		RequestDispatcher view = request.getRequestDispatcher("IniciaSesionoRegistrate.jsp");
		view.forward(request,response);


	}	



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger.info("Atendiendo GET");
		
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		UserDAO userDAO = new JDBCUserDAOImpl();
		userDAO.setConnection(conn);

		HostingDAO HostingDAO = new JDBCHostingDAOImpl();
		HostingDAO.setConnection(conn);

		String username = request.getParameter("user");
		String password = request.getParameter("password");

		User user = userDAO.get(username);


		if((user != null) && (user.getPassword().equals(password))) {

			HttpSession sesion = request.getSession();
			sesion.setAttribute("user",user);
			
			List<Hosting> HostingCategoria = HostingDAO.getAll();
			CategoryDAO categorias =new JDBCCategoryDAOImpl();
			categorias.setConnection(conn); 
								
			request.setAttribute("HostingCategoria",HostingCategoria);
			request.setAttribute("Categorias",categorias.getAll());
			RequestDispatcher view = request.getRequestDispatcher("Categorias.jsp");
			view.forward(request,response);
			
		}else {
			
			String error = "¡ERROR: Contraseña o Usuario Incorrecto!";
			request.setAttribute("error",error);
			RequestDispatcher view = request.getRequestDispatcher("IniciaSesionoRegistrate.jsp");
			view.forward(request,response);
		}




	}



}
