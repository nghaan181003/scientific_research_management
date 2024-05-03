package Model;

public class DinhKem {
	private int MaFile;
	private int MaDeTai;
	private String TacGia;
	private String TieuDe;
	private int LoaiDinhKem;
	private String NoiDung;
	private String TenFile;
	
	public String getTenFile() {
		return TenFile;
	}
	public void setTenFile(String tenFile) {
		TenFile = tenFile;
	}
	public int getMaFile() {
		return MaFile;
	}
	public void setMaFile(int maFile) {
		MaFile = maFile;
	}
	public int getMaDeTai() {
		return MaDeTai;
	}
	public void setMaDeTai(int maDeTai) {
		MaDeTai = maDeTai;
	}
	public String getTacGia() {
		return TacGia;
	}
	public void setTacGia(String tacGia) {
		TacGia = tacGia;
	}
	public String getTieuDe() {
		return TieuDe;
	}
	public void setTieuDe(String tieuDe) {
		if (tieuDe == null)
			TieuDe = "Không có tiêu đề";
		else
			TieuDe = tieuDe;
	}
	public int getLoaiDinhKem() {
		return LoaiDinhKem;
	}
	public void setLoaiDinhKem(int loaiDinhKem) {
		LoaiDinhKem = loaiDinhKem;
	}
	public String getNoiDung() {
		return NoiDung;
	}
	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}
	public DinhKem() {
		super();
	}
	
	
	
	

}
