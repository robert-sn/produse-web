/**
 * 
 */
package mapper;

import org.apache.ibatis.annotations.*;
import produse.Utilizator;

/**
 * @author laurentiu.balmus
 *
 */
public interface Utilizator_mapper {
	final String selectUtilizator = "SELECT UTILIZATOR_ID, UTILIZATOR_NUME, ROL_ID FROM utilizator WHERE UTILIZATOR_NUME = #{utilizator_nume}";

	@Select(selectUtilizator)
	@Results(value = {
			@Result(property="utilizator_id", column="UTILIZATOR_ID"),
			@Result(property="utilizator_nume", column="UTILIZATOR_NUME")
	})	
	Utilizator selectUtilizator(String utilizator_nume);
}
