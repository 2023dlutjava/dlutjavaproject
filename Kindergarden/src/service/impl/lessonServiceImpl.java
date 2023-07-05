package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.impl.StudentDAOImpl;
import dao.impl.lessonDAOImpl;
import entity.Student;
import entity.lesson;
import service.Updatelesson;
import service.Viewlesson;
import service.lessonService;
/**
 * @author 王家豪
 * 课程服务模块
 */
public class lessonServiceImpl implements lessonService,Viewlesson,Updatelesson{

	/**
	 * 根据课程名或id找到学这门课的学生
	 * @author 王家豪
	 * 返回学这门课的学生表
	 */
	public List<Student> findstuofles(lesson les) {
		StudentDAOImpl stuDAOImpl=new StudentDAOImpl();
		String selectSQL=null;
		List<Student> ret=new ArrayList<Student>();
		if(les.getId()==0) {
			selectSQL="SELECT stu.id,stu.name,stu.class FROM kindergarden.student as stu join kindergarden.study as s on stu.id=s.stuid join kindergarden.lesson as l on s.lesid=l.id where l.name=?";
			Object[] param= {les.getName()};
			ret=stuDAOImpl.selectStudent(selectSQL, param);
		}
		if(les.getName()==null) {
			selectSQL="SELECT stu.id,stu.name,stu.class FROM kindergarden.student as stu join kindergarden.study as s on stu.id=s.stuid join kindergarden.lesson as l on s.lesid=l.id where s.lesid=?";
			Object[] param= {les.getId()};
			ret=stuDAOImpl.selectStudent(selectSQL, param);
		}
		return ret;
	}
	/**
	 * @author 王家豪
	 * 打印一个课程表
	 */
	public void prinlesList(List<lesson> lis) {
		System.out.println("课程序号\t课程名");
		for(int i=0;i<lis.size();i++) {
			lesson les=lis.get(i);
			System.out.println(les.getId()+"\t"+les.getName()+"\t");
		}
	}
	/**
	 * @author 王家豪
	 * 更改课程，只能根据id更改名称
	 */
	public int Changelesson(int id,String toname) {
		lessonDAOImpl lesDAOImpl=new lessonDAOImpl();
		String selectSQL="update kindergarden.lesson set name=? where id=?";
		Object[] param= {toname,id};
		return lesDAOImpl.executeSQL(selectSQL, param);
	}
	/**
	 * @author 王家豪
	 * 根据名称添加课程
	 */
	public int addlesson(lesson les) {
		lessonDAOImpl lesDAOImpl=new lessonDAOImpl();
		String selectSQL="insert into kindergarden.lesson (id,name) values(null,?)";
		Object[] param= {les.getName()};
		return lesDAOImpl.executeSQL(selectSQL, param);
	}
	/**
	 * @author 王家豪
	 * 根据id删除课程
	 */
	public int dellesson(lesson les) {
		lessonDAOImpl lesDAOImpl=new lessonDAOImpl();
		String selectSQL="delete from kindergarden.lesson where id=?";
		Object[] param= {les.getId()};
		return lesDAOImpl.executeSQL(selectSQL, param);
	}
}
