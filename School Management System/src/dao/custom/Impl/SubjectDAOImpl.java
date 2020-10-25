package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.SubjectDAO;
import entity.Subject;

import java.sql.ResultSet;
import java.util.List;

public class SubjectDAOImpl implements SubjectDAO {
    @Override
    public boolean save(Subject subject) throws Exception {
        return CrudUtil.execute("Insert into subject values(?,?,?)", subject.getId(),subject.getSub_name(),subject.getTeacher());
    }

    @Override
    public boolean update(Subject subject) throws Exception {
        return CrudUtil.execute("UPDATE subject SET subject_name=?,subject_teacher=? WHERE sub_id=?",subject.getSub_name(),subject.getTeacher(),subject.getId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.execute("Delete from subject where sub_id?",id);
    }

    @Override
    public Subject get(String id) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM tregister WHERE reg_no=?", id);
        if (resultSet.next()){
           return new Subject(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3));
        }else{
            return null;
        }
    }

    @Override
    public List<Subject> getAll() throws Exception {
        return null;
    }
}
