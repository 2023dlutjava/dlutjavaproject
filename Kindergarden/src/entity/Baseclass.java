package entity;
/**
 * @author 王家豪
 * 班级基类，为抽象类
 */
public abstract class Baseclass {
	private int id;//class id
	private String foodtext;//the file's name on the food of the class
	/**
	 * 根据这个文件的名字到对应的文件夹下寻找储存在txt中的食谱信息
	 * @author 王家豪
	 */
	private int cost;//cost of the class
	
	
	public Baseclass() {
		
	}
	public Baseclass(int id) {
		this.id=id;
		foodtext="foodfile"+id+".txt";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoodtext() {
		return foodtext;
	}
	public void setFoodtext(String foodtext) {
		this.foodtext = foodtext;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
