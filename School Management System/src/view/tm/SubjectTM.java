package view.tm;

import dto.SubjectDTO;

public class SubjectTM extends SubjectDTO {
    private String id;
    private String subject_name;
    private String teacher;

    public SubjectTM() {
    }

    public SubjectTM(String id, String subject_name, String teacher) {
        this.id = id;
        this.subject_name = subject_name;
        this.teacher = teacher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
