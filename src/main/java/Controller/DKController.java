package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DangKyDao;
import Dao.DeTaiDao;
import Model.DangKy;
import Model.DeTai;

@WebServlet("/DK")
public class DKController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DeTaiDao detaiDao;
	DangKyDao dkdao;

	public DKController() {
		super();
		detaiDao = new DeTaiDao();
		dkdao = new DangKyDao();
	}

	protected void doGet(HttpServletRequest re, HttpServletResponse res) throws ServletException, IOException {

		String action = re.getParameter("action");
		if (action == null)
			return;
		switch (action) {
		case "update":
			upDateStatus(re, res);
			break;
		case "danhsach":
			getDanhSachDeTaiDangKy(re, res);
			break;
		default:
			getDanhSachDeTaiDangKy(re, res);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	private void upDateStatus(HttpServletRequest re, HttpServletResponse res) throws ServletException, IOException {
		int maTT = Integer.parseInt(re.getParameter("id"));
		dkdao.update(maTT);
		res.sendRedirect("DK?action=danhsach");
	}

	private void getDanhSachDeTaiDangKy(HttpServletRequest re, HttpServletResponse res)
			throws ServletException, IOException {
		List<DeTai> listDeTai = detaiDao.dangKyDeTai();
		re.setAttribute("listDeTai", listDeTai);
		DangKy A = dkdao.get(1);
		re.setAttribute("trangthai", A.getTrangThai());
		RequestDispatcher dispatcher = re.getRequestDispatcher("QuanLyDangKy.jsp");
		dispatcher.forward(re, res);
	}

}
