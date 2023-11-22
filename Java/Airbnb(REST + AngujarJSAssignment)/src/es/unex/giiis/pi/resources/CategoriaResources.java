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
import es.unex.giiis.pi.dao.CategoryDAO;
import es.unex.giiis.pi.dao.HostingCategoriesDAO;
import es.unex.giiis.pi.dao.HostingDAO;
import es.unex.giiis.pi.dao.JDBCHostingCategoriesDAOImpl;
import es.unex.giiis.pi.model.User;
import es.unex.giiis.pi.model.like;
import es.unex.giiis.pi.resources.exceptions.CustomNotFoundException;
import es.unex.giiis.pi.model.Category;
import es.unex.giiis.pi.model.Hosting;
import es.unex.giiis.pi.model.HostingCategories;
import es.unex.giiis.pi.dao.JDBCCategoryDAOImpl;


@Path("/categorias")
public class CategoriaResources  {

	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;



	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getCategorias(@Context HttpServletRequest request) {


		Connection conn = (Connection) sc.getAttribute("dbConn");

		CategoryDAO categoryDAO = new JDBCCategoryDAOImpl();
		categoryDAO.setConnection(conn);


		return categoryDAO.getAll();

	}


	@GET
	@Path("/existencia/{nombreCategoria}")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean getExistenciaCategoria(@PathParam("nombreCategoria") String nombreCategoria,@Context HttpServletRequest request) {

		Boolean encCategoria = false;

		Connection conn = (Connection) sc.getAttribute("dbConn");

		CategoryDAO categoryDAO = new JDBCCategoryDAOImpl();
		categoryDAO.setConnection(conn);

		Category categoryAux = categoryDAO.get(nombreCategoria);

		if(categoryAux != null) encCategoria = true;

		return encCategoria;

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response post(Category categoria,@Context HttpServletRequest request) {


		Connection conn = (Connection) sc.getAttribute("dbConn");	 
		CategoryDAO categoryDAO = new JDBCCategoryDAOImpl();
		categoryDAO.setConnection(conn);

		long id = categoryDAO.add(categoria);


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
	
	
	@DELETE
	@Path("/{categoriaID: [0-9]+}")
	public Response delete(@PathParam("categoriaID")Long categoriaID ,@Context HttpServletRequest request) {


		Connection conn = (Connection) sc.getAttribute("dbConn");	 
		CategoryDAO categoryDAO = new JDBCCategoryDAOImpl();
		categoryDAO.setConnection(conn);
		
		categoryDAO.delete(categoriaID);
		


		Response res=null;
		return res;  

	}


	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response put(Category categoria,@Context HttpServletRequest request) {


		Connection conn = (Connection) sc.getAttribute("dbConn");	 
		CategoryDAO categoryDAO = new JDBCCategoryDAOImpl();
		categoryDAO.setConnection(conn);

		Category categoriaAux = categoryDAO.get(categoria.getId());
		if(categoria.getName() != null)  categoriaAux.setName(categoria.getName());
		if(categoria.getDescription() != null)  categoriaAux.setDescription(categoria.getDescription());

		categoryDAO.save(categoriaAux);

		Response res = null;
		return res;  

	}



}
