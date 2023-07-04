package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
/**
 * 数据库操作基类
 * @author 王家豪
 */
public class BaseDAO {
	public static String drive;
	public static String urll;
	public static String usernam;
	public static String passwor;
	/**
	 * 静态加载
	 * @author 王家豪
	 */
	static {
		init();
	}
	/**
	 * 根据文件获得数据库配置信息
	 * @author 王家豪
	*/
	public static void init() {
		Properties params=new Properties();
		String config="src/test.properties";
		//property place
		try {
			InputStream is=new FileInputStream(config);
			try {
				params.load(is);
				drive=params.getProperty("driver");
				urll=params.getProperty("url");
				usernam=params.getProperty("username");
				passwor=params.getProperty("password");
				System.out.println("数据库配置加载成功！");
				//load property
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}catch(Exception ee) {
			System.out.println("没读进来！");
		}
	}
	/**获得连接
	 * @author 王家豪
	 * @return 数据库的连接
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection connection() throws ClassNotFoundException,SQLException{
		Connection conn=null;
		try {
			Class.forName(drive);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection(urll, usernam, passwor);
			//get connection
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//System.out.println("数据库连接成功！");
		return conn;
	}
	/**
	 * 关闭所有创建的东西
	 * @author 王家豪
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
				//close result set
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
				//close preparedstatement
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
				//close connection
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * @author 王家豪
	 * 执行增删改的SQL语句
	 */
	public int excecuteSQL(String preSQL,Object[] param) {
		Connection conn=null;
		PreparedStatement pstmt=null; 
		int num=0;
		try {
			conn=connection();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try {
			System.out.println("数据库连接成功！");
			pstmt=conn.prepareStatement(preSQL);
			if (param!=null) {
				for (int i=0;i<param.length;++i){
					pstmt.setObject(i+1,param[i]);
				}
			}
			//load all “?” in pstmt
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn,pstmt,null);
		}
		return num;
	}
}
