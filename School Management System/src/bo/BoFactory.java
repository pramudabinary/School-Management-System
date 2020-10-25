package bo;

import bo.custom.impl.*;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {
    }

    public static BoFactory getInstance() {
        return (boFactory == null) ?
                (boFactory = new BoFactory()) : (boFactory);
    }
    public enum BOType {
        SINFORMATION, STUDENT, TEACHER, SUBJECT,ADMIN
    }

    public <T> T getBo(BOType type) {
        switch (type) {
            case SINFORMATION:
                return (T) new SInformationBoImpl();
            case STUDENT:
                return (T) new StudentBoImpl();
            case TEACHER:
                return (T) new TeacherBoImpl();
            case SUBJECT:
                return (T) new SubjectBoImpl();
            case ADMIN:
                return (T) new AdminBoImpl();
            default:
                return null;
        }
    }
}