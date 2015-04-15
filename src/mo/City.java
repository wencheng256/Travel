package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Logger;

import db.Mysql;

public class City implements Sqlable {
	
	private Mysql mysql;
	private int id;
	private String name;
	private int province;
	
	
	//构造函数
	public City()
	{
		mysql=Mysql.getInstance();
	}
	
	public City(int id)
	{
		this();
		this.id=id;
	}
	public City(String name,int province)
	{
		this();
		this.name=name;
		this.province=province;
	}
	public City(int id,String name,int province)
	{
		this(name,province);
		this.id=id;
	}
	
	
	@Override
	public boolean insert() {
		// TODO 自动生成的方法存根
		if(name==null||province==0)
			return false;
		String sql="INSERT INTO city(name,province) values('"+name+"',"+province+")";
		return mysql.execute(sql);
	}

	@Override
	public int update() {
		// TODO 自动生成的方法存根
		if(id==0)
			return -1;
		String sql="UPDATE city SET name='"+name+"',province="+province+" where id="+id;
		return mysql.update(sql);
	}

	@Override
	public boolean delete() {
		// TODO 自动生成的方法存根
		if(id<=0)
			return false;
		return mysql.delete("city", id);
	}
	@Override
	public boolean delete(int id) {
		// TODO 自动生成的方法存根
		if(id<=0)
			return false;
		return mysql.delete("city", id);
	}
	@Override
	public boolean truncate() {
		// TODO 自动生成的方法存根
		String sql="TRUNCATE table city";
		return mysql.equals(sql);
	}

	//Getter and Setter
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

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	//select 语句
	@Override
	public Iterator<City> selectAll() {
		// TODO 自动生成的方法存根
		String sql="select name,province from city";
		ResultSet rs=mysql.query(sql);
		LinkedList<City> list=new LinkedList<City>();	
		try {
			while(rs.next())
			{
				City city=new City();
				city.setId(rs.getInt(1));
				city.setName(rs.getString(2));
				
				list.add(city);
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
	public City selectedId(int id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Iterator<City> selectSql(String where) {
		// TODO 自动生成的方法存根
		return null;
	}
	//单元测试
	public static void main(String[] args) {
	// TODO 自动生成的方法存根
		City test1=new City(2,"济宁",2);
		System.out.println(test1.update());
	}

}
