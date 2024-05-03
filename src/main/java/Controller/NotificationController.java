package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.NotificationDao;
import Model.Notification;
import Model.User;
import Service.NotificationService;

@WebServlet("/ThongBao")
public class NotificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NotificationService notificationService;
	private NotificationDao thongBaoDAO;

	public NotificationController() {
		super();
		notificationService = new NotificationService();
		thongBaoDAO = new NotificationDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "danhsach":
			listThongBao(request, response);
			break;
		case "chitiet":
			showChiTietThongBao(request, response);
			break;
		case "them":
			themBaoCao(request, response);
			break;
		case "tao":
			taoBaoCao(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void listThongBao(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		User A = (User) session.getAttribute("user");
		List<Notification> listThongBao = notificationService.getByUserName(A.getTenDangNhap());
		request.setAttribute("listThongBao", listThongBao);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DanhSachThongBao.jsp");
		dispatcher.forward(request, response);
	}

	private void showChiTietThongBao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int MaTB = Integer.parseInt(request.getParameter("MaTB"));
		Notification chiTietThongBao = notificationService.get(MaTB);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ChiTietThongBao.jsp");
		request.setAttribute("thongBao", chiTietThongBao);
		dispatcher.forward(request, response);

	}

	private void themBaoCao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		User A = (User) session.getAttribute("user");
		String MaNgNhan = request.getParameter("MaNgNhan");
		String TieuDe = request.getParameter("TieuDe");
		String NoiDung = request.getParameter("NoiDung");
		
		//System.out.println(MaNgNhan + TieuDe + NoiDung);
		Notification newThongBao = new Notification();
		newThongBao.setMaNgGui(A.getTenDangNhap());
		newThongBao.setMaNgNhan(MaNgNhan);
		newThongBao.setTieuDe(TieuDe);
		newThongBao.setNoiDung(NoiDung);
		thongBaoDAO.taoBaoCao(newThongBao);
		response.sendRedirect("TaoThongBao.jsp");
	}

	private void taoBaoCao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("TaoThongBao.jsp");
	}

}
