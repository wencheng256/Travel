package mo;

import java.util.Iterator;

import db.Mysql;

public class User implements Sqlable {

	private Mysql mysql;
	private int id;
	private String name;
	private String realname;
	private String password;
	private String phonenum;
	private String postbox;
	
	public User()
	{
		mysql=Mysql.getInstance();
	}
	public User(int id)
	{
		this();
		this.setId(id);
	}
	public User(String name,String realname,String password,String phonenum,String postbox)
	{
		this();
		this.name=name;
		this.realname=realname;
		this.setPassword(password);
		this.phonenum=phonenum;
		this.postbox=postbox;
	}
	public User(int id,String name,String realname,String password,String phonenum,String postbox)
	{
		this(name,realname,password,phonenum,postbox);
		this.setId(id);
	}
	
	
	@Override
	public boolean insert() {
		// TODO 自动生成的方法存根
		if(name==null||realname==null||password==null||phonenum==null||postbox==null)
			return false;
		String sql="INSERT INTO user(name,realname,password,phonenum,postbox) values('"+name+"','"+realname+"','"+password+"','"+phonenum+"','"+postbox+"')";
		return mysql.execute(sql);
	}

	@Override
	public int update() {
		// TODO 自动生成的方法存根
		if(id==0)
			return -1;
		  String sql="UPDATE user SET name='"+name+"',realname='"+realname+"',password='"+password+"',phonenum='"+phonenum+"',postbox='"+postbox+"' where id="+id;
		  return mysql.update(sql);
	}

	@Override
	public boolean delete() {
		// TODO 自动生成的方法存根
		if(id==0)
			return false;
		return mysql.delete("user", id);
	}

	@Override
	public boolean delete(int id) {
		// TODO 自动生成的方法存根
		if(id==0)
			return false;
		return mysql.delete("user", id);
	}

	@Override
	public boolean truncate() {
		// TODO 自动生成的方法存根
		String sql="TRUNCATE table user";
		return mysql.equals(sql);
	}
	
	//Getter and Setter;
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPostbox() {
		return postbox;
	}
	public void setPostbox(String postbox) {
		this.postbox = postbox;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//select方法
	@Override
	public Iterator selectAll() {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public Sqlable selectedId(int id) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public Iterator selectSql(String where) {
		// TODO 自动生成的方法存根
		return null;
	}
	//单元测试
	public static void main(String[] args) {
	// TODO 自动生成的方法存根
		User test1=new User(5,"wencheng258","韩文程111222", ",wk5201314", "18369189857", "wencheng256@gmail.com");
		System.out.println(test1.delete());
	}
}
