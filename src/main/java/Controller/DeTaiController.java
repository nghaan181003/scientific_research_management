package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.DangKyDao;
import Dao.DeTaiDao;
import Dao.DinhKemDao;
import Dao.DuyetDao;
import Dao.LinhVucDao;
import Dao.NghiemThuDao;
import Dao.NhomDao;
import Dao.TieuChiDao;
import Dao.TrangThaiDao;
import Dao.UserDao;
import Model.DangKy;
import Model.DeTai;
import Model.DinhKem;
import Model.Duyet;
import Model.KetQuaNghiemThu;
import Model.LinhVuc;
import Model.NghiemThu;
import Model.NhomNghienCuu;
import Model.TieuChi;
import Model.TrangThai;
import Model.User;

@WebServlet("/DeTai")
public class DeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DeTaiDao detaiDao;
	private LinhVucDao LinhVucDAO;
	private DuyetDao DuyetDao;
	private NhomDao NhomDao;
	private TieuChiDao TieuChiDao;
	private NghiemThuDao NghiemThuDao;

	public DeTaiController() {
		super();
		detaiDao = new DeTaiDao();
		LinhVucDAO = new LinhVucDao();
		DuyetDao = new DuyetDao();
		NhomDao = new NhomDao();
		TieuChiDao = new TieuChiDao();
		NghiemThuDao = new NghiemThuDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action == null)
			return;
		switch (action) {
		case "huongdan":
			getListByMaGV(request, response);
			break;
		case "SinhVien":
			break;
		case "QuanLy":
			break;
		case "ChiTiet":
			showChiTietDeTai(request, response);
			break;
		case "TatCa":
			getAllList(request, response);
			break;
		case "dsduyetdetai":
			dsduyetdetai(request, response);
			break;
		case "showDuyetDeTai":
			showDuyetDeTai(request, response);
			break;
		case "duyetDeTai":
			duyetDeTai(request, response);
			break;
		case "danhsachDeTaiDangKy":
			danhsachDeTaiDangKy(request, response);
			break;
		case "detaicuatoi":
			DeTaiCuaToi(request, response);
			break;
		case "dexuat":
			showDeXuatDeTai(request, response);
			break;
		case "themdexuat":
			dexuatDeTai(request, response);
			break;
		case "them":
			themDeTai(request, response);
			break;
		case "ChuaHoanThanh":
			break;
		case "showDangKyDeTai":
			showDangKyDeTai(request,response);
			break;
		case "dangkydetai":
			dangkyDeTai(request,response);
			break;
		case "danhsachnghiemthudetai":
			dsnghiemthudetai(request, response);
			break;
		case "showNghiemThuDeTai":
			showNghiemThuDeTai(request, response);
			break;
		case "nghiemthudetai":
			nghiemthuDeTai(request, response);
			break;
		case "ketquanghiemthu":
			showKetQuaNghiemThu(request,response);
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void getAllList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<DeTai> listTatCaDeTai = detaiDao.getAll();
		List<DeTai> listDeTaiChuaHoanThanh = detaiDao.getByStatus(1);
		List<DeTai> listDeTaiDaHoanThanh = detaiDao.getByStatus(2);
		List<DeTai> listDeTaiDangTienHanh = detaiDao.getByStatus(3);
		List<DeTai> listDeTaiChuaDangKy = detaiDao.getByStatus(4);
		List<DeTai> listDeTaiChoDuyet = detaiDao.getByStatus(5);
		LinhVucDao lvDao = new LinhVucDao();
		UserDao uDao = new UserDao();
		TrangThaiDao ttDao = new TrangThaiDao();
		List<LinhVuc> linhvucs = lvDao.selectLinhVucByStatus();
		List<User> GVs = uDao.getMaGVList();
		List<TrangThai> tts = ttDao.getAll();
		int MaTT = Integer.parseInt(request.getParameter("id"));
		switch (MaTT) {
		case 1:
			request.setAttribute("listDeTai", listDeTaiChuaHoanThanh);
			break;
		case 2:
			request.setAttribute("listDeTai", listDeTaiDaHoanThanh);
			break;
		case 3:
			request.setAttribute("listDeTai", listDeTaiDangTienHanh);
			break;
		case 4:
			request.setAttribute("listDeTai", listDeTaiChuaDangKy);
			break;
		case 5:
			request.setAttribute("listDeTai", listDeTaiChoDuyet);
			break;
		default:
			request.setAttribute("listDeTai", listTatCaDeTai);
			break;
		}
		// request.setAttribute("listDeTai", listDeTai);
		request.setAttribute("listLV", linhvucs);
		request.setAttribute("listGVs", GVs);
		request.setAttribute("listTT", tts);
		RequestDispatcher dispatcher = request.getRequestDispatcher("QuanLyDeTai.jsp");
		dispatcher.forward(request, response);
	}

	private void getListByMaGV(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User A = (User) session.getAttribute("user");
		List<DeTai> listDeTai = detaiDao.getByMaGV(A.getTenDangNhap());
		request.setAttribute("listDeTai", listDeTai);
		System.out.println(listDeTai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DSDeTaiHuongDan.jsp");
		dispatcher.forward(request, response);
	}

	// ĐỀ TÀI CỦA CỦA TÔI
	private void DeTaiCuaToi(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		User A = (User) session.getAttribute("user");
		List<DeTai> listDeTai = detaiDao.selectAllDeTai(A.getTenDangNhap());
		request.setAttribute("listDeTai", listDeTai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DeTaiCuaToi.jsp");
		dispatcher.forward(request, response);
	}
	// Luc truoc
//	private void getDeTail(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		int MaDT = Integer.parseInt(request.getParameter("MaDT"));
//		DeTai chiTietDeTai = detaiDao.selectDeTai(MaDT);
//		List<DeTai> listTV = detaiDao.DanhSachThanhVien(MaDT);
//		request.setAttribute("listTV", listTV);
//		request.setAttribute("deTai", chiTietDeTai);
//		System.out.println(chiTietDeTai.getTenGiaoVien());
//		RequestDispatcher dispatcher = request.getRequestDispatcher("ChiTietDeTai.jsp");
//		dispatcher.forward(request, response);
//	}

	// Chi tiet de tai
	private void showChiTietDeTai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int MaDT = Integer.parseInt(request.getParameter("MaDT"));
		DeTai chiTietDeTai = detaiDao.selectDeTai(MaDT);
		List<DeTai> listChiTietDeTai = detaiDao.selectChiTietDeTai(MaDT);
		request.setAttribute("listChiTietDeTai", listChiTietDeTai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ChiTietDeTai.jsp");
		request.setAttribute("deTai", chiTietDeTai);

		DinhKemDao dinhkemdao = new DinhKemDao();
		List<DinhKem> lst = dinhkemdao.LayDanhSachTaiLieuDeTai(MaDT, 1);
		request.setAttribute("tailieu", lst);
		dispatcher.forward(request, response);
	}

	// Hien thi form de xuat de tai
	private void showDeXuatDeTai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<LinhVuc> linhvucs = LinhVucDAO.selectLinhVucByStatus();
		request.setAttribute("listLinhVuc", linhvucs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DeXuatDeTai.jsp");
		dispatcher.forward(request, response);
	}

	// De xuat de tai
	private void dexuatDeTai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User A = (User) session.getAttribute("user");
		request.setCharacterEncoding("UTF-8");
		String TenDeTai = request.getParameter("TenDeTai");
		int MaLV = Integer.parseInt(request.getParameter("MaLV"));
		String MoTa = request.getParameter("MoTa");
		int KinhPhi = Integer.parseInt(request.getParameter("KinhPhi"));
		DeTai newDeTai = new DeTai();
		newDeTai.setTenDeTai(TenDeTai);
		newDeTai.setMaLV(MaLV);
		newDeTai.setMoTa(MoTa);
		newDeTai.setKinhPhi(KinhPhi);
		newDeTai.setMaTT(5);
		newDeTai.setMaGV(A.getTenDangNhap());
		detaiDao.insertDeTai(newDeTai);
		response.sendRedirect("DeTai?action=dexuat");
	}

	// Tao de tai moi
	private void themDeTai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String TenDeTai = request.getParameter("TenDeTai");
		System.out.print(TenDeTai);
		int MaLV = Integer.parseInt(request.getParameter("MaLV"));
		String MaGv = request.getParameter("MaGV");
		int KinhPhi = Integer.parseInt(request.getParameter("KinhPhi"));
		String MoTa = request.getParameter("MoTa");
		DeTai newDeTai = new DeTai();
		newDeTai.setTenDeTai(TenDeTai);
		newDeTai.setMaLV(MaLV);
		newDeTai.setMaGV(MaGv);
		newDeTai.setMaTT(4);
		newDeTai.setMoTa(MoTa);
		newDeTai.setKinhPhi(KinhPhi);
		detaiDao.insertDeTai(newDeTai);
		response.sendRedirect("DeTai?action=TatCa&id=0");
	}

	private void dsduyetdetai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<DeTai> listDeTai = detaiDao.getDSDeTaiDuyet();
		request.setAttribute("listDeTai", listDeTai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DSDeTaiDuyet.jsp");
		dispatcher.forward(request, response);
	}

	private void showDuyetDeTai(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {
		int MaDT = Integer.parseInt(request.getParameter("MaDT"));
		DeTai newDeTai = detaiDao.selectDeTai(MaDT);
		System.out.println(MaDT);
		System.out.println(newDeTai);
		int MaNhom = NhomDao.getMaNhomByMaDT(MaDT);
		List<User> listThanhVien = NhomDao.selectAllThanhVien(MaNhom);
		request.setAttribute("detai", newDeTai);
		request.setAttribute("listThanhVien", listThanhVien);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DuyetDeTai.jsp");
		dispatcher.forward(request, response);
	}

	private void duyetDeTai(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		int MaDT = Integer.parseInt(request.getParameter("MaDT"));
		int kq = Integer.parseInt(request.getParameter("duyet"));
		String LyDo = request.getParameter("LyDo");

		HttpSession session = request.getSession();
		User QL = (User) session.getAttribute("user");
		String MaNguoiDuyet = QL.getTenDangNhap();

		Duyet duyet = new Duyet(MaNguoiDuyet, LyDo, MaDT);
		DuyetDao.insertDuyet(duyet);

		int MaNhom = NhomDao.getMaNhomByMaDT(MaDT);
		System.out.println("Ma Nhom:" + MaNhom);
		DeTai newDeTai = new DeTai();
		newDeTai.setMaDT(MaDT);
		if (kq == 1) {
			if (MaNhom == 0) {
				newDeTai.setMaTT(4);
			} else {
				newDeTai.setMaTT(3);
			}
		} else {
			
			if (MaNhom == 0) {
				newDeTai.setMaTT(6);
				
			} else {
				newDeTai.setMaTT(4);
			}
		}

		detaiDao.updateMaTTByDeTai(newDeTai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DeTai?action=dsduyetdetai");
		dispatcher.forward(request, response);
	}

	private void danhsachDeTaiDangKy(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		DangKyDao dkdao = new DangKyDao();
		DangKy A = dkdao.get(1);
		String alert;
		List<DeTai> listDeTai = detaiDao.dangKyDeTai();
		if (A.getTrangThai() == 1)
		{
			alert = "Chưa tới hạn đăng ký!";
			//listDeTai = null;
		}
		else
		{
			alert = null;
			//listDeTai = detaiDao.dangKyDeTai();
		}
		request.setAttribute("alert",alert);
		request.setAttribute("listDeTai", listDeTai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DSDeTaiDangKy.jsp");
		dispatcher.forward(request, response);
		
	}
	private void dangkyDeTai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int MaNhom = 0;
		int MaDT = Integer.parseInt(request.getParameter("MaDT"));
		int i = 1;
		while (request.getParameter("mssv" + i) != null) {
			String MaTV = request.getParameter("mssv" + i);
			String MaTrgNhom = request.getParameter("MaTrgNhom");
			NhomNghienCuu newNhom = new NhomNghienCuu();
			if (i == 1) {
				MaNhom = NhomDao.getMaNhom() + 1;
			} else {
				MaNhom = NhomDao.getMaNhom();
			}
			newNhom.setMaNhom(MaNhom);
			newNhom.setMaTV(MaTV);
			newNhom.setMaTrgNhom(MaTrgNhom);
			NhomDao.insertNhom(newNhom);
			i++;
		}
		MaNhom = NhomDao.getMaNhom();
		
		detaiDao.updateMaNhomByMaDT(MaDT, MaNhom);
		detaiDao.updateMaTTByMaDT(5,MaDT);
		response.sendRedirect("DeTai?action=danhsachDeTaiDangKy");
	}
	private void showDangKyDeTai(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {
		int MaDT = Integer.parseInt(request.getParameter("MaDT"));
		request.setAttribute("MaDT", MaDT);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DangKyDeTai.jsp");
		dispatcher.forward(request, response);
	}
	private void dsnghiemthudetai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<DeTai> listDeTai = detaiDao.getDSDeTaiNghiemThu();
		request.setAttribute("listDeTai", listDeTai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DSDeTaiNghiemThu.jsp");
		dispatcher.forward(request, response);
	}

	private void showNghiemThuDeTai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<TieuChi> lstTieuChi = TieuChiDao.selectTieuChiByStatus();
		request.setAttribute("listTieuChi", lstTieuChi);
		int MaDT = Integer.parseInt(request.getParameter("MaDT"));
		//DeTai detai = detaiDao.selectDeTaiByMaDT(MaDT);
		DeTai detai = detaiDao.selectDeTai(MaDT);
		request.setAttribute("detai", detai);
		int MaNhom = NhomDao.getMaNhomByMaDT(MaDT);
		List<User> listThanhVien = NhomDao.selectAllThanhVien(MaNhom);
		request.setAttribute("listThanhVien", listThanhVien);
		DinhKemDao dinhkemdao = new DinhKemDao();
		List<DinhKem> lst = dinhkemdao.LayDanhSachTaiLieuDeTai(MaDT, 2);
		request.setAttribute("tailieu", lst);
		RequestDispatcher dispatcher = request.getRequestDispatcher("NghiemThuDeTai.jsp");
		dispatcher.forward(request, response);
	}

	private void nghiemthuDeTai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int MaDT = Integer.parseInt(request.getParameter("MaDT"));
		System.out.print(request);
		List<TieuChi> lstTieuChi = TieuChiDao.selectTieuChiByStatus();
		int i = 0;
		for (TieuChi tieuChi : lstTieuChi) {
			i++;
			int MaTC = tieuChi.getMaTC();
			System.out.print(request.getParameter("NhanXet" + i));
			String NhanXet = request.getParameter("NhanXet" + i);
			String KetQua = request.getParameter("KetQua");
			HttpSession session = request.getSession();
			User GV = (User) session.getAttribute("user");
			String MaNgNT = GV.getTenDangNhap();
			NghiemThu newNghiemThu = new NghiemThu();
			newNghiemThu.setMaDT(MaDT);
			newNghiemThu.setMaNgNT(MaNgNT);
			newNghiemThu.setMaTC(MaTC);
			newNghiemThu.setNhanXet(NhanXet);
			newNghiemThu.setKetQua(KetQua);
			NghiemThuDao.insertNghiemThu(newNghiemThu);
		}
		detaiDao.updateMaTTByMaDT(2, MaDT);
		response.sendRedirect("DeTai?action=danhsachnghiemthudetai");
	}
	
	private void showKetQuaNghiemThu(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {
		int MaDT = Integer.parseInt(request.getParameter("MaDT"));
		request.setAttribute("MaDT", MaDT);
		List<KetQuaNghiemThu> lstKetQuaNT = NghiemThuDao.getKetQuaNTByMaDT(MaDT);
		request.setAttribute("ketQuaNT", lstKetQuaNT.get(1));
		request.setAttribute("lstKetQuaNT", lstKetQuaNT);
		RequestDispatcher dispatcher = request.getRequestDispatcher("KetQuaNghiemThu.jsp");
		dispatcher.forward(request, response);
	}
}
