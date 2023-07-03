package entity.exclass;

import entity.Baseclass;
/**
 * @author 王家豪
 * 大班类，继承抽象基类
 */

public class Largeclass extends Baseclass {
	public Largeclass() {
		super();
	}
	public Largeclass(int id) {
		super(id);
		setCost(3000);
	}
}
