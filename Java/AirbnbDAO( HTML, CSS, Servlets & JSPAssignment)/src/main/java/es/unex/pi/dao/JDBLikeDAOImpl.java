package es.unex.pi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import es.unex.pi.model.like;

public class JDBLikeDAOImpl implements LikeDAO{
	
	private Connection conn;
	private static final Logger logger = Logger.getLogger(JDBLikeDAOImpl.class.getName());

	@Override
	public List<like> getAll() {

		if (conn == null) return null;
						
		ArrayList<like> likeList = new ArrayList<like>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM likes");
						
			while ( rs.next() ) {
				like like = new like();
				like.setIdUser(rs.getInt("idUser"));
				like.setIdHosting(rs.getInt("idHosting"));
						
				likeList.add(like);
				logger.info("fetching all likes: "+like.getIdUser()+" "+like.getIdHosting());
					
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return likeList;
	}

	@Override
	public List<like> getAllByHosting(long idHosting) {
		
		if (conn == null) return null;
						
		ArrayList<like> likeList = new ArrayList<like>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM likes WHERE idHosting="+idHosting);

			while ( rs.next() ) {
				like like = new like();
				like.setIdUser(rs.getInt("idUser"));
				like.setIdHosting(rs.getInt("idHosting"));

				likeList.add(like);
				logger.info("fetching all likes by idUser: "+like.getIdUser()+"->"+like.getIdHosting());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return likeList;
	}
	
	@Override
	public List<like> getAllByUser(long idUser){
		
		if (conn == null) return null;
						
		ArrayList<like> likeList = new ArrayList<like>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM likes WHERE idUser="+idUser);

			while ( rs.next() ) {
				like like = new like();
				like.setIdUser(rs.getInt("idUser"));
				like.setIdHosting(rs.getInt("idHosting"));
							
				likeList.add(like);
				logger.info("fetching all likes by idHosting: "+like.getIdHosting()+"-> "+like.getIdUser());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return likeList;
	}
	
	
	@Override
	public like get(long idUser,long idHosting) {
		if (conn == null) return null;
		
		like like = null;		
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM likes WHERE idUser="+idUser+" AND idHosting="+idHosting);			 
			if (!rs.next()) return null;
			like= new like();
			like.setIdUser(rs.getInt("idUser"));
			like.setIdHosting(rs.getInt("idHosting"));

			logger.info("fetching likes by idUser: "+like.getIdUser()+"  and idHosting: "+like.getIdHosting());
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return like;
	}
	
	

	@Override
	public boolean add(like like) {
		boolean done = false;
		if (conn != null){
			
			Statement stmt;
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate("INSERT INTO likes (idUser,idHosting) VALUES('"+
									like.getIdUser()+"','"+
									like.getIdHosting()+"')");
						
				logger.info("creating likes:("+like.getIdUser()+" "+like.getIdHosting());
				done= true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return done;
	}

	@Override
	public boolean save(like like) {
		boolean done = false;
		if (conn != null){

			Statement stmt;
			try {
				stmt = conn.createStatement();
				
				ResultSet rs = stmt.executeQuery("SELECT * FROM likes WHERE idUser="+like.getIdUser());			 
				if (!rs.next()) 
					return false;
				long idHosting = rs.getInt("idHosting");

				stmt.executeUpdate("UPDATE likes SET idHosting="+like.getIdHosting()
				+" WHERE idUser = "+like.getIdUser() + " AND idHosting = " + idHosting);
				
				logger.info("updating likes:("+like.getIdUser()+" "+like.getIdHosting());
				
				done= true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return done;
	}

	@Override
	public boolean delete(long idUser, long idHosting) {
		boolean done = false;
		if (conn != null){

			Statement stmt;
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate("DELETE FROM likes WHERE idUser ="+idUser+" AND idHosting="+idHosting);
				logger.info("deleting likes: "+idUser+" , idHosting="+idHosting);
				done= true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return done;
	}

	@Override
	public void setConnection(Connection conn) {
		// TODO Auto-generated method stub
		this.conn = conn;
	}

}
