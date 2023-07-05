package test.modeinMain;

import java.util.Scanner;

/**
 * 课程管理子系统实现
 * @author 王家豪
 */
public class modelesson {
	public static void inmodelesson(){
		prinmodelesson();
		System.out.println("==========课程管理==========");
		Scanner input=new Scanner(System.in);
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
				System.out.println("1：查看所有课程信息");
				System.out.println("=================================");
				break;
			case 2:
				System.out.println("2：查看课程所有学生");
				System.out.println("=================================");
				break;
			case 3:
				System.out.println("3：课程增添");
				System.out.println("=================================");
				break;
			case 4:
				System.out.println("4：课程删除");
				System.out.println("=================================");
				break;
			case 5:
				System.out.println("5：更改课程信息");
				System.out.println("=================================");
				break;
			case 9:
				prinmodelesson();
				break;
			default:
				System.out.println("输入有误,请重新输入!");
				mode=true;
				break;
			}
		}
	}
	private static void prinmodelesson() {
		System.out.println("1：查看所有课程信息");
		System.out.println("2：查看课程所有学生");
		System.out.println("3：课程增添");
		System.out.println("4：课程删除");
		System.out.println("5：更改课程信息");
	}
}
