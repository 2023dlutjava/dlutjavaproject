package entity.exclass;

import entity.Baseclass;
/**
 * @author 王家豪
 * 中班类，继承抽象基类
 */
public class Midclass extends Baseclass {
	public Midclass() {
		super();
	}
	public Midclass(int id) {
		super(id);
		setCost(3000);
	}
}
