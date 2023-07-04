package dao;

import java.util.List;
import entity.Student;

public interface StudentDAO {
	/**
	 * 根据SQL寻找所有学生
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
}
