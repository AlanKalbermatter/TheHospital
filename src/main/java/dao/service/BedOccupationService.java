package dao.service;

import dao.domain.BedDTO;
import dao.jdbc.impl.AbstractJdbcDAO;
import dao.jdbc.impl.BedDAO;

import java.sql.SQLException;

public class BedOccupationService extends AbstractJdbcDAO {

    public BedOccupationService(){}

    public BedDTO getById(long id) throws SQLException {
        BedDAO bed = new BedDAO();
        BedDTO b = bed.getById(id);
//        b.setPatient(this.getById(b.));
        return b;
    }



}
