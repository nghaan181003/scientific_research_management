package Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DinhKemDao;
import Dao.FileDao;
import Model.DeTai;
import Model.DinhKem;
import Model.File;

@WebServlet("/download")
public class DownloadFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int BUFFER_SIZE = 1024*1000;
       
    public DownloadFileController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lay tham so
		int MaFile = Integer.parseInt(request.getParameter("fid"));
		int MaDT = Integer.parseInt(request.getParameter("dt"));
		
		
		//Khoi tao DAO
		FileDao filedao = new FileDao();
		File A = filedao.get(MaFile);
		String filename = A.getDuongDan();
		
		String path = request.getServletContext().getRealPath("/uploads" + "/" + MaDT + "/" + A.getDuongDan());
		
		java.io.File F = new java.io.File(path);
		OutputStream os = null;
		FileInputStream fis = null;
		
		response.setHeader("Content-Disposition", String.format("attachment;filename=\"%s\"", F.getName()));
		response.setContentType("application/octet-stream");
		
		if (F.exists())
		{
			os = response.getOutputStream();
			fis = new FileInputStream(F);
			byte[] bf = new byte[BUFFER_SIZE];
			int byteRead=-1;
			while((byteRead=fis.read(bf))!=-1)
			{
				os.write(bf,0,byteRead);
			}
		}
		else
		{
			System.out.println("Không tìm thấy" + filename);
		}
		System.out.println(path);
		
		
	}

}
