/**
 * 
 */
package produse;

/**
 * @author laurentiu.balmus
 *
 */
public class Utilizator {
	
	int utilizator_id;
	String utilizator_nume;
	String utilizator_parola;
	int rol_id;
	
	/**
	 * 
	 */
	public Utilizator() {
		this.utilizator_id = 0;
		this.utilizator_nume = "";
		this.utilizator_parola = "";
		this.rol_id = 0;
	}
	
	public Utilizator(int utilizator_id, String utilizator_nume, String utilizator_parola, int rol_id) {
		this.utilizator_id = rol_id;
		this.utilizator_nume = utilizator_nume;
		this.utilizator_parola = utilizator_parola;
		this.rol_id = rol_id;
	}
	
	public Utilizator(Utilizator utilizator) {
		this.utilizator_id = utilizator.utilizator_id;
		this.utilizator_nume = utilizator.utilizator_nume;
		this.utilizator_parola = utilizator.utilizator_parola;
		this.rol_id = utilizator.rol_id;
	}

	/**
	 * @return the utilizator_id
	 */
	public int getUtilizator_id() {
		return utilizator_id;
	}

	/**
	 * @param utilizator_id the utilizator_id to set
	 */
	public void setUtilizator_id(int utilizator_id) {
		this.utilizator_id = utilizator_id;
	}

	/**
	 * @return the utilizator_nume
	 */
	public String getUtilizator_nume() {
		return utilizator_nume;
	}

	/**
	 * @param utilizator_nume the utilizator_nume to set
	 */
	public void setUtilizator_nume(String utilizator_nume) {
		this.utilizator_nume = utilizator_nume;
	}

	/**
	 * @return the utilizator_parola
	 */
	public String getUtilizator_parola() {
		return utilizator_parola;
	}

	/**
	 * @param utilizator_parola the utilizator_parola to set
	 */
	public void setUtilizator_parola(String utilizator_parola) {
		this.utilizator_parola = utilizator_parola;
	}

	/**
	 * @return the rol_id
	 */
	public int getRol_id() {
		return rol_id;
	}

	/**
	 * @param rol_id the rol_id to set
	 */
	public void setRol_id(int rol_id) {
		this.rol_id = rol_id;
	}
	
	
}
