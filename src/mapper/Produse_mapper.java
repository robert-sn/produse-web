/**
 * 
 */
package mapper;
import org.apache.ibatis.annotations.*;
import java.util.*;
import produse.Produs;
/**
 * @author laurentiu.balmus
 *
 */
public interface Produse_mapper {
	final String selectProdus = "SELECT * FROM PRODUS";
	final String selectProdusActiv = "SELECT * FROM PRODUS WHERE produs_stare = 1 AND PRODUS_STOC > 0";
	final String selectProdusById = "SELECT * FROM PRODUS WHERE PRODUS_ID = #{id}";
	final String selectProdusByNume = "SELECT * FROM PRODUS WHERE PRODUS_NUME = #{produs_nume};";
	final String insertProdus = "INSERT INTO PRODUS(PRODUS_NUME, PRODUS_PRET, PRODUS_STOC, PRODUS_GARANTIE, PRODUS_DESCRIERE_SCURTA, produs_stare, CATEGORIE_ID)"
			+ "VALUES(#{produs_nume}, #{produs_pret}, #{produs_stoc}, #{produs_garantie}, #{produs_descriere_scurta}, #{produs_stare}, #{categorie_id})";
	
	final String updateProdusPret = "UPDATE PRODUS SET PRODUS_PRET = #{produs_pret} WHERE PRODUS_ID = #{produs_id}";
	final String updateProdusCantitate= "UPDATE PRODUS SET PRODUS_STOC = #{produs_stoc} WHERE PRODUS_ID = #{produs_id}";
	final String updateProdusStare = "UPDATE PRODUS SET produs_stare = #{produs_stare} WHERE PRODUS_ID = #{produs_id}";
	@Select(selectProdus)
	@Results(value = {
			@Result(property="produs_id" , column="PRODUS_ID"),
			@Result(property="produs_nume", column="PRODUS_NUME"),
			@Result(property="produs_pret", column="PRODUS_PRET"),
			@Result(property="produs_stoc", column="PRODUS_STOC"),
			@Result(property="produs_garantie", column="PRODUS_GARANTIE"),
			@Result(property="produs_descriere_scurta", column="PRODUS_DESCRIERE_SCURTA"),
			@Result(property="produs_stare", column="produs_stare"),
			@Result(property="categorie_id", column="CATEGORIE_ID")			
	})	
	List<Produs> selectProdus();
	
	@Select(selectProdusActiv)
	@Results(value = {
			@Result(property="produs_id" , column="PRODUS_ID"),
			@Result(property="produs_nume", column="PRODUS_NUME"),
			@Result(property="produs_pret", column="PRODUS_PRET"),
			@Result(property="produs_stoc", column="PRODUS_STOC"),
			@Result(property="produs_garantie", column="PRODUS_GARANTIE"),
			@Result(property="produs_descriere_scurta", column="PRODUS_DESCRIERE_SCURTA"),
			@Result(property="produs_stare", column="produs_stare"),
			@Result(property="categorie_id", column="CATEGORIE_ID")			
	})
	List<Produs> selectProdusActiv();
	
	@Select(selectProdusById)
	@Results(value = {
			@Result(property="produs_id" , column="PRODUS_ID"),
			@Result(property="produs_nume", column="PRODUS_NUME"),
			@Result(property="produs_pret", column="PRODUS_PRET"),
			@Result(property="produs_stoc", column="PRODUS_STOC"),
			@Result(property="produs_garantie", column="PRODUS_GARANTIE"),
			@Result(property="produs_descriere_scurta", column="PRODUS_DESCRIERE_SCURTA"),
			@Result(property="produs_stare", column="produs_stare"),
			@Result(property="categorie_id", column="CATEGORIE_ID")			
	})	
	Produs selectProduseById(int id);
	
	@Select(selectProdusByNume)
	@Results(value = {
			@Result(property="produs_id" , column="PRODUS_ID"),
			@Result(property="produs_nume", column="PRODUS_NUME"),
			@Result(property="produs_pret", column="PRODUS_PRET"),
			@Result(property="produs_stoc", column="PRODUS_STOC"),
			@Result(property="produs_garantie", column="PRODUS_GARANTIE"),
			@Result(property="produs_descriere_scurta", column="PRODUS_DESCRIERE_SCURTA"),
			@Result(property="produs_stare", column="produs_stare"),
			@Result(property="categorie_id", column="CATEGORIE_ID")			
	})	
	Produs selectProduseByNume(String	produs_nume);
	
	@Insert(insertProdus)
	@Options(useGeneratedKeys = true, keyProperty = "produs_id")
	void insertProdus(Produs produs);
	/**
	 * 
	 * @param produs_id
	 * @param produs_pret
	 */
	@Update(updateProdusPret)	
	void updateProdusPret(@Param("produs_id") int produs_id,@Param("produs_pret")  int produs_pret); 
	/**
	 * 
	 * @param produs_id 
	 * @param produs_sotc
	 */
	@Update(updateProdusCantitate)
	void updateProdusCantitate(@Param("produs_id")int produs_id, @Param("produs_stoc") int produs_sotc);
	
	@Update(updateProdusStare)
	void updateProdusStare(@Param("produs_id")int produs_id, @Param("produs_stare") boolean produs_stare);
	
}
