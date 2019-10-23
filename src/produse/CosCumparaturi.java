/**
 * 
 */
package produse;
import java.util.*;

/**
 * @author laurentiu.balmus
 *
 */
public class CosCumparaturi {
	List<ProdusInCos> lista = new ArrayList<>();;

	

	/**
	 * 
	 */
	public CosCumparaturi() {
		
	}

	/**
	 * @return the lista
	 */
	public List<ProdusInCos> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<ProdusInCos> lista) {
		this.lista = lista;
	}
	
	/**
	 * 
	 * @param p
	 */
	public void addProdusInCos(ProdusInCos p) {
		lista.add(p);
		
	}
	
	public void stergeToateProduseleDinCos() {
		lista.removeAll(lista);
	}
	
	public void sterge(ProdusInCos p) {
		if(lista.size()!= 0) {
	 		int pos = -1;
	 		for(int i=0;i<lista.size();i++) {				
				if(lista.get(i).getProdus_id() == p.getProdus_id() ) {
					pos = i;					
				}				
			}
	 	
		
	 		if(lista.get(pos).produs_cantitate > 1) lista.get(pos).produs_cantitate--;
	 			else lista.remove(pos);
			
		}
	}
	
	

}
