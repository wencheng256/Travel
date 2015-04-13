package mo;

import db.Mysql;

public class User implements Sqlable {

	private String name;
	private String realname;
	private String pass;
	private String phonenum;
	private String postbox;

	
	public User()
	{
		mysql=Mysql.getInstance();
	}
	public User(int id)
	{
		this();
		this.id=id;
	}
	public User(String name,String image,String loc,String link)
	{
		this();
		this.name=name;
		this.image=image;
		this.loc=loc;
		this.link=link;
	}
	public User(int id,String name,String image,String loc,String link)
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
		return false;
	}

	@Override
	public int update() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public boolean delete() {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean truncate() {
		// TODO 自动生成的方法存根
		return false;
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

}
