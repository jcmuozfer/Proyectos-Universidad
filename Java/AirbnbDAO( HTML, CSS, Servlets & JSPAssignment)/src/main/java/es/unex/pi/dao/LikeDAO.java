package es.unex.pi.dao;

import java.sql.Connection;
import java.util.List;

import es.unex.pi.model.like;

public interface LikeDAO {
	/**
	 * set the database connection in this DAO.
	 * 
	 * @param conn
	 *            database connection.
	 */
	public void setConnection(Connection conn);

	/**
	 * Gets all the hosting and the categories related to them from the database.
	 * 
	 * @return List of all the hosting and the user related to them from the database.
	 */
	
	public List<like> getAll();

	/**
	 *Gets all the host of the user that are related to a category.
	 * 
	 * @param idUser
	 *            User identifier
	 * 
	 * @return List of all the like related to a category.
	 */
	public List<like> getAllByUser(long idUser);
	
	/**
	 * Gets all the like that contains an specific hosting.
	 * 
	 * @param idHosting
	 *            Hosting Identifier
	 * 
	 * @return List of all the like that contains an specific hosting
	 */
	public List<like> getAllByHosting(long idHosting);

	/**
	 * Gets a HostingCategory from the DB using idUser and idHosting.
	 * 
	 * @param idUser 
	 *            user identifier.
	 *            
	 * @param idHosting
	 *            hosting Identifier
	 * 
	 * @return likeUser with that idh and idct.
	 */
	
	public like get(long idUser,long idHosting);

	/**
	 * Adds an like to the database.
	 * 
	 * @param HostingCategory
	 *            HostingCategory object with the details of the relation between the hosting and the category.
	 * 
	 * @return hosting identifier or -1 in case the operation failed.
	 */
	
	public boolean add(like likeHost);

	/**
	 * Updates an existing HostingCategory in the database.
	 * 
	 * @param likeHost
	 *            likeHost object with the new details of the existing relation between the hosting and the user. 
	 * 
	 * @return True if the operation was made and False if the operation failed.
	 */
	
	public boolean save(like likeHost);

	/**
	 * Deletes an like from the database.
	 * 
	 * @param idUser
	 *            User identifier.
	 *            
	 * @param idHosting
	 *            Hosting Identifier
	 * 
	 * @return True if the operation was made and False if the operation failed.
	 */
	
	public boolean delete(long idUser, long idHosting);
}
