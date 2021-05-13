package jaxb.service;

import jaxb.dao.realization.MedicalStaffDAO;
import jaxb.model.MedicalStaff;

public class MedicalStaffService {
    private MedicalStaffDAO msdao = new MedicalStaffDAO();

    public MedicalStaffService(){}

    public void create(MedicalStaff ms){
        msdao.save(ms);
    }

    public void update(MedicalStaff ms){
        msdao.update(ms);
    }

    public MedicalStaff getById(long id){
        return msdao.getById(id);
    }

    public void delete(MedicalStaff ms){
        msdao.delete(ms);
    }

}
