package entity.exclass;

import entity.Baseclass;
/**
 * @author 王家豪
 * 小班类，继承抽象基类
 */
public class Littleclass extends Baseclass {
	public Littleclass() {
		super();
	}
	public Littleclass(int id) {
		super(id);
		setCost(2000);
	}
}
