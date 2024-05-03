package Model;

public class Duyet {
	String MaNguoiDuyet;
	String LyDo;
	int MaDT;
	public Duyet() {
		super();
	}
	public Duyet(String maNguoiDuyet, String lyDo, int maDT) {
		super();
		MaNguoiDuyet = maNguoiDuyet;
		LyDo = lyDo;
		MaDT = maDT;
	}
	public String getMaNguoiDuyet() {
		return MaNguoiDuyet;
	}
	public void setMaNguoiDuyet(String maNguoiDuyet) {
		MaNguoiDuyet = maNguoiDuyet;
	}
	public String getLyDo() {
		return LyDo;
	}
	public void setLyDo(String lyDo) {
		LyDo = lyDo;
	}
	public int getMaDT() {
		return MaDT;
	}
	public void setMaDT(int maDT) {
		MaDT = maDT;
	}
	
}
