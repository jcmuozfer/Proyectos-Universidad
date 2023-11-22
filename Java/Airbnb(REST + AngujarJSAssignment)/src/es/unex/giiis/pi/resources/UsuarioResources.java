package es.unex.giiis.pi.resources;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import es.unex.giiis.pi.dao.JDBCUserDAOImpl;
import es.unex.giiis.pi.dao.JDBLikeDAOImpl;
import es.unex.giiis.pi.dao.LikeDAO;
import es.unex.giiis.pi.dao.JDBCHostingDAOImpl;
import es.unex.giiis.pi.dao.UserDAO;
import es.unex.giiis.pi.dao.HostingCategoriesDAO;
import es.unex.giiis.pi.dao.HostingDAO;
import es.unex.giiis.pi.dao.JDBCHostingCategoriesDAOImpl;
import es.unex.giiis.pi.model.User;
import es.unex.giiis.pi.model.like;
import es.unex.giiis.pi.resources.exceptions.CustomNotFoundException;
import es.unex.giiis.pi.model.Hosting;
import es.unex.giiis.pi.model.HostingCategories;


/**
 * Servlet implementation class UsuarioResources
 */
@Path("/usuarios")
public class UsuarioResources  {

	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;

	@POST	  
	@Consumes(MediaType.APPLICATION_JSON)
	public Response post(User usuarioNuevo,
			@Context HttpServletRequest request) {	

		Connection conn = (Connection) sc.getAttribute("dbConn");
		UserDAO userDAO = new JDBCUserDAOImpl();
		userDAO.setConnection(conn);

		long id=userDAO.add(usuarioNuevo);



		Response res;	
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

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUsuarioJSON(@Context HttpServletRequest request) {


		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if(user != null )
			return  user;
		else throw new CustomNotFoundException(" No se ha encontrado usuario de esta sesión");		   

	}

	@PUT	  
	@Consumes(MediaType.APPLICATION_JSON)
	public Response put(User usuarioModificado, @Context HttpServletRequest request) {	

		Connection conn = (Connection) sc.getAttribute("dbConn");
		UserDAO userDAO = new JDBCUserDAOImpl ();
		userDAO.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		usuarioModificado.setId(user.getId());
		if(usuarioModificado.getUsername() == null)usuarioModificado.setUsername(user.getUsername());
		if(usuarioModificado.getPassword() == null)usuarioModificado.setPassword(user.getPassword());
		if(usuarioModificado.getEmail() == null)usuarioModificado.setEmail(user.getEmail());

		userDAO.save(usuarioModificado);

		session.setAttribute("user",usuarioModificado);

		Response res = null;	

		return res;  
	}

	@DELETE
	public Response deleteUsuario(@Context HttpServletRequest request) {

		Connection conn = (Connection) sc.getAttribute("dbConn");
		UserDAO userDAO = new JDBCUserDAOImpl();
		userDAO.setConnection(conn);

		HostingDAO HostingDAO = new JDBCHostingDAOImpl();
		HostingDAO.setConnection(conn);

		HttpSession sesion = request.getSession();
		User user = (User) sesion.getAttribute("user");
		LikeDAO likeDAO =  new JDBLikeDAOImpl();
		likeDAO.setConnection(conn);

		List<Hosting> AlojamientosUsuario = HostingDAO.getAllByUser(user.getId());
		for(Hosting alojamientoAux :AlojamientosUsuario) {

			/*Borrar el alojamiento */
			HostingDAO.delete(alojamientoAux.getId());
			
			/*Borrar los likes asoacidos al alojamiento */
			List<like> alojamientoMegusta = likeDAO.getAllByHosting(alojamientoAux.getId());
			for(like likeAux : alojamientoMegusta) likeDAO.delete(likeAux.getIdUser(), likeAux.getIdHosting());
			
			/*Borrar  los hostingCategoria asoacidos al alojamiento */
			HostingCategoriesDAO hostingCategoriesDAO = new  JDBCHostingCategoriesDAOImpl();
			hostingCategoriesDAO.setConnection(conn);
			List<HostingCategories> alojamientoCategoria = hostingCategoriesDAO.getAllByHosting(alojamientoAux.getId());
			for(HostingCategories hostingAux : alojamientoCategoria) hostingCategoriesDAO.delete(hostingAux.getIdh(),hostingAux.getIdct());

			
		}
		
		List<like> alojamientoMegusta = likeDAO.getAllByUser(user.getId());
		for(like likeAux : alojamientoMegusta) { 
			
			/*Borrar  los likes asoacidos al usuario*/
			likeDAO.delete(likeAux.getIdUser(), likeAux.getIdHosting());
			/*Actualizamos  los likes totales del alojameinto asociado al like del usuario*/
			Hosting alojamientoAux = HostingDAO.get(likeAux.getIdHosting());
			int aux = alojamientoAux.getLikes();
			aux = aux -1;
			alojamientoAux.setLikes(aux);
			HostingDAO.save(alojamientoAux);
			}
		
			
		userDAO.delete(user.getId());


		return Response.noContent().build();

	}


	@GET
	@Path("/nombre/{usuarioNombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean getUsuarioNombre(@PathParam("usuarioNombre") String usuarioNombre, @Context HttpServletRequest request) {

		Connection conn = (Connection) sc.getAttribute("dbConn");
		UserDAO userDAO = new JDBCUserDAOImpl();
		userDAO.setConnection(conn);

		HttpSession sesion = request.getSession();
		User user = (User) sesion.getAttribute("user");

		if(user.getUsername().equals(usuarioNombre))return false;
		user = userDAO.get(usuarioNombre);

		if(user != null)return  true;
		else return  false;	   

	}
	
	@GET
	@Path("/correo/{usuarioNombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean getCorreo(@PathParam("usuarioNombre") String usuarioNombre, @Context HttpServletRequest request) {

		Connection conn = (Connection) sc.getAttribute("dbConn");
		UserDAO userDAO = new JDBCUserDAOImpl();
		userDAO.setConnection(conn);
		
		HttpSession sesion = request.getSession();
		User user = (User) sesion.getAttribute("user");

		if(user.getUsername().equals(usuarioNombre))return false;
		user = userDAO.get(usuarioNombre);

		if(user != null)return  true;
		else return  false;	   

	}


}
