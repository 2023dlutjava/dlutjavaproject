package test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import test.modeinMain.*;

public class Main {

	/**
	 * @author 王家豪
	 * 这里是main函数，程序开端
	 * @param args
	 */
	public static void main(String[] args) {
		Main.startMain();
	}
	/**
	 * @author 王家豪
	 * 登录操作
	 */
	private static void startMain() {
		System.out.println("=============启动幼儿园管理系统=============");
		Properties params=new Properties();
		String config="src/test.properties";
		String pass="P@ssw0rd n0t l0@ded yet,please l0@d the p@ssw0rd";
		try {
			InputStream is=new FileInputStream(config);
			try {
				params.load(is);
				pass=params.getProperty("miyao");
				//login
			}catch(IOException e) {
				e.printStackTrace();
			}
		}catch(FileNotFoundException e) {
			System.out.println("系统配置文件出错！");
			e.printStackTrace();
		}
		Scanner input=new Scanner(System.in);
		boolean mode=true;
		String vis;
		System.out.print("请输入系统密码以进入系统：");
		while(mode) {
			vis=input.next();
			if(pass.equals(vis)) {
				System.out.println("==============欢迎来到幼儿园管理系统==============");
				Main.Choose();
				mode=false;
			}
			else {
				System.out.println("=====密码错误，拒绝进入系统=====");
				System.out.print("请重新输入系统密码：");
				mode=true;
			}
		}
		input.close();
	}
	/**
	 * @author 王家豪
	 * 主系统界面
	 */
	private static void Choose() {
		prinMain();
		Scanner input=new Scanner(System.in,"gbk");
		boolean mode=true;
		while(mode) {
			System.out.print("（位于主界面）请根据需要进行的操作输入序号，再次查看界面输入9，退出请输入0：");
			int num=input.nextInt();
			switch(num) {
			case 0:
				System.out.println("您确定要退出？(确认退出输入0，输入其他键返回)");
				int visquit=input.nextInt();
				if(visquit!=0) {
					mode=true;
					break;
				}
				System.out.println("==========退出成功==========");
				mode=false;
				break;
			case 1:
				modeClass.inmodeClass();//进入班级管理模块
				System.out.println("=================================");
				break;
			case 2:
				modeStudent.inmodeStudent();//进入学生管理模块
				System.out.println("=================================");
				break;
			case 3:
				modelesson.inmodelesson();//进入课程管理模块
				System.out.println("=================================");
				break;
			case 9:
				prinMain();
				break;
			default:
				System.out.println("输入有误,请重新输入!");
				mode=true;
				break;
			}
		}
		input.close();
	}
	/**
	 * @author 王家豪
	 * 输出主界面信息
	 */
	private static void prinMain() {
		System.out.println("1：班级管理");
		System.out.println("2：学生管理");
		System.out.println("3：课程管理");
	}
}
