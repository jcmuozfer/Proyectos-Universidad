
package es.unex.giiis.pi.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
 * Servlet implementation class Registro
 */
@WebServlet(
		urlPatterns = { "/RegistrarUsuario" }
		)
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		logger.info("Atendiendo GET");

		RequestDispatcher view = request.getRequestDispatcher("/pages/registro.jsp");
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
				RequestDispatcher view = request.getRequestDispatcher("/pages/registro.jsp");
				view.forward(request,response);

			}else{
				User user = userDAO.get(username);



				if(user != null) { //Comprobamos si el usuario esta en la bd
					String error="¡ ERROR: El usuario introducido ya se encuentra registrado !";
					request.setAttribute("error",error);
					RequestDispatcher view = request.getRequestDispatcher("/pages/registro.jsp");
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
						RequestDispatcher view = request.getRequestDispatcher("/pages/registro.jsp");
						view.forward(request,response);
					}else { //Comprobamos si las dos contraseñas coinciden

						if(!contra1.equals(contra2)) {

							String error="¡ ERROR: Las contraseñas introducidas no coinciden !";
							request.setAttribute("error",error);
							RequestDispatcher view = request.getRequestDispatcher("/pages/registro.jsp");
							view.forward(request,response);


						}else {

							if(contra1.length()<5) {

								String error="¡ ERROR: Las contraseña introducida es demasiado corta. Tiene que tener al menos 5 dígitos!";
								request.setAttribute("error",error);
								RequestDispatcher view = request.getRequestDispatcher("/pages/registro.jsp");
								view.forward(request,response);

							}else {
								User usuarioNuevo =  new User();
								usuarioNuevo.setId(userDAO.getAll().size());
								usuarioNuevo.setUsername(username);
								usuarioNuevo.setEmail(email);
								usuarioNuevo.setPassword(contra1);
								userDAO.add(usuarioNuevo );
								RequestDispatcher view = request.getRequestDispatcher("/pages/IniciarSesion.jsp");
								view.forward(request,response);							}

						}
					}
				}
			}
			break;
		}
		
		case "Atrás": {
			RequestDispatcher view = request.getRequestDispatcher("/pages/IniciarSesion.jsp");
			view.forward(request,response);
			
			break;
		}
		}


	}

}
