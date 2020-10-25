package bo.custom.impl;

import bo.custom.AdminBO;
import dao.DaoFactory;
import dao.QueryDAO;
import dao.custom.AdminDAO;
import db.DBConnection;
import dto.AdminDTO;
import entity.Admin;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


public class AdminBoImpl implements AdminBO {
    private AdminDAO dao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.ADMIN);
    private QueryDAO qDao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.QUERY);

    @Override
    public void saveAdmin(AdminDTO dto) throws Exception {
        boolean save = dao.save(new Admin(dto.getId(), dto.getName(), dto.getUser_name(), dto.getPassword()));
        if (save){
            new Alert(Alert.AlertType.CONFIRMATION,"Added").showAndWait();
        }else{
            new Alert(Alert.AlertType.CONFIRMATION,"Not Added").showAndWait();
        }
    }


    @Override
    public void updateAdmin(AdminDTO dto) throws Exception {
        boolean update = dao.update(new Admin(dto.getId(), dto.getName(), dto.getUser_name(), dto.getPassword()));
        if (update){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated").showAndWait();
        }else{
            new Alert(Alert.AlertType.CONFIRMATION,"Not Updated").showAndWait();
        }
    }

    @Override
    public void deleteAdmin(String id) throws Exception {
        dao.delete(id);
    }

    @Override
    public void getAdmin(String id) throws Exception {
        dao.get(id);
    }

    @Override
    public ArrayList<AdminDTO> getAllAdmins() throws Exception {
        List<Admin> list = dao.getAll();
        ArrayList<AdminDTO> arrayList = new ArrayList<>();
        for (Admin c : list){
            arrayList.add(new AdminDTO(
                    c.getId(),
                    c.getName(),
                    c.getUser_name(),
                    c.getPassword()));
        }
        return arrayList;
    }

    @Override
    public boolean adminLogin(String userName, String password) throws Exception {
        Admin admin = dao.adminLogin(userName, password);
        if (admin != null)
            return true;

        return false;

    }
}
