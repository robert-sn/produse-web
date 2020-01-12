/**
 * 
 */
package DbUtils;

import java.util.*;

import produse.*;
import java.sql.*;


/**
 * @author laurentiu.balmus
 *
 */
public class DbSelect {
	/**
	 * 
	 * @return List<Categorie>
	 */
	public static List<Categorie> selectCategorie(){
		
		List<Categorie> categ = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select categorie_id, categorie_nume from categorie";

		try {
			con = Dbutil.getConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Categorie cat = new Categorie();
				
				cat.setCategorie_id(rs.getInt(1));
				cat.setCategorie_nume(rs.getString(2));
				categ.add(cat);
			}
			
		}catch(SQLException | NullPointerException e) {
			e.printStackTrace();
		}finally {
			Dbutil.closeAll(con, pstmt, rs);
		}
				
		return categ;
	}
	/**
	 * 
	 * @return Lista cu produse
	 */
	public static List<Produs> selectProdus(){
		List<Produs> prod = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query ="select produs_id,produs_nume,produs_pret,produs_stoc,produs_garantie,"
				+ "produs_descriere_scurta,categorie_id,produs_stare from produs order by categorie_id ";
		try {
			con = Dbutil.getConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Produs pr = new Produs();
				pr.setProdus_id(rs.getInt(1));
				pr.setProdus_nume(rs.getString(2));
				pr.setProdus_pret(rs.getInt(3));
				pr.setProdus_stoc(rs.getInt(4));
				pr.setProdus_garantie(rs.getInt(5));
				pr.setProdus_descriere_scurta(rs.getString(6));
				pr.setCategorie_id(rs.getInt(7));
				pr.setProdus_stare(rs.getBoolean(8));
				
				prod.add(pr);
			}
			
		}catch(SQLException | NullPointerException e) {
			e.printStackTrace();
		}finally {
			Dbutil.closeAll(con, pstmt, rs);
		}
		
		return prod;
	}
	/**
	 * 
	 * @return speficatii
	 */
	public static List<Specificatie> selectSpecificatie(){
		
		List<Specificatie> spec = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select specificatie_id, specificatie_nume ,specificatie_valoare from specificatie";

		try {
			con = Dbutil.getConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Specificatie s = new Specificatie();
				
				s.setSpecificatie_id(rs.getInt(1));
				s.setSpecificatie_nume(rs.getString(2));
				s.setSpecificatie_valoare(rs.getString(3));
				spec.add(s);
			}
			
		}catch(SQLException | NullPointerException e) {
			e.printStackTrace();
		}finally {
			Dbutil.closeAll(con, pstmt, rs);
		}
				
		return spec;
	}
	/**
	 * 
	 * @return lista Roluri
	 */
	public static List<Rol> selectRol(){
		List<Rol> rol = new ArrayList<>();
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select rol_id, rol_nume from rol";
	
		try {
			con = Dbutil.getConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Rol r = new Rol();
				r.setRol_id(rs.getInt(1));
				r.setRol_nume(rs.getString(2));
				rol.add(r);
			}
		
		}catch(SQLException | NullPointerException e){
			e.printStackTrace();
		}finally {
			Dbutil.closeAll(con, pstmt, rs);
		}
		
		return rol;
	}
	
	/**
	 * 
	 * @param utilizator_nume
	 * @param utilizator_parola
	 * @return
	 */
	public static Utilizator selectUtilizator(String utilizator_nume, String utilizator_parola){
		
		Utilizator utilizator = new Utilizator();
		
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select utilizator_nume, utilizator_parola, rol_id, utilizator_id from utilizator where utilizator_nume = ? and utilizator_parola = ?";
	
		try {
			con = Dbutil.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, utilizator_nume);
			pstmt.setString(2, utilizator_parola);
			
			//pstmt.executeUpdate();
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				
				utilizator.setUtilizator_nume(rs.getString(1));
				utilizator.setUtilizator_parola(rs.getString(2));
				utilizator.setRol_id(rs.getInt(3));
				utilizator.setUtilizator_id(rs.getInt(4));
				
				
			}
		
		}catch(SQLException | NullPointerException e){
			e.printStackTrace();
		}finally {
			Dbutil.closeAll(con, pstmt, rs);
		}
		
		return utilizator;
		
	}
	
	/**
	 * 
	 * @param nume
	 * @param parola
	 * @return
	 */
	public static boolean validare(String nume, String parola) {
		boolean status = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select utilizator_nume, utilizator_parola, rol_id from utilizator where utilizator_nume = ? and utilizator_parola = ?";
		try {
			con = Dbutil.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, nume);
			pstmt.setString(2, parola);
			//pstmt.executeUpdate();
			
			rs = pstmt.executeQuery();
			status = rs.next();
		
		}catch(SQLException | NullPointerException e){
			e.printStackTrace();
		}finally {
			Dbutil.closeAll(con, pstmt, rs);
		}
		
		
		
		return status;
	}
	
	/**
	 * 
	 */
	public static List<Comanda> selectComanda(String status){
		List<Comanda> comanda = new ArrayList<>();
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select comanda_id, utilizator_id, sum, modalitate_plata, status_comanda, data, c.cantitate "
				+ "from comanda, continutcomanda c  where c.comanda_id = comdanda.comanda_id and status_comanda = ?";
		
		try {
			con = Dbutil.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, status);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				/**
				  * @param utilizator_nume
				  * @param data
				  * @param suma
				  * @param modalitate_plata
				  * @param status_comanda
				 */
				Comanda com = new Comanda(
						rs.getString(1), 
						rs.getDate(2), 
						rs.getInt(3), 
						rs.getString(4), 
						rs.getString(5),
						rs.getInt(6)
						);
				
				
				comanda.add(com);						
			}
		
		
		}catch(SQLException | NullPointerException e){
			e.printStackTrace();
		}finally {
			Dbutil.closeAll(con, pstmt, rs);
		}
		return comanda;
	}
	
}
