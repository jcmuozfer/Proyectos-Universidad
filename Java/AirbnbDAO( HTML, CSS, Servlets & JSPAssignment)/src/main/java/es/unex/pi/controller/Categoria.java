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
import java.util.Collections;
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
import es.unex.pi.dao.JDBLikeDAOImpl;
import es.unex.pi.dao.LikeDAO;
import es.unex.pi.dao.UserDAO;
import es.unex.pi.model.Category;
import es.unex.pi.model.Hosting;
import es.unex.pi.model.HostingCategories;
import es.unex.pi.model.User;
import es.unex.pi.model.like;
import es.unex.pi.dao.ComparadorMeGusta;

/**
 * Servlet implementation class Categoria
 */
public class Categoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Categoria() {
		super();
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
		UserDAO userDAO = new JDBCUserDAOImpl();
		userDAO.setConnection(conn);

		CategoryDAO categorias =new JDBCCategoryDAOImpl();
		categorias.setConnection(conn); 

		HostingDAO HostingDAO = new JDBCHostingDAOImpl();
		HostingDAO.setConnection(conn);

		HostingCategoriesDAO HostingCategoriesDAO = new JDBCHostingCategoriesDAOImpl();
		HostingCategoriesDAO.setConnection(conn);

		String ordenar = request.getParameter("ordenar");
		String bus = request.getParameter("bus");
		String dis = request.getParameter("dis");
		String categoria = request.getParameter("categoria");


		List<Hosting> HostingCategoria = HostingDAO.getAll();

		if(bus!=null) {

			List<Hosting> auxList = HostingDAO.getAll();
			int indice = 0;
			for(Hosting aux:auxList) {
				String titulo = aux.getTitle();
				String desc =  aux.getDescription();
				if( titulo.indexOf(bus)== -1 && desc.indexOf(bus)==-1) 
					HostingCategoria.remove(indice);	
				else indice++;
			}
		}

		if(ordenar!=null) {
			ComparadorMeGusta comparador =new ComparadorMeGusta();
			if(ordenar.equals("Más Me gustas")) Collections.sort(HostingCategoria,Collections.reverseOrder(comparador) );	
			if(ordenar.equals("Menos Me gustas")) Collections.sort(HostingCategoria,comparador);
		}
		if(dis!=null) {
			
			
			if(dis.equals("Reservado")) {
				logger.info("Reservado");
				HostingCategoria = HostingDAO.getAllNoDisponible();		
			}
			if(dis.equals("Disponible")) HostingCategoria = HostingDAO.getAllDisponible();
		}
		if(categoria!=null) {
			long idCategoria = -1;
			//Buscamos el id de la categoria
			List<Category> ListaCategorias = categorias.getAll();
			for(Category categoriaAux:ListaCategorias )
				if(categoriaAux.getName().equals(categoria)) idCategoria = categoriaAux.getId();

			if(idCategoria != -1) {
				HostingCategoria.clear();
				//Buscamos obtenemos los alojamientos que tienen esa característica
				List<HostingCategories> listaAlojamientos = HostingCategoriesDAO.getAllByCategory((int)idCategoria);

				for(HostingCategories hostC :listaAlojamientos) {
					Hosting hostingAux = HostingDAO.get(hostC.getIdh());
					HostingCategoria.add(hostingAux);
				}
			}
		}


		request.setAttribute("HostingCategoria",HostingCategoria);
		request.setAttribute("Categorias",categorias.getAll());
		RequestDispatcher view = request.getRequestDispatcher("Categorias.jsp");
		view.forward(request,response);

		}

	}
