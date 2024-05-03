package Model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User  implements Serializable{
	private String tenDangNhap;
	private String matKhau;
	private String gioiTinh;
	private String hoTen;
	private String soCCCD;
	private String diaChi;
	private String email;
	private String soDT;
	private String ngaySinh;
	private int khoa;
	private String soTK;
	private String tenNH;
	private int maLoaiND;
	private int maKhoa;
	private int maLop;
	private String tenKhoa;
	private String tenLoaiND;
	private String MaTrgNhom;
	
	
	
	
	public String getTenLoaiND() {
		return tenLoaiND;
	}
	public void setTenLoaiND(String tenLoaiND) {
		this.tenLoaiND = tenLoaiND;
	}
	public String getTenKhoa() {
		return tenKhoa;
	}
	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSoCCCD() {
		return soCCCD;
	}
	public void setSoCCCD(String soCCCD) {
		this.soCCCD = soCCCD;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	
	public int getKhoa() {
		return khoa;
	}
	public void setKhoa(int khoa) {
		this.khoa = khoa;
	}
	public String getSoTK() {
		return soTK;
	}
	public void setSoTK(String soTK) {
		this.soTK = soTK;
	}
	public String getTenNH() {
		return tenNH;
	}
	public void setTenNH(String tenNH) {
		this.tenNH = tenNH;
	}
	public int getMaLoaiND() {
		return maLoaiND;
	}
	public void setMaLoaiND(int maLoaiND) {
		this.maLoaiND = maLoaiND;
	}
	public int getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(int maKhoa) {
		this.maKhoa = maKhoa;
	}
	public int getMaLop() {
		return maLop;
	}
	public void setMaLop(int maLop) {
		this.maLop = maLop;
	}
	
	
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getMaTrgNhom() {
		return MaTrgNhom;
	}
	public void setMaTrgNhom(String maTrgNhom) {
		MaTrgNhom = maTrgNhom;
	}
	public User(String tenDangNhap, String matKhau, String gioiTinh, String hoTen, String soCCCD, String diaChi,
			String email, String soDT, String ngaySinh, int khoa, String soTK, String tenNH, int maLoaiND, int maKhoa,
			int maLop) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.gioiTinh = gioiTinh;
		this.hoTen = hoTen;
		this.soCCCD = soCCCD;
		this.diaChi = diaChi;
		this.email = email;
		this.soDT = soDT;
		this.ngaySinh = ngaySinh;
		this.khoa = khoa;
		this.soTK = soTK;
		this.tenNH = tenNH;
		this.maLoaiND = maLoaiND;
		this.maKhoa = maKhoa;
		this.maLop = maLop;
	}
	public User() {
		super();
	}
	public User(String tenDangNhap, String matKhau, String gioiTinh, String hoTen, String soCCCD, String diaChi,
			String email, String soDT, String ngaySinh, String soTK, String tenNH, int maLoaiND, int maKhoa, String tenKhoa, String tenLoaiND) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.gioiTinh = gioiTinh;
		this.hoTen = hoTen;
		this.soCCCD = soCCCD;
		this.diaChi = diaChi;
		this.email = email;
		this.soDT = soDT;
		this.ngaySinh = ngaySinh;
		this.soTK = soTK;
		this.tenNH = tenNH;
		this.maLoaiND = maLoaiND;
		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
		this.tenLoaiND = tenLoaiND;
	}
	
	public User(String tenDangNhap, String matKhau, String gioiTinh, String hoTen, String soCCCD, String diaChi,
			String email, String soDT, String soTK, String tenNH) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.gioiTinh = gioiTinh;
		this.hoTen = hoTen;
		this.soCCCD = soCCCD;
		this.diaChi = diaChi;
		this.email = email;
		this.soDT = soDT;
		//this.ngaySinh = ngaySinh;
		this.soTK = soTK;
		this.tenNH = tenNH;

		
	}
	
}
