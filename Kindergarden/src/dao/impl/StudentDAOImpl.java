package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDAO;
/**
 * 学生类数据库操作
 * @author 王家豪
 */
import dao.StudentDAO;
import entity.Student;

public class StudentDAOImpl extends BaseDAO implements StudentDAO {
	/**
	 * 查找所有学生
	 */
	public List<Student> getAllStudent(){
		List<Student> allStu=new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		/* 处理SQL,执行SQL */
		try {
			conn = connection(); // 得到数据库连接
			pstmt = conn.prepareStatement("SELECT * FROM kindergarden.student"); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句
			while(rs.next()) {
				Student stu=new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setClas(rs.getInt("class"));
				allStu.add(stu);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();//Exception area
		} catch (SQLException e) {
			e.printStackTrace(); 
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return allStu;
	}
	/**
	 * 更新接口实现
	 * @author 王家豪
	 */
	public int updateStu(String sql, Object[] param) {
		int count = super.executeSQL(sql, param);
		return count;//返回是否更新成功
	}
	/**
	 * 按条件查找接口实现
	 * @author 王家豪
	 */
	public List<Student> selectStudent(String sql,Object[] param){
		List<Student> ListStu=new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		/* 处理SQL,执行SQL */
		try {
			conn = connection(); // 得到数据库连接
			pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
			if(param!=null) {
				for(int i=0;i<param.length;i++) {
					pstmt.setObject(i+1,param[i]);// 为预编译sql设置参数
				}
			}
			rs = pstmt.executeQuery(); // 执行SQL语句
			while(rs.next()) {
				Student stu=new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setClas(rs.getInt("class"));
				ListStu.add(stu);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();//Exception area
		} catch (SQLException e) {
			e.printStackTrace(); 
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return ListStu;
	}
}
