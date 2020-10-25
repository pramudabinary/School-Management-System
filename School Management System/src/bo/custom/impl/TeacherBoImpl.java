package bo.custom.impl;

import bo.custom.TeacherBO;
import dao.DaoFactory;
import dao.QueryDAO;
import dao.custom.TeacherDAO;
import dto.TeacherDTO;
import entity.Teacher;

import java.util.ArrayList;
import java.util.List;


public class TeacherBoImpl implements TeacherBO {
    private TeacherDAO dao= DaoFactory.getInstance()
            .getDao(DaoFactory.DAOType.TEACHER);
    private QueryDAO qDao= DaoFactory.getInstance()
            .getDao(DaoFactory.DAOType.QUERY);
    @Override
    public boolean saveRegistration(TeacherDTO dto) throws Exception {
       return dao.save(new Teacher(dto.getReg_no(),
                dto.getFull_name(),
                dto.getName_with_initials(),
                dto.getAddress(),
                dto.getDob(),
                dto.getNic(),
                dto.getTclass(),
                dto.getSubject()));
    }

    @Override
    public void updateRegistration(TeacherDTO dto) throws Exception {
          dao.update(new Teacher(
                  dto.getReg_no(),
                  dto.getFull_name(),
                  dto.getName_with_initials(),
                  dto.getAddress(),
                  dto.getDob(),
                  dto.getNic(),
                  dto.getTclass(),
                  dto.getSubject()));
    }

    @Override
    public boolean deleteRegistration(String id) throws Exception {
       return dao.delete(id);
    }


    @Override
    public TeacherDTO getRegistration(String id) throws Exception {
        Teacher ted = dao.get(id);
        return new TeacherDTO(ted.getReg_no(),
                ted.getFull_name(),
                ted.getName_with_initials(),
                ted.getAddress(),
                ted.getDob(),
                ted.getNic(),
                ted.getTclass(),
                ted.getSubject());
    }

    @Override
    public ArrayList<TeacherDTO> getAllRegistration() throws Exception {
        List<Teacher> list = dao.getAll();
        ArrayList<TeacherDTO> arrayList = new ArrayList<>();

        for (Teacher t : list){
            arrayList.add(new TeacherDTO(
                    t.getReg_no(),
                    t.getFull_name(),
                    t.getName_with_initials(),
                    t.getAddress(),
                    t.getDob(),
                    t.getNic(),
                    t.getTclass(),
                    t.getSubject()));
        }
        return arrayList;
    }
}
