package Model;

public class Khoa {

	@Override
	public String toString() {
		return "Khoa [Id=" + Id + ", TenKhoa=" + TenKhoa + "]";
	}
	private int Id;
	private String TenKhoa;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTenKhoa() {
		return TenKhoa;
	}
	public void setTenKhoa(String tenKhoa) {
		TenKhoa = tenKhoa;
	}
	public Khoa(int id, String tenKhoa) {
		super();
		Id = id;
		TenKhoa = tenKhoa;
	}
	public Khoa() {
		super();
	}
	
	
}
