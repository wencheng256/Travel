package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Logger;

import db.Mysql;

public class Travel implements Sqlable {

	
	private Mysql mysql;
	private int id;
	private String name;
	private String tip;
	private int price;
	private String image;
	private String content;
	private String label;
	private int city;
	private int seller;
	
	public Travel()
	{
		mysql=Mysql.getInstance();
	}
	public Travel(int id)
	{
		this();
		this.setId(id);
	}
	public Travel(String name,String tip,int price,String image,String content,String label,int city,int seller)
	{
		this();
		this.name=name;
		this.tip=tip;
		this.price=price;
		this.image=image;
		this.content=content;
		this.label=label;
		this.city=city;
		this.seller=seller;
	}
	public Travel(int id,String name,String tip,int price,String image,String content,String label,int city,int seller)
	{
		this(name,tip,price,image,content,label,city,seller);
		this.setId(id);
	}
	
	@Override
	public boolean insert() {
		// TODO 自动生成的方法存根
		if(name==null||tip==null||price==0||image==null||content==null||label==null||city==0||seller==0)
			return false;
		String sql="INSERT INTO user(name,tip,price,image,content,label,city,seller) values('"+name+"','"+tip+"',"+price+",'"+image+"','"+content+"',"+label+","+city+","+seller+")";
		return mysql.execute(sql);
	}

	@Override
	public int update() {
		// TODO 自动生成的方法存根
		if(id==0)
			return -1;
		  String sql="UPDATE user SET name='"+name+"',tip='"+tip+"',price="+price+",image='"+image+"',content='"+content+"',label='"+label+"',city='"+city+",seller='"+seller+"' where id="+id;
		  return mysql.update(sql);
	}

	@Override
	public boolean delete() {
		// TODO 自动生成的方法存根
		if(id==0)
			return false;
		return mysql.delete("travel", id);
	}

	@Override
	public boolean delete(int id) {
		// TODO 自动生成的方法存根
		if(id<=0)
			return false;
		return mysql.delete("travel", id);
	}

	@Override
	public boolean truncate() {
		// TODO 自动生成的方法存根
		String sql="TRUNCATE table travel";
		return mysql.equals(sql);
	}

	
	
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

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getSeller() {
		return seller;
	}

	public void setSeller(int seller) {
		this.seller = seller;
	}
	//select 语句
	@Override
	public Iterator<Travel> selectAll() {
		// TODO 自动生成的方法存根
		String sql="select id,name,tip,price,image,content,label,city,seller from travel";
		ResultSet rs=mysql.query(sql);
		LinkedList<Travel> list=new LinkedList<Travel>();	
		try {
			while(rs.next())
			{
				Travel travel=new Travel();
				travel.setId(rs.getInt(1));
				travel.setName(rs.getString(2));
				travel.setTip(rs.getString(3));
				travel.setPrice(rs.getInt(4));
				travel.setImage(rs.getString(5));
				travel.setContent(rs.getString(6));
				travel.setLabel(rs.getString(7));
				travel.setCity(rs.getInt(8));
				travel.setSeller(rs.getInt(9));
				
				
				list.add(travel);
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
	public Travel selectedId(int id) {
		// TODO 自动生成的方法存根
		String sql="select id,name,tip,price,image,content,label,city,seller from travel where id="+id;
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				Travel travel=new Travel();
				travel.setId(rs.getInt(1));
				travel.setName(rs.getString(2));
				travel.setTip(rs.getString(3));
				travel.setPrice(rs.getInt(4));
				travel.setImage(rs.getString(5));
				travel.setContent(rs.getString(6));
				travel.setLabel(rs.getString(7));
				travel.setCity(rs.getInt(8));
				travel.setSeller(rs.getInt(9));
				
				return travel;
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
	public Iterator<Travel> selectSql(String where) {
		// TODO 自动生成的方法存根
		String sql="select id,name,tip,price,image,content,label,city,seller from travel where id where "+where;
		ResultSet rs=mysql.query(sql);
		LinkedList<Travel> list=new LinkedList<Travel>();	
		try {
			while(rs.next())
			{
				Travel travel=new Travel();
				travel.setId(rs.getInt(1));
				travel.setName(rs.getString(2));
				travel.setTip(rs.getString(3));
				travel.setPrice(rs.getInt(4));
				travel.setImage(rs.getString(5));
				travel.setContent(rs.getString(6));
				travel.setLabel(rs.getString(7));
				travel.setCity(rs.getInt(8));
				travel.setSeller(rs.getInt(9));
				
				list.add(travel);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public Iterator<Travel> selectCity(int city)
	{
		String sql="select id,name,tip,price,image,content,label,city,seller from travel where city = "+city+"";
		ResultSet rs=mysql.query(sql);
		LinkedList<Travel> list=new LinkedList<Travel>();	
		try {
			while(rs.next())
			{
				Travel travel=new Travel();
				travel.setId(rs.getInt(1));
				travel.setName(rs.getString(2));
				travel.setTip(rs.getString(3));
				travel.setPrice(rs.getInt(4));
				travel.setImage(rs.getString(5));
				travel.setContent(rs.getString(6));
				travel.setLabel(rs.getString(7));
				travel.setCity(rs.getInt(8));
				travel.setSeller(rs.getInt(9));
				
				list.add(travel);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public Iterator<Travel> searchLabel(String label)
	{
		String sql="select id,name,tip,price,image,content,label,city,seller from travel where label like %"+label+"%";
		ResultSet rs=mysql.query(sql);
		LinkedList<Travel> list=new LinkedList<Travel>();	
		try {
			while(rs.next())
			{
				Travel travel=new Travel();
				travel.setId(rs.getInt(1));
				travel.setName(rs.getString(2));
				travel.setTip(rs.getString(3));
				travel.setPrice(rs.getInt(4));
				travel.setImage(rs.getString(5));
				travel.setContent(rs.getString(6));
				travel.setLabel(rs.getString(7));
				travel.setCity(rs.getInt(8));
				travel.setSeller(rs.getInt(9));
				
				list.add(travel);
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
	}
}
