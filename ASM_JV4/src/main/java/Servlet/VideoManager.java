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

import Model.Video;



/**
 * Servlet implementation class VideoManager
 */
@WebServlet({"/VideoManager", "/VideoManager/AddVid", "/VideoManager/DeleteVid", "/VideoManager/UpdateVid"})
public class VideoManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoManager() {
        super();
        // TODO Auto-generated constructor stub
    }
	
    public void Save(String Id, String Tit,String Poster, String Des, String Ac) {
		// Bắt đầu giao dịch
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ASM");

    	// Tạo EntityManager từ EntityManagerFactory
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction transaction = em.getTransaction();
		em.getTransaction().begin();

		// Tạo đối tượng mới của lớp bang2
		Video video = new Video();
		video.setId(Id);
		video.setPoster(Poster);
		video.setTitle(Tit);
		video.setDescription(Des);
		video.setViews(0);
		if(Ac.equals("yes")) {
			video.setActive(true);
		}else {
			video.setActive(false);
		}
		
		// Lưu đối tượng vào CSDL
		em.persist(video);

		// Commit giao dịch
		em.getTransaction().commit();

		// Đóng EntityManager và EntityManagerFactory
//		em.close();
//		emf.close();
    }
    public void Delete(String id) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ASM");

    	// Tạo EntityManager từ EntityManagerFactory
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction transaction = em.getTransaction();
		em.getTransaction().begin();
		Video video = em.find(Video.class, id);
		em.remove(video);
		em.getTransaction().commit();
    }
    public void Update(String id, String title, String poster, String description, String active) {
        // Bắt đầu giao dịch
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ASM");
        // Tạo EntityManager từ EntityManagerFactory
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        em.getTransaction().begin();
        
        // Tìm và cập nhật đối tượng video có Id tương ứng
        Video video = em.find(Video.class, id);
		    video.setTitle(title); 
		    System.out.println(video.getTitle());
		    video.setPoster(poster);
		    video.setDescription(description);
		    video.setActive(true);
//		if(active.equals("yes")) {
//		    
//		} else {
//		    video.setActive(false);
//		}

		// Lưu đối tượng vào CSDL
		em.merge(video);
		// Commit giao dịch
		em.getTransaction().commit();

    }

    public List<Video> GetlistVid() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ASM");

    	// Tạo EntityManager từ EntityManagerFactory
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction transaction = em.getTransaction();
        String query = "SELECT DISTINCT v FROM Video v";
        TypedQuery<Video> typedQuery = em.createQuery(query, Video.class);
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
		List<Video> video = GetlistVid();
		request.setAttribute("videos", video);
		request.getRequestDispatcher("/views/Videos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ASM");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	    transaction.begin();
		request.setCharacterEncoding("utf-8");

	    response.setCharacterEncoding("utf-8");
	    
	    String uri = request.getRequestURI();
	    if(uri.contains("AddVid")) {
			String id = request.getParameter("ID");
			String tit = request.getParameter("title");
			String pos = request.getParameter("poster");
			String des = request.getParameter("des");
			String ac = request.getParameter("active");
			Save(id, tit,pos, des, ac);
			List<Video> video = GetlistVid();
			request.setAttribute("videos", video);
		}
	    else if(uri.contains("DeleteVid")) {
			String id = request.getParameter("idDelete");
			Delete(id);
			List<Video> video = GetlistVid();
			request.setAttribute("videos", video);
		}
	    else if(uri.contains("UpdateVid")) {
			String tt = request.getParameter("title");
			String ps = request.getParameter("poster");
			String ds = request.getParameter("des");
			String c = request.getParameter("active");
			String id = request.getParameter("idUpdate");
			Update(id, tt, ps, ds, c);
			System.out.println(ds);
			List<Video> video = GetlistVid();
			request.setAttribute("videos", video);
		}else {}
	    
	    // Đóng EntityManager và EntityManagerFactory ở đây
	    em.close();
	    emf.close();
		doGet(request, response);
	}

}