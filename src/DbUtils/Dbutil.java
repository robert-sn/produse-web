/**
 * 
 */
package DbUtils;

import java.sql.*;

/**
 * @author laurentiu.balmus
 *
 */
public class Dbutil {
	
	/**
	 * 
	 * @return con
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {						
			String url = "jdbc:mysql://localhost:3306/produse";
			con = DriverManager.getConnection(url,"root","");
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
		
	}
	/**
	 * 
	 * @param con
	 * @param pstmt
	 * @param rs
	 */
	public static void closeAll(Connection con , PreparedStatement pstmt, ResultSet rs) {
		try {
			if(con != null) {
				con.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			if(pstmt!=null) {
				pstmt.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs!=null) {
				rs.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param con
	 * @param pstmt
	 */
	public static void close(Connection con, PreparedStatement pstmt) {
		closeAll(con, pstmt, null);
	}
	
}
