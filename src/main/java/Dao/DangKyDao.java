package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.DangKy;
import Util.JDBCUtil;

public class DangKyDao {

	public DangKy get(int id) {
		String sql = "select * from dangky where id = ?";
		try {
			// Bước 1: Mở kết nối kết MySQL
			Connection conn = JDBCUtil.getConnection();
			// Bước 2: Khởi tạo Prepare Statement
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				DangKy p = new DangKy();
				p.setID(rs.getInt("ID"));
				p.setTrangThai(rs.getInt("TrangThai"));
				p.setMoTa(rs.getString("MoTa"));
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void update(int TT) {
		try {

			Connection conn = JDBCUtil.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement("update dangky set TrangThai = ?");
			preparedStatement.setInt(1, TT);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
