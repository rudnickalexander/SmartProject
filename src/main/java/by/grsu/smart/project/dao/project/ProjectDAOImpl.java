package by.grsu.smart.project.dao.project;

import by.grsu.smart.project.dao.BaseDAO;
import by.grsu.smart.project.entity.Project;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProjectDAOImpl extends BaseDAO implements ProjectDAO {
    private final static Logger logger = Logger.getLogger(ProjectDAOImpl.class);

    @Override
    public Project getProject(Long id) {
        return (Project) sessionFactory.getCurrentSession().get(Project.class, id);
    }

    @Override
    public void save(Project project) {
        sessionFactory.getCurrentSession().save(project);
        logger.info("Saved project - " + project);
    }

    @Override
    public void update(Project project) {
        Project p = (Project) sessionFactory.getCurrentSession().load(Project.class, project.getId());
        logger.info("Updated project - " + project);
        //todo update
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Project> getLatest() {
        String stringQuery = "select p from Project p order by p.createdDate desc";
        Query query = sessionFactory.getCurrentSession().createQuery(stringQuery);

        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Project> findProject(List<Double> params) {
        String queryString = "select p from Project p " +
                                "where p.simplePaybackPeriod >= :sPPF " +
                                    "and p.simplePaybackPeriod <= :sPPT " +
                                    "and p.dynamicPaybackPeriod >= :dPPF " +
                                    "and p.dynamicPaybackPeriod <= :dPPT " +
                                    "and p.netPresentValue >= :pIF " +
                                    "and p.netPresentValue <= :pIT";

        Query query = sessionFactory.getCurrentSession().createQuery(queryString);
        query.setParameter("sPPF", params.get(0) == null ? 0 : params.get(0).intValue());
        query.setParameter("sPPT", params.get(1) == null ? 9999 : params.get(1).intValue());
        query.setParameter("dPPF", params.get(2) == null ? 0 : params.get(2).intValue());
        query.setParameter("dPPT", params.get(3) == null ? 9999 : params.get(3).intValue());
        query.setParameter("pIF", params.get(4) == null ? 0 : params.get(4));
        query.setParameter("pIT", params.get(5) == null ? 999999999 : params.get(5));

        return query.list();
    }
}
