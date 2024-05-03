package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.DeTai;
import Util.HandleException;
import Util.JDBCUtil;

public class DeTaiDao {

	private static final String CHI_TIET_DE_TAI = "select *, nd.hoten as tengiaovien from detai "
			+ "join nhomnghiencuu on detai.manhom = nhomnghiencuu.manhom "
			+ "join nguoidung on nguoidung.tendangnhap = nhomnghiencuu.MaTV "
			+ "join nguoidung as nd on nd.tendangnhap = detai.magv " + "JOIN trangthai ON detai.MaTT = trangthai.MaTT "
			+ "where MaDT = ?";
	private static final String DE_TAI_CUA_TOI = "SELECT detai.*, trangthai.trangthai, nhomnghiencuu.matv "
			+ "FROM detai " + "JOIN trangthai ON detai.MaTT = trangthai.MaTT "
			+ "JOIN nhomnghiencuu ON detai.MaNhom = nhomnghiencuu.MaNhom "
			+ "WHERE nhomnghiencuu.matv = ? AND detai.matt != 4 AND detai.matt != 6";
	private static final String INSERT_DETAI = "INSERT INTO detai"
			+ "  (TenDeTai, MaLV, MoTa, KinhPhi, MaTT, MaGV) VALUES " + " (?, ?, ?, ?, ?, ?);";

	private static final String UPDATE_DETAI_BY_MADT = "update detai set MaTT = ? , tendetai = ?, mota = ? , malv = ? , manhom = ? , kinhphi = ?, magv = ? , dot = ? where MaDT = ?\r\n"
			+ "";

	private static final String DS_DE_TAI_CAN_DUYET = "select * from detai\r\n"
			+ "join trangthai on detai.matt = trangthai.matt\r\n" + "join linhvuc on detai.malv = linhvuc.malv\r\n"
			+ "join nguoidung on detai.magv = nguoidung.tendangnhap\r\n" + "where detai.matt = 5";

	private static final String DS_DE_TAI_CAN_NGHIEM_THU = "select * from detai\r\n"
			+ "join trangthai on detai.matt = trangthai.matt\r\n" + "join linhvuc on detai.malv = linhvuc.malv\r\n"
			+ "join nguoidung on detai.magv = nguoidung.tendangnhap\r\n" + "where detai.matt = 1";

	private static final String UPDATE_MATT_BY_MADT = "update detai set MaTT = ? where MaDT = ?;";
	private static final String SELECT_DETAI_BY_MADT = "select *, nd.hoten as tengiaovien\r\n" + "from detai \r\n"
			+ "join nguoidung as nd on detai.magv = nd.tendangnhap\r\n" + "where detai.madt = ?";

	private static final String DANG_KY_DE_TAI = "select * from detai\r\n"
			+ "join trangthai on detai.matt = trangthai.matt\r\n"
			+ "join nguoidung as nd on nd.tendangnhap = detai.magv\r\n" + "where detai.MaTT = 4";
	private static final String UPDATE_MANHOM_BY_MADT = "update detai set MaNhom = ? where MaDT = ?;";
	
	private static final String CHI_TIET_KHONG_NHOM = "select * from detai\r\n"
			+ "join nguoidung on nguoidung.tendangnhap = detai.magv\r\n"
			+ "where madt = ?";

	public List<DeTai> DanhSachThanhVien(int MaDT) {
		List<DeTai> lst = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn.prepareStatement(CHI_TIET_DE_TAI);
			preparedStatement.setInt(1, MaDT);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			DeTai deTai = new DeTai();
			while (rs.next()) {

				deTai.setTenDeTai(rs.getString("TenDeTai"));
				deTai.setMoTa(rs.getString("MoTa"));
				deTai.setMaLV(rs.getInt("MaLV"));
				deTai.setMaTT(rs.getInt("MaTT"));
				deTai.setMaNhom(rs.getInt("MaNhom"));
				deTai.setKinhPhi(rs.getInt("KinhPhi"));
				deTai.setMaGV(rs.getString("MaGV"));
				// deTai.setDot(rs.getDate("Dot"));
				deTai.setTrangThai(rs.getString("TrangThai"));
				deTai.setMaTV(rs.getString("MaTV"));
				deTai.setTenDangNhap(rs.getString("TenDangNhap"));
				deTai.setHoTen(rs.getString("HoTen"));
				deTai.setSoDT(rs.getString("SoDT"));
				deTai.setMaTrgNhom(rs.getString("MaTrgNhom"));
				lst.add(deTai);
			}

		} catch (SQLException e) {
			JDBCUtil.printSQLException(e);
		}
		return lst;
	}

	// getAll
	public List<DeTai> getAll() {
		List<DeTai> detai = new ArrayList<>();
		try {
			Connection conn = JDBCUtil.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn
					.prepareStatement("select * from detai\r\n" + "join trangthai on detai.matt = trangthai.matt\r\n"
							+ "join linhvuc on detai.malv = linhvuc.malv\r\n"
							+ "join nguoidung on detai.magv = nguoidung.tendangnhap");
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				DeTai newDT = new DeTai();
				newDT.setMaDT(rs.getInt("MaDT"));
				newDT.setTenDeTai(rs.getString("TenDeTai"));
				newDT.setMoTa(rs.getString("MoTa"));
				newDT.setMaLV(rs.getInt("MaLV"));
				newDT.setMaTT(rs.getInt("MaTT"));
				newDT.setMaNhom(rs.getInt("MaNhom"));
				newDT.setKinhPhi(rs.getInt("KinhPhi"));
				newDT.setMaGV(rs.getString("MaGV"));
				// newDT.setDot(rs.getDate("Dot"));
				newDT.setTrangThai(rs.getString("TrangThai"));
				newDT.setLinhVuc(rs.getString("TenLinhVuc"));
				newDT.setTenGiaoVien(rs.getString("HoTen"));
				detai.add(newDT);
			}
		} catch (SQLException e) {
			JDBCUtil.printSQLException(e);
		}

		return detai;
	}

	// Danh sach de tai theo trang thai
	public List<DeTai> getByStatus(int status) {
		List<DeTai> detai = new ArrayList<>();
		try {
			Connection conn = JDBCUtil.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn
					.prepareStatement("select * from detai\r\n" + "join trangthai on detai.matt = trangthai.matt\r\n"
							+ "join linhvuc on detai.malv = linhvuc.malv\r\n"
							+ "join nguoidung on detai.magv = nguoidung.tendangnhap where trangthai.matt = ?");
			preparedStatement.setInt(1, status);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				DeTai newDT = new DeTai();
				newDT.setMaDT(rs.getInt("MaDT"));
				newDT.setTenDeTai(rs.getString("TenDeTai"));
				newDT.setMoTa(rs.getString("MoTa"));
				newDT.setMaLV(rs.getInt("MaLV"));
				newDT.setMaTT(rs.getInt("MaTT"));
				newDT.setMaNhom(rs.getInt("MaNhom"));
				newDT.setKinhPhi(rs.getInt("KinhPhi"));
				newDT.setMaGV(rs.getString("MaGV"));
				// newDT.setDot(rs.getDate("Dot"));
				newDT.setTrangThai(rs.getString("TrangThai"));
				newDT.setLinhVuc(rs.getString("TenLinhVuc"));
				newDT.setTenGiaoVien(rs.getString("HoTen"));
				detai.add(newDT);
			}
		} catch (SQLException e) {
			JDBCUtil.printSQLException(e);
		}

		return detai;
	}

	// Danh sach cac de tai can duyet
	public List<DeTai> getDSDeTaiDuyet() {
		List<DeTai> detai = new ArrayList<>();
		try {
			Connection conn = JDBCUtil.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn.prepareStatement(DS_DE_TAI_CAN_DUYET);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				DeTai newDT = new DeTai();
				newDT.setMaDT(rs.getInt("MaDT"));
				newDT.setTenDeTai(rs.getString("TenDeTai"));
				newDT.setMoTa(rs.getString("MoTa"));
				newDT.setMaLV(rs.getInt("MaLV"));
				newDT.setMaTT(rs.getInt("MaTT"));
				newDT.setMaNhom(rs.getInt("MaNhom"));
				newDT.setKinhPhi(rs.getInt("KinhPhi"));
				newDT.setMaGV(rs.getString("MaGV"));
				// newDT.setDot(rs.getDate("Dot"));
				newDT.setTrangThai(rs.getString("TrangThai"));
				newDT.setLinhVuc(rs.getString("TenLinhVuc"));
				newDT.setTenGiaoVien(rs.getString("HoTen"));
				detai.add(newDT);
			}
		} catch (SQLException e) {
			JDBCUtil.printSQLException(e);
		}

		return detai;
	}

	// Danh sách các đề tài của giảng viên hướng dẫn
	public List<DeTai> getByMaGV(String maGV) {
		List<DeTai> detai = new ArrayList<>();
		try {
			Connection conn = JDBCUtil.getConnection();

			PreparedStatement preparedStatement = conn
					.prepareStatement("select * from detai\r\n" + "join trangthai on detai.MaTT = trangthai.MaTT\r\n"
							+ "where detai.MaGV = ? AND trangthai.MaTT != 4 AND trangthai.MaTT != 6;");
			preparedStatement.setString(1, maGV);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				DeTai newDT = new DeTai();
				newDT.setMaDT(rs.getInt("MaDT"));
				newDT.setTenDeTai(rs.getString("TenDeTai"));
				newDT.setMoTa(rs.getString("MoTa"));
				newDT.setMaLV(rs.getInt("MaLV"));
				newDT.setMaTT(rs.getInt("MaTT"));
				newDT.setMaNhom(rs.getInt("MaNhom"));
				newDT.setKinhPhi(rs.getInt("KinhPhi"));
				newDT.setMaGV(rs.getString("MaGV"));
				// newDT.setDot(rs.getDate("Dot"));
				newDT.setTrangThai(rs.getString("TrangThai"));
				detai.add(newDT);
			}
		} catch (SQLException e) {
			JDBCUtil.printSQLException(e);
		}

		return detai;
	}

	// Danh sach de tai cua toi
	public List<DeTai> selectAllDeTai(String username) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<DeTai> deTai = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn.prepareStatement(DE_TAI_CUA_TOI);
			// Step 3: Execute the query or update query
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int MaDT = rs.getInt("MaDT");
				String TenDeTai = rs.getString("TenDeTai");
				String MoTa = rs.getString("MoTa");
				int MaLV = rs.getInt("MaLV");
				int MaTT = rs.getInt("MaTT");
				int MaNhom = rs.getInt("MaNhom");
				int KinhPhi = rs.getInt("KinhPhi");
				String MaGV = rs.getString("MaGV");
				// java.sql.Date Dot = (java.sql.Date)rs.getDate("Dot");
				String TrangThai = rs.getString("Trangthai");
				String MaTV = rs.getString("MaTV");

				DeTai a = new DeTai();
				a.setMaDT(MaDT);
				a.setTenDeTai(TenDeTai);
				a.setMoTa(MoTa);
				a.setMaLV(MaLV);
				a.setMaTT(MaTT);
				a.setMaNhom(MaNhom);
				a.setKinhPhi(KinhPhi);
				a.setMaGV(MaGV);
				// a.setDot(Dot);
				a.setTrangThai(TrangThai);
				a.setMaTV(MaTV);
				deTai.add(a);
			}

		} catch (SQLException e) {
			JDBCUtil.printSQLException(e);
		}
		return deTai;
	}

	// Chi tiet de tai
	public DeTai selectDeTai(int mdt) {
		DeTai a = null;
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(CHI_TIET_KHONG_NHOM);
			preparedStatement.setInt(1, mdt);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int MaDT = rs.getInt("MaDT");
				String TenDeTai = rs.getString("TenDeTai");
				String MoTa = rs.getString("MoTa");
				int MaLV = rs.getInt("MaLV");
				int MaTT = rs.getInt("MaTT");
				int MaNhom = rs.getInt("MaNhom");
				int KinhPhi = rs.getInt("KinhPhi");
				String MaGV = rs.getString("MaGV");
				String TenGiangVien = rs.getString("HoTen");

				a = new DeTai();
				a.setMaDT(MaDT);
				a.setTenDeTai(TenDeTai);
				a.setMoTa(MoTa);
				a.setMaLV(MaLV);
				a.setMaTT(MaTT);
				a.setMaNhom(MaNhom);
				a.setKinhPhi(KinhPhi);
				a.setMaGV(MaGV);
				a.setTenGiaoVien(TenGiangVien);
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return a;
	}

	// Chi tiet de tai danh sach nhom
	public List<DeTai> selectChiTietDeTai(int MaDT) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<DeTai> chiTietDeTai = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn.prepareStatement(CHI_TIET_DE_TAI);
			preparedStatement.setInt(1, MaDT);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String TenDeTai = rs.getString("TenDeTai");
				String MoTa = rs.getString("MoTa");
				int MaLV = rs.getInt("MaLV");
				int MaTT = rs.getInt("MaTT");
				int MaNhom = rs.getInt("MaNhom");
				int KinhPhi = rs.getInt("KinhPhi");
				String MaGV = rs.getString("MaGV");
				// java.sql.Date Dot = (java.sql.Date)rs.getDate("Dot");
				String TrangThai = rs.getString("Trangthai");
				String MaTV = rs.getString("MaTV");
				String TenDangNhap = rs.getString("TenDangNhap");
				String HoTen = rs.getString("HoTen");
				String SoDT = rs.getString("SoDT");
				String MaTrgNhom = rs.getString("MaTrgNhom");

				DeTai a = new DeTai();
				a.setTenDeTai(TenDeTai);
				a.setMoTa(MoTa);
				a.setMaLV(MaLV);
				a.setMaTT(MaTT);
				a.setMaNhom(MaNhom);
				a.setKinhPhi(KinhPhi);
				a.setMaGV(MaGV);
				// a.setDot(Dot);
				a.setTrangThai(TrangThai);
				a.setMaTV(MaTV);
				a.setTenDangNhap(TenDangNhap);
				a.setHoTen(HoTen);
				a.setSoDT(SoDT);
				a.setMaTrgNhom(MaTrgNhom);

				chiTietDeTai.add(a);
			}

		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return chiTietDeTai;
	}

	public void insertDeTai(DeTai detai) {
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_DETAI);
			preparedStatement.setString(1, detai.getTenDeTai());
			preparedStatement.setInt(2, detai.getMaLV());
			preparedStatement.setString(3, detai.getMoTa());
			preparedStatement.setInt(4, detai.getKinhPhi());
			preparedStatement.setInt(5, detai.getMaTT());
			preparedStatement.setString(6, detai.getMaGV());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
	}

	public void updateDeTai(DeTai detai) {
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_DETAI_BY_MADT);
			preparedStatement.setInt(1, detai.getMaTT());
			preparedStatement.setString(2, detai.getTenDeTai());
			preparedStatement.setString(3, detai.getMoTa());
			preparedStatement.setInt(4, detai.getMaLV());
			preparedStatement.setInt(5, detai.getMaNhom());
			preparedStatement.setInt(6, detai.getKinhPhi());
			preparedStatement.setString(7, detai.getMaGV());
			preparedStatement.setString(8, detai.StringGetDot());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
	}

	public DeTai get(int MaDT) {
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("select * from detai where madt = ?");
			preparedStatement.setInt(1, MaDT);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				DeTai newDT = new DeTai();
				newDT.setMaDT(rs.getInt("MaDT"));
				newDT.setTenDeTai(rs.getString("TenDeTai"));
				newDT.setMoTa(rs.getString("MoTa"));
				newDT.setMaLV(rs.getInt("MaLV"));
				newDT.setMaTT(rs.getInt("MaTT"));
				newDT.setMaNhom(rs.getInt("MaNhom"));
				newDT.setKinhPhi(rs.getInt("KinhPhi"));
				newDT.setMaGV(rs.getString("MaGV"));

				return newDT;

			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return null;
	}

	public void updateMaTTByDeTai(DeTai detai) {
		try {
			Connection conn = JDBCUtil.getConnection();
			System.out.print(detai.getTenDeTai());
			PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_MATT_BY_MADT);
			preparedStatement.setInt(1, detai.getMaTT());
			preparedStatement.setInt(2, detai.getMaDT());
			System.out.print(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
	}

	public void updateMaTTByMaDT(int MaTT, int MaDT) {
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_MATT_BY_MADT);
			preparedStatement.setInt(1, MaTT);
			preparedStatement.setInt(2, MaDT);
			System.out.print(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
	}

	public DeTai selectDeTaiByMaDT(int maDT) {
		DeTai a = null;
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_DETAI_BY_MADT);
			preparedStatement.setInt(1, maDT);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int MaDT = rs.getInt("MaDT");
				String TenDeTai = rs.getString("TenDeTai");
				String MoTa = rs.getString("MoTa");
				int MaLV = rs.getInt("MaLV");
				int MaTT = rs.getInt("MaTT");
				int MaNhom = rs.getInt("MaNhom");
				int KinhPhi = rs.getInt("KinhPhi");
				String MaGV = rs.getString("MaGV");
				int MaDK = rs.getInt("MaDK");
				String TenGiangVien = rs.getString("TenGiaoVien");

				a = new DeTai();
				a.setMaDT(MaDT);
				a.setTenDeTai(TenDeTai);
				a.setMoTa(MoTa);
				a.setMaLV(MaLV);
				a.setMaTT(MaTT);
				a.setMaNhom(MaNhom);
				a.setKinhPhi(KinhPhi);
				a.setMaGV(MaGV);
				a.setTenGiaoVien(TenGiangVien);
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return a;
	}

	public List<DeTai> dangKyDeTai() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<DeTai> deTai = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn.prepareStatement(DANG_KY_DE_TAI);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int MaDT = rs.getInt("MaDT");
				String TenDeTai = rs.getString("TenDeTai");
				String MoTa = rs.getString("MoTa");
				int MaLV = rs.getInt("MaLV");
				int MaTT = rs.getInt("MaTT");
				int MaNhom = rs.getInt("MaNhom");
				int KinhPhi = rs.getInt("KinhPhi");
				String MaGV = rs.getString("MaGV");
				String TrangThai = rs.getString("Trangthai");
				String HoTen = rs.getString("HoTen");

				DeTai a = new DeTai();
				a.setMaDT(MaDT);
				a.setTenDeTai(TenDeTai);
				a.setMoTa(MoTa);
				a.setMaLV(MaLV);
				a.setMaTT(MaTT);
				a.setMaNhom(MaNhom);
				a.setKinhPhi(KinhPhi);
				a.setMaGV(MaGV);
				a.setTrangThai(TrangThai);
				a.setHoTen(HoTen);
				deTai.add(a);
			}

		} catch (SQLException e) {
			JDBCUtil.printSQLException(e);
		}
		return deTai;
	}

	public void updateMaNhomByMaDT(int MaDT, int MaNhom) {
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_MANHOM_BY_MADT);
			preparedStatement.setInt(1, MaNhom);
			preparedStatement.setInt(2, MaDT);
			System.out.print(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
	}

	public static void main(String[] args) {
		DeTaiDao d = new DeTaiDao();
		List<DeTai> detai = d.getByMaGV("gv01");
		// DeTai A = d.selectDeTai(1);
		System.out.print(detai);
	}

	public List<DeTai> getDSDeTaiNghiemThu() {
		List<DeTai> detai = new ArrayList<>();
		try {
			Connection conn = JDBCUtil.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn.prepareStatement(DS_DE_TAI_CAN_NGHIEM_THU);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				DeTai newDT = new DeTai();
				newDT.setMaDT(rs.getInt("MaDT"));
				newDT.setTenDeTai(rs.getString("TenDeTai"));
				newDT.setMoTa(rs.getString("MoTa"));
				newDT.setMaLV(rs.getInt("MaLV"));
				newDT.setMaTT(rs.getInt("MaTT"));
				newDT.setMaNhom(rs.getInt("MaNhom"));
				newDT.setKinhPhi(rs.getInt("KinhPhi"));
				newDT.setMaGV(rs.getString("MaGV"));
				newDT.setTrangThai(rs.getString("TrangThai"));
				newDT.setLinhVuc(rs.getString("TenLinhVuc"));
				newDT.setTenGiaoVien(rs.getString("HoTen"));
				detai.add(newDT);
			}
		} catch (SQLException e) {
			JDBCUtil.printSQLException(e);
		}

		return detai;
	}
}
