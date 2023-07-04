package dao;

import java.util.List;

import entity.Baseclass;

public interface BaseclassDAO {
	/**
	 * 查找所有的课程
	 * @author 王家豪
	 * @return
	 */
	public List<Baseclass> getAllclass();
	/**
	 * 更新课程
	 * @author 王家豪
	 * @param sql
	 * @param param
	 * @return
	 */
	public int updatecla(String sql, String[] param);
}
