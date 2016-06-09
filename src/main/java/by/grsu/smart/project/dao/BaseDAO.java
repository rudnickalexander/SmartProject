package by.grsu.smart.project.dao;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDAO {
    private final static Logger logger = Logger.getLogger(BaseDAO.class);

    @Autowired
    protected SessionFactory sessionFactory;
}
