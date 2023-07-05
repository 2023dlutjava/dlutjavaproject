package test.modeinMain;

import java.util.List;
import java.util.Scanner;
import service.impl.*;
import service.ViewStudent;
import service.ChangeStudent;
import service.UpdateStudent;
import service.ViaStuToLesson;
import entity.lesson;
/**
 * @author 王家豪 严强强
 * 学生管理子系统实现
 */
public class modeStudent {
	
	
	public static void inmodeStudent(){
		prinmodeStudent();
		System.out.println("==========学生管理==========");
		Scanner input=new Scanner(System.in,"gbk");
		boolean mode=true;
		while(mode) {
			System.out.print("（位于学生管理界面）请根据需要进行的操作输入序号，再次查看界面输入9，返回主界面请输入0：");
			int num=input.nextInt();
			switch(num) {
			case 0:
				System.out.println("==========退出学生管理==========");
				mode=false;
				break;
			case 1:
				ViewStudent viewStudent=new StudentServiceImpl();
				System.out.println("1：查看学生信息");
				System.out.println("=================================");
				System.out.println("请输入要查看的学生ID：");
				int id11=input.nextInt();
				viewStudent.view(id11);	
				break;
			case 2:
				ChangeStudent changeStudent=new StudentServiceImpl();
				System.out.println("2：更改学生学籍信息");
				System.out.println("=================================");
				System.out.println("请输入要更改的学生ID：");
				int id22=input.nextInt();
				 changeStudent.change(id22);
				break;
			case 3:
				ViaStuToLesson viaStuToLesson =new  StudentServiceImpl();
				System.out.println("3：查看学生所有课程");
				System.out.println("=================================");
				System.out.println("请输入要查看的学生ID：");
				int id33=input.nextInt();
				List<lesson> listles=viaStuToLesson.viastulesson(id33);
				lessonServiceImpl lesser=new lessonServiceImpl();
				if(listles.size()==0) {
					System.out.println("该学生未选课！");
				}
				else {
					System.out.println("该学生所选课程为:");
					lesser.prinlesList(listles);
				}
				break;
			case 4:
				UpdateStudent updateStudent1=new  StudentServiceImpl();
				System.out.println("4：学生增添");
				System.out.println("=================================");
				System.out.println("请输入要增加的学生ID：");
				int id44=input.nextInt();
				updateStudent1.update(id44, 2);
				break;
			case 5:
				UpdateStudent updateStudent2=new  StudentServiceImpl();
				System.out.println("5：学生删除");
				System.out.println("=================================");
				System.out.println("请输入要删除的学生ID：");
				int id55=input.nextInt();
				updateStudent2.update(id55, 1);
				break;
			case 9:
				prinmodeStudent();
				break;
			default:
				System.out.println("输入有误,请重新输入!");
				mode=true;
				break;
			}
		}
	}
	private static void prinmodeStudent(){
		System.out.println("1：查看学生信息");
		System.out.println("2：更改学生学籍信息");
		System.out.println("3：查看学生所有课程");
		System.out.println("4：学生增添");
		System.out.println("5：学生删除");
	}
}