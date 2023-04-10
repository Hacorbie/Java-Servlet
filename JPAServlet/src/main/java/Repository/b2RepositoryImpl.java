package Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.protobuf.ByteString;

import Model.bang2;

//@Repository
public class b2RepositoryImpl{
	@PersistenceContext
    private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	
	
	@Transactional
	public bang2 save(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");

		// Tạo EntityManager từ EntityManagerFactory
		EntityManager em = emf.createEntityManager();

		// Bắt đầu giao dịch
		em.getTransaction().begin();

		// Tạo đối tượng mới của lớp bang2
		bang2 b2 = new bang2();
		b2.setTen("Ten moi");
		b2.setLuong(5000);

		// Lưu đối tượng vào CSDL
		em.persist(b2);

		// Commit giao dịch
		em.getTransaction().commit();

		// Đóng EntityManager và EntityManagerFactory
		em.close();
		emf.close();
		return b2;
	}
}

