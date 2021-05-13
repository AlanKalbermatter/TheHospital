package jaxb.dao.interfaces;

public interface IEntityDAO<T> {
    void save(T entity);
    T getById(long id);
    void update(T entity);
    void delete(T entity);
}
