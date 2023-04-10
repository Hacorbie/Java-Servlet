package Lab2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bai1
 */
@WebServlet({"/Bai1","/ChuVi","/DienTich"})
public class Bai1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bai1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("views/param/formb1.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Double a = Double.parseDouble(request.getParameter("a"));
		Double b = Double.parseDouble(request.getParameter("b"));
		Double c = Double.parseDouble(request.getParameter("c"));
		if( (a + b > c) && (a + c > b) && (b + c > a)) {
			Double chuvi = a+b+c;
			Double p = chuvi/2;
			Double duongcao = 2*Math.sqrt(p*(p - a)*(p - b)*(p-c))/a;
			Double dientich = (a*duongcao)/2;
			String uri = request.getRequestURI();
			System.out.println(p);
			System.out.println(duongcao);
			System.out.println(dientich);
			
			if(uri.contains("DienTich")) {
				request.setAttribute("message", "Dien tich: " + dientich);
			}else {
				request.setAttribute("message", "Chu vi: " + chuvi);
			}
			}
			else {
			request.setAttribute("message",
			"Khong thoa man cac canh cua tam giac!");
			}
			request.getRequestDispatcher("/views/param/formb1.jsp").forward(request, response);
			}

}
