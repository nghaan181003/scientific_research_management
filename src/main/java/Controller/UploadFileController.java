package Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Dao.BaoCaoDao;
import Dao.DeTaiDao;
import Dao.DinhKemDao;
import Dao.FileDao;
import Model.BaoCao;
import Model.DeTai;
import Model.DinhKem;
import Model.File;
import Model.User;

@WebServlet("/upload")
@MultipartConfig
public class UploadFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String SAVE_DIRECTORY = "uploads";
	DeTaiDao detaidao;
	FileDao filedao;
	DinhKemDao dinhkemdao;
	BaoCaoDao baocaodao;

	public UploadFileController() {
		super();
		detaidao = new DeTaiDao();
		filedao = new FileDao();
		dinhkemdao = new DinhKemDao();
		baocaodao = new BaoCaoDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null)
			return;
		switch (action) {
		case "showupload":
			ShowUpload(request, response);
			break;
		case "uploadfile":
			UpLoadFile(request, response);
			break;
		case "showbaocao":
			ShowBaoCao(request,response);
			break;
		case "baocao":
			BaoCaoDeTai(request,response);
			break;
		default:
			break;
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}
	
	private void ShowUpload(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
		int MaDT = Integer.parseInt(request.getParameter("MaDT"));
		DeTai d = detaidao.get(MaDT);
		request.setAttribute("deTai", d);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormUpLoadFile.jsp");
		dispatcher.forward(request, response);
	}
	private void UpLoadFile(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("user");
		int MaDT = Integer.parseInt(request.getParameter("MaDT"));
		DeTai d = detaidao.get(MaDT);
		Part part = request.getPart("FileDT");
		
		//Xu ly luu File
		String realPath = request.getServletContext().getRealPath("/uploads" + "/" + d.getMaDT());
		String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

		if (!Files.exists(Paths.get(realPath))) {
			Files.createDirectories(Paths.get(realPath));
		}
		part.write(realPath + "/" + filename);
		
		//Truyen du lieu
		File A = new File();
		A.setDuongDan(filename);
		filedao.add(A);
		int MaFile = filedao.getMaxId();
		DinhKem newDinhKem = new DinhKem();
		newDinhKem.setMaFile(MaFile);
		newDinhKem.setMaDeTai(MaDT);
		newDinhKem.setTacGia(U.getTenDangNhap());
		newDinhKem.setLoaiDinhKem(1);  //loai dinh kem
		dinhkemdao.add(newDinhKem);
		System.out.println(realPath + "/" + filename);
		response.sendRedirect("DeTai?action=TatCa&id=0");
	}
	private void ShowBaoCao(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
		int MaDT = Integer.parseInt(request.getParameter("MaDT"));
		DeTai d = detaidao.get(MaDT);
		request.setAttribute("deTai", d);
		RequestDispatcher dispatcher = request.getRequestDispatcher("BaoCaoDeTai.jsp");
		dispatcher.forward(request, response);
	}
	private void BaoCaoDeTai(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("user");
		int MaDT = Integer.parseInt(request.getParameter("MaDT"));
		DeTai d = detaidao.get(MaDT);
		Part part = request.getPart("FileDT");
		
		//Xu ly luu File
		String realPath = request.getServletContext().getRealPath("/uploads" + "/" + d.getMaDT());
		String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

		if (!Files.exists(Paths.get(realPath))) {
			Files.createDirectories(Paths.get(realPath));
		}
		part.write(realPath + "/" + filename);
		
		//Truyen du lieu
		File A = new File();
		A.setDuongDan(filename);
		filedao.add(A);
		int MaFile = filedao.getMaxId();
		DinhKem newDinhKem = new DinhKem();
		newDinhKem.setMaFile(MaFile);
		newDinhKem.setMaDeTai(MaDT);
		newDinhKem.setTacGia(U.getTenDangNhap());
		newDinhKem.setLoaiDinhKem(2);  //loai dinh kem
		dinhkemdao.add(newDinhKem);
		System.out.println(realPath + "/" + filename);
		BaoCao baocao = new BaoCao();
		String TenBC = request.getParameter("TenBC");
		String MotaBC = request.getParameter("MotaBC");
		int MaTT = Integer.parseInt(request.getParameter("MaTT"));
		baocao.setMaDT(MaDT);
		baocao.setMaTT(MaTT);
		baocao.setTenBC(TenBC);
		baocao.setMotaBC(MotaBC);
		baocaodao.add(baocao);
		detaidao.updateMaTTByMaDT(1,MaDT);
		response.sendRedirect("DeTai?action=huongdan");
	}
	
}
