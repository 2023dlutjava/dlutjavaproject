package dao;

import java.util.List;

import entity.lesson;


public interface lessonDAO {
	/**
	 * @author 王家豪
	 * 获得所有的课程
	 * @return
	 */
	public List<lesson> getAlllesson();
	/**
	 * @author 王家豪
	 * 更新课程信息
	 * @param sql
	 * @param param
	 * @return
	 */
	public int updateles(String sql, Object[] param);
	/**
	 * @author 王家豪
	 * 按条件查找课程信息
	 */
	public List<lesson> selectlesson(String sql,Object[] param);
}
