package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.BaoCao;
import Util.HandleException;
import Util.JDBCUtil;

public class BaoCaoDao {
	public void add(BaoCao A) {
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(
					"INSERT INTO baocao (MaDT, MaTT, TenBC, MotaBC) VALUES (?, ?, ?, ?);");
			preparedStatement.setInt(1, A.getMaDT());
			preparedStatement.setInt(2, A.getMaTT());
			preparedStatement.setString(3, A.getTenBC());
			preparedStatement.setString(4, A.getMotaBC());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
	}
}
