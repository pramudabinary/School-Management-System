package dao.custom.Impl;

import com.sun.xml.internal.ws.addressing.WsaTubeHelper;
import dao.CrudUtil;
import dao.custom.StudentDAO;
import dto.StudentDTO;
import entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean save(Student student) throws Exception {
        return CrudUtil.execute
                ("INSERT INTO sregister VALUES(?,?,?,?,?,?,?,?)",
                        student.getReg_no(),
                        student.getFull_name(),
                        student.getName_with_initials(),
                        student.getAddress(),
                        student.getDob(),
                        student.getNic(),
                        student.getDoa(),
                        student.getGrade());
    }

    @Override
    public boolean update(Student student) throws Exception {
        return CrudUtil.execute("UPDATE sregister SET full_name=?,name_with_initials=?,address=?,dob=?,nic=?,doa=?,grade=? WHERE reg_no=?",
                student.getFull_name(),
                student.getName_with_initials(),
                student.getAddress(),
                student.getDob(),
                student.getNic(),
                student.getDoa(),
                student.getGrade(),
                student.getReg_no());

    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.execute("DELETE FROM sregister WHERE reg_no=?",id);

    }

    @Override
    public Student get(String id) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM sregister WHERE reg_no=?",id);
        if (resultSet.next()) {
            return new Student(
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
    public List<Student> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM sregister");
        ArrayList<Student> list = new ArrayList();
        while (resultSet.next()) {
            list.add(
                    new Student(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8)));
        }
        System.out.println("dao "+list.toString());
        return list;
    }
}


