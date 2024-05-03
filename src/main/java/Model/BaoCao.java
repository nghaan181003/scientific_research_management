package Model;

public class BaoCao {
	int MaBC;
	int MaDT;
	int MaTT;
	String TenBC;
	String MotaBC;
	public BaoCao() {
		super();
	}
	public BaoCao(int maBC, int maDT, int maTT, String tenBC, String motaBC) {
		super();
		MaBC = maBC;
		MaDT = maDT;
		MaTT = maTT;
		TenBC = tenBC;
		MotaBC = motaBC;
	}
	public int getMaBC() {
		return MaBC;
	}
	public void setMaBC(int maBC) {
		MaBC = maBC;
	}
	public int getMaDT() {
		return MaDT;
	}
	public void setMaDT(int maDT) {
		MaDT = maDT;
	}
	public int getMaTT() {
		return MaTT;
	}
	public void setMaTT(int maTT) {
		MaTT = maTT;
	}
	public String getTenBC() {
		return TenBC;
	}
	public void setTenBC(String tenBC) {
		TenBC = tenBC;
	}
	public String getMotaBC() {
		return MotaBC;
	}
	public void setMotaBC(String motaBC) {
		MotaBC = motaBC;
	}
	
}
