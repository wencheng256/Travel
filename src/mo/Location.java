package mo;

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
		return false;
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
	//单元测试
	public static void main(String[] args) {
	// TODO 自动生成的方法存根
		Location test1=new Location("华北");
		System.out.println(test1.insert());
	}

}
