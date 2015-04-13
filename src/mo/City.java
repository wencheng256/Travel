package mo;

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
	public City(int id,String name,int province)
	{
		this();
		this.id=id;
		this.name=name;
		this.province=province;
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
	
	//单元测试
	public static void main(String[] args) {
	// TODO 自动生成的方法存根
	}
}
