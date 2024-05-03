package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.KetQuaNghiemThu;
import Model.NghiemThu;
import Util.HandleException;
import Util.JDBCUtil;

public class NghiemThuDao {
	private static final String INSERT_NGHIEM_THU = "INSERT INTO nghiemthu"
			+ "  (MaDT, MaNgNT, NhanXet, KetQua, MaTC) VALUES " + " (?, ?, ?, ?, ?);";
	private static final String SELECT_KET_QUA_NGHIEM_THU = "select TenDeTai, MoTa, MaNhom, TenTC, NhanXet, HoTen as TenGV, KetQua from nghiemthu\r\n"
			+ "join tieuchi on tieuchi.MaTC = nghiemthu.MaTC\r\n" + "join detai on detai.MaDT = nghiemthu.MaDT\r\n"
			+ "join nguoidung on nguoidung.TenDangNhap = detai.MaGV \r\n" + "where nghiemthu.MaDT = ?";

	public void insertNghiemThu(NghiemThu nghiemthu)  {
		try {
			Connection conn = JDBCUtil.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_NGHIEM_THU);
			preparedStatement.setInt(1, nghiemthu.getMaDT());
			preparedStatement.setString(2, nghiemthu.getMaNgNT());
			preparedStatement.setString(3, nghiemthu.getNhanXet());
			preparedStatement.setString(4, nghiemthu.getKetQua());
			preparedStatement.setInt(5, nghiemthu.getMaTC());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		
	}
	
	public List<KetQuaNghiemThu> getKetQuaNTByMaDT(int maDT) {
		List<KetQuaNghiemThu> lstKetQuaNT = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_KET_QUA_NGHIEM_THU);
			preparedStatement.setInt(1, maDT);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String TenDeTai = rs.getString("TenDeTai");
				String MoTa = rs.getString("MoTa");
				int MaNhom = rs.getInt("MaNhom");
				String TenTC = rs.getString("TenTC");
				String NhanXet = rs.getString("NhanXet");
				String TenGV = rs.getString("TenGV");
				String KetQua = rs.getString("KetQua");

				lstKetQuaNT.add(new KetQuaNghiemThu(TenDeTai,MoTa,MaNhom,TenTC,NhanXet,TenGV,KetQua)) ;
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}

		return lstKetQuaNT;
	}
}
