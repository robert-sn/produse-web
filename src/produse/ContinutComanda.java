/**
 * 
 */
package produse;

/**
 * @author laurentiu.balmus
 *
 */
public class ContinutComanda {

	int continutcomanda_id, comanda_id, produs_id, cantitate;
	
	/**
	 * @param continutcomanda_id
	 * @param comanda_id
	 * @param produs_id
	 * @param cantitate
	 */
	public ContinutComanda( int comanda_id, int produs_id, int cantitate) {
		super();
		
		this.comanda_id = comanda_id;
		this.produs_id = produs_id;
		this.cantitate = cantitate;
	}

	/**
	 * @return the continutcomanda_id
	 */
	public int getContinutcomanda_id() {
		return continutcomanda_id;
	}

	/**
	 * @param continutcomanda_id the continutcomanda_id to set
	 */
	public void setContinutcomanda_id(int continutcomanda_id) {
		this.continutcomanda_id = continutcomanda_id;
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
	public int getProdus_id() {
		return produs_id;
	}

	/**
	 * @param produs_id the utilizator_id to set
	 */
	public void setProdus_id(int produs_id) {
		this.produs_id = produs_id;
	}

	/**
	 * @return the cantitate
	 */
	public int getCantitate() {
		return cantitate;
	}

	/**
	 * @param cantitate the cantitate to set
	 */
	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}
	
	
}
