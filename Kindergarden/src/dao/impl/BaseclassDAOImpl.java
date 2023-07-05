package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDAO;
import dao.BaseclassDAO;
import entity.Baseclass;
import entity.exclass.*;
/**
 * 班级类数据库操作
 * @author 王家豪
 */
public class BaseclassDAOImpl extends BaseDAO implements BaseclassDAO {
	/**
	 * 查找所有班级
	 */
	public List<Baseclass> getAllclass(){
		List<Baseclass> allCla=new ArrayList<Baseclass>();//要返回的队列
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		/* 处理SQL,执行SQL */
		try {
			conn = connection(); // 得到数据库连接
			pstmt = conn.prepareStatement("SELECT * FROM kindergarden.classroom"); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句
			while(rs.next()) {
				Baseclass cla=null;
				if(rs.getInt("id")/10==1)cla=new Littleclass();
				if(rs.getInt("id")/10==2)cla=new Midclass();
				if(rs.getInt("id")/10==3)cla=new Largeclass();
				cla.setId(rs.getInt("id"));
				cla.setFoodtext(rs.getString("foodfile"));
				cla.setCost(rs.getInt("cost"));
				allCla.add(cla);//队列插入
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace(); 
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return allCla;
	}
	/**
	 * 更新接口实现
	 * @author 王家豪
	 */
	public int updatecla(String sql, String[] param) {
		int count = super.executeSQL(sql, param);
		return count;//返回是否成功
	}
	/**
	 * 按条件查找实现
	 * @author 王家豪
	 */
	public List<Baseclass> selectclass(String sql, String[] param){
		List<Baseclass> ListCla=new ArrayList<Baseclass>();//要返回的队列
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		/* 处理SQL,执行SQL */
		try {
			conn = connection(); // 得到数据库连接
			pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
			if (param != null) {
				for (int i=0;i<param.length;i++){
					pstmt.setString(i+1,param[i]); // 为预编译sql设置参数
				}
			}
			rs = pstmt.executeQuery(); // 执行SQL语句
			while(rs.next()) {
				Baseclass cla=null;
				if(rs.getInt("id")/10==1)cla=new Littleclass();
				if(rs.getInt("id")/10==2)cla=new Midclass();
				if(rs.getInt("id")/10==3)cla=new Largeclass();
				cla.setId(rs.getInt("id"));
				cla.setFoodtext(rs.getString("foodfile"));
				cla.setCost(rs.getInt("cost"));
				ListCla.add(cla);//队列插入
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace(); 
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return ListCla;
	}
}
