package Lab1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bai6
 */
@WebServlet("/Bai6")
public class Bai6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bai6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("views/formb6.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Double chieudai = Double.parseDouble(request.getParameter("chieudai"));
		Double chieurong = Double.parseDouble(request.getParameter("chieurong"));
		Double dientich = chieudai*chieurong;
		request.setAttribute("dientich", "Dien tich: " + dientich);
		Double chuvi = (chieudai+chieurong)*2;
		request.setAttribute("chuvi", "Chu vi: " + chuvi);
		request.getRequestDispatcher("/views/successb6.jsp").forward(request, response);
		doGet(request, response);
	}

}
