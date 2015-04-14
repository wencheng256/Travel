package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.MyLogger;

public class Mysql {
	
	static private Mysql mysql=null;
	
	private Connection connection;
	private Statement statement;
	
	//获得JDBC Mysql连接
	private Mysql()
	{
		try {
			MyLogger.start();
			String url="jdbc:mysql://localhost:3306/travel?useUnicode=true&characterEncoding=utf-8";
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(url, "root", "abc123");
			statement=connection.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
		}
	}
	
	//单例模式获得Mysql唯一实例
	static public Mysql getInstance()
	{
		if(mysql==null)
		{
			mysql=new Mysql();
		}
		return mysql;
	}
	
	//执行操作sql语句执行，返回ResultSet
	public ResultSet query(String sql)
	{
		try {
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	//操作sql语句执行，返回布尔值
	public boolean execute(String sql)
	{
		try {
			statement.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	//更新语句执行，返回受影响的条目
	public int update(String sql)
	{
		try {
			return statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			Logger.getLogger("travel").warning(e.getMessage());
			return -1;
		}
	}
	
	public boolean delete(String table,int id)
	{
		String sql="DELETE FROM "+table+" WHERE id ="+id;
		return mysql.execute(sql);
	}
	
//	单元测试之用
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Mysql mysql=Mysql.getInstance();
		String sql="SELECT * from user";
		mysql.query(sql);
	}
	

}
