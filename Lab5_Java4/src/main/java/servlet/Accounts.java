package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Users;
import repo.Userrepo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet(name = "Accounts", value = { "/account/sign-up", "/account/sign-in", "/account/sign-out",
		"/account/forgot-password", "/account/change-password", "/account/edit-profile" })
public class Accounts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Userrepo repo = new Userrepo();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uri = req.getRequestURI();
		if(uri.contains("sign-in")) {
			req.getRequestDispatcher("/view/Signin.jsp").forward(req, res);
			return;
		}else if(uri.contains("sign-up")) {
			req.getRequestDispatcher("/view/Signup.jsp").forward(req, res);
			return;
		}
		req.getRequestDispatcher("/view/Signin.jsp").forward(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("sign-in")) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			Users u = repo.getOne(username);
			System.out.println(password + "/" + u.getPassword());
			if(!u.getPassword().equalsIgnoreCase(password)) {
				req.setAttribute("result", "đăng nhập thất bại");
				req.getRequestDispatcher("/view/Signin.jsp").forward(req, res);
			}else {
				req.setAttribute("result", "đăng nhập thành công");
				req.setAttribute("user", u);
				req.getRequestDispatcher("/view/ManageAccount.jsp").forward(req, res);
			}
			
		} else if (uri.contains("sign-up")) {
			Users u = new Users();
			try {
				BeanUtils.populate(u, req.getParameterMap());
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(repo.getOne(u.getId()) != null) {
				req.setAttribute("result", "tên đăng nhập này đã dc sử dụng bởi tài khoản khác");
			}else {
				repo.create(u);
				req.setAttribute("result", "tạo mới thành công");
				req.getRequestDispatcher("/view/Signin.jsp").forward(req, res);
			}
		} else if (uri.contains("edit-profile")) {
			Users u = new Users();
			try {
				BeanUtils.populate(u, req.getParameterMap());
				repo.update(u);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			res.getWriter().write("cập nhật thành công");
			req.setAttribute("result", "cập nhật thành công");
		}
	}

}
