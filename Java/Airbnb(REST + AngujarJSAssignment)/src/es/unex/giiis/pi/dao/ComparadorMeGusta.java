package es.unex.giiis.pi.dao;
import java.util.Comparator;
import es.unex.giiis.pi.model.*;

public class ComparadorMeGusta implements  Comparator<Hosting>{

	public int compare(Hosting h1, Hosting h2) {
		
		if(h1.getLikes() == h2.getLikes()) 
			return h1.getTitle().compareTo(h2.getTitle());
		else 
			if(h1.getLikes() > h2.getLikes()) 
				return 1;
			else 
				return -1;
			
		
	}
}
