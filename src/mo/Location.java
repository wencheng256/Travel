package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Logger;

import db.Mysql;

public class Location implements Sqlable {

	private Mysql mysql;
	private int id;
	private String name;
	
	public Location()
	{
		mysql=Mysql.getInstance();
	}
	public Location(int id)
	{
		this();
		this.setId(id);
	}
	public Location(String name)
	{
		this();
		this.setName(name);
	}
	public Location(int id,String name)
	{
		this(name);
		this.setId(id);
	}
	
	
	@Override
	public boolean insert() {
		// TODO 自动生成的方法存根
		if(name==null)
			return false;
		String sql="INSERT INTO location(name) values('"+name+"')";
		return mysql.execute(sql);
	}

	@Override
	public int update() {
		// TODO 自动生成的方法存根
		if(id==0)
			return -1;
		  String sql="UPDATE location SET name='"+name+"' where id="+id;
		  return mysql.update(sql);
	}

	@Override
	public boolean delete() {
		// TODO 自动生成的方法存根
		if(id<=0)
			return false;
		return mysql.delete("location", id);
	}

	@Override
	public boolean delete(int id) {
		// TODO 自动生成的方法存根
		if(id==0)
			return false;
		return mysql.delete("Location", id);
	}

	@Override
	public boolean truncate() {
		// TODO 自动生成的方法存根
		String sql="TRUNCATE table location";
		return mysql.equals(sql);
	}
	
	//Getter and Seller
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
	//select 语句
	@Override
	public Iterator<Location> selectAll() {
		// TODO 自动生成的方法存根
		String sql="select id,name from location";
		ResultSet rs=mysql.query(sql);
		LinkedList<Location> list=new LinkedList<Location>();	
		try {
			while(rs.next())
			{
				Location location=new Location();
				location.setId(rs.getInt(1));
				location.setName(rs.getString(2));
				
				list.add(location);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Location selectedId(int id) {
		// TODO 自动生成的方法存根
		String sql="select id,name from location where id="+id;
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				Location location=new Location();
				location.setId(rs.getInt(1));
				location.setName(rs.getString(2));
				
				return location;
			}
			return null;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Iterator<Location> selectSql(String where) {
		// TODO 自动生成的方法存根
		String sql="select id,name from location where "+where;
		ResultSet rs=mysql.query(sql);
		LinkedList<Location> list=new LinkedList<Location>();	
		try {
			while(rs.next())
			{
				Location location=new Location();
				location.setId(rs.getInt(1));
				location.setName(rs.getString(2));
				
				list.add(location);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	//单元测试
	public static void main(String[] args) {
	// TODO 自动生成的方法存根
		Location test=new Location(1,"华北");
		System.out.println(test.selectSql("id=3").next().getName());
	}

}
