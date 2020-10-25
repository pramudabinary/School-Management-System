package bo.custom.impl;

import bo.custom.SubjectBO;
import dao.DaoFactory;
import dao.QueryDAO;
import dao.custom.SubjectDAO;
import db.DBConnection;
import dto.SubjectDTO;
import entity.Student;
import entity.Subject;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


public class SubjectBoImpl implements SubjectBO {
    SubjectDAO dao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.SUBJECT);
    QueryDAO queryDAO = DaoFactory.getInstance().getDao(DaoFactory.DAOType.QUERY);
    @Override
    public void saveSubject(SubjectDTO dto) throws Exception {
        dao.save(new Subject(dto.getId(),dto.getSub_name(),dto.getTeacher()));
    }

    @Override
    public void updateSubject(SubjectDTO dto) throws Exception {
        dao.update(new Subject(dto.getId(),dto.getSub_name(),dto.getTeacher()));
    }

    @Override
    public void deleteSubject(String id) throws Exception {
        dao.delete(id);
    }

    @Override
    public SubjectDTO getSubject(String id) throws Exception {
        Subject sub = dao.get(id);
        return new SubjectDTO(sub.getId(),sub.getSub_name(),sub.getTeacher());
    }

    @Override
    public ArrayList<SubjectDTO> getAllSubject() throws Exception {
        List<Subject> list = dao.getAll();
        ArrayList<SubjectDTO> arrayList = new ArrayList<>();
        for (Subject sub : list){
            arrayList.add(
                    new SubjectDTO(
                            sub.getId(),sub.getSub_name(),sub.getTeacher()));
        }
        return arrayList;
    }   
}
