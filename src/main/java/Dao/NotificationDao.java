package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Notification;
import Util.HandleException;
import Util.JDBCUtil;

public class NotificationDao {

	private static final String TAO_BAO_CAO = "INSERT INTO thongbao"
			+ "  (manggui, MaNgNhan , TieuDe, NoiDung, ngaygui) VALUES " + " (?, ?, ?, ?, CURRENT_DATE());";

	public List<Notification> getByUserName(String username) {
		String sql = "select * from thongbao where MaNgNhan = ?";
		List<Notification> lst = new ArrayList<>();
		try {
			// Bước 1: Mở kết nối kết MySQL
			Connection conn = JDBCUtil.getConnection();
			// Bước 2: Khởi tạo Prepare Statement
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int MaTB = rs.getInt("MaTB");
				String MaNgGui = rs.getString("MaNgGui");
				String MaNgNhan = rs.getString("MaNgNhan");
				String TieuDe = rs.getString("TieuDe");
				String NoiDung = rs.getString("NoiDung");
				java.sql.Date NgayGui = (java.sql.Date) rs.getDate("NgayGui");
				lst.add(new Notification(MaTB, MaNgGui, MaNgNhan, TieuDe, NoiDung, NgayGui));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}

	public Notification get(int id) {
		Notification thongBao = new Notification();
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM thongbao WHERE MaTB = ?");
			preparedStatement.setInt(1, id);

			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				thongBao.setTieuDe(rs.getString("TieuDe"));
				thongBao.setMaNgGui(rs.getString("MaNgGui"));
				thongBao.setMaNgNhan(rs.getString("MaNgNhan"));
				thongBao.setNoiDung(rs.getString("NoiDung"));
				thongBao.setNgayGui(rs.getDate("NgayGui"));
				return thongBao;
			}
		}

		catch (SQLException e) {
			JDBCUtil.printSQLException(e);
		}
		return null;
	}

	public void taoBaoCao(Notification thongBao) {
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(TAO_BAO_CAO);
			preparedStatement.setString(1, thongBao.getMaNgGui());
			preparedStatement.setString(2, thongBao.getMaNgNhan());
			preparedStatement.setString(3, thongBao.getTieuDe());
			preparedStatement.setString(4, thongBao.getNoiDung());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
	}
}
