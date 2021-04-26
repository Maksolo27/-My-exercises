

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by maxim on 26.04.2021.
 */
public class OrderDB {


    public List<Orders> getOrderList(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Orders.class);
        Root<Orders> root = cq.from(Orders.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        List<Orders> orderList = query.getResultList();
        return orderList;
    }
}
