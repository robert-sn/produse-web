/**
 * 
 */
package dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * @author laurentiu.balmus
 *
 */
public class MyBatisUtil {
	
	private static SqlSessionFactory sqlSessionFactory;
	/**
	 * 
	 */
	static {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

}
