/**
 * 
 */
package DbUtils;

import java.sql.*;

import produse.*;

/**
 * @author laurentiu.balmus
 *
 */
public class DbInsert {
	/**
	 * 
	 * @param categorie_nume
	 */
	public static void insertCategorie(String categorie_nume){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into categorie(categorie_id, categorie_nume) values(null,?)";
		
		try {
			con = Dbutil.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, categorie_nume);
			
			pstmt.executeUpdate();
		}catch(SQLException | NullPointerException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(con, pstmt);			
		}
	}
	/**
	 * 
	 * @param produs_nume
	 * @param produs_pret
	 * @param produs_stoc
	 * @param produs_garantie
	 * @param produs_descriere_scurta
	 * @param categorie_id
	 * @param produs_activ
	 */
	public static void insertProdus(String produs_nume, int produs_pret, int produs_stoc, 
			int produs_garantie, String produs_descriere_scurta, int categorie_id, boolean produs_stare) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into produs(produs_id,produs_nume,produs_pret,produs_stoc,produs_garantie,"  
								 +"produs_descriere_scurta,categorie_id,produs_activ)values(null,?,?,?,?,?,?,?)";
		
		try {
			con = Dbutil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, produs_nume);
			pstmt.setInt(2, produs_pret);
			pstmt.setInt(3, produs_stoc);
			pstmt.setInt(4, produs_garantie);
			pstmt.setString(5, produs_descriere_scurta);
			pstmt.setInt(6, categorie_id);
			pstmt.setBoolean(7, produs_stare);
			
			
			pstmt.executeUpdate();
			
		}catch(SQLException | NullPointerException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(con, pstmt);			
		}
		
	}
	
	/**
	 * 
	 * @param p 
	 */
	public static void insertProdus(Produs p) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into produs(produs_nume,produs_pret,produs_stoc,produs_garantie,"  
								 +"produs_descriere_scurta,categorie_id,produs_activ)values(?,?,?,?,?,?,?)";
		
		try {
			con = Dbutil.getConnection();
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, p.getProdus_nume());
			pstmt.setInt(2, p.getProdus_pret());
			pstmt.setInt(3, p.getProdus_stoc());
			pstmt.setInt(4, p.getProdus_garantie());
			pstmt.setString(5, p.getProdus_descriere_scurta());
			pstmt.setInt(6, p.getCategorie_id());
			pstmt.setBoolean(7, p.getProdus_stare());
			
			
			pstmt.executeUpdate();
			
		}catch(SQLException | NullPointerException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(con, pstmt);			
		}
	}
	/**
	 * 
	 * @param specificatie_nume
	 * @param specificatie_valoare
	 */
	public static void insertSpecificatie(String specificatie_nume , String specificatie_valoare) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into specificatie(specificatie_id,specificatie_nume,specificatie_valoare) values(null,?,?)";
		
		try {
			con = Dbutil.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, specificatie_nume);
			pstmt.setString(2, specificatie_valoare);
			
			pstmt.executeUpdate();
		}catch(SQLException | NullPointerException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(con, pstmt);			
		}
				
	}
	public static void insertCategorie_specificatie(String categorie_specificatie_nume){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into categorie_specificatie(categorie_specificatie_id, categorie_specificatie_nume) values(null,?)";
		
		try {
			con = Dbutil.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, categorie_specificatie_nume);
			
			pstmt.executeUpdate();
		}catch(SQLException | NullPointerException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(con, pstmt);			
		}
	}
	
	public static void insertUtilizator(String utilizator_nume, String utilizator_parola, int rol_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into utilizator(utilizator_id, utilizator_nume, utilizator_parola, rol_id) values(null,?,?,?)";
		
		try {
			con = Dbutil.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, utilizator_nume);
			pstmt.setString(2, utilizator_parola);
			pstmt.setInt(3, rol_id);
			
			
			pstmt.executeUpdate();
		}catch(SQLException | NullPointerException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(con, pstmt);			
		}
		
	}
	/**
	 * 
	 * @param utilizator
	 */
	public static void insertUtilizator(Utilizator utilizator) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into utilizator( utilizator_nume, utilizator_parola, rol_id) values(?,?,?)";
		
		try {
			con = Dbutil.getConnection();
			
			pstmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, utilizator.getUtilizator_nume());
			pstmt.setString(2, utilizator.getUtilizator_parola());
			pstmt.setInt(3, utilizator.getRol_id());
			
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				utilizator.setUtilizator_id(rs.getInt(1));
			}
		}catch(SQLException | NullPointerException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(con, pstmt);			
		}		
	}
	
	/**
	 * 
	 * @param Comanda comanda
	 */
	public static void insertComanda(Comanda comanda) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into comanda( utilizator_id, data, suma, modalitate_plata, status_comanda) values(?,?,?,?,?)";
		
		try {
			con = Dbutil.getConnection();
			
			pstmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setInt(1, comanda.getUtilizator_id());
			pstmt.setDate(2, comanda.getData());
			pstmt.setInt(3, comanda.getSuma());
			pstmt.setString(4, comanda.getModalitate_plata());
			pstmt.setString(5, comanda.getStatus_comanda());
			
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				comanda.setComanda_id(rs.getInt(1));
			}
		}catch(SQLException | NullPointerException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(con, pstmt);			
		}
	}
	
	/**
	 * 
	 * @param ConinutComanda cc
	 */
	public static void insertContinutComanda(ContinutComanda cc) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into continutcomanda( comanda_id, produs_id, cant) values(?,?,?)";
		
		try {
			con = Dbutil.getConnection();
			
			pstmt = con.prepareStatement(query);
			
			
			pstmt.setInt(1, cc.getComanda_id());
			pstmt.setInt(2, cc.getProdus_id());
			pstmt.setInt(3, cc.getCantitate());
			
			pstmt.executeUpdate();
			
		
		}catch(SQLException | NullPointerException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(con, pstmt);			
		}
	}
	
}
