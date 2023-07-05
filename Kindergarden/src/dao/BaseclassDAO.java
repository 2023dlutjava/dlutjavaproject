package dao;

import java.util.List;

import entity.Baseclass;

public interface BaseclassDAO {
	/**
	 * 查找所有的班级
	 * @author 王家豪
	 * @return
	 */
	public List<Baseclass> getAllclass();
	/**
	 * 更新班级
	 * @author 王家豪
	 * @param sql
	 * @param param
	 * @return
	 */
	public int updatecla(String sql, Object[] param);
	/**
	 * 按条件查找班级
	 * @author 王家豪
	 */
	public List<Baseclass> selectclass(String sql, Object[] param);
}
