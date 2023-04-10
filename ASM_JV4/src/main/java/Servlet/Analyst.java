package Servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.VideoFavor;
/**
 * Servlet implementation class Analyst
 */
@WebServlet("/Analyst")
public class Analyst extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Analyst() {
        super();
        // TODO Auto-generated constructor stub
    }
    private List<VideoFavor> GetList(){
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ASM"); 

    	// Tạo EntityManager từ EntityManagerFactory
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction transaction = em.getTransaction();
    	String query = "SELECT new VideoFavor(o.video.Title, count(o), min(o.LikeDate), max(o.LikeDate)) "
    	        + "FROM Favorite o "
    	        + "GROUP BY o.video.Id";
    	TypedQuery<VideoFavor> typedQuery = em.createQuery(query, VideoFavor.class); 
        return typedQuery.getResultList();

    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

	    response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/views/Ana.jsp").forward(request, response);
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

	    response.setCharacterEncoding("utf-8");
		List<VideoFavor> vid = GetList();
		request.setAttribute("vids", vid);
		doGet(request, response);
	}

}
