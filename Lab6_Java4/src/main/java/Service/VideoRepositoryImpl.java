package Service;
import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import Model.Videos;

public class VideoRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    
    public List<Videos> findByTitleContaining(String title) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
    	EntityManager em = emf.createEntityManager();
        String query = "SELECT v FROM Video v WHERE v.title LIKE :title";
        TypedQuery<Videos> typedQuery = em.createQuery(query, Videos.class);
        typedQuery.setParameter("title", "%" + title + "%");
        return typedQuery.getResultList();
    }
}
