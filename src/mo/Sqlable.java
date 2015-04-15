package mo;

import java.util.Iterator;


public interface Sqlable {
	abstract public boolean insert();
	abstract public int update();
	abstract public boolean delete();
	abstract public boolean delete(int id);
	abstract public boolean truncate();	//清空表
	abstract public Iterator selectAll();
	abstract public Sqlable selectedId(int id);
	abstract public Iterator selectSql(String where);
}
