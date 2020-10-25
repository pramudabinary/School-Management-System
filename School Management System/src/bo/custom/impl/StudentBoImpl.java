package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DaoFactory;
import dao.QueryDAO;
import dao.custom.StudentDAO;
import dto.StudentDTO;
import entity.Student;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class StudentBoImpl implements StudentBO {
    private StudentDAO dao= DaoFactory.getInstance()
            .getDao(DaoFactory.DAOType.STUDENT);
    private QueryDAO qDao= DaoFactory.getInstance()
            .getDao(DaoFactory.DAOType.QUERY);
    @Override
    public void saveRegistration(StudentDTO dto) throws Exception {
        boolean save = dao.save(new Student(dto.getReg_no(),
                dto.getFull_name(),
                dto.getName_with_initials(),
                dto.getAddress(),
                dto.getDob(),
                dto.getNic(),
                dto.getDoa(),
                dto.getGrade()));
        if (save){
            new Alert(Alert.AlertType.CONFIRMATION,"Registred").showAndWait();
        }else{
            new Alert(Alert.AlertType.CONFIRMATION,"Not Registred").showAndWait();
        }

    }

    @Override
    public void updateRegistration(StudentDTO dto) throws Exception {
        boolean update = dao.update(new Student(
                dto.getReg_no(),
                dto.getFull_name(),
                dto.getFull_name(),
                dto.getAddress(),
                dto.getDob(),
                dto.getNic(),
                dto.getNic(),
                dto.getDoa(),
                dto.getGrade()));
        if (update){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated").showAndWait();
        }else{
            new Alert(Alert.AlertType.CONFIRMATION,"Not Updated").showAndWait();
        }
    }

    @Override
    public boolean deleteRegistration(String id) throws Exception {
        boolean delete = dao.delete(id);

        if (delete){
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted").showAndWait();
        }else{
            new Alert(Alert.AlertType.CONFIRMATION,"Not Deleted").showAndWait();
        }
        return delete;
    }

    @Override
    public StudentDTO getRegistration(String id) throws Exception {
        Student c = dao.get(id);
        return new StudentDTO(
                c.getReg_no(),
                c.getFull_name(),
                c.getName_with_initials(),
                c.getAddress(),
                c.getDob(),
                c.getNic(),
                c.getDoa(),
                c.getGrade());

    }

    @Override
    public ArrayList<StudentDTO> getAllRegistration() throws Exception {
        List<Student> list = dao.getAll();
        ArrayList<StudentDTO> arrayList = new ArrayList<>();
        for (Student c : list) {
            arrayList.add(new StudentDTO(
                    c.getReg_no(),
                    c.getFull_name(),
                    c.getName_with_initials(),
                    c.getAddress(),
                    c.getDob(),
                    c.getNic(),
                    c.getDoa(),
                    c.getGrade()));
        }
        return arrayList;
    }

    @Override
    public String getId() throws Exception {
        return null;
    }
}
