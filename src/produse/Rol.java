/**
 * 
 */
package produse;

/**
 * @author laurentiu.balmus
 *
 */
public class Rol {
	int rol_id;
	String rol_nume;
	
	/**
	 * 
	 */
	public Rol() {
		this.rol_id = 0;
		this.rol_nume = null;
	}
	/**
	 * 
	 * @param rol_id
	 * @param rol_nume
	 */
	public Rol(int rol_id, String rol_nume) {
		this.rol_id = rol_id;
		this.rol_nume = rol_nume;
	}
	/**
	 * @param rol_id the rol_id to set
	 */
	public void setRol_id(int rol_id) {
		this.rol_id = rol_id;
	}
	/**
	 * @param rol_nume the rol_nume to set
	 */
	public void setRol_nume(String rol_nume) {
		this.rol_nume = rol_nume;
	}
	/**
	 * @return the rol_id
	 */
	public int getRol_id() {
		return rol_id;
	}
	/**
	 * @return the rol_nume
	 */
	public String getRol_nume() {
		return rol_nume;
	}
	public String toString() {
		return rol_nume+"|"+rol_nume;
	}
}
