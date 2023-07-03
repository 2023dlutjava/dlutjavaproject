package entity;
/**
 * @author 王家豪
 * 课程类
 */
public class lesson {
	private int id;//lesson id
	private String name;//lesson name
	
	public lesson() {
		
	}
	public lesson(int id,String name) {
		this.id=id;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
