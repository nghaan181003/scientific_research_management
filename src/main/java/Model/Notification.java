package Model;

import java.util.Date;

public class Notification {
	private int MaTB; 
	private String MaNgGui; 
	private String MaNgNhan;
	private String TieuDe;
	private String NoiDung; 
	private Date NgayGui;
	public Notification() {
		super();
	}

	public Notification(int maTB, String maNgGui, String maNgNhan, String tieuDe, String noiDung, Date ngayGui) {
		super();
		MaTB = maTB;
		MaNgGui = maNgGui;
		MaNgNhan = maNgNhan;
		TieuDe = tieuDe;
		NoiDung = noiDung;
		NgayGui = ngayGui;
	}
	

	public Notification(String maNgNhan, String tieuDe, String noiDung) {
		super();
		MaNgNhan = maNgNhan;
		TieuDe = tieuDe;
		NoiDung = noiDung;
	}

	public int getMaTB() {
		return MaTB;
	}

	public void setMaTB(int maTB) {
		MaTB = maTB;
	}

	public String getMaNgGui() {
		return MaNgGui;
	}

	public void setMaNgGui(String maNgGui) {
		MaNgGui = maNgGui;
	}

	public String getMaNgNhan() {
		return MaNgNhan;
	}

	public void setMaNgNhan(String maNgNhan) {
		MaNgNhan = maNgNhan;
	}

	public String getTieuDe() {
		return TieuDe;
	}

	public void setTieuDe(String tieuDe) {
		TieuDe = tieuDe;
	}


	public String getNoiDung() {
		return NoiDung;
	}

	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}

	public Date getNgayGui() {
		return NgayGui;
	}

	public void setNgayGui(Date ngayGui) {
		NgayGui = ngayGui;
	}
}
