package by.grsu.smart.project.dao;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDAOImpl {
    private final static Logger logger = Logger.getLogger(BaseDAOImpl.class);

    @Autowired
    protected SessionFactory sessionFactory;
}
