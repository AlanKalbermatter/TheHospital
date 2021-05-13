package dao.interfaces;

import jaxb.model.MedicalStaff;

import java.sql.SQLException;

public interface IEntityDAO<T> {

    public void save(T entity) throws SQLException;
    public MedicalStaff getById(long id) throws SQLException;
    public void update(T entity) throws SQLException;
    public void delete(T entity) throws SQLException;

}
