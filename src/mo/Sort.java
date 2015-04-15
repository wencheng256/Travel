package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Logger;

import db.Mysql;

public class Sort implements Sqlable {

	private Mysql mysql;
	private int id;
	private String name;
	
	public Sort()
	{
		mysql=Mysql.getInstance();
	}
	public Sort(int id)
	{
		this();
		this.id=id;
	}
	public Sort(String name)
	{
		this();
		this.name=name;
	}
	public Sort(int id,String name)
	{
		this(name);
		this.id=id;
	}
	
	
	@Override
	public boolean insert() {
		// TODO 自动生成的方法存根
		if(name==null)
			return false;
		String sql="INSERT INTO sort(name) values('"+name+"')";
		return mysql.execute(sql);
	}

	@Override
	public int update() {
		// TODO 自动生成的方法存根
		if(id==0)
			return -1;
		  String sql="UPDATE sort SET name='"+name+"' where id="+id;
		  return mysql.update(sql);
	}

	@Override
	public boolean delete() {
		// TODO 自动生成的方法存根
		if(id==0)
			return false;
		return mysql.delete("sort", id);
	}

	@Override
	public boolean delete(int id) {
		// TODO 自动生成的方法存根
		if(id<=0)
			return false;
		return mysql.delete("sort", id);
	}

	@Override
	public boolean truncate() {
		// TODO 自动生成的方法存根
		String sql="TRUNCATE table adv";
		return mysql.equals(sql);
	}

	@Override
	public Iterator<Sort> selectAll() {
		// TODO 自动生成的方法存根
		String sql="select id,name from sort";
		ResultSet rs=mysql.query(sql);
		LinkedList<Sort> list=new LinkedList<Sort>();	
		try {
			while(rs.next())
			{
				Sort sort=new Sort();
				sort.setId(rs.getInt(1));
				sort.setName(rs.getString(2));
				
				list.add(sort);
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
	public Sort selectedId(int id) {
		// TODO 自动生成的方法存根
		String sql="select id,name from sort where id="+id;
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				Sort sort=new Sort();
				sort.setId(rs.getInt(1));
				sort.setName(rs.getString(2));
				
				return sort;
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
	public Iterator<Sort> selectSql(String where) {
		// TODO 自动生成的方法存根
		String sql="select id,name from sort where "+where;
		ResultSet rs=mysql.query(sql);
		LinkedList<Sort> list=new LinkedList<Sort>();	
		try {
			while(rs.next())
			{
				Sort sort=new Sort();
				sort.setId(rs.getInt(1));
				sort.setName(rs.getString(2));
				
				list.add(sort);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	
	//Gettter and Setter
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
	
	//单元测试
	public static void main(String[] args) {
	// TODO 自动生成的方法存根
		Sort sort=new Sort("分类1");
		System.out.println(sort.selectAll().next().getName());
	}

}
