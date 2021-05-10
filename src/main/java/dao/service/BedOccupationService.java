package dao.service;

import dao.domain.misc.Bed;
import dao.jdbc.impl.AbstractJdbcDAO;
import dao.jdbc.impl.BedDAO;

import java.sql.SQLException;

public class BedOccupationService extends AbstractJdbcDAO {

    public BedOccupationService(){}

    public Bed getById(long id) throws SQLException {
        BedDAO bed = new BedDAO();
        Bed b = bed.getById(id);
//        b.setPatient(this.getById(b.));
        return b;
    }



}
