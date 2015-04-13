package mo;


public interface Sqlable {
	abstract public boolean insert();
	abstract public int update();
	abstract public boolean delete();
	abstract public boolean delete(int id);
	abstract public boolean truncate();
}
