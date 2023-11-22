package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
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
import es.unex.pi.model.Hosting;
import es.unex.pi.model.User;

/**
 * Servlet implementation class Registro
 */
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registro() {
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


		RequestDispatcher view = request.getRequestDispatcher("registro.jsp");
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

		String username = request.getParameter("usuario");
		String email = request.getParameter("correo");
		String contra1 = request.getParameter("contra1");
		String contra2 = request.getParameter("contra2");
		String accion = request.getParameter("accion");
		
		switch (accion) {
		case "Aceptar y continuar": {
			if(username == "" || email =="" || contra1 == "" || contra2 == ""){

				String error="¡ ERROR: Se tienen que completar todos los parámetros !";
				request.setAttribute("error",error);
				RequestDispatcher view = request.getRequestDispatcher("registro.jsp");
				view.forward(request,response);

			}else{
				User user = userDAO.get(username);



				if(user != null) { //Comprobamos si el usuario esta en la bd
					String error="¡ ERROR: El usuario introducido ya se encuentra registrado !";
					request.setAttribute("error",error);
					RequestDispatcher view = request.getRequestDispatcher("registro.jsp");
					view.forward(request,response);

				}else {//Comprobamos si el correo esta en la bd

					List<User> listUser = new ArrayList<User>();
					listUser = userDAO.getAll();
					Iterator<User> itUser = listUser.iterator();
					boolean enc = false; 
					while(itUser.hasNext() && !enc) {
						User userAux = itUser.next();
						if(userAux.getEmail().equals(email))enc = true;
					}

					if(enc) {
						String error="¡ ERROR: El correo introducido ya se encuentra registrado !";
						request.setAttribute("error",error);
						RequestDispatcher view = request.getRequestDispatcher("registro.jsp");
						view.forward(request,response);
					}else { //Comprobamos si las dos contraseñas coinciden

						if(!contra1.equals(contra2)) {

							String error="¡ ERROR: Las contraseñas introducidas no coinciden !";
							request.setAttribute("error",error);
							RequestDispatcher view = request.getRequestDispatcher("registro.jsp");
							view.forward(request,response);


						}else {

							if(contra1.length()<5) {

								String error="¡ ERROR: Las contraseña introducida es demasiado corta. Tiene que tener al menos 5 dígitos!";
								request.setAttribute("error",error);
								RequestDispatcher view = request.getRequestDispatcher("registro.jsp");
								view.forward(request,response);

							}else {
								User usuarioNuevo =  new User();
								usuarioNuevo.setId(userDAO.getAll().size());
								usuarioNuevo.setUsername(username);
								usuarioNuevo.setEmail(email);
								usuarioNuevo.setPassword(contra1);
								userDAO.add(usuarioNuevo );
								response.sendRedirect("IniciaSesionoRegistrate.jsp");
							}

						}
					}
				}
			}
			break;
		}
		
		case "Atrás": {
			RequestDispatcher view = request.getRequestDispatcher("IniciaSesionoRegistrate.jsp");
			view.forward(request,response);
			
			break;
		}
		}


	}

}
