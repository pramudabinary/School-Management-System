package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.AdminDAO;
import entity.Admin;
import entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public boolean save(Admin admin) throws Exception {
        return CrudUtil.execute("Insert into admin values(?,?,?,SHA1(?))", admin.getId(), admin.getName(), admin.getUser_name(), admin.getPassword());
    }

    @Override
    public boolean update(Admin admin) throws Exception {
        return CrudUtil.execute("UPDATE admin SET admin_name=?,user_name=?,password=? WHERE admin_id=?", admin.getName(), admin.getUser_name(), admin.getPassword(), admin.getId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.execute("Delete from admin where admin_id=?", id);
    }

    @Override
    public Admin get(String id) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM sregister WHERE reg_no=?", id);
        if (rst.next()) {
            return new Admin(
                    rst.getString(1),
                    (rst.getString(2)),
                    (rst.getString(3)),
                    (rst.getString(4)));

        } else {
            return null;
        }
    }

    @Override
    public List<Admin> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM admin");
        ArrayList<Admin> arrayList = new ArrayList<>();
        while (resultSet.next()){
            arrayList.add(new Admin(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)));
        }
        return arrayList;

    }

    @Override
    public Admin adminLogin(String userName, String password) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM admin WHERE user_name=? AND password = SHA1(?)", userName, password);
        if (rst.next()) {
            return new Admin(
                    rst.getString(1),
                    (rst.getString(2)),
                    (rst.getString(3)),
                    (rst.getString(4)));

        }
        return null;
    }
}
