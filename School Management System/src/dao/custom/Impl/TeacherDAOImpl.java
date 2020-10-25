package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.TeacherDAO;
import entity.Student;
import entity.Teacher;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAOImpl implements TeacherDAO {
    @Override
    public boolean save(Teacher teacher) throws Exception {
        return CrudUtil.execute("Insert into tregister values(?,?,?,?,?,?,?,?)",
                teacher.getReg_no(),
                teacher.getFull_name(),
                teacher.getName_with_initials(),
                teacher.getAddress(),
                teacher.getDob(),
                teacher.getNic(),
                teacher.getTclass(),
                teacher.getSubject());
    }

    @Override
    public boolean update(Teacher teacher) throws Exception {
        return CrudUtil.execute("UPDATE tregister SET full_name=?,name_with_initials=?,address=?,dob=?,nic=?,class=?,subject=? WHERE reg_no=?",
                teacher.getFull_name(),
                teacher.getName_with_initials(),
                teacher.getAddress(),
                teacher.getDob(),
                teacher.getNic(),
                teacher.getTclass(),
                teacher.getSubject(),
                teacher.getReg_no());
    }


    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.execute("Delete from tregister where reg_no=?",id);
    }

    @Override
    public Teacher get(String id) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM tregister WHERE reg_no=?",id);
        if (resultSet.next()) {
            return new Teacher(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8));

        } else {
            return null;
        }
    }

    @Override
    public List<Teacher> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM tregister");
        ArrayList<Teacher> arrayList = new ArrayList<>();
        while (resultSet.next()){
            arrayList.add(
                    new Teacher(
            resultSet.getString(1),
            resultSet.getString(2),
            resultSet.getString(3),
            resultSet.getString(4),
            resultSet.getString(5),
            resultSet.getString(6),
            resultSet.getString(7),
            resultSet.getString(8)));
        }
        return arrayList;
    }
}
