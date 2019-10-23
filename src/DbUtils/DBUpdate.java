/**
 * 
 */
package DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author laurentiu.balmus
 *
 */
public class DBUpdate {
	
	/**
	 * 
	 * @param produs_id
	 * @param produs_pret
	 */
	public static void updateProdus(int produs_id, int produs_pret) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "update produs set produs_pret = ? where produs_id = ?";
		
		try {
			con = Dbutil.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, produs_pret);
			pstmt.setInt(2, produs_id);
			
			pstmt.executeUpdate();
			
		}catch(SQLException | NullPointerException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(con, pstmt);			
		}
	}
	
	public static void updateComanda(String status,int comanda_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "update comanda set status_comanda = ? where comanda_id = ?";
		
		try {
			con = Dbutil.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, status);
			pstmt.setInt(2, comanda_id);
			
			pstmt.executeUpdate();
			
		}catch(SQLException | NullPointerException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(con, pstmt);			
		}
	}

}
