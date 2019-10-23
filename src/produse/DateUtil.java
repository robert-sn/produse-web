/**
 * 
 */
package produse;

/**
 * @author laurentiu.balmus
 *
 */
public class DateUtil {

	public static java.sql.Date convertDate(java.util.Date utilDate){
		
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		return sqlDate;
				
	}
}
