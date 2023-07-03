package entity;
/**
 * @author 王家豪
 * 学生类
 */
public class Student {
	private int id;//student id
	private String name;//student name
	private int clas;//the class which the student in
	
	public Student() {
		
	}
	public Student(int id,String name,int clas) {
		this.id=id;
		this.name=name;
		this.clas=clas;
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
	public int getClas() {
		return clas;
	}
	public void setClas(int clas) {
		this.clas = clas;
	}
	
}
