package bo.custom;

import bo.SuperBO;
import dto.SubjectDTO;

import java.util.ArrayList;

public interface SubjectBO extends SuperBO {
    public void saveSubject(SubjectDTO dto)throws Exception;
    public void updateSubject(SubjectDTO dto)throws Exception;
    public void deleteSubject(String id)throws Exception;
    public SubjectDTO getSubject(String id)throws Exception;
    public ArrayList<SubjectDTO> getAllSubject()throws Exception;
}
