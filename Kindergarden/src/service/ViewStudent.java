package service;

import java.util.List;

import entity.Student;

/**
 * @author 严强强
 */

public interface ViewStudent {
	/*
	 * 实现查看学生信息的接口
	 * 
	 */
	public void view(int id);
	/**
	 * @author 王家豪
	 * 实现打印一个学生表
	 */
	public void prinstuList(List<Student> lis);
}
