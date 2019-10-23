/**
 * 
 */
package dao.impl;

import dao.UtilizatorDAO;
import mapper.Categorie_mapper;
import mapper.Utilizator_mapper;
import produse.Utilizator;
import org.apache.ibatis.session.SqlSession;
import dao.MyBatisUtil;
/**
 * @author laurentiu.balmus
 *
 */
public class UtilizatorDaoImpl implements UtilizatorDAO{
	
	public Utilizator selectUtilizator(String utilizator_nume) {
		
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Utilizator_mapper mapper = session.getMapper(Utilizator_mapper.class);
		Utilizator utilizator = new Utilizator(mapper.selectUtilizator(utilizator_nume));		
		session.commit();
		session.close();
		return utilizator;
	}

}
