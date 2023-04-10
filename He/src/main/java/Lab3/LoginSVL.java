package Lab3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginSVL
 */
@WebServlet("/LoginSVL")
public class LoginSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSVL() {
        super();
        // TODO Auto-generated constructor stub
    }
    public class CookieUtils {
    	// Tạo và gửi cookie về client để lưu
    	public static Cookie add(String name, String value, int hours,
    	HttpServletResponse resp) {
    	Cookie cookie = new Cookie(name, value);
    	cookie.setMaxAge(hours*60*60);
    	cookie.setPath("/");
    	resp.addCookie(cookie);
    	return cookie;
    	}
    	public static String get(String name, HttpServletRequest req) {
    		Cookie[] cookies = req.getCookies();
    		if(cookies != null) {
    		for(Cookie cookie: cookies) {
    		if(cookie.getName().equalsIgnoreCase(name)) {
    		return cookie.getValue();
    		}
    		}
    		}
    		return "";
    		}

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// đọc giá trị của cookie
		request.setCharacterEncoding("utf-8");

	    response.setCharacterEncoding("utf-8");
				String username = CookieUtils.get("username", request);
				String password = CookieUtils.get("password", request);
				// chuyển sang login.jsp để hiển thị lên form
				request.setAttribute("username", username);
				request.setAttribute("password", password);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/views/LoginCookie/login.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// đọc tham số form đăng nhập
		request.setCharacterEncoding("utf-8");

	    response.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		// kiểm tra tài khoản đăng nhập
		if(!username.equalsIgnoreCase("poly")) {
		request.setAttribute("message", "Sai tên đăng nhập!");
		}
		else if(password.length() < 6) {
		request.setAttribute("message", "Sai mật khẩu!");
		}
		else {
		request.setAttribute("message", "Đăng nhập thành công!");
		// ghi nhớ hoặc xóa tài khoản đã ghi nhớ bằng cookie
		int hours = (remember == null) ? 0 : 30*24; // 0 = xóa
		CookieUtils.add("username", username, hours, response);
		CookieUtils.add("password", password, hours, response);
		}
		
		request.getRequestDispatcher("/views/LoginCookie/login.jsp").forward(request, response);
	}

}
