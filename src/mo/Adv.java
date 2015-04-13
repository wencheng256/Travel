package mo;

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

}
