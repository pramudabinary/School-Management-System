package bo.custom;

import bo.SuperBO;
import dto.TeacherDTO;

import java.util.ArrayList;

public interface TeacherBO extends SuperBO {
    boolean saveRegistration(TeacherDTO dto)throws Exception;
    void updateRegistration(TeacherDTO dto)throws Exception;
    boolean deleteRegistration(String id)throws Exception;
    TeacherDTO getRegistration(String id)throws Exception;
    ArrayList<TeacherDTO> getAllRegistration()throws Exception;
}
