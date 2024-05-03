package Model;

public class KetQuaNghiemThu {
	String TenDeTai;
	String MoTa;
	int MaNhom;
	String TenTC;
	String NhanXet;
	String TenGV;
	String KetQua;
	public KetQuaNghiemThu() {
		super();
	}
	public KetQuaNghiemThu(String tenDeTai, String moTa, int maNhom, String tenTC, String nhanXet, String tenGV, String ketQua) {
		super();
		TenDeTai = tenDeTai;
		MoTa = moTa;
		MaNhom = maNhom;
		TenTC = tenTC;
		TenGV = tenGV;
		KetQua = ketQua;
		NhanXet = nhanXet;
	}
	public String getTenDeTai() {
		return TenDeTai;
	}
	public void setTenDeTai(String tenDeTai) {
		TenDeTai = tenDeTai;
	}
	public String getMoTa() {
		return MoTa;
	}
	public void setMoTa(String moTa) {
		MoTa = moTa;
	}
	public int getMaNhom() {
		return MaNhom;
	}
	public void setMaNhom(int maNhom) {
		MaNhom = maNhom;
	}
	public String getTenTC() {
		return TenTC;
	}
	public void setTenTC(String tenTC) {
		TenTC = tenTC;
	}
	public String getTenGV() {
		return TenGV;
	}
	public void setTenGV(String tenGV) {
		TenGV = tenGV;
	}
	public String getKetQua() {
		return KetQua;
	}
	public void setKetQua(String ketQua) {
		KetQua = ketQua;
	}
	public String getNhanXet() {
		return NhanXet;
	}
	public void setNhanXet(String nhanXet) {
		NhanXet = nhanXet;
	}
	
}
