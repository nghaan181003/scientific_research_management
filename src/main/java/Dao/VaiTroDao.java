package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Khoa;
import Model.VaiTro;
import Util.HandleException;
import Util.JDBCUtil;

public class VaiTroDao {
	public List<VaiTro> getAll() {
		List<VaiTro> lst = new ArrayList<>();
		try {
			Connection conn = JDBCUtil.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement("select * from loainguoidung");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				VaiTro a = new VaiTro();
				a.setMaLoaiND(rs.getInt(1));
				a.setTenLoaiND(rs.getString(2));
				lst.add(a);
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return lst;
	}
	
}
