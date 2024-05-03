package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.DinhKem;
import Model.File;
import Util.HandleException;
import Util.JDBCUtil;

public class DinhKemDao {
	
	public void add(DinhKem A)
	{
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO dinhkem values(? , ? , ? ,? , ? , ?)");
			preparedStatement.setInt(1, A.getMaFile());
			preparedStatement.setInt(2, A.getMaDeTai());
			preparedStatement.setString(3, A.getTacGia());
			preparedStatement.setString(4, A.getTieuDe());
			preparedStatement.setString(5, A.getNoiDung());
			preparedStatement.setInt(6,A.getLoaiDinhKem());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
	}
	
	public List<DinhKem> LayDanhSachTaiLieuDeTai(int MaDT, int LoaiDinhKem)
	{
		List<DinhKem> lst = new ArrayList<>();
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("select * from detai\r\n"
					+ "join dinhkem on detai.madt = dinhkem.MaDeTai\r\n"
					+ "join file on file.mafile = dinhkem.mafile\r\n"
					+ "where dinhkem.LoaiDinhKem = ? AND detai.MaDT = ?");
			preparedStatement.setInt(1, LoaiDinhKem);
			preparedStatement.setInt(2, MaDT);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				DinhKem A = new DinhKem();
				int maFile = rs.getInt("MaFile");
				int maDeTai = rs.getInt("MaDeTai");
				String tacGia = rs.getString("TacGia");
				String noiDung = rs.getString("NoiDung");
				int loaiDinhKem = rs.getInt("LoaiDinhKem");
				String tieuDe = rs.getString("TieuDe");
				String tenFile = rs.getString("DuongDan");
				
				
				A.setMaFile(maFile);
				A.setMaDeTai(maDeTai);
				A.setTacGia(tacGia);
				A.setNoiDung(noiDung);
				A.setLoaiDinhKem(loaiDinhKem);
				A.setTieuDe(tieuDe);
				A.setTenFile(tenFile);
				
				lst.add(A);
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return lst;
	}

}
