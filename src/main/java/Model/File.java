package Model;

public class File {
	private int MaFile;
	private String DuongDan;
	public int getMaFile() {
		return MaFile;
	}
	public void setMaFile(int maFile) {
		MaFile = maFile;
	}
	public String getDuongDan() {
		return DuongDan;
	}
	public File() {
		super();
	}
	@Override
	public String toString() {
		return "File [MaFile=" + MaFile + ", DuongDan=" + DuongDan + "]";
	}
	public File(int maFile, String duongDan) {
		super();
		MaFile = maFile;
		DuongDan = duongDan;
	}
	public void setDuongDan(String duongDan) {
		DuongDan = duongDan;
	}
}
