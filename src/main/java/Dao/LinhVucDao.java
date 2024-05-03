package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.DeTai;
import Model.LinhVuc;
import Util.HandleException;
import Util.JDBCUtil;

public class LinhVucDao {
	
	private static final String SELECT_LINH_VUC_BY_STATUS = "select * from linhvuc where status = 1;";

	public List<LinhVuc> selectLinhVucByStatus() {

		List<LinhVuc> linhvucs = new ArrayList<>();
		try {
			Connection conn = JDBCUtil.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_LINH_VUC_BY_STATUS);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				
				int MaLV = rs.getInt("MaLV");
				String TenLinhVuc = rs.getString("TenLinhVuc");
				int status = rs.getInt("status");
				
				LinhVuc linhvuc = new LinhVuc();
				linhvuc.setMaLV(MaLV);
				linhvuc.setTenLinhVuc(TenLinhVuc);
				linhvuc.setStatus(status);
				linhvucs.add(linhvuc);
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return linhvucs;
	}
	
}
