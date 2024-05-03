package Model;

public class DangKy {
	private int ID;
	private int TrangThai;
	private String MoTa;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(int trangThai) {
		TrangThai = trangThai;
	}

	public String getMoTa() {
		return MoTa;
	}

	public void setMoTa(String moTa) {
		MoTa = moTa;
	}

	public DangKy(int iD, int trangThai, String moTa) {
		super();
		ID = iD;
		TrangThai = trangThai;
		MoTa = moTa;
	}

	public DangKy() {
		super();
	}

}
