package Model;

public class NhomNghienCuu {
	int MaNhom;
	String MaTV;
	String MaTrgNhom;
	public NhomNghienCuu() {
		super();
	}
	public NhomNghienCuu(int maNhom, String maTV, String maTrgNhom) {
		super();
		MaNhom = maNhom;
		MaTV = maTV;
		MaTrgNhom = maTrgNhom;
	}
	public int getMaNhom() {
		return MaNhom;
	}
	public void setMaNhom(int maNhom) {
		MaNhom = maNhom;
	}
	public String getMaTV() {
		return MaTV;
	}
	public void setMaTV(String maTV) {
		MaTV = maTV;
	}
	public String getMaTrgNhom() {
		return MaTrgNhom;
	}
	public void setMaTrgNhom(String maTrgNhom) {
		MaTrgNhom = maTrgNhom;
	}
	
}
