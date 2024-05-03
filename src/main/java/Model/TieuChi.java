package Model;

public class TieuChi {
	int MaTC;
	String TenTC;
	int status;
	public TieuChi() {
		super();
	}
	public TieuChi(int maTC, String tenTC, int status) {
		super();
		MaTC = maTC;
		TenTC = tenTC;
		this.status = status;
	}
	public int getMaTC() {
		return MaTC;
	}
	public void setMaTC(int maTC) {
		MaTC = maTC;
	}
	public String getTenTC() {
		return TenTC;
	}
	public void setTenTC(String tenTC) {
		TenTC = tenTC;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
