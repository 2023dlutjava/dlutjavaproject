package test;
import dao.*;
public class Main {

	/**
	 * @author 王家豪
	 * 这里是main函数，程序开端
	 * @param args
	 */
	public static void main(String[] args) {
		Main.startMain();
	}
	private static void startMain() {
		/**
		 * todo 做界面
		 */
		BaseDAO a=new BaseDAO();
		a.makSele();
	}

}
