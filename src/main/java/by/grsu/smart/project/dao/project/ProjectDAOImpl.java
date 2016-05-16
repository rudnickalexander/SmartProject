package by.grsu.smart.project.dao.project;

import by.grsu.smart.project.dao.BaseDAOImpl;
import by.grsu.smart.project.entity.Project;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProjectDAOImpl extends BaseDAOImpl implements ProjectDAO {
    private final static Logger logger = Logger.getLogger(ProjectDAOImpl.class);

    @Override
    @Transactional
    public void save(Project project) {
        sessionFactory.getCurrentSession().save(project);
    }

    @Override
    @Transactional
    public void update(Project project) {
        Project p = (Project) sessionFactory.getCurrentSession().load(Project.class, project.getId());
        //todo update
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Project> getLatest() {
        String stringQuery = "select p from Project p order by p.createdDate desc";
        Query query = sessionFactory.getCurrentSession().createQuery(stringQuery);

        return query.list();
    }
}
