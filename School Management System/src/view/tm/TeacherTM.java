package view.tm;

public class TeacherTM {
    private String reg_no;
    private String full_name;
    private String initial_with_name;
    private String address;
    private String dob;
    private String nic;
    private String classt;
    private String subject;

    public TeacherTM() {
    }

    public TeacherTM(String reg_no, String full_name, String initial_with_name, String address, String dob, String nic, String classt, String subject) {
        this.reg_no = reg_no;
        this.full_name = full_name;
        this.initial_with_name = initial_with_name;
        this.address = address;
        this.dob = dob;
        this.nic = nic;
        this.classt = classt;
        this.subject = subject;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getInitial_with_name() {
        return initial_with_name;
    }

    public void setInitial_with_name(String initial_with_name) {
        this.initial_with_name = initial_with_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getClasst() {
        return classt;
    }

    public void setClasst(String classt) {
        this.classt = classt;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
