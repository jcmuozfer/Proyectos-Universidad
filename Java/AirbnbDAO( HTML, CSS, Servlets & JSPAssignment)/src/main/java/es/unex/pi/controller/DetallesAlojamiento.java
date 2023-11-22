package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import es.unex.pi.dao.*;
import es.unex.pi.model.*;



/**
 * Servlet implementation class DetallesAlojamiento
 */
public class DetallesAlojamiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetallesAlojamiento() {
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
		UserDAO userDAO = new JDBCUserDAOImpl();
		userDAO.setConnection(conn);

		HostingDAO HostingDAO = new JDBCHostingDAOImpl();
		HostingDAO.setConnection(conn);

		HostingCategoriesDAO hostingsCategoriesDAO = new JDBCHostingCategoriesDAOImpl();
		hostingsCategoriesDAO.setConnection(conn);

		String meGusta = request.getParameter("meGusta");
		String idHosting = request.getParameter("idHosting");

		Hosting HostingAux = HostingDAO.get(Long.parseLong(idHosting));

		LikeDAO likeDAO =  new JDBLikeDAOImpl();
		likeDAO.setConnection(conn);


		User user = userDAO.get(HostingAux.getIdu());	

		request.setAttribute("corazon","imgDetalles/corazon.png");

		
		if(meGusta != null) {
			if(likeDAO.get(user.getId(), HostingAux.getId()) !=null) {
				HostingAux.setLikes(HostingAux.getLikes() - 1 );
				HostingDAO.save(HostingAux);
				HostingAux = HostingDAO.get(Long.parseLong(idHosting));
				likeDAO.delete(user.getId(), HostingAux.getId());	
				request.setAttribute("corazon","imgDetalles/corazon.png");
				
			}
			else {

				HostingAux.setLikes(HostingAux.getLikes() +1 );
				HostingDAO.save(HostingAux);

				like NuevoLike = new like();
				NuevoLike.setIdHosting(HostingAux.getId());
				NuevoLike.setIdUser(user.getId());
				likeDAO.add(NuevoLike);
				request.setAttribute("corazon","imgDetalles/corazonMegusta.png");

				


			}
					

		}

		
		if(likeDAO.get(user.getId(), HostingAux.getId()) !=null) 
			request.setAttribute("corazon","imgDetalles/corazonMegusta.png");

		
		
		List<Hosting> alojamientosRelacionados = new ArrayList<Hosting>();

		
		Hosting alojamientoDetalle = HostingDAO.get(Long.parseLong(idHosting));
		
		//Obtener alojamientos que tengan la misma categoria
		
		List<HostingCategories> categoriasAlojamientoDet = new  ArrayList<HostingCategories>();
		categoriasAlojamientoDet =  hostingsCategoriesDAO.getAllByHosting(Long.parseLong(idHosting));

		List<HostingCategories> categoriasAlojamientoRel = new  ArrayList<HostingCategories>();
		for(HostingCategories hostingCategoriaAux : categoriasAlojamientoDet ) {
			List<HostingCategories> aux =  hostingsCategoriesDAO.getAllByCategory(hostingCategoriaAux.getIdct());
			for(HostingCategories hostingCategoriaAuxAux : aux ) {
				if(hostingCategoriaAuxAux.getIdh() != Long.parseLong(idHosting)) 
				categoriasAlojamientoRel.add(hostingCategoriaAuxAux);
			}
		} 
		
		for(HostingCategories hostingCategoriaAux : categoriasAlojamientoRel) 
			alojamientosRelacionados.add(HostingDAO.get(hostingCategoriaAux.getIdh()));
	
		
		
		for(Hosting alojamientoAux : HostingDAO.getAll()) 
			if(alojamientoDetalle.getLocation().equals(alojamientoAux.getLocation()) && (alojamientoDetalle.getId() != alojamientoAux.getId())) {
				Boolean enc  =false;
				
				for(Hosting alojamientoAuxAux  :alojamientosRelacionados) 
					if(alojamientoAux.getId() == alojamientoAuxAux.getId()) enc = true;
					
				if(!enc) alojamientosRelacionados.add(alojamientoAux);

				
			}
		
		
		
		
		
		
		
		request.setAttribute("propietario",user.getUsername());
		request.setAttribute("HostingAux",HostingAux);
		request.setAttribute("alojamientosRelacionados",alojamientosRelacionados);

		RequestDispatcher view = request.getRequestDispatcher("detalleAlojamiento.jsp");
		view.forward(request,response);

	}



}
