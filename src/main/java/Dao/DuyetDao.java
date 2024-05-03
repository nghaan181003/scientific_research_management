package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Duyet;
import Model.NhomNghienCuu;
import Util.HandleException;
import Util.JDBCUtil;

public class DuyetDao {
	private static final String INSERT_DUYET = "INSERT INTO duyet" + "  (MaNguoiDuyet, LyDo, MaDT) VALUES "
			+ " (?, ?, ?);";
	
	public void insertDuyet(Duyet duyet) {
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_DUYET);
			preparedStatement.setString(1, duyet.getMaNguoiDuyet());
			preparedStatement.setString(2, duyet.getLyDo());
			preparedStatement.setInt(3, duyet.getMaDT());
			System.out.print(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
	}
}
