package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.SInformationDAO;
import entity.SInformation;

import java.util.List;

public class SInformationDAOImpl implements SInformationDAO {
    @Override
    public boolean save(SInformation sI) throws Exception {
        return false;
    }

    @Override
    public boolean update(SInformation sInformation) throws Exception {
        return CrudUtil.execute
                ("UPDATE info SET address=?,zone =?,province =?,district=?,principal_name =?,principal_no =? WHERE name =?",
                        sInformation.getAddress(),
                        sInformation.getZone(),
                        sInformation.getProvince(),
                        sInformation.getDistrict(),
                        sInformation.getName_principal(),
                        sInformation.getPrincipal_con(),
                        sInformation.getName());

    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public SInformation get(String s) throws Exception {
        return null;
    }

    @Override
    public List<SInformation> getAll() throws Exception {
        return null;
    }
}
