package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DinhKemDao;
import Model.DinhKem;

/**
 * Servlet implementation class TaiLieuController
 */
@WebServlet("/tailieu")
public class TaiLieuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaiLieuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int MaDT = Integer.parseInt(request.getParameter("MaDT"));
		DinhKemDao dinhkemdao = new DinhKemDao();
		List<DinhKem> lst = dinhkemdao.LayDanhSachTaiLieuDeTai(MaDT, 1);
		request.setAttribute("list", lst);
		request.getRequestDispatcher("DSTaiLieuDeTai.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
