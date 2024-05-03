package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.TieuChi;
import Util.HandleException;
import Util.JDBCUtil;

public class TieuChiDao {
	private static final String SELECT_TIEU_CHI_BY_STATUS = "select * from tieuchi where status = 1;";

	public List<TieuChi> selectTieuChiByStatus() {

		List<TieuChi> lstTieuChi = new ArrayList<>();
		try {
			Connection conn = JDBCUtil.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_TIEU_CHI_BY_STATUS);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				
				int MaLV = rs.getInt("MaTC");
				String TenTC = rs.getString("TenTC");
				int status = rs.getInt("status");
				
				TieuChi TieuChi = new TieuChi();
				TieuChi.setMaTC(MaLV);
				TieuChi.setTenTC(TenTC);
				TieuChi.setStatus(status);
				lstTieuChi.add(TieuChi);
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return lstTieuChi;
	}
}
