/**
 * 
 */
package dao.impl;

import java.util.List;

import produse.Categorie;
import org.apache.ibatis.session.SqlSession;
import dao.MyBatisUtil;
import dao.CategorieDAO;

import mapper.Categorie_mapper;

/**
 * @author laurentiu.balmus
 *
 */
public class CategorieDaoImpl implements CategorieDAO {

	public List<Categorie> selectCategorie(){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Categorie_mapper mapper = session.getMapper(Categorie_mapper.class);
		List<Categorie> categorie = mapper.selectCategorie();
		session.commit();
		session.close();
		return categorie;
		
	}
	
	public void insertCategorie(String categorie_nume) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Categorie_mapper mapper = session.getMapper(Categorie_mapper.class);
		mapper.insertCategorie(categorie_nume);
		session.commit();
		session.close();		
	}
}
