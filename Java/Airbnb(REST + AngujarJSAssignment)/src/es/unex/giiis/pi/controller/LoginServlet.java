package es.unex.giiis.pi.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Logger;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.Path;
import es.unex.giiis.pi.dao.JDBCUserDAOImpl;
import es.unex.giiis.pi.dao.UserDAO;
import es.unex.giiis.pi.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		urlPatterns = { "/IniciarSesion" }
		)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());




	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			RequestDispatcher view = request.getRequestDispatcher("/pages/IniciarSesion.jsp");
			view.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);
		HttpSession session = request.getSession();

		String username = request.getParameter("user");
		String password = request.getParameter("password");		

				if(username!=null && password !=null ) {
					User user = userDao.get(username);

					if ((user != null) && (user.getPassword().equals(password)))
					{
						logger.info("credentials: "+username+" - "+password);
						session.setAttribute("user",user);
						response.sendRedirect("pages/index.html"); //Redirigimos a una nueva aplicación raíz de la 
						//aplicación en angular js
					}else { 
						request.setAttribute("error","¡ERROR: Contraseña o Usuario Incorrecto!");
						RequestDispatcher view = request.getRequestDispatcher("/pages/IniciarSesion.jsp");
						view.forward(request,response);}					
				}else {

					request.setAttribute("error","¡ERROR: Algún parámetro se encuentra vacio!");
					RequestDispatcher view = request.getRequestDispatcher("/pages/IniciarSesion.jsp");
					view.forward(request,response);}			



	}	
}

