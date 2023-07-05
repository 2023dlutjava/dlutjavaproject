package test.modeinMain;

import java.util.List;
import java.util.Scanner;
import dao.lessonDAO;
import dao.impl.*;
import entity.Student;
import entity.lesson;
import service.impl.StudentServiceImpl;
import service.impl.lessonServiceImpl;

/**
 * 课程管理子系统实现
 * @author 王家豪
 */
public class modelesson {
	public static void inmodelesson(){
		prinmodelesson();
		System.out.println("==========课程管理==========");
		Scanner input=new Scanner(System.in,"gbk");
		boolean mode=true;
		while(mode) {
			System.out.print("（位于课程管理界面）请根据需要进行的操作输入序号，再次查看界面输入9，返回主界面请输入0：");
			int num=input.nextInt();
			switch(num) {
			case 0:
				System.out.println("==========退出课程管理==========");
				mode=false;
				break;
			case 1:
				seealllesson();//查看所有课程
				System.out.println("=================================");
				break;
			case 2:
				System.out.println("请输入要查看的课程序号或课程名称");
				String mid=input.next();
				lesson findles=new lesson();
				try {
					int midd=Integer.parseInt(mid);
					findles.setId(midd);
				}catch(NumberFormatException e) {
					findles.setName(mid);
				}
				findStudentoflesson(findles);//查看课程所有学生
				System.out.println("=================================");
				break;
			case 3:
				addlesson();//添加课程
				System.out.println("=================================");
				break;
			case 4:
				dellesson();//删除课程
				System.out.println("=================================");
				break;
			case 5:
				changelesson();//更改课程
				System.out.println("=================================");
				break;
			case 9:
				prinmodelesson();//再次查看模块界面
				break;
			default:
				System.out.println("输入有误,请重新输入!");
				mode=true;
				break;
			}
		}
	}
	/**
	 * @author 王家豪
	 * 输出界面操作信息
	 */
	private static void prinmodelesson() {
		System.out.println("1：查看所有课程信息");
		System.out.println("2：查看课程所有学生");
		System.out.println("3：课程增添");
		System.out.println("4：课程删除");
		System.out.println("5：更改课程信息");
	}
	/**
	 * @author 王家豪
	 * 查看所有信息实现
	 */
	private static void seealllesson() {
		lessonDAO lesDAO = new lessonDAOImpl();
		List<lesson> lesList = lesDAO.getAlllesson();//从dao获取信息
		System.out.println("课程序号\t课程名称");
		for(int i=0;i<lesList.size();i++) {//输出信息
		lesson les = lesList.get(i);
			System.out.println(les.getId()+"\t"+les.getName());
		   }
	}
	/**
	 * @author 王家豪
	 * 查看指定课程所有学生
	 * 输入课程id或名称均可
	 * @param les
	 */
	private static void findStudentoflesson(lesson les) {
		lessonServiceImpl lesser=new lessonServiceImpl();
		StudentServiceImpl stuser=new StudentServiceImpl();
		List<Student> listu=lesser.findstuofles(les);
		if(listu.size()==0) {
			System.out.println("没有学生学习这门课程！");
		}
		else {
			System.out.println("学习这门课程的学生信息如下：");
			stuser.prinstuList(listu);
		}
	}
	/**
	 * @author 王家豪
	 * 名称添加课程，课序号自增
	 */
	private static void addlesson() {
		System.out.println("请输入要添加的课程名（课程序号自动生成），输入0返回上一层");
		Scanner input=new Scanner(System.in,"gbk");
		lesson les=new lesson();
		String namee=input.next();//输入课程名
		if(namee.equals("0"))
			return;
		les.setName(namee);
		lessonServiceImpl lesser=new lessonServiceImpl();
		int flag=lesser.addlesson(les);
		if(flag==1) {
			System.out.println("课程添加成功！");
		}else {
			System.out.println("添加失败！");
		}
	}
	/**
	 * @author 王家豪
	 * 根据id删除课程，因为数据库的特殊状态，根据名称删除课程不被允许
	 */
	private static void dellesson() {
		System.out.println("请输入要删除的课程序号，输入0返回上一层");
		Scanner input=new Scanner(System.in,"gbk");
		lesson les=new lesson();
		int idd=input.nextInt();//输入课程序号
		if(idd==0)return;
		les.setId(idd);
		lessonServiceImpl lesser=new lessonServiceImpl();
		int flag=lesser.dellesson(les);
		if(flag==1) {
			System.out.println("课程删除成功！");
		}else {
			System.out.println("未找到该课程！");
		}
	}
	/**
	 * @author 王家豪
	 * 更改课程
	 */
	private static void changelesson() {
		System.out.println("请输入要改变名称的课程序号，输入0返回上一层");
		Scanner input=new Scanner(System.in,"gbk");
		int idd=input.nextInt();
		if(idd==0)return;
		System.out.println("请输入要改变的名称");
		String toname=input.next();
		lessonServiceImpl lesser=new lessonServiceImpl();
		int flag=lesser.Changelesson(idd, toname);
		if(flag==1) {
			System.out.println("课程名称更改成功！");
		}else {
			System.out.println("未找到该课程！");
		}
	}
}
