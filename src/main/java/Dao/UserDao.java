package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.User;
import Util.HandleException;
import Util.JDBCUtil;

public class UserDao {
	private static final String UPDATE_NGUOI_DUNG = "UPDATE nguoidung "
	        + "SET MatKhau = ?, HoTen = ?, GioiTinh = ?, SoDT = ?, Email = ?, DiaChi = ?, TenNH = ?, SoTK = ?, SoCCCD = ? "
	        + "WHERE tendangnhap = ?";


	private static final String SELECT_USER = "select * from nguoidung \r\n"
			+ "			join khoa on nguoidung.makhoa = khoa.id \r\n"
			+ "            join loainguoidung on nguoidung.maloaind = loainguoidung.id\r\n"
			+ "			where TenDangNhap = ?";

	public User get(String username)
	{
		String sql = "SELECT * FROM nguoidung nd \r\n"
				+ "JOIN khoa k ON nd.MaKhoa = k.id \r\n"
				+ "JOIN loainguoidung loaind ON nd.MaLoaind = loaind.id \r\n"
				+ "WHERE nd.TenDangNhap = ?";
		try {
			//Bước 1: Mở kết nối kết MySQL
			Connection conn = JDBCUtil.getConnection();
			//Bước 2: Khởi tạo Prepare Statement
			PreparedStatement preparedStatement  = conn
					.prepareStatement(sql);
			preparedStatement.setString(1,username);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next())
			{
				User user = new User();
				user.setTenDangNhap(rs.getString("TenDangNhap"));
				user.setMatKhau(rs.getString("MatKhau"));
				user.setMaLoaiND(rs.getInt("MaLoaiND"));
				user.setTenKhoa(rs.getString("TenKhoa"));
				user.setHoTen(rs.getString("HoTen"));
				user.setGioiTinh(rs.getString("GioiTinh"));
				user.setSoCCCD(rs.getString("SoCCCD"));
				user.setDiaChi(rs.getString("DiaChi"));
				user.setEmail(rs.getString("Email"));
				user.setSoDT(rs.getString("SoDT"));
				user.setNgaySinh(rs.getString("NgaySinh"));
				user.setKhoa(rs.getInt("Khoa"));
				user.setSoTK(rs.getString("SoTK"));
				user.setTenNH(rs.getString("TenNH"));
				user.setTenLoaiND(rs.getString("TenLoaiND"));
				return user;
			}
		}
		catch(SQLException  e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public void add(User A)
	{
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("insert into nguoidung "
					+ "(TenDangNhap, MatKhau, HoTen, MaLoaiND, MaKhoa, GioiTinh, SoDT, Email, DiaChi, TenNH, SoTK, NgaySinh, SoCCCD) "
					+ "values (? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);\r\n" + "");
			preparedStatement.setString(1, A.getTenDangNhap());
			preparedStatement.setString(2, A.getMatKhau());
			preparedStatement.setString(3, A.getHoTen());
			preparedStatement.setInt(4, A.getMaLoaiND());
			preparedStatement.setInt(5, A.getMaKhoa());
			preparedStatement.setString(6, A.getGioiTinh());
			preparedStatement.setString(7, A.getSoDT());
			preparedStatement.setString(8, A.getEmail());
			preparedStatement.setString(9, A.getDiaChi());
			preparedStatement.setString(10, A.getTenNH());
			preparedStatement.setString(11, A.getSoTK());
			preparedStatement.setString(12, A.getNgaySinh());
			preparedStatement.setString(13, A.getSoCCCD());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
	}
	
	public boolean updateUser(User user) {
		boolean rowUpdated = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_NGUOI_DUNG);
			System.out.println(preparedStatement);
			
			preparedStatement.setString(1, user.getMatKhau());
			preparedStatement.setString(2, user.getHoTen());
			//statement.setInt(3, user.getMaKhoa());
			preparedStatement.setString(3, user.getGioiTinh());
			preparedStatement.setString(4, user.getSoDT());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setString(6, user.getDiaChi());
			preparedStatement.setString(7, user.getTenNH());
			preparedStatement.setString(8, user.getSoTK());
			//statement.setString(9, user.getNgaySinh());
			preparedStatement.setString(9, user.getSoCCCD());
			preparedStatement.setString(10, user.getTenDangNhap());

			rowUpdated = preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return rowUpdated;
	}
	
	public boolean delete(String username)
	{
		return true;
	}
	
	public String getTenKhoa(String username)
	{
		return "";
	}
	
	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		String sql = "select * from nguoidung join loainguoidung on nguoidung.maloaind = loainguoidung.id";
		try {
			// Bước 1: Mở kết nối kết MySQL
			Connection conn = JDBCUtil.getConnection();
			// Bước 2: Khởi tạo Prepare Statement
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setTenDangNhap(rs.getString("TenDangNhap"));
				user.setMatKhau(rs.getString("MatKhau"));
				user.setMaLoaiND(rs.getInt("MaLoaiND"));
				user.setHoTen(rs.getString("HoTen"));
				user.setTenLoaiND(rs.getString("TenLoaiND"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public User selectUser(String TenDangNhap) {
		User user = null;
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USER);
			preparedStatement.setString(1, TenDangNhap);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String MatKhau = rs.getString("MatKhau");
				String HoTen = rs.getString("HoTen");
				String NgaySinh = rs.getString("NgaySinh");
				String GioiTinh = rs.getString("GioiTinh");
				String DiaChi = rs.getString("DiaChi");
				String SoDT = rs.getString("SoDT");
				String SoCCCD = rs.getString("SoCCCD");
				int MaKhoa = rs.getInt("MaKhoa");
				String SoTK = rs.getString("SoTK");
				String TenNH = rs.getString("TenNH");
				String Email = rs.getString("Email");
				int MaLoaiND = rs.getInt("MaLoaiND");
				String TenKhoa = rs.getString("TenKhoa");
				String TenLoaiND = rs.getString("TenLoaiND");
				
			

				user = new User(TenDangNhap, MatKhau, GioiTinh, HoTen, SoCCCD, DiaChi, Email, SoDT, NgaySinh, SoTK,
						TenNH, MaLoaiND, MaKhoa, TenKhoa,TenLoaiND);
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return user;
	}
	
	public List<User> getMaGVList()
	{
		List<User> users = new ArrayList<>();
		String sql = "select * from nguoidung where MaLoaiND = 2";
		try {
			//Bước 1: Mở kết nối kết MySQL
			Connection conn = JDBCUtil.getConnection();
			//Bước 2: Khởi tạo Prepare Statement
			PreparedStatement preparedStatement  = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next())
			{
				User user = new User();
				user.setTenDangNhap(rs.getString("TenDangNhap"));
				user.setMatKhau(rs.getString("MatKhau"));
				user.setMaLoaiND(rs.getInt("MaLoaiND"));
				user.setHoTen(rs.getString("HoTen"));
				users.add(user);
			}
		}
		catch(SQLException  e)
		{
			e.printStackTrace();
		}
		return users;
	}
	
	public static void main(String[] args)
	{
		UserDao dao = new UserDao();
		User A = new User();
		A.setTenDangNhap("admin02");
		A.setMatKhau("12345");
		A.setHoTen("Nguyen Van A");
		A.setMaLoaiND(1);
		A.setMaKhoa(1);
		dao.add(A);
	}
}
