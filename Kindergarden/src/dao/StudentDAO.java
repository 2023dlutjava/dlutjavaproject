package dao;

import java.util.List;
import entity.Student;

public interface StudentDAO {
	/**
	 * 寻找所有学生
	 * @author 王家豪
	 * @return
	 */
	public List<Student> getAllStudent();
	/**
	 * 进行更新操作
	 * @author 王家豪
	 * @param sql
	 * @param param
	 * @return
	 */
	public int updateStu(String sql,String[] param);
	/**
	 * @author 王家豪
	 * 按条件查找学生
	 */
	public List<Student> selectStudent(String sql,String[] param);
}
