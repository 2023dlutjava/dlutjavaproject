package service;

import entity.lesson;

/**
 * 课程的添加和删除类
 * @author 王家豪
 */
public interface Updatelesson {
	/**
	 * 添加课程
	 */
	public int addlesson(lesson les);
	/**
	 * 删除课程
	 */
	public int dellesson(lesson les);
}
