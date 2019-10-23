/**
 * 
 */
package dao.impl;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.MyBatisUtil;
import dao.RolDAO;
import mapper.Rol_mapper;
import produse.Rol;
/**
 * @author laurentiu.balmus
 *
 */
public class RolDaoImpl implements RolDAO {

	public List<Rol> selectRol(){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Rol_mapper mapper = session.getMapper(Rol_mapper.class);
		List<Rol> rol = new ArrayList<>();
		rol.addAll(mapper.selectRol());
		session.commit();
		session.close();
		return rol;
	}
}
