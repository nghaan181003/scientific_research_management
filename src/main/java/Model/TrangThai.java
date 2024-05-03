package Model;

public class TrangThai {

	@Override
	public String toString() {
		return "TrangThai [MaTT=" + MaTT + ", TrangThai=" + TrangThai + "]";
	}
	private int MaTT;
	private String TrangThai;
	public int getMaTT() {
		return MaTT;
	}
	public void setMaTT(int maTT) {
		MaTT = maTT;
	}
	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
	public TrangThai() {
		super();
	}
	public TrangThai(int maTT, String trangThai) {
		super();
		MaTT = maTT;
		TrangThai = trangThai;
	}
	
	
}
