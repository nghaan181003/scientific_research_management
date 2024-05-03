package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.File;
import Util.HandleException;
import Util.JDBCUtil;

public class FileDao {
	
	public void add(File A)
	{
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO File (DuongDan) VALUES (?)");
			preparedStatement.setString(1, A.getDuongDan());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
	}
	
	public File get(int MaFile)
	{
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("select * from file where MaFile = ?;");
			preparedStatement.setInt(1, MaFile);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				File A = new File();
				
				int maFile = rs.getInt("MaFile");
				String duongdan = rs.getString("DuongDan");
				
				A.setDuongDan(duongdan);
				A.setMaFile(maFile);
				return A;
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return null;
	}
	
	public int getMaxId()
	{
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT MAX(MaFile) as max FROM test_backup.file;");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return 0;
	}

}
