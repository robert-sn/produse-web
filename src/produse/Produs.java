package produse;

public class Produs {

	int produs_id, produs_pret, produs_stoc, produs_garantie, categorie_id;
	String produs_nume, produs_descriere_scurta;
	boolean produs_stare ;
	/**
	 * @param null
	 */
	public Produs() {
		
		produs_id = 0;
		produs_nume = null;
		produs_pret = 0;
		produs_stoc = 0;
		produs_garantie = 0;
		produs_descriere_scurta = null;
		categorie_id = 0;
		produs_stare = false;
		
	}
	/**
	 * 
	 * @param produs_id
	 * @param produs_nume
	 * @param produs_pret
	 * @param produs_stoc
	 * @param produs_garantie
	 * @param produs_descriere_scurta
	 * @param categorie_id
	 * @param produs_activ
	 */
	public Produs(int produs_id,String produs_nume, int produs_pret, int produs_stoc, 
			int produs_garantie, String produs_descriere_scurta, int categorie_id, boolean produs_stare) {
		this.produs_id = produs_id;
		this.produs_nume = produs_nume;
		this.produs_pret = produs_pret;
		this.produs_stoc = produs_stoc;
		this.produs_garantie = produs_garantie ;		
		this.produs_descriere_scurta = produs_descriere_scurta;
		this.categorie_id = categorie_id;
		this.produs_stare = produs_stare;
		
	}
	/**
	 * 
	 * @param p
	 * @return
	 */
	public Produs(Produs p) {
		this.produs_id = p.produs_id;
		this.produs_nume = p.produs_nume;
		this.produs_pret = p.produs_pret;
		this.produs_stoc = p.produs_stoc;
		this.produs_garantie = p.produs_garantie ;		
		this.produs_descriere_scurta = p.produs_descriere_scurta;
		this.categorie_id = p.categorie_id;
		this.produs_stare = p.getProdus_stare();
		
	}
	public void setProdus(Produs p) {
		this.produs_id = p.produs_id;
		this.produs_nume = p.produs_nume;
		this.produs_pret = p.produs_pret;
		this.produs_stoc = p.produs_stoc;
		this.produs_garantie = p.produs_garantie ;		
		this.produs_descriere_scurta = p.produs_descriere_scurta;
		this.categorie_id = p.categorie_id;
		this.produs_stare = p.produs_stare;
	}
	/**
	 * 
	 * @param produs_nume
	 * @param produs_pret
	 * @param produs_stoc
	 * @param produs_garantie
	 * @param produs_descriere_scurta
	 * @param categorie_id
	 * @param produs_stare implicit true
	 */
	public Produs(String produs_nume, String produs_pret, String produs_stoc, 
			String produs_garantie, String produs_descriere_scurta, String categorie_id) {
		
		
		this.produs_nume = produs_nume;
		this.produs_pret = Integer.parseInt(produs_pret);
		this.produs_stoc = Integer.parseInt(produs_stoc);
		this.produs_garantie = Integer.parseInt(produs_garantie) ;		
		this.produs_descriere_scurta = produs_descriere_scurta;
		this.categorie_id = Integer.parseInt(categorie_id);
		this.produs_stare = true;
		
	}
	
	/**
	 * 
	 * @param produs_descriere_scurta
	 */
	public void setProdus_descriere_scurta(String produs_descriere_scurta) {
		this.produs_descriere_scurta = produs_descriere_scurta;
	}
	/**
	 * 
	 * @param produs_garantie
	 */
	public void setProdus_garantie(int produs_garantie) {
		this.produs_garantie = produs_garantie;
	}
	/**
	 * 
	 * @param produs_id
	 */
	public void setProdus_id(int produs_id) {
		this.produs_id = produs_id;
	}
	/**
	 * 
	 * @param produs_nume
	 */
	public void setProdus_nume(String produs_nume) {
		this.produs_nume = produs_nume;
	}
	/**
	 * 
	 * @param produs_pret
	 */
	public void setProdus_pret(int produs_pret) {
		this.produs_pret = produs_pret;
	}
	/**
	 * 
	 * @param produs_stoc
	 */
	public void setProdus_stoc(int produs_stoc) {
		this.produs_stoc = produs_stoc;
	}
	/**
	 * 
	 * @param categorie_id
	 */
	public void setCategorie_id(int categorie_id) {
		this.categorie_id = categorie_id;
	}
	/**
	 * 
	 * @param produs_activ
	 */
	public void setProdus_stare(boolean produs_stare) {
		this.produs_stare = produs_stare;
	}
	/**
	 * 
	 * @return produs_garantie
	 */
	public String getProdus_descriere_scurta() {
		return produs_descriere_scurta;
	}
	/**
	 * 
	 * @return produs_garantie
	 */
	public int getProdus_garantie() {
		return produs_garantie;
	}
	/**
	 * 
	 * @return produs_id
	 */
	public int getProdus_id() {
		return  produs_id;
	}
	/**
	 * 
	 * @return produs_nume
	 */
	public String getProdus_nume() {
		return produs_nume;
	}
	/**
	 * 
	 * @return produs_pret
	 */
	public int getProdus_pret() {
		return produs_pret;
	}
	/**
	 * 
	 * @return produs_stoc
	 */
	public int getProdus_stoc() {
		return produs_stoc;
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
	 * @return produs_activ
	 */
	public boolean getProdus_stare() {
		return produs_stare;
	}
	
	@Override
	public String toString() {
		
		return produs_id + "|" + produs_nume +"|"+ produs_pret + "|"+ produs_stoc +"|"
				+ produs_garantie+"|"+produs_descriere_scurta+"|"+ categorie_id + "|" + produs_stare;
	}
	
}
