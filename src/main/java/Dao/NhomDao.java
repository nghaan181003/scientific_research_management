package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.NhomNghienCuu;
import Model.User;
import Util.HandleException;
import Util.JDBCUtil;

public class NhomDao {
	private static final String INSERT_NHOM = "INSERT INTO nhomnghiencuu" + "  (MaNhom, MaTV, MaTrgNhom) VALUES "
			+ " (?, ?, ?);";
	private static final String SELECT_ALL_THANH_VIEN = "select * from nguoidung\r\n"
			+ "join nhomnghiencuu on nguoidung.TenDangNhap = nhomnghiencuu.MaTV\r\n"
			+ "where nhomnghiencuu.MaNhom = ?;";
	private static final String SELECT_MANHOM_BY_MADT = "select MaNhom from detai where MaDT = ?";

	public void insertNhom(NhomNghienCuu nhom)  {
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_NHOM);
			preparedStatement.setInt(1, nhom.getMaNhom());
			preparedStatement.setString(2, nhom.getMaTV());
			preparedStatement.setString(3, nhom.getMaTrgNhom());
			System.out.print(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
	}

	public int getMaNhom() {
		int MaNhom = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("select max(MaNhom) from nhomnghiencuu");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				MaNhom = rs.getInt(1);
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return MaNhom;
	}

	public int getMaNhomByMaDT(int maDT) {
		int MaNhom = 0;
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_MANHOM_BY_MADT);
			preparedStatement.setInt(1, maDT);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				MaNhom = rs.getInt("MaNhom");
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return MaNhom;
	}

	public List<User> selectAllThanhVien(int MaNhom) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> lstThanhVien = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_THANH_VIEN);
			// Step 3: Execute the query or update query
			preparedStatement.setInt(1, MaNhom);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String TenDangNhap = rs.getString("TenDangNhap");
				String HoTen = rs.getString("HoTen");
				String SoDT = rs.getString("SoDT");
				String MaTrgNhom = rs.getString("MaTrgNhom");
				User thanhvien = new User();
				thanhvien.setTenDangNhap(TenDangNhap);
				thanhvien.setHoTen(HoTen);
				thanhvien.setSoDT(SoDT);
				thanhvien.setMaTrgNhom(MaTrgNhom);
				lstThanhVien.add(thanhvien);

			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return lstThanhVien;
	}

}
