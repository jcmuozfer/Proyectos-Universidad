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
import java.util.List;

import es.unex.pi.dao.CategoryDAO;
import es.unex.pi.dao.HostingCategoriesDAO;
import es.unex.pi.dao.JDBCCategoryDAOImpl;
import es.unex.pi.dao.JDBCHostingCategoriesDAOImpl;
import es.unex.pi.dao.JDBCUserDAOImpl;
import es.unex.pi.dao.UserDAO;
import es.unex.pi.model.Category;
import es.unex.pi.model.HostingCategories;
import es.unex.pi.model.User;

/**
 * Servlet implementation class GestionCategorias
 */
public class GestionCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionCategorias() {
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

		CategoryDAO categoryDAO = new JDBCCategoryDAOImpl();
		categoryDAO.setConnection(conn);

		HostingCategoriesDAO HostingsCategoriesDAO = new JDBCHostingCategoriesDAOImpl();
		HostingsCategoriesDAO.setConnection(conn);
		
		String opcion = request.getParameter("opcion");

		switch (opcion) {
		case "Crear Categoria": {
			String nombre = request.getParameter("nombre");
			String desc = request.getParameter("desc");
			if(nombre !="" && nombre!=null ) {
				Category NuevaCategoria = new Category();
				NuevaCategoria.setName(nombre);
				NuevaCategoria.setDescription(desc);
				categoryDAO.add(NuevaCategoria);
			}
				
			break;
		}
		
		case "Modificar Categoria": {
			String nombreC = request.getParameter("nombreC");
			String descC = request.getParameter("descC");
			String idCategoria = request.getParameter("update");
			Category CategoriaAntigua = new Category();
			CategoriaAntigua =	categoryDAO.get(Long.parseLong(idCategoria));
			
			Category NuevaCategoria = new Category();
			NuevaCategoria.setId(CategoriaAntigua.getId());
			if(nombreC=="" || nombreC==null) NuevaCategoria.setName(CategoriaAntigua.getName());
			else NuevaCategoria.setName(nombreC);
			
			if(descC=="" || descC == null) NuevaCategoria.setDescription(CategoriaAntigua.getDescription());
			else NuevaCategoria.setDescription(descC);
			
				categoryDAO.save(NuevaCategoria);
				
			break;
		}
		
		case "Eliminar Categoria": {
			List<Category> categorias = categoryDAO.getAll();
			for(Category categoria:categorias) {
				String aux = request.getParameter(categoria.getId()+"");
				if(aux!=null) 
				if( aux.equals("1")) {
					List<HostingCategories>hostingCategories = HostingsCategoriesDAO.getAllByCategory(categoria.getId());
					for(HostingCategories auxHostingCategories:hostingCategories) 
						HostingsCategoriesDAO.delete(auxHostingCategories.getIdh(), auxHostingCategories.getIdct());
			
				categoryDAO.delete(categoria.getId());
				}
			}
			break;

		}

	}
		
		UserDAO userDAO = new JDBCUserDAOImpl();
		userDAO.setConnection(conn);

		HttpSession sesion = request.getSession();
		User user = (User) sesion.getAttribute("user");

		request.setAttribute("nombre",user.getUsername());
		request.setAttribute("correo",user.getEmail());
		request.setAttribute("contra",user.getPassword());

		RequestDispatcher view = request.getRequestDispatcher("Perfil.jsp");
		view.forward(request,response);

		}
}
