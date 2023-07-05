package service;

import java.util.List;

import entity.Student;
import entity.lesson;

/**
 * @author 王家豪
 * 实现lesson模块的基础接口
 */
public interface lessonService {
	/**
	 * 找到对应课程的学生
	 * @param les
	 * @return
	 */
	public List<Student> findstuofles(lesson les);
	/**
	 * 修改课程信息
	 */
	public int Changelesson(int id,String toname);
}
