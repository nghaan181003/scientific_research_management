package Controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;
import Service.UserService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String alerMsg = "";
		UserService service = new UserService();
		User user = service.login(username, password);
		if(user!=null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			if (user.getMaLoaiND() == 1)
			{
				response.sendRedirect("TrangChuAdmin.jsp");
			}
			else if (user.getMaLoaiND() == 2)
			{
				response.sendRedirect("TrangChuGiaoVien.jsp");
			}
			else if (user.getMaLoaiND() == 3)
			{
				response.sendRedirect("TrangChuSinhVien.jsp");
			}
			else
			{
				response.sendRedirect("TrangChuQuanLy.jsp");
			}
			
		}
		else
		{
			alerMsg = "Tài khoản và mật khẩu không đúng";
			request.setAttribute("alert", alerMsg);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
