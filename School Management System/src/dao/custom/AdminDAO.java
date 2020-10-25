package dao.custom;

import dao.CrudDAO;
import entity.Admin;

public interface AdminDAO extends CrudDAO<Admin,String> {

    Admin adminLogin(String userName, String password)  throws Exception;
}
