package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Logger;

import db.Mysql;

public class TicketLabel implements Sqlable {

	private Mysql mysql;
	private int id;
	private String name;
	
	public TicketLabel()
	{
		mysql=Mysql.getInstance();
	}
	public TicketLabel(int id)
	{
		this();
		this.id=id;
	}
	public TicketLabel(String name)
	{
		this();
		this.name=name;
	}
	public TicketLabel(int id,String name)
	{
		this(name);
		this.id=id;
	}
	
	@Override
	public boolean insert() {
		// TODO 自动生成的方法存根
		if(name==null)
			return false;
		String sql="INSERT INTO ticketlabel(name) values('"+name+"')";
		return mysql.execute(sql);
	}

	@Override
	public int update() {
		// TODO 自动生成的方法存根
		if(id==0)
			return -1;
		  String sql="UPDATE ticketlabel SET name='"+name+"' where id="+id;
		  return mysql.update(sql);
	}

	@Override
	public boolean delete() {
		// TODO 自动生成的方法存根
		if(id==0)
			return false;
		return mysql.delete("ticketLabel", id);
	}

	@Override
	public boolean delete(int id) {
		// TODO 自动生成的方法存根
		if(id<=0)
			return false;
		return mysql.delete("ticketLabel", id);
	}

	@Override
	public boolean truncate() {
		// TODO 自动生成的方法存根
		String sql="TRUNCATE table ticketlabel";
		return mysql.equals(sql);
	}

	@Override
	public Iterator<TicketLabel> selectAll() {
		String sql="select id,name from ticketlabel";
		ResultSet rs=mysql.query(sql);
		LinkedList<TicketLabel> list=new LinkedList<TicketLabel>();	
		try {
			while(rs.next())
			{
				TicketLabel ticketlabel = new TicketLabel();
				ticketlabel.setId(rs.getInt(1));
				ticketlabel.setName(rs.getString(2));
				
				list.add(ticketlabel);
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
	public TicketLabel selectedId(int id) {
		// TODO 自动生成的方法存根
		String sql="select id,name from ticketlabel where id="+id;
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				TicketLabel ticketlabel = new TicketLabel();
				ticketlabel.setId(rs.getInt(1));
				ticketlabel.setName(rs.getString(2));
				
				return ticketlabel;
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
	public Iterator<TicketLabel> selectSql(String where) {
		// TODO 自动生成的方法存根
		String sql="select id,name from ticketlabel where "+where;
		ResultSet rs=mysql.query(sql);
		LinkedList<TicketLabel> list=new LinkedList<TicketLabel>();	
		try {
			while(rs.next())
			{
				TicketLabel ticketlabel = new TicketLabel();
				ticketlabel.setId(rs.getInt(1));
				ticketlabel.setName(rs.getString(2));
				
				list.add(ticketlabel);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//单元测试
	public static void main(String[] args) {
	// TODO 自动生成的方法存根
		TicketLabel test=new TicketLabel(2,"来啵3");
		System.out.println(test.selectedId(2).getName());
	}

}
