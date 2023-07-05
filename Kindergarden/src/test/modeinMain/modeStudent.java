package test.modeinMain;

import java.util.Scanner;

/**
 * @author 王家豪
 * 学生管理子系统实现
 */
public class modeStudent {
	public static void inmodeStudent(){
		prinmodeStudent();
		System.out.println("==========学生管理==========");
		Scanner input=new Scanner(System.in);
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
				System.out.println("1：查看所有班级信息");
				System.out.println("=================================");
				break;
			case 2:
				System.out.println("2：查看班级食谱");
				System.out.println("=================================");
				break;
			case 3:
				System.out.println("3：查看班级学生");
				System.out.println("=================================");
				break;
			case 4:
				System.out.println("4：查看班级所有课程");
				System.out.println("=================================");
				break;
			case 5:
				System.out.println("5：增添班级");
				System.out.println("=================================");
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
		System.out.println("1：查看所有学生信息");
		System.out.println("2：查看学生所学课程");
		System.out.println("3：学生增添");
		System.out.println("4：学生删除");
		System.out.println("5：更改学生信息");
	}
}
