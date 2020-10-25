package bo.custom.impl;

import bo.custom.SInformationBO;
import dao.DaoFactory;
import dao.QueryDAO;
import dao.custom.SInformationDAO;
import db.DBConnection;
import dto.SInformationDTO;
import entity.SInformation;
import javafx.scene.control.Alert;
import org.apache.poi.hssf.record.formula.functions.T;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class SInformationBoImpl implements SInformationBO {
    private SInformationDAO dao= DaoFactory.getInstance()
            .getDao(DaoFactory.DAOType.SINFORMATION);
    private QueryDAO qDao= DaoFactory.getInstance()
            .getDao(DaoFactory.DAOType.QUERY);

    @Override
    public boolean updateInformation(SInformationDTO dto) throws Exception {
        return dao.update(new SInformation(
                dto.getName(),
                dto.getAddress(),
                dto.getZone(),
                dto.getProvince(),
                dto.getDistrict(),
                dto.getName_principal(),
                dto.getPrincipal_con()));

    }
}
