package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Logger;

import db.Mysql;

public class Adv implements Sqlable {
	
	private Mysql mysql;
	private int id;
	private String name;
	private String image;
	private String loc;
	private String link;
	
	public Adv()
	{
		mysql=Mysql.getInstance();
	}
	public Adv(int id)
	{
		this();
		this.id=id;
	}
	public Adv(String name,String image,String loc,String link)
	{
		this();
		this.name=name;
		this.image=image;
		this.loc=loc;
		this.link=link;
	}
	public Adv(int id,String name,String image,String loc,String link)
	{
		this();
		this.id=id;
		this.name=name;
		this.image=image;
		this.loc=loc;
		this.link=link;
	}

	@Override
	public boolean insert() {
		// TODO 自动生成的方法存根
		if(name==null||image==null||loc==null||link==null)
			return false;
		String sql="INSERT INTO adv(name,image,loc,link) values('"+name+"','"+image+"','"+loc+"','"+link+"')";
		return mysql.execute(sql);
	}

	@Override
	public int update() {
		// TODO 自动生成的方法存根
		if(id==0)
			return -1;
		  String sql="UPDATE adv SET name='"+name+"',image='"+image+"',loc='"+loc+"',link='"+link+"' where id="+id;
		  return mysql.update(sql);
	}

	@Override
	public boolean delete() {
		// TODO 自动生成的方法存根
		if(id==0)
			return false;
		return mysql.delete("adv", id);
	}
	public boolean delete(int id) {
		// TODO 自动生成的方法存根
		if(id<=0)
			return false;
		return mysql.delete("adv", id);
	}
	@Override
	public boolean truncate() {
		// TODO 自动生成的方法存根
		String sql="TRUNCATE table adv";
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	//selected方法
	@Override
	public Iterator selectAll() {
		// TODO 自动生成的方法存根
		String sql="select id,name,image,loc,link from adv";
		ResultSet rs=mysql.query(sql);
		LinkedList<Adv> list=new LinkedList<Adv>();	
		try {
			while(rs.next())
			{
				Adv adv=new Adv();
				adv.setId(rs.getInt(1));
				adv.setName(rs.getString(2));
				adv.setImage(rs.getString(3));
				adv.setLoc(rs.getString(4));
				adv.setLink(rs.getString(5));
				
				list.add(adv);
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
	public Sqlable selectedId(int id) {
		// TODO 自动生成的方法存根
		String sql="select id,name,image,loc,link from adv where id="+id;
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				Adv adv=new Adv();
				adv.setId(rs.getInt(1));
				adv.setName(rs.getString(2));
				adv.setImage(rs.getString(3));
				adv.setLoc(rs.getString(4));
				adv.setLink(rs.getString(5));
				return adv;
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
	public Iterator selectSql(String where) {
		// TODO 自动生成的方法存根
		return null;
	}
	
	//单元测试
	public static void main(String[] args) {
	// TODO 自动生成的方法存根
		Adv test=new Adv(1,"主页轮播图2","1122", "11", "11");
		test.delete();
	}

}
