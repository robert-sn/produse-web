/**
 * 
 */
package dao;
import java.util.*;

import produse.Categorie;

/**
 * @author laurentiu.balmus
 *
 */
public interface CategorieDAO {
	
	public List<Categorie> selectCategorie();
	public void insertCategorie(String categorie_nume);
	
	

}
