package Model;

public class LinhVuc {
	int MaLV;
	String TenLinhVuc;
	int status;
	public LinhVuc() {
		super();
	}
	public LinhVuc(int maLV, String tenLinhVuc, int status) {
		super();
		MaLV = maLV;
		TenLinhVuc = tenLinhVuc;
		this.status = status;
	}
	public int getMaLV() {
		return MaLV;
	}
	public void setMaLV(int maLV) {
		MaLV = maLV;
	}
	public String getTenLinhVuc() {
		return TenLinhVuc;
	}
	public void setTenLinhVuc(String tenLinhVuc) {
		TenLinhVuc = tenLinhVuc;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
