package bo.custom;

import dto.AdminDTO;

import java.util.ArrayList;

public interface AdminBO {

    void saveAdmin(AdminDTO dto)throws Exception;
    void updateAdmin(AdminDTO dto)throws Exception;
    void deleteAdmin(String id)throws Exception;
    void getAdmin(String id)throws Exception;
    ArrayList<AdminDTO> getAllAdmins()throws Exception;

    boolean adminLogin(String userName, String password) throws Exception;
}
