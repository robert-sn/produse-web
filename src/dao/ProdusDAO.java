/**
 * 
 */
package dao;

import produse.Produs;
import java.util.*;
import org.apache.ibatis.session.SqlSession;
import mapper.Produse_mapper;

/**
 * @author laurentiu.balmus
 *
 */
public class ProdusDAO {
	/**
	 * 
	 * @return
	 */
	public static List<Produs> getData() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Produse_mapper mapper = session.getMapper(Produse_mapper.class);
		List<Produs> produs = new ArrayList<>();
		produs.addAll(mapper.selectProdus());
		session.commit();
		session.close();
		return produs;		
	}
	public static List<Produs> selectListaProdusActiv() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Produse_mapper mapper = session.getMapper(Produse_mapper.class);
		List<Produs> produs = new ArrayList<>();
		produs.addAll(mapper.selectProdusActiv());
		session.commit();
		session.close();
		return produs;		
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Produs getData(int id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory()	.openSession();
		Produse_mapper mapper = session.getMapper(Produse_mapper.class);
		Produs produs = mapper.selectProduseById(id);
		session.commit();
		session.close();
		return produs;
		
	}
	public static Produs getData(String produs_nume) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory()	.openSession();
		Produse_mapper mapper = session.getMapper(Produse_mapper.class);
		Produs produs = mapper.selectProduseByNume(produs_nume);
		session.commit();
		session.close();
		return produs;
		
	}
	/**
	 * 
	 * @param produs
	 */
	public static void insertProdus(Produs produs) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Produse_mapper mapper = session.getMapper(Produse_mapper.class);
		mapper.insertProdus(produs);
		session.commit();
		session.close();
	}
	/**
	 * 
	 * @param produs_id
	 * @param produs_pret
	 */
	public static void updateProdusPret(int produs_id, int produs_pret) {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			Produse_mapper mapper = session.getMapper(Produse_mapper.class);
			mapper.updateProdusPret(produs_id, produs_pret);
			session.commit();
			session.close();
	}
	/**
	 * 
	 * @param produs_id
	 * @param produs_cantitate
	 */
	public static void updateProdusCantitate(int produs_id, int produs_cantitate) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Produse_mapper mapper = session.getMapper(Produse_mapper.class);
		mapper.updateProdusCantitate(produs_id, produs_cantitate);
		session.commit();
		session.close();
	}
	
	public static void updateProdusStare(int produs_id, boolean produs_stare) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Produse_mapper mapper = session.getMapper(Produse_mapper.class);
		mapper.updateProdusStare(produs_id, produs_stare);
		session.commit();
		session.close();
	}
	
	
	
}
