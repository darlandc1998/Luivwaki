package app.daos;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericDAO<T extends Serializable> implements IGenericDAO<T> {

    private final Class<T> clazz;

    @Autowired
    SessionFactory sessionFactory;
    
    public GenericDAO(SessionFactory sessionFactory, Class<T> clazz){
        this.sessionFactory = sessionFactory;
        this.clazz = clazz;
    }

    @Override
    public T findOne(Integer id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    @Override
    public List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName(), clazz).getResultList();
    }

    @Override
    public void create(T entity) {
        Session s = getCurrentSession();
        
        getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public void deleteById(Integer entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }

    protected final Session getCurrentSession() {        
        return sessionFactory.openSession();
    }
}
