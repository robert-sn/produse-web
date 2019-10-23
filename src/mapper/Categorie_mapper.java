/**
 * 
 */
package mapper;
import produse.Categorie;
import java.util.List;


import org.apache.ibatis.annotations.*;


/**
 * @author laurentiu.balmus
 *
 */
public interface Categorie_mapper {
	final String selectCategorie = "SELECT * FROM CATEGORIE ORDER BY CATEGORIE_NUME";	
	final String insertCategorie = "INSERT INTO CATEGORIE(CATEGORIE_NUME) VALUE (#{categorie_nume})";
	
	@Select(selectCategorie)
	@Results(value = {
			@Result(property="categorie_id",column="CATEGORIE_ID"),
			@Result(property="categorie_nume",column="CATEGORIE_NUME")			
	})	
	List<Categorie> selectCategorie();
	
	@Insert(insertCategorie)
	void insertCategorie(String categorie_nume);
	
}
