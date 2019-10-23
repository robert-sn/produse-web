/**
 * 
 */
package mapper;
import org.apache.ibatis.annotations.*;
import java.util.*;
import produse.Rol;
/**
 * @author laurentiu.balmus
 *
 */
public interface Rol_mapper {
	final String selectRol = "select rol_id, rol_nume from rol order by rol_nume";
	
	
	@Select(selectRol)
	@Results(value = {
			@Result(property="rol_id", column="ROL_ID"),
			@Result(property="rol_nume", column="ROL_NUME")
	})
	List<Rol> selectRol();
}
