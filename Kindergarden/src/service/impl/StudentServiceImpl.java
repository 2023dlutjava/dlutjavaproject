package service.impl;
/**
 * 学生操作实现类
 * @author 严强强
 */
import service.ChangeStudent;

import service.UpdateStudent;
import service.ViaStuToLesson;
import service.ViewStudent;
import java.util.*;
import dao.impl.*;
import entity.Student;
import entity.lesson;
import dao.lessonDAO;
import dao.StudentDAO;


public class StudentServiceImpl implements ChangeStudent, UpdateStudent, ViaStuToLesson, ViewStudent {
	 /*
	  * 根据学生ID查看学生信息
	  */
	@Override
	public void view(int id) {
		StudentDAO studentDAO = new StudentDAOImpl();;//注入StudentDAO对象
		String sql="select * from kindergarden.student where id=?" ;
		List<Student> students=new ArrayList<Student>();
		Object[] str={id};
		students=studentDAO.selectStudent(sql, str);
		System.out.println("学生信息为：");
		prinstuList(students);
	}
	/*
	 * 根据学生ID找到学生所选课程
	 */
	@Override
	public List<lesson> viastulesson(int id) {
		lessonDAO   llessonDAO=new lessonDAOImpl();//注入lessonDAO对象
		String sql="select l.id,l.name from kindergarden.study as st join kindergarden.lesson as l on st.lesid=l.id where st.stuid=?";
		List<lesson> lessons=new ArrayList<lesson>();
		Object[] str={id};
		lessons=llessonDAO.selectlesson(sql, str);
		return lessons;
	}
	/*
	 * 更新学生表中的学生信息
	 */
	@Override
	public void update(int id,int type) {
		StudentDAO studentDAO = new StudentDAOImpl();//注入StudentDAO对象
		if(type==1) {//删除
			String sql="delete from kindergarden.student where id=?";
			Object[] str={id};
			int flag=studentDAO.updateStu(sql, str);
			if(flag>0) {
				System.out.println("删除成功！！");
			}else if(flag==0){
				System.out.println("未找到该数据！");
			}else {
				System.out.println("sql执行异常！");
			}
		}
		if(type==2) {//添加
			Scanner input=new Scanner(System.in,"gbk");
			System.out.print("请输入学生姓名：");
			String name=input.next();
			System.out.print("请输入学生班级：");
			int clas=input.nextInt();
			String sql="insert into kindergarden.student (id,name,class) values(?,?,?)";
			Object[] str={id,name,clas};
			int flag=studentDAO.updateStu(sql, str);
			if(flag>0) {
				System.out.println("添加成功！！");
			}else if(flag==0){
				System.out.println("添加失败！");
			}else {
				System.out.println("sql执行异常！");
			}
		}
	}
	/*
	 * 更改学生属性
	 */
	@Override
	public void change(int id) {
		StudentDAOImpl studentDAO = new StudentDAOImpl();//注入StudentDAO对象
		Scanner input1=new Scanner(System.in,"gbk");
		boolean biao=true;
		do {
		System.out.print("请选择要更改的学生属性 1.id 2.name 3.class (输入0退出)");
		int num=input1.nextInt();
		switch(num) {
		case 0:
			biao=false;
			break;
		case 1:
			System.out.print("请输入更改后的学生id：");
			int id1=input1.nextInt();
			String sql="update kindergarden.student set id=? where id=?";
			Object[] str={id1,id};
			int flag=studentDAO.updateStu(sql, str);
			if(flag>0) {
			System.out.println("更改成功！！");
			}else if(flag==0){
				System.out.println("未找到该数据！");
			}else {
				System.out.println("sql执行异常！");
			}
			break;
		case 2:	
			System.out.print("请输入更改后的学生name：");
			String name=input1.next();
			String sql2="update kindergarden.student set name=? where id=?";
			Object[] str2={name,id};
			int flag2=studentDAO.updateStu(sql2, str2);
			if(flag2>0) {
			System.out.println("更改成功！！");
			}else if(flag2==0){
				System.out.println("未找到该数据！");
			}else {
				System.out.println("sql执行异常！");
			}
			break;
		case 3:
			System.out.print("请输入更改后的学生class：");
			String classs=input1.next();
			String sql3="update kindergarden.student set class=? where id=?";
			Object[] str3={classs,id};
			int flag3=studentDAO.updateStu(sql3, str3);
			if(flag3>0) {
			System.out.println("更改成功！！");
			}else if(flag3==0){
				System.out.println("未找到该数据！");
			}else {
				System.out.println("sql执行异常！");
			}
			break;
		}	
		}while(biao==true);

	}
	/**
	 * @author 王家豪
	 * 打印一个学生表
	 */
	public void prinstuList(List<Student> lis) {
		System.out.println("学生序号\t学生姓名\t学生班级");
		for(int i=0;i<lis.size();i++) {
			Student stu=lis.get(i);
			System.out.print(stu.getId()+"\t"+stu.getName()+"\t");
			int viscla=stu.getClas();
			if(viscla/10==1)System.out.println("小"+viscla%10+"班");
			if(viscla/10==2)System.out.println("中"+viscla%10+"班\t");
			if(viscla/10==3)System.out.println("大"+viscla%10+"班\t");
		}
	}
}
