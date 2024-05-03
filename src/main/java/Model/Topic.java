package Model;

public class Topic {
	private int MaDT;
	private String TenDeTai;
	private String MoTa;
	private int MaLV;
	private int MaTT;
	private int MaNhom;
	private int KinhPhi;
	private String MaGV;
	private int MaDK;
	private String TrangThai;
	private String MaTV;
	
	public Topic() {
		super();
	}
	public Topic(int maDT, String tenDeTai, String moTa, int maLV, int maTT, int maNhom, int kinhPhi, String maGV,
			int maDK) {
		super();
		MaDT = maDT;
		TenDeTai = tenDeTai;
		MoTa = moTa;
		MaLV = maLV;
		MaTT = maTT;
		MaNhom = maNhom;
		KinhPhi = kinhPhi;
		MaGV = maGV;
		MaDK = maDK;
	}
	
	public Topic(int maDT, String tenDeTai, String moTa, int maLV, int maTT, int maNhom, int kinhPhi, String maGV,
			int maDK, String trangThai) {
		super();
		MaDT = maDT;
		TenDeTai = tenDeTai;
		MoTa = moTa;
		MaLV = maLV;
		MaTT = maTT;
		MaNhom = maNhom;
		KinhPhi = kinhPhi;
		MaGV = maGV;
		MaDK = maDK;
		TrangThai = trangThai;
	}
	
	
	public Topic(int maDT, String tenDeTai, String moTa, int maLV, int maTT, int maNhom, int kinhPhi, String maGV,
			int maDK, String trangThai, String maTV) {
		super();
		MaDT = maDT;
		TenDeTai = tenDeTai;
		MoTa = moTa;
		MaLV = maLV;
		MaTT = maTT;
		MaNhom = maNhom;
		KinhPhi = kinhPhi;
		MaGV = maGV;
		MaDK = maDK;
		TrangThai = trangThai;
		MaTV = maTV;
	}
	public String getMaTV() {
		return MaTV;
	}
	public void setMaTV(String maTV) {
		MaTV = maTV;
	}
	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
	public int getMaDT() {
		return MaDT;
	}
	public void setMaDT(int maDT) {
		MaDT = maDT;
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
	public int getMaLV() {
		return MaLV;
	}
	public void setMaLV(int maLV) {
		MaLV = maLV;
	}
	public int getMaTT() {
		return MaTT;
	}
	public void setMaTT(int maTT) {
		MaTT = maTT;
	}
	public int getMaNhom() {
		return MaNhom;
	}
	public void setMaNhom(int maNhom) {
		MaNhom = maNhom;
	}
	public int getKinhPhi() {
		return KinhPhi;
	}
	public void setKinhPhi(int kinhPhi) {
		KinhPhi = kinhPhi;
	}
	public String getMaGV() {
		return MaGV;
	}
	public void setMaGV(String maGV) {
		MaGV = maGV;
	}
	public int getMaDK() {
		return MaDK;
	}
	public void setMaDK(int maDK) {
		MaDK = maDK;
	}
	
	

}
