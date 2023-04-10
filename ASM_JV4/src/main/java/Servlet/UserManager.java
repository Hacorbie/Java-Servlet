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

import Model.User;

/**
 * Servlet implementation class UserManager
 */
@WebServlet({"/UserManager", "/UserManager/AddUser"})
public class UserManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManager() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void SaveUr(String Id, String pass,String name, String email, String R) {
		// Bắt đầu giao dịch
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ASM");

    	// Tạo EntityManager từ EntityManagerFactory
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction transaction = em.getTransaction();
		em.getTransaction().begin();

		User user = new User();
		user.setId(Id);
		user.setPassword(pass);
		user.setEmail(email);
		user.setFullname(name);
		System.out.println(user.getId());
		
		if(R.equals("yes")) {
			user.setAdmin(true);
		}else {
			user.setAdmin(false);
		}
			em.persist(user);
		
		// Lưu đối tượng vào CSDL
		

		// Commit giao dịch
		em.getTransaction().commit();

		// Đóng EntityManager và EntityManagerFactory
//		em.close();
//		emf.close();
    }
    public List<User> GetlistUser() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ASM");

    	// Tạo EntityManager từ EntityManagerFactory
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction transaction = em.getTransaction();
        String query = "SELECT DISTINCT v FROM User v";
        TypedQuery<User> typedQuery = em.createQuery(query, User.class);
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
		List<User> user = GetlistUser();
		request.setAttribute("users", user);
		request.getRequestDispatcher("/views/User.jsp").forward(request, response);
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
	    if(uri.contains("AddUser")) {
			String id = request.getParameter("ID");
			String pass = request.getParameter("pass");
			String name = request.getParameter("fname");
			String emai = request.getParameter("emai");
			String role =  "yes";
			SaveUr(id, pass,name, emai, role);
			List<User> user = GetlistUser();
			request.setAttribute("users", user);
		}
	    
	    // Đóng EntityManager và EntityManagerFactory ở đây
	    em.close();
	    emf.close();
		doGet(request, response);
	}

}
