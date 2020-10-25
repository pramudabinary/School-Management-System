package entity;

import dto.AdminDTO;
import dto.SubjectDTO;

public class Subject implements SuperEntity {
    private String id;
    private String sub_name;
    private String teacher;

    public Subject() {
    }

    public Subject(String id, String sub_name, String teacher) {
        this.id = id;
        this.sub_name = sub_name;
        this.teacher = teacher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
