package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDAO;
import dao.lessonDAO;
import entity.lesson;
/**
 * 课程类数据库操作
 * @author 王家豪
 */
public class lessonDAOImpl extends BaseDAO implements lessonDAO {
	/**
	 * 查找所有课程
	 */
	public List<lesson> getAlllesson(){
		List<lesson> allles=new ArrayList<lesson>();//要返回的队列
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		/* 处理SQL,执行SQL */
		try {
			conn = connection(); // 得到数据库连接
			pstmt = conn.prepareStatement("SELECT * FROM kindergarden.lesson"); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句
			while(rs.next()) {
				lesson les=new lesson();
				les.setId(rs.getInt("id"));
				les.setName(rs.getString("name"));
				allles.add(les);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace(); 
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return allles;
	}
	/**
	 * 更新接口实现
	 * @author 王家豪
	 */
	public int updateles(String sql, Object[] param) {
		int count = super.executeSQL(sql, param);
		return count;//返回是否更新成功
	}
	/**
	 * 按条件查找接口实现
	 * @author 王家豪
	 */
	public List<lesson> selectlesson(String sql,Object[] param){
		List<lesson> Listles=new ArrayList<lesson>();//要返回的队列
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		/* 处理SQL,执行SQL */
		try {
			conn = connection(); // 得到数据库连接
			pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
			if(param!=null) {
				for (int i=0;i<param.length;i++){
					pstmt.setObject(i+1, param[i]);// 为预编译sql设置参数
				}
			}
			rs = pstmt.executeQuery(); // 执行SQL语句
			while(rs.next()) {
				lesson les=new lesson();
				les.setId(rs.getInt("id"));
				les.setName(rs.getString("name"));
				Listles.add(les);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace(); 
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return Listles;
	}
}
