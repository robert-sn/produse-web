package produse;

public class Categorie {
	
	int categorie_id;
	String categorie_nume;
	
	public Categorie() {
		categorie_id = 0;
		categorie_nume = null;
		
	}
	/**
	 * 
	 * @param idcategorie
	 * @param categorie_nume
	 */
	public Categorie(int categorie_id, String categorie_nume) {
		this.categorie_id = categorie_id;
		this.categorie_nume = categorie_nume;
	}
	/**
	 * 
	 * @return categorie_nume
	 */
	public String getCategorie_nume() {
		return categorie_nume;
	}
	/**
	 * 
	 * @return categorie_id
	 */
	public int getCategorie_id() {
		return categorie_id;
	}
	/**
	 * 
	 * @param categorie_nume
	 */
	public void setCategorie_nume(String categorie_nume) {
		this.categorie_nume = categorie_nume;
	}
	/**
	 * 
	 * @param idcategorie
	 */
	public void setCategorie_id(int idcategorie) {
		this.categorie_id = idcategorie;
	}
	
	@Override
	public String toString() {
		
		return categorie_id + " " +categorie_nume;
	}
}
