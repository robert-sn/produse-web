/**
 * 
 */
package produse;

/**
 * @author laurentiu.balmus
 *
 */
public class Categorie_specificatie {

	int categorie_specificatie_id;
	String categorie_specificatie_nume;
	
	public Categorie_specificatie() {
		
		this.categorie_specificatie_id = 0;
		this.categorie_specificatie_nume = null;
	}
	/**
	 * 
	 * @param categorie_specificatie_id
	 * @param categorie_specificatie_nume
	 */
	public Categorie_specificatie(int categorie_specificatie_id, String categorie_specificatie_nume) {
		
		this.categorie_specificatie_id = categorie_specificatie_id;
		this.categorie_specificatie_nume = categorie_specificatie_nume;
	}
	/**
	 * 
	 * @param categorie_specificatie_id
	 */
	public void setCategorie_specificatie_id(int categorie_specificatie_id) {
		this.categorie_specificatie_id = categorie_specificatie_id;
	}
	/**
	 * 
	 * @param categorie_specificatie_nume
	 */
	public void setCategorie_specificatie_nume(String categorie_specificatie_nume) {
		this.categorie_specificatie_nume = categorie_specificatie_nume;
	}
	/**
	 * 
	 * @return categorie_specificatie_id
	 */
	public int getCategorie_specificatie_id() {
		return categorie_specificatie_id;
	}
	/**
	 * 
	 * @return categorie_specificatie_nume
	 */
	public String getCategorie_specificatie_nume() {
		return categorie_specificatie_nume;
	}
	
	public String toString() {
		return categorie_specificatie_id+"|"+categorie_specificatie_nume;
	}
	
	
}
