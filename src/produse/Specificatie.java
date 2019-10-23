/**
 * 
 */
package produse;

/**
 * @author laurentiu.balmus
 *
 */
public class Specificatie {

	int specificatie_id;
	String specificatie_nume, specificatie_valoare;
	/**
	 * 
	 */
	public Specificatie() {
		
	specificatie_id = 0;
	specificatie_nume = null;
	specificatie_valoare = null;
	
	}
	/**
	 * 
	 * @param specificatie_id
	 * @param specificatie_nume
	 * @param specificatie_valoare
	 */
	public Specificatie(int specificatie_id, String specificatie_nume , String specificatie_valoare) {
		this.specificatie_id = specificatie_id;
		this.specificatie_nume = specificatie_nume;
		this.specificatie_valoare = specificatie_valoare;
	}
	
	/**
	 * 
	 * @return specificatie_id
	 */
	public int getSpecificatie_id() {
		return specificatie_id;
	}
	/**
	 * 
	 * @return
	 */
	public String getSpecificatie_nume() {
		return specificatie_nume;
	}
	/**
	 * 
	 * @return
	 */
	public String getSpecificatie_valoare() {
		return specificatie_valoare;
	}
	/**
	 * 
	 * @param specificatie_id
	 */
	public void setSpecificatie_id(int specificatie_id) {
		this.specificatie_id = specificatie_id;
	}
	/**
	 * 
	 * @param specificatie_nume
	 */
	public void setSpecificatie_nume(String specificatie_nume) {
		this.specificatie_nume = specificatie_nume;
	}
	/**
	 * 
	 * @param specificatie_valoare
	 */
	public void setSpecificatie_valoare(String specificatie_valoare) {
		this.specificatie_valoare = specificatie_valoare;
	}
	/**
	 * 
	 */
	public String toString() {
		return specificatie_id +"|" + specificatie_nume +"|"+specificatie_valoare;
	}
	
}
