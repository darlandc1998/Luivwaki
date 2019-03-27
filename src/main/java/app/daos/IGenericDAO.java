package app.daos;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T extends Serializable> {

    T findOne(Integer id);

    List<T> findAll();

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteById(Integer entityId);

}
