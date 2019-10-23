/**
 * 
 */
package produse;

import java.sql.Date;


/**
 * @author laurentiu.balmus
 *
 */
public class Comanda {
	
	int comanda_id, utilizator_id, suma;
	String modalitate_plata, status_comanda;
	Date data;
	String utilizator_nume;
	
	public Comanda() {
		
	}
	
	/**
	 * @param comanda_id
	 * @param utilizator_id
	 * @param sum
	 * @param status_comanda
	 * @param modalitate_plata
	 * @param data
	 */
	public Comanda(int utilizator_id, int sum, String status_comanda, String modalitate_plata, Date data) {
		super();
		
		this.utilizator_id = utilizator_id;
		this.suma = sum;
		this.status_comanda = status_comanda;
		this.modalitate_plata = modalitate_plata;
		this.data = data;
	}
	
	
	/**
	 * @param utilizator_nume
	 * @param data
	 * @param suma
	 * @param modalitate_plata
	 * @param status_comanda
	 */
	public Comanda(String utilizator_nume, Date data, int suma, String modalitate_plata, String status_comanda,int comanda_id) {
		super();
		this.utilizator_nume = utilizator_nume;
		this.data = data;
		this.suma = suma;
		this.modalitate_plata = modalitate_plata;
		this.status_comanda = status_comanda;
		this.comanda_id = comanda_id;
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
	 * @return the comanda_id
	 */
	public int getComanda_id() {
		return comanda_id;
	}
	/**
	 * @param comanda_id the comanda_id to set
	 */
	public void setComanda_id(int comanda_id) {
		this.comanda_id = comanda_id;
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
	 * @return the sum
	 */
	public int getSuma() {
		return suma;
	}
	/**
	 * @param sum the sum to set
	 */
	public void setSuma(int sum) {
		this.suma = sum;
	}
	/**
	 * @return the status_comanda
	 */
	public String getStatus_comanda() {
		return status_comanda;
	}
	/**
	 * @param status_comanda the status_comanda to set
	 */
	public void setStatus_comanda(String status_comanda) {
		this.status_comanda = status_comanda;
	}
	/**
	 * @return the modalitate_plata
	 */
	public String getModalitate_plata() {
		return modalitate_plata;
	}
	/**
	 * @param modalitate_plata the modalitate_plata to set
	 */
	public void setModalitate_plata(String modalitate_plata) {
		this.modalitate_plata = modalitate_plata;
	}
	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(java.util.Date data) {
		this.data = DateUtil.convertDate(data);
	}
	
	
}
