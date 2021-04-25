
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;

/**
 * Created by maxim on 25.04.2021.
 */
public class CurrencyDB {


    public List<Currency> getCurrencyList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Currency.class);
        Root<Currency> root = cq.from(Currency.class);
        Selection[] selections = { root.get("cc"), root.get("rate") };
        cq.select( cb.construct(Currency.class, selections) );
        Query query = session.createQuery(cq);
        List<Currency> currencyList = query.getResultList();
        session.close();
        return currencyList;
    }
}
