package mo;

import db.Mysql;

public class Province implements Sqlable {
	
	private Mysql mysql;
	private String name;
	private int location;

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

}
