package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.TrangThai;
import Util.JDBCUtil;

public class TrangThaiDao {

	private static final String LOC_DE_TAI_THEO_TT = "SELECT * FROM TrangThai WHERE TrangThai= ?";
	
	public List<TrangThai> getAll()
	{
		List<TrangThai> lst = new ArrayList<TrangThai>();
		
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("select * from trangthai");
			//preparedStatement.setString(1, );
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				TrangThai t = new TrangThai();
				t.setMaTT(rs.getInt(1));
				t.setTrangThai(rs.getString(2));
				lst.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	
	public static void main(String[] args)
	{
		TrangThaiDao dao = new TrangThaiDao();
		System.out.println(dao.getAll());
	}
}
