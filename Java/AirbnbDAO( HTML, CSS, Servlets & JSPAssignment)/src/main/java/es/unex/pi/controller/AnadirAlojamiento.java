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
import java.util.Iterator;
import java.util.List;
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
 * Servlet implementation class AnadirAlojamiento
 */
public class AnadirAlojamiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnadirAlojamiento() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Atendiendo GET");

		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		CategoryDAO categoryDAO = new JDBCCategoryDAOImpl();
		categoryDAO.setConnection(conn);
		List<Category> categorias = categoryDAO.getAll();


		request.setAttribute("categorias",categorias);

		RequestDispatcher view = request.getRequestDispatcher("AnadirAlojamiento.jsp");
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		UserDAO userDAO = new JDBCUserDAOImpl();
		userDAO.setConnection(conn);

		CategoryDAO categoryDAO = new JDBCCategoryDAOImpl();
		categoryDAO.setConnection(conn);
		List<Category> categorias = categoryDAO.getAll();
		String accion = request.getParameter("accion");



		switch (accion) {
		case "Aceptar y continuar": {
			String nombre = request.getParameter("nombre");
			String desc = request.getParameter("desc");
			String tlf = request.getParameter("tlf");
			String correo = request.getParameter("correo");
			String precio = request.getParameter("precio");
			String localidad = request.getParameter("localidad");
			String serv = request.getParameter("serv");

			if(nombre=="" || desc=="" || tlf=="" || correo=="" || precio=="" || localidad=="" ){

				String error ="¡ ERROR: Se tienen que completar todos los parámetros !";

				request.setAttribute("categorias",categorias);
				request.setAttribute("error",error);

				RequestDispatcher view = request.getRequestDispatcher("AnadirAlojamiento.jsp");
				view.forward(request,response);

			}else{

				HttpSession sesion = request.getSession();
				User user = (User) sesion.getAttribute("user");

				HostingDAO HostingDAO = new JDBCHostingDAOImpl();
				HostingDAO.setConnection(conn);

				Hosting nuevoHosting = new Hosting();
				nuevoHosting.setContactEmail(correo);
				if(serv !=null) {
					nuevoHosting.setAvailable(1);
				}else {
					nuevoHosting.setAvailable(0);
				}
				nuevoHosting.setDescription(desc);
				nuevoHosting.setIdu((int)user.getId());
				nuevoHosting.setLikes(0);
				nuevoHosting.setLocation(localidad);
				nuevoHosting.setTelephone(tlf);
				nuevoHosting.setTitle(nombre);
				nuevoHosting.setDisponible(1);

				HostingDAO.add(nuevoHosting);


				HostingCategoriesDAO HostingsCategoriesDAO = new JDBCHostingCategoriesDAOImpl();
				HostingsCategoriesDAO.setConnection(conn);

				HostingCategories nuevoHostingCategories = new HostingCategories();

				/*Para obtener el id del último hosting*/
				List<Hosting> HostingsList = HostingDAO.getAll();
				Iterator<Hosting> itHostingList = HostingsList.iterator();
				long idUltHost=-1;
				while(itHostingList.hasNext()) {
					Hosting Hosting = (Hosting) itHostingList.next();
					if(!itHostingList.hasNext()) idUltHost= Hosting.getId();
				}

				for(Category categoriaAux:categorias) {
					String idCategoria = request.getParameter(categoriaAux.getName());
					if(idCategoria !=null) {
						nuevoHostingCategories.setIdh(idUltHost);
						nuevoHostingCategories.setIdct(categoriaAux.getId());
						HostingsCategoriesDAO.add(nuevoHostingCategories);
					}
				}

				List<Hosting> Hostings = HostingDAO.getAllByUser(user.getId());

				request.setAttribute("Hostings",Hostings);

				RequestDispatcher view = request.getRequestDispatcher("GestionAlojamientos.jsp");
				view.forward(request,response);


			}
			break;
		}
		case "Atrás": {
			
			HostingDAO HostingDAO = new JDBCHostingDAOImpl();
			HostingDAO.setConnection(conn);
			HttpSession sesion = request.getSession();
			User user = (User) sesion.getAttribute("user");
			List<Hosting> Hostings = HostingDAO.getAllByUser(user.getId());
			request.setAttribute("Hostings",Hostings);
			response.sendRedirect("GestionAlojamientos.jsp");
			
			break;
		}
		}


	}
}
