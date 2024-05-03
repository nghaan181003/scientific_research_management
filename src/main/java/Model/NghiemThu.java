package Model;

public class NghiemThu {
	int MaDT;
	String MaNgNT;
	String NhanXet;
	String KetQua;
	int MaTC;
	public NghiemThu() {
		super();
	}
	public NghiemThu(int maDT, String maNgNT, String nhanXet, String ketQua, int maTC) {
		super();
		MaDT = maDT;
		MaNgNT = maNgNT;
		NhanXet = nhanXet;
		KetQua = ketQua;
		MaTC = maTC;
	}
	public int getMaDT() {
		return MaDT;
	}
	public void setMaDT(int maDT) {
		MaDT = maDT;
	}
	public String getMaNgNT() {
		return MaNgNT;
	}
	public void setMaNgNT(String maNgNT) {
		MaNgNT = maNgNT;
	}
	public String getNhanXet() {
		return NhanXet;
	}
	public void setNhanXet(String nhanXet) {
		NhanXet = nhanXet;
	}
	public String getKetQua() {
		return KetQua;
	}
	public void setKetQua(String ketQua) {
		KetQua = ketQua;
	}
	public int getMaTC() {
		return MaTC;
	}
	public void setMaTC(int maTC) {
		MaTC = maTC;
	}
	
}
