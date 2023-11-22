package es.unex.giiis.pi.resources;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import es.unex.giiis.pi.dao.JDBCUserDAOImpl;
import es.unex.giiis.pi.dao.JDBCHostingDAOImpl;
import es.unex.giiis.pi.dao.UserDAO;
import es.unex.giiis.pi.dao.HostingDAO;
import es.unex.giiis.pi.model.User;
import es.unex.giiis.pi.model.like;
import es.unex.giiis.pi.resources.exceptions.CustomBadRequestException;
import es.unex.giiis.pi.resources.exceptions.CustomNotFoundException;
import es.unex.giiis.pi.dao.CategoryDAO;
import es.unex.giiis.pi.dao.ComparadorMeGusta;
import es.unex.giiis.pi.dao.JDBLikeDAOImpl;
import es.unex.giiis.pi.dao.LikeDAO;
import es.unex.giiis.pi.model.Hosting;
import es.unex.giiis.pi.dao.CategoryDAO;
import es.unex.giiis.pi.dao.JDBCCategoryDAOImpl;
import es.unex.giiis.pi.model.Category;
import es.unex.giiis.pi.dao.HostingCategoriesDAO;
import es.unex.giiis.pi.dao.JDBCHostingCategoriesDAOImpl;
import es.unex.giiis.pi.model.HostingCategories;
/**
 * Servlet implementation class AlojamientosResource
 */
@Path("/alojamientos")
public class AlojamientosResource{

	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hosting> getAlojamientos(@Context HttpServletRequest request) {


		Connection conn = (Connection) sc.getAttribute("dbConn");
		HostingDAO hostingDAO = new JDBCHostingDAOImpl ();
		hostingDAO.setConnection(conn);

		List<Hosting> alojamientos;
		alojamientos = hostingDAO.getAll();

		return alojamientos; 
	}

	
	@GET
	@Path("/CategoriasPertenece/{alojamientoID: [0-9]+}")	  
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getCategoriasPertenece(@PathParam("alojamientoID") long alojamientoID,
													@Context HttpServletRequest request) {



		Connection conn = (Connection) sc.getAttribute("dbConn");

		HostingCategoriesDAO HostingsCategoriesDAO = new JDBCHostingCategoriesDAOImpl();
		HostingsCategoriesDAO.setConnection(conn);

		CategoryDAO categoryDAO = new JDBCCategoryDAOImpl();
		categoryDAO.setConnection(conn);
		
		List<Category> categorias = categoryDAO.getAll();
		List<Category> CategoriaPertenece = new ArrayList<Category>();
		
		for(Category categoria:categorias) {
			HostingCategories hostingCategoriaAux = HostingsCategoriesDAO.get(alojamientoID, categoria.getId());
			if(hostingCategoriaAux != null) 
				CategoriaPertenece.add(categoria);
		}

		
		return CategoriaPertenece;

	}
	
	
	@GET
	@Path("/CategoriasNoPertenece/{alojamientoID: [0-9]+}")	  
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getCategoriasNoPertenece(@PathParam("alojamientoID") long alojamientoID,
													@Context HttpServletRequest request) {


		Connection conn = (Connection) sc.getAttribute("dbConn");

		HostingCategoriesDAO HostingsCategoriesDAO = new JDBCHostingCategoriesDAOImpl();
		HostingsCategoriesDAO.setConnection(conn);

		CategoryDAO categoryDAO = new JDBCCategoryDAOImpl();
		categoryDAO.setConnection(conn);
		
		List<Category> categorias = categoryDAO.getAll();
		List<Category> CategoriaNoPertenece = new ArrayList<Category>();
		
		for(Category categoria:categorias) {
			HostingCategories hostingCategoriaAux = HostingsCategoriesDAO.get(alojamientoID, categoria.getId());
			if(hostingCategoriaAux == null) 
				CategoriaNoPertenece.add(categoria);
		}

		
		return CategoriaNoPertenece;

	}
	
	
	
	
	
	@GET
	@Path("/alojamientosRelacionados/{alojamientoID: [0-9]+}")	  
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hosting> getAlojamientosRelacionados(@PathParam("alojamientoID") long alojamientoID,
			@Context HttpServletRequest request) {

		Connection conn = (Connection) sc.getAttribute("dbConn");
		
		HostingDAO hostingDAO = new JDBCHostingDAOImpl ();
		hostingDAO.setConnection(conn);
		
		HostingCategoriesDAO hostingsCategoriesDAO = new JDBCHostingCategoriesDAOImpl();
		hostingsCategoriesDAO.setConnection(conn);
		
		List<Hosting> alojamientosRelacionados = new ArrayList<Hosting>();

		
		Hosting alojamientoDetalle = hostingDAO.get(alojamientoID);
		
		//Obtener alojamientos que tengan la misma categoria
		
		List<HostingCategories> categoriasAlojamientoDet = new  ArrayList<HostingCategories>();
		categoriasAlojamientoDet =  hostingsCategoriesDAO.getAllByHosting(alojamientoID);

		List<HostingCategories> categoriasAlojamientoRel = new  ArrayList<HostingCategories>();
		for(HostingCategories hostingCategoriaAux : categoriasAlojamientoDet ) {
			List<HostingCategories> aux =  hostingsCategoriesDAO.getAllByCategory(hostingCategoriaAux.getIdct());
			for(HostingCategories hostingCategoriaAuxAux : aux ) {
				if(hostingCategoriaAuxAux.getIdh() != alojamientoID) 
				categoriasAlojamientoRel.add(hostingCategoriaAuxAux);
			}
		} 
		
		for(HostingCategories hostingCategoriaAux : categoriasAlojamientoRel) 
			alojamientosRelacionados.add(hostingDAO.get(hostingCategoriaAux.getIdh()));
	
		
		
		for(Hosting alojamientoAux : hostingDAO.getAll()) 
			if(alojamientoDetalle.getLocation().equals(alojamientoAux.getLocation()) && (alojamientoDetalle.getId() != alojamientoAux.getId())) {
				Boolean enc  =false;
				
				for(Hosting alojamientoAuxAux  :alojamientosRelacionados) 
					if(alojamientoAux.getId() == alojamientoAuxAux.getId()) enc = true;
					
				if(!enc) alojamientosRelacionados.add(alojamientoAux);

				
			}
		return alojamientosRelacionados;
	}
	
	
	
	@GET
	@Path("/buscarAlojamiento/{nombreAlojamiento}")	  
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hosting> getAlojamientosBuscar(@PathParam("nombreAlojamiento") String nombreAlojamiento,
			@Context HttpServletRequest request) {


		Connection conn = (Connection) sc.getAttribute("dbConn");
		HostingDAO hostingDAO = new JDBCHostingDAOImpl ();
		hostingDAO.setConnection(conn);


		List<Hosting> alojamientos = hostingDAO.getAll();
		if(!nombreAlojamiento.equals("null")) {
			List<Hosting> alojamientosAux = hostingDAO.getAll();

			int indice = 0;
			for(Hosting aux:alojamientosAux) {

				String titulo = aux.getTitle();
				String desc =  aux.getDescription();
				if( titulo.indexOf(nombreAlojamiento)== -1 && desc.indexOf(nombreAlojamiento)==-1) 
					alojamientos.remove(indice);	
				else indice++;
			}
		}

		return alojamientos;

	}


	@GET
	@Path("/infoAlojamiento/{alojamientoID: [0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Hosting getAlojamientoID(@PathParam("alojamientoID") long alojamientoID,
			@Context HttpServletRequest request) {


		Connection conn = (Connection) sc.getAttribute("dbConn");
		HostingDAO hostingDAO = new JDBCHostingDAOImpl ();
		hostingDAO.setConnection(conn);

		Hosting alojamiento = hostingDAO.get(alojamientoID);


		return alojamiento;

	}

	@GET
	@Path("/meGusta/{alojamientoID: [0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean getAlojamientoMegusta(@PathParam("alojamientoID") long alojamientoID,
			@Context HttpServletRequest request) {


		Connection conn = (Connection) sc.getAttribute("dbConn");
		HostingDAO hostingDAO = new JDBCHostingDAOImpl ();
		hostingDAO.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		LikeDAO likeDAO =  new JDBLikeDAOImpl();
		likeDAO.setConnection(conn);
		like meGusta = likeDAO.get(user.getId(), alojamientoID);

		boolean encMegusta = false;


		if(meGusta != null) encMegusta =true;



		return encMegusta;

	}

	@GET
	@Path("/disponibilidad/{disponibilidad}")	  
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hosting> getAlojamientoDisponibilidad(@PathParam("disponibilidad") int disponibilidad,
			@Context HttpServletRequest request) {


		Connection conn = (Connection) sc.getAttribute("dbConn");
		HostingDAO hostingDAO = new JDBCHostingDAOImpl ();
		hostingDAO.setConnection(conn);

		List<Hosting> HostingCategoria = hostingDAO.getAll();
		switch (disponibilidad) {

		case 0:
			HostingCategoria = hostingDAO.getAllNoDisponible();
			break;

		case 1:
			HostingCategoria = hostingDAO.getAllDisponible();

			break;	
		}				
		return HostingCategoria;

	}	 




	@GET
	@Path("/categoria/{categoriaID: [0-9]+}")	  
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hosting> getAlojamientoCategoria(@PathParam("categoriaID") Long categoriaID,
			@Context HttpServletRequest request) {


		Connection conn = (Connection) sc.getAttribute("dbConn");
		HostingCategoriesDAO hostingCategoriesDAO = new JDBCHostingCategoriesDAOImpl(); 
		hostingCategoriesDAO.setConnection(conn);

		HostingDAO hostingDAO = new JDBCHostingDAOImpl ();
		hostingDAO.setConnection(conn);

		List<HostingCategories> categoriaAlojamiento =  hostingCategoriesDAO.getAllByCategory(categoriaID);
		List<Hosting> alojamientos =  new ArrayList<Hosting> ();

		for(HostingCategories  hostingCategories:categoriaAlojamiento ) {

			Hosting alojamientoAux = hostingDAO.get(hostingCategories.getIdh());
			alojamientos.add(alojamientoAux);

		}




		return alojamientos;
	}	 


	@GET
	@Path("/ordenar/{ordenar}")	  
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hosting> getAlojamientoOrdenados(@PathParam("ordenar") int ordenar,
			@Context HttpServletRequest request) {


		Connection conn = (Connection) sc.getAttribute("dbConn");
		HostingDAO hostingDAO = new JDBCHostingDAOImpl ();
		hostingDAO.setConnection(conn);

		List<Hosting> HostingCategoria = hostingDAO.getAll();

		ComparadorMeGusta comparador =new ComparadorMeGusta();

		switch (ordenar) {

		case 0:
			Collections.sort(HostingCategoria,comparador);
			break;

		case 1:
			Collections.sort(HostingCategoria,Collections.reverseOrder(comparador));

			break;	
		}				
		return HostingCategoria;

	}	  

	@GET
	@Path("/alojamientosUsuario")	  
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hosting> getAlojamientosUsuario(@PathParam("alojamientoID") long alojamientoID,
			@Context HttpServletRequest request) {


		Connection conn = (Connection) sc.getAttribute("dbConn");
		HostingDAO hostingDAO = new JDBCHostingDAOImpl ();
		hostingDAO.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");


		List<Hosting> alojamientos = hostingDAO.getAllByUser(user.getId());


		return alojamientos;

	}

	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	public Response post(Hosting alojamientoNuevo, @Context HttpServletRequest request) {	

		Connection conn = (Connection) sc.getAttribute("dbConn");
		HostingDAO hostingDAO = new JDBCHostingDAOImpl ();
		hostingDAO.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		alojamientoNuevo.setIdu((int)user.getId());
		alojamientoNuevo.setLikes(0);
		Response res;	

		long id=hostingDAO.add(alojamientoNuevo);

		CategoryDAO categoriaDAO = new  JDBCCategoryDAOImpl();
		categoriaDAO.setConnection(conn);



		res = Response //return 201 and Location: /orders/newid
				.created(
						uriInfo.getAbsolutePathBuilder()
						.path(Long.toString(id))
						.build())
				.contentLocation(
						uriInfo.getAbsolutePathBuilder()
						.path(Long.toString(id))
						.build())
				.build();
		return res;  
	}


	@POST	
	@Path("/asignarCategoria")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postCategoriasAlojamientoNuevo(List<Long> categoriasID, 
			@Context HttpServletRequest request) {	

		Connection conn = (Connection) sc.getAttribute("dbConn");
		HostingCategoriesDAO hostingCategoriesDAO = new  JDBCHostingCategoriesDAOImpl();
		hostingCategoriesDAO.setConnection(conn);

		HostingDAO hostingDAO = new JDBCHostingDAOImpl ();
		hostingDAO.setConnection(conn);

		HostingCategories alojamientoCategoria = new HostingCategories();

		List<Hosting> HostingsList = hostingDAO.getAll();
		Iterator<Hosting> itHostingList = HostingsList.iterator();
		long idUltHost=-1;
		while(itHostingList.hasNext()) {
			Hosting Hosting = (Hosting) itHostingList.next();
			if(Hosting.getId() >idUltHost ) idUltHost= Hosting.getId();
		}

		for(Long categoriaID: categoriasID) {

			if(categoriaID != -1) {
				alojamientoCategoria.setIdct(categoriaID);
				alojamientoCategoria.setIdh(idUltHost);	
				hostingCategoriesDAO.add(alojamientoCategoria);
			}

		}

		return null;  
	}


	@POST	
	@Path("/asignarCategoria/{alojamientoID: [0-9]+}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postCategoriasAlojamientoID(List<Long> categoriasID,
			@PathParam("alojamientoID") long alojamientoID,
			@Context HttpServletRequest request) {	

		Connection conn = (Connection) sc.getAttribute("dbConn");
		HostingCategoriesDAO hostingCategoriesDAO = new  JDBCHostingCategoriesDAOImpl();
		hostingCategoriesDAO.setConnection(conn);


		CategoryDAO categoryDAO = new  JDBCCategoryDAOImpl();
		categoryDAO.setConnection(conn);

		List<Category> categorias = categoryDAO.getAll();
		for(Category categoriaAux: categorias)hostingCategoriesDAO.delete(alojamientoID, categoriaAux.getId()); 

		HostingCategories alojamientoCategoria = new HostingCategories();
		for(Long categoriaID: categoriasID) {
			if(categoriaID != -1) {
				alojamientoCategoria.setIdct(categoriaID);
				alojamientoCategoria.setIdh(alojamientoID);	
				hostingCategoriesDAO.add(alojamientoCategoria);
			}

		}

		return null;  
	}

	@GET
	@Path("/{alojamientoID: [0-9]+}")	  
	@Produces(MediaType.APPLICATION_JSON)
	public Hosting getAlojamientoJSON(@PathParam("alojamientoID") long alojamientoID,
			@Context HttpServletRequest request) {

		Connection conn = (Connection) sc.getAttribute("dbConn");
		HostingDAO hostingDAO = new JDBCHostingDAOImpl ();
		hostingDAO.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Hosting alojamiento = hostingDAO.get(alojamientoID);

		if(alojamiento != null && alojamiento.getIdu() ==  user.getId())
			return  alojamiento;
		else throw new CustomNotFoundException("Alojamiento ("+ alojamientoID + ") no se ha encontrado");		   

	}

	@PUT
	@Path("/meGusta/{alojamientoID: [0-9]+}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Boolean putMeGusta(@PathParam("alojamientoID") long alojamientoID,
			@Context HttpServletRequest request) throws Exception{


		Connection conn = (Connection) sc.getAttribute("dbConn");
		HostingDAO hostingDAO = new JDBCHostingDAOImpl ();
		hostingDAO.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		LikeDAO likeDAO =  new JDBLikeDAOImpl();
		likeDAO.setConnection(conn);
		like meGusta = likeDAO.get(user.getId(), alojamientoID);
		Hosting alojamientoAux = hostingDAO.get(alojamientoID);
		Boolean meGustaResp = false;
		if(meGusta != null) {

			likeDAO.delete(user.getId(), alojamientoID);
			alojamientoAux.setLikes(alojamientoAux.getLikes() - 1);
			hostingDAO.save(alojamientoAux);
		}
		else {
			like NuevoLike = new like();
			NuevoLike.setIdHosting(alojamientoID);
			NuevoLike.setIdUser(user.getId());
			likeDAO.add(NuevoLike);
			likeDAO.add(NuevoLike);
			alojamientoAux.setLikes(alojamientoAux.getLikes() + 1);
			hostingDAO.save(alojamientoAux);
			meGustaResp = true;
		}



		return meGustaResp;
	}


	@PUT
	@Path("/{alojamientoID: [0-9]+}/{categoriaID}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response put(Hosting alojamientoActualizado,
			@PathParam("alojamientoID") long alojamientoID,
			@PathParam("categoriaID") long categoriaID,
			@Context HttpServletRequest request) throws Exception{

		Connection conn = (Connection) sc.getAttribute("dbConn");
		HostingDAO hostingDAO = new JDBCHostingDAOImpl ();
		hostingDAO.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Response response = null;


		Hosting alojamientoAntiguo  = hostingDAO.get(alojamientoID);

		if( alojamientoAntiguo.getIdu() ==  user.getId()) {

			if(alojamientoActualizado.getTitle()!=null) alojamientoAntiguo.setTitle(alojamientoActualizado.getTitle());
			if(alojamientoActualizado.getDescription()!=null) alojamientoAntiguo.setDescription(alojamientoActualizado.getDescription());
			if(alojamientoActualizado.getTelephone()!=null) alojamientoAntiguo.setTelephone(alojamientoActualizado.getTelephone());
			if(alojamientoActualizado.getContactEmail()!=null) alojamientoAntiguo.setContactEmail(alojamientoActualizado.getContactEmail());
			if(alojamientoActualizado.getLocation()!=null) alojamientoAntiguo.setLocation(alojamientoActualizado.getLocation());
			alojamientoAntiguo.setAvailable(alojamientoActualizado.getAvailable());
			alojamientoAntiguo.setDisponible(alojamientoActualizado.getDisponible());

			hostingDAO.save(alojamientoAntiguo);

			if(categoriaID != -1) {
				HostingCategories alojamientoCategoria = new HostingCategories();
				alojamientoCategoria.setIdct(categoriaID);
				alojamientoCategoria.setIdh(alojamientoID);

				HostingCategoriesDAO hostingCategoriesDAO = new  JDBCHostingCategoriesDAOImpl();
				hostingCategoriesDAO.setConnection(conn);
				hostingCategoriesDAO.save(alojamientoCategoria);
			}
		}else throw new CustomNotFoundException("Alojamiento ("+ alojamientoID + ") no se ha podido actualziar");		   




		return response;
	}

	@DELETE
	@Path("/{alojamientoID: [0-9]+}")	  
	public Response deleteAlojamiento(@PathParam("alojamientoID") long alojamientoID,
			@Context HttpServletRequest request) {

		Connection conn = (Connection) sc.getAttribute("dbConn");
		HostingDAO hostingDAO = new JDBCHostingDAOImpl ();
		hostingDAO.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Hosting alojamiento = hostingDAO.get(alojamientoID);

		if(alojamiento != null && alojamiento.getIdu() ==  user.getId()) {
			hostingDAO.delete(alojamientoID);

			LikeDAO likeDAO =  new JDBLikeDAOImpl();
			likeDAO.setConnection(conn);
			List<like> alojamientoMegusta = likeDAO.getAllByHosting(alojamientoID);
			for(like likeAux : alojamientoMegusta) likeDAO.delete(likeAux.getIdUser(), likeAux.getIdHosting());

			HostingCategoriesDAO hostingCategoriesDAO = new  JDBCHostingCategoriesDAOImpl();
			hostingCategoriesDAO.setConnection(conn);
			List<HostingCategories> alojamientoCategoria = hostingCategoriesDAO.getAllByHosting(alojamientoID);
			for(HostingCategories hostingAux : alojamientoCategoria) hostingCategoriesDAO.delete(hostingAux.getIdh(),hostingAux.getIdct());

			return Response.noContent().build(); //204 no content 

		}else throw new CustomNotFoundException("Alojamiento ("+ alojamientoID + ") no se ha encontrado para eliminar");	

	}




}
