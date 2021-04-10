import Entity.Matches;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;


/**
 * Created by maxim on 10.04.2021.
 */
public class MathesHelper {

    private SessionFactory sessionFactory;

    public MathesHelper(){
        sessionFactory = HibernateUtils.getFactory();
    }

    public List<Matches> getMatchesList(){
        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Matches> criteriaQuery = criteriaBuilder.createQuery(Matches.class);

        Root<Matches> root = criteriaQuery.from(Matches.class);

        Selection[] selections = {root.get("id"), root.get("goals1"), root.get("goals2"), root.get("team1"), root.get("team2")};

        criteriaQuery.select(criteriaBuilder.construct(Matches.class, selections));

        Query query = session.createQuery(criteriaQuery);

        List<Matches> matchesList = query.getResultList();

        session.close();

        return matchesList;
    }
    public int getMatchesDataTableSize(){
        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Matches> criteriaQuery = criteriaBuilder.createQuery(Matches.class);

        Root<Matches> root = criteriaQuery.from(Matches.class);

        Selection[] selections = {root.get("id"), root.get("goals1"), root.get("goals2"), root.get("team1"), root.get("team2")};

        criteriaQuery.select(criteriaBuilder.construct(Matches.class, selections));

        Query query = session.createQuery(criteriaQuery);

        List<Matches> matchesList = query.getResultList();

        session.close();

        return matchesList.size();
    }

    public Matches getMatchById(long id){
        Session session = sessionFactory.openSession();
        Matches match = session.get(Matches.class, id);
        session.close();
        return match;
    }
    public Matches addMatch(Matches match){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(match);
        session.getTransaction().commit();
        session.close();
        return match;
    }
}
