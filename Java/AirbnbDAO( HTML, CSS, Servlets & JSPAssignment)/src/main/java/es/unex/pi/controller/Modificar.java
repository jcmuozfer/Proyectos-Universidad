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
import es.unex.pi.dao.JDBLikeDAOImpl;
import es.unex.pi.dao.LikeDAO;
import es.unex.pi.dao.UserDAO;
import es.unex.pi.model.Category;
import es.unex.pi.model.Hosting;
import es.unex.pi.model.HostingCategories;
import es.unex.pi.model.User;
import es.unex.pi.model.like;
import es.unex.pi.util.Triplet;

/**
 * Servlet implementation class Modificar
 */
public class Modificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Modificar() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



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

		String username = request.getParameter("usuario");
		String email = request.getParameter("correo");
		String contra1 = request.getParameter("contra1");
		String contra2 = request.getParameter("contra2");
		String opcion = request.getParameter("opcion");


		HttpSession sesion = request.getSession();
		User user = (User) sesion.getAttribute("user");

		RequestDispatcher view;

		switch(opcion) {

		case "Aceptar y continuar":


			boolean enc = false;

			if(!(username == "" && email =="" && contra1 == "" && contra2 == "")) {
				if(username != "") {
					enc = true;
					user.setUsername(username);
				}
				if(email != "") {
					enc = true;
					user.setEmail(email);
				}
				if(contra1 != "" || contra2 != "") {
					if(!contra1.equals(contra2)) {

						String error="¡ ERROR: Las contraseñas introducidas no coinciden !";
						request.setAttribute("error",error);

					}else {
						if(contra1.length()<5) {
							String error="¡ ERROR: Las contraseña introducida es inferior a 5 dígitos!";
							request.setAttribute("error",error);
						}else {		
							enc = true;
							user.setPassword(contra1);	
						}
					}
				}			
			

				if(enc) {

					userDAO.save(user);

				}
			}

			List<Hosting> HostingCategoriaAux = HostingDAO.getAll();

			CategoryDAO categoriasAux =new JDBCCategoryDAOImpl();
			categoriasAux.setConnection(conn); 


			request.setAttribute("HostingCategoria",HostingCategoriaAux);
			request.setAttribute("Categorias",categoriasAux.getAll());
			view = request.getRequestDispatcher("Categorias.jsp");
			view.forward(request,response);
			
			break;
		case "Gestión de Alojamientos":

			List<Hosting> Hostings = HostingDAO.getAllByUser(user.getId());
			sesion.setAttribute("Hostings",Hostings);
			response.sendRedirect("GestionAlojamientos.jsp");

			break;
		case "Gestión de Categorias":



			CategoryDAO categoryDAO = new JDBCCategoryDAOImpl();
			categoryDAO.setConnection(conn);
			List<Category> categorias = categoryDAO.getAll();
			request.setAttribute("categorias",categorias);
			view = request.getRequestDispatcher("GestionCategorias.jsp");
			view.forward(request,response);

			break;



		case "Cerrar Sesión":

			sesion.invalidate();
			response.sendRedirect("IniciaSesionoRegistrate.jsp");


			break;
		case "Eliminar Usuario":


			HostingCategoriesDAO HostingsCategoriesDAO = new JDBCHostingCategoriesDAOImpl();
			HostingsCategoriesDAO.setConnection(conn);

			LikeDAO likeDAO =  new JDBLikeDAOImpl();
			likeDAO.setConnection(conn);

			List<Hosting> AlojamientosUsuario = HostingDAO.getAllByUser(user.getId());
			for(Hosting alojamientoAux :AlojamientosUsuario) {

				/*Borrar la relación que tiene este alojamiento con la categoria */
				List<HostingCategories>HostingsList= HostingsCategoriesDAO.getAllByHosting(alojamientoAux.getId());
				for(HostingCategories HostingCategoriesAux : HostingsList) 
					HostingsCategoriesDAO.delete(HostingCategoriesAux.getIdh(), HostingCategoriesAux.getIdct());

				/*Borrar el alojamiento */
				HostingDAO.delete(alojamientoAux.getId());
			}
			List<like> likeUsuario = likeDAO.getAllByUser(user.getId());
			for(like likeAux:likeUsuario )likeDAO.delete(likeAux.getIdUser(), likeAux.getIdHosting());

			userDAO.delete(user.getId());
			response.sendRedirect("IniciaSesionoRegistrate.jsp");
			break;




		}

	}

}
