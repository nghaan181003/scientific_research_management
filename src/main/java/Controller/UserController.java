package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.KhoaDao;
import Dao.UserDao;
import Dao.VaiTroDao;
import Model.Khoa;
import Model.User;
import Model.VaiTro;
import Service.UserService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/NguoiDung")
public class UserController extends HttpServlet {
	UserService userSer;
	KhoaDao khoaDao;
	VaiTroDao vaitroDao;
	UserDao userDao;
	private static final long serialVersionUID = 1L;
       
    
    public UserController() {
        super();
        userSer = new UserService();
        khoaDao = new KhoaDao();
        vaitroDao = new VaiTroDao();
        userDao = new UserDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		System.out.println(action);
		switch(action)
		{
		case "DanhSach":
			getUserList(request, response);
			break;
		case "Them":
			addUser(request, response);
			break;
		case "ChinhSua":
			editUser(request, response);
			break;
		case "CapNhat":
			updateUser(request, response);
			break;
		}
	}
	
	private void getUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<User> userLst = userSer.getAll();
		List<Khoa> khoaLst = khoaDao.getAll();
		List<VaiTro> vaitroLst = vaitroDao.getAll();
		request.setAttribute("listUser", userLst);
		request.setAttribute("listRoles", vaitroLst);
		request.setAttribute("listFacs", khoaLst);
		request.getRequestDispatcher("AdminUserList.jsp").forward(request, response);
	}
	
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");

		String nTenDangNhap = request.getParameter("newUserName");
		String nMatKhau = request.getParameter("newPassword");
		String nHoTen = request.getParameter("newName");
		int nMaLoaiND = Integer.parseInt(request.getParameter("newRole"));
		int nMaKhoa = Integer.parseInt(request.getParameter("newFac"));
		String nGioiTinh = request.getParameter("newGioiTinh");
		String nSoDT = request.getParameter("newSoDT");
		String nEmail = request.getParameter("newEmail");
		String nDiaChi = request.getParameter("newDiaChi");
		String nTenNH = request.getParameter("newTenNH");
		String nSoTK = request.getParameter("newSoTK");
		String nNgaySinh = request.getParameter("newNgaySinh");
		String nSoCCCD = request.getParameter("newSoCCCD");
		System.out.println(nNgaySinh);

		User newUser = new User();
		newUser.setTenDangNhap(nTenDangNhap);
		newUser.setMaKhoa(nMaKhoa);
		newUser.setMatKhau(nMatKhau);
		newUser.setMaLoaiND(nMaLoaiND);
		newUser.setHoTen(nHoTen);
		newUser.setGioiTinh(nGioiTinh);
		newUser.setSoDT(nSoDT);
		newUser.setEmail(nEmail);
		newUser.setDiaChi(nDiaChi);
		newUser.setTenNH(nTenNH);
		newUser.setSoTK(nSoTK);
		newUser.setSoCCCD(nSoCCCD);
		
		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateTime = LocalDate.parse(nNgaySinh, inputFormat);
		
		DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		newUser.setNgaySinh(dateTime.format(outputFormat));
		
		userDao.add(newUser);
		response.sendRedirect("NguoiDung?action=DanhSach");
	}
	
	private void editUser(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
				String TenDangNhap = request.getParameter("TenDangNhap");
		        System.out.print(request.getParameter("TenDangNhap"));
		        
		        User selectUser = userDao.selectUser(TenDangNhap);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("ChinhSuaNguoiDung.jsp");
		        request.setAttribute("user", selectUser);
		        dispatcher.forward(request, response);

		    }
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
		    throws IOException {
				String TenDangNhap = request.getParameter("TenDangNhap");
		        String MatKhau = request.getParameter("MatKhau");
		        System.out.print(MatKhau);
                String HoTen = request.getParameter("HoTen");
                //String NgaySinh = request.getParameter("newNgaySinh");
                String GioiTinh = request.getParameter("GioiTinh");
                String DiaChi = request.getParameter("DiaChi");
                String SoDT = request.getParameter("SoDT");
                String SoCCCD = request.getParameter("SoCCCD");
                //int MaKhoa = Integer.parseInt(request.getParameter("MaKhoa"));
                String SoTK = request.getParameter("SoTK");
                String TenNH = request.getParameter("TenNH");
                String Email = request.getParameter("Email");
                
                User up = new User(TenDangNhap, MatKhau, GioiTinh, HoTen, SoCCCD, DiaChi, Email, SoDT, SoTK, TenNH);
                userDao.updateUser(up);
		        response.sendRedirect("NguoiDung?action=DanhSach");
		    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//addUser(request,response);
	}

}
