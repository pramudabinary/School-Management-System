package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;

import java.util.ArrayList;

public interface StudentBO extends SuperBO {
    public void saveRegistration(StudentDTO dto)throws Exception;
    public void updateRegistration(StudentDTO dto)throws Exception;
    public boolean deleteRegistration(String id)throws Exception;
    public StudentDTO getRegistration(String id)throws Exception;
    public ArrayList<StudentDTO> getAllRegistration()throws Exception;
    public String getId()throws Exception;
}
