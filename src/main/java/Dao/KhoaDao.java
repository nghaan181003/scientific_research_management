package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Khoa;
import Util.HandleException;
import Util.JDBCUtil;

public class KhoaDao {
	public List<Khoa> getAll() {

		List<Khoa> lst = new ArrayList<>();
		try {
			Connection conn = JDBCUtil.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement("select * from khoa");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Khoa a = new Khoa();
				a.setId(rs.getInt(1));
				a.setTenKhoa(rs.getString(2));
				lst.add(a);
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return lst;
	}
	
	public static void main(String[] args)
	{
		KhoaDao a = new KhoaDao();
		List<Khoa> lst = a.getAll();
		System.out.println(lst);
	}
	
}
