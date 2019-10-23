/**
 * 
 */
package produse;



/**
 * @author laurentiu.balmus
 *
 */
public class ProdusInCos {
	
	int produs_id, produs_valoare, produs_cost;
	String produs_denumire;
	 int produs_cantitate;
	
	/**
	 * @param produs_id
	 * @param produs_valoare
	 * @param produs_cantitate
	 * @param produs_cost
	 * @param produs_denumire
	 */
	
	
	public ProdusInCos(int produs_id, String produs_denumire, int produs_valoare, int produs_cantitate	) {
		super();
		this.produs_id = produs_id;		
		this.produs_valoare = produs_valoare;
		this.produs_denumire = produs_denumire;
		this.produs_cantitate = produs_cantitate;
	}
	/**
	 * 
	 */
	public ProdusInCos() {
		
	}
	
	/**
	 * @return the produs_id
	 */
	public int getProdus_id() {
		return produs_id;
	}
	/**
	 * @param produs_id the produs_id to set
	 */
	public void setProdus_id(int produs_id) {
		this.produs_id = produs_id;
	}
	/**
	 * @return the produs_valoare
	 */
	public int getProdus_valoare() {
		return produs_valoare;
	}
	/**
	 * @param produs_valoare the produs_valoare to set
	 */
	public void setProdus_valoare(int produs_valoare) {
		this.produs_valoare = produs_valoare;
	}
	/**
	 * @return the produs_cantitate
	 */
	public int getProdus_cantitate() {
		return produs_cantitate;
	}
	/**
	 * @param produs_cantitate the produs_cantitate to set
	 */
	public void setProdus_cantitate(int	produs_cantitate) {
		
			this.produs_cantitate += produs_cantitate;
		
	}
	/**
	 * @return the produs_cost
	 */
	public int getProdus_cost() {
		return produs_cost;
	}
	/**
	 * @param produs_cost the produs_cost to set
	 */
	public void setProdus_cost(int produs_valoare, int produs_cantitate) {
		this.produs_cost = produs_valoare * produs_cantitate;
	}
	/**
	 * @return the produs_denumire
	 */
	public String getProdus_denumire() {
		return produs_denumire;
	}
	/**
	 * @param produs_denumire the produs_denumire to set
	 */
	public void setProdus_denumire(String produs_denumire) {
		this.produs_denumire = produs_denumire;
	}
	
	
	@Override
	public String toString() {
		return "cosCumparaturi [produs_id=" + produs_id + ", produs_denumire=" + produs_denumire + ", produs_valoare="
				+ produs_valoare + ", produs_cantitate=" + produs_cantitate + ", produs_cost=" + produs_cost + "]";
	}
	
	
	
	
	

	
}
