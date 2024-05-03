package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DeTai {
	@Override
	public String toString() {
		return "DeTai [MaDT=" + MaDT + ", TenDeTai=" + TenDeTai + ", MoTa=" + MoTa + ", MaLV=" + MaLV + ", MaTT=" + MaTT
				+ ", MaNhom=" + MaNhom + ", KinhPhi=" + KinhPhi + ", MaGV=" + MaGV + ", Dot=" + Dot + "]";
	}
	int MaDT;
	String TenDeTai;
	String MoTa;
	int MaLV;
	int MaTT;
	int MaNhom;
	int KinhPhi;
	String MaGV;
	Date Dot;
	String TrangThai;
	String MaTV;
	String HoTen;
	String SoDT;
	String TenGiaoVien;
	String TenDangNhap;
	String LinhVuc;
	public String getLinhVuc() {
		return LinhVuc;
	}
	public void setLinhVuc(String linhVuc) {
		LinhVuc = linhVuc;
	}
	public String getTenDangNhap() {
		return TenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}
	public String getTenGiaoVien() {
		return TenGiaoVien;
	}
	public void setTenGiaoVien(String tenGiaoVien) {
		TenGiaoVien = tenGiaoVien;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getSoDT() {
		return SoDT;
	}
	public void setSoDT(String soDT) {
		SoDT = soDT;
	}
	public String getMaTrgNhom() {
		return MaTrgNhom;
	}
	public void setMaTrgNhom(String maTrgNhom) {
		MaTrgNhom = maTrgNhom;
	}
	String MaTrgNhom;
	
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
	public DeTai() {
		super();
	}
	public DeTai(int maDT, String tenDeTai, String moTa, int maLV, int maTT, int maNhom, int kinhPhi, String maGV,
			Date dot) {
		super();
		MaDT = maDT;
		TenDeTai = tenDeTai;
		MoTa = moTa;
		MaLV = maLV;
		MaTT = maTT;
		MaNhom = maNhom;
		KinhPhi = kinhPhi;
		MaGV = maGV;
		Dot = dot;
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
	public Date getDot() {
		return Dot;
	}
	public void setDot(Date dot) {
		Dot = dot;
	}
	
	public String StringGetDot() {
		SimpleDateFormat df = new SimpleDateFormat("MM/yyyy");
		return df.format(Dot);
	}

	

}
