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
import java.util.Iterator;
import java.util.List;

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
 * Servlet implementation class EditarAlojamient
 */
public class EditarAlojamient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarAlojamient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		HostingDAO HostingDAO = new JDBCHostingDAOImpl();
		HostingDAO.setConnection(conn);

		HostingCategoriesDAO hostingsCategoriesDAO = new JDBCHostingCategoriesDAOImpl();
		hostingsCategoriesDAO.setConnection(conn);
		Hosting HostingAux = new Hosting();
		String idHosting = request.getParameter("idHosting");
		HostingAux = HostingDAO.get(Long.parseLong(idHosting));

		String accion = request.getParameter("boton");

		switch (accion) {
		case "Aceptar y continuar" : {

			String nombre = request.getParameter("nombre");
			String desc = request.getParameter("desc");
			String tlf = request.getParameter("tlf");
			String correo = request.getParameter("correo");
			//String precio = request.getParameter("precio");
			String localidad = request.getParameter("localidad");

			String av = request.getParameter("av");
			String dis = request.getParameter("dis");
			
			
			
			Hosting HostAntiguo = new Hosting();
			HostAntiguo = HostingDAO.get(Long.parseLong(idHosting));

			HostingAux.setId(HostAntiguo.getId());
			HostingAux.setIdu(HostAntiguo.getIdu());
			HostingAux.setLikes(HostAntiguo.getLikes());

			if(av!=null) { 
				if(av.equals("1"))HostingAux.setAvailable(2);				
			}else HostingAux.setAvailable(0);
			
			CategoryDAO categoryDAO = new JDBCCategoryDAOImpl();
			categoryDAO.setConnection(conn);
			List<Category> categorias = categoryDAO.getAll();
			
			for(Category categoriaAux:categorias) {
				String idCategoria = request.getParameter(categoriaAux.getId()+"");
				
				if(idCategoria !=null) {
						HostingCategories nuevoHostingCategories = new HostingCategories();
						nuevoHostingCategories.setIdh(HostingAux.getId());
						nuevoHostingCategories.setIdct(categoriaAux.getId());
						hostingsCategoriesDAO.add(nuevoHostingCategories);
				}else hostingsCategoriesDAO.delete(HostAntiguo.getId(), categoriaAux.getId());
			}
				
			

			if(nombre == "") HostingAux.setTitle(HostAntiguo.getTitle());
			else HostingAux.setTitle(nombre);

			if(correo == "") HostingAux.setContactEmail(HostAntiguo.getContactEmail());
			else HostingAux.setContactEmail(correo);

			if(desc == "") HostingAux.setDescription(HostAntiguo.getDescription());
			else HostingAux.setDescription(desc);

			if(localidad == "") HostingAux.setLocation(HostAntiguo.getLocation());
			else HostingAux.setLocation(localidad);

			if(tlf == "") HostingAux.setTelephone(HostAntiguo.getTelephone());
			else HostingAux.setTelephone(tlf);
			if(dis.equals("1"))HostingAux.setDisponible(1);
			else HostingAux.setDisponible(0);
			
			HostingDAO.save(HostingAux);
			break;	
		}
		case "Cancelar" : {

			break;		}
		case "Eliminar Alojamiento": {

			
			/*Borrar la relación que tiene este alojamiento con la categoria */
			List<HostingCategories>HostingsList= hostingsCategoriesDAO.getAllByHosting(HostingAux.getId());
			for(HostingCategories HostingCategoriesAux : HostingsList) 
				hostingsCategoriesDAO.delete(HostingCategoriesAux.getIdh(), HostingCategoriesAux.getIdct());
			
			/*Borrar la relación que tiene este alojamiento con los like que ha  recibido */
			LikeDAO likeDAO =  new JDBLikeDAOImpl();
			likeDAO.setConnection(conn);
			
			List<like> LikeList = likeDAO.getAllByHosting(HostingAux.getId());
			for(like LikeAux:LikeList ) likeDAO.delete(LikeAux.getIdUser(), LikeAux.getIdHosting());
				
			/*Borrar el alojamiento */
			HostingDAO.delete(HostingAux.getId());
			
			break;	
		}

		}
		
		List<Hosting> Hostings = HostingDAO.getAllByUser(HostingAux.getIdu());

		request.setAttribute("Hostings",Hostings);

		RequestDispatcher view = request.getRequestDispatcher("GestionAlojamientos.jsp");
		view.forward(request,response);



	}

}
