package mo;

import db.Mysql;

public class Province implements Sqlable {
	
	private Mysql mysql;
	private int id;
	private String name;
	private int location;

	
	public Province()
	{
		mysql=Mysql.getInstance();
	}
	public Province(int id)
	{
		this();
		this.setId(id);
	}
	public Province(String name,int location)
	{
		this();
		this.name=name;
		this.location=location;
	}
	public Province(int id,String name,int location)
	{
		this(name,location);
		this.setId(id);
	}
	
	
	@Override
	public boolean insert() {
		// TODO 自动生成的方法存根
		if(name==null||location==0)
			return false;
		String sql="INSERT INTO province(name,location) values('"+name+"','"+location+"')";
		return mysql.execute(sql);
	}

	@Override
	public int update() {
		// TODO 自动生成的方法存根
		if(id==0)
			return -1;
		  String sql="UPDATE province SET name='"+name+"',location="+location+" where id="+id;
		  return mysql.update(sql);
	}

	@Override
	public boolean delete() {
		// TODO 自动生成的方法存根
		if(id==0)
			return false;
		return mysql.delete("province", id);
	}

	@Override
	public boolean delete(int id) {
		// TODO 自动生成的方法存根
		if(id==0)
			return false;
		return mysql.delete("province", id);
	}

	@Override
	public boolean truncate() {
		// TODO 自动生成的方法存根
		return false;
	}

	
	//Getter and Setter
	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
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
		Province test1=new Province(2,"河北",3);
		System.out.println(test1.insert());
	}
}
