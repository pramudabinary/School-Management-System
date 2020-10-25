package dao;

import dao.custom.Impl.*;

public class DaoFactory {
    private static DaoFactory daoFactory;


    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return (daoFactory == null) ?
                (daoFactory = new DaoFactory()) : (daoFactory);
    }

    public enum DAOType {
        SINFORMATION, STUDENT, TEACHER, SUBJECT, ADMIN, QUERY
    }



    public <T> T getDao(DAOType type) {
        switch (type) {
            case SINFORMATION:
                return (T) new SInformationDAOImpl();
            case STUDENT:
                return (T) new StudentDAOImpl();
            case TEACHER:
                return (T) new TeacherDAOImpl();
            case SUBJECT:
                return (T) new SubjectDAOImpl();
            case ADMIN:
                return (T) new AdminDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            default:
                return null;
        }
    }
}
