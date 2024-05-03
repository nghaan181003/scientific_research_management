package Model;

public class VaiTro {
	private int MaLoaiND;
	private String TenLoaiND;
	public int getMaLoaiND() {
		return MaLoaiND;
	}
	public void setMaLoaiND(int maLoaiND) {
		MaLoaiND = maLoaiND;
	}
	public String getTenLoaiND() {
		return TenLoaiND;
	}
	public void setTenLoaiND(String tenLoaiND) {
		TenLoaiND = tenLoaiND;
	}
	public VaiTro(int maLoaiND, String tenLoaiND) {
		super();
		MaLoaiND = maLoaiND;
		TenLoaiND = tenLoaiND;
	}
	public VaiTro() {
		super();
	}
}
