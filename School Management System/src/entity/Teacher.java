package entity;

public class Teacher implements SuperEntity {
    private String reg_no;
    private String full_name;
    private String name_with_initials;
    private String address;
    private String dob;
    private String nic;
    private String tclass;
    private String subject;

    public Teacher(String string) {
    }

    public Teacher(String reg_no, String full_name, String name_with_initials, String address, String dob, String nic, String tclass, String subject) {
        this.reg_no = reg_no;
        this.full_name = full_name;
        this.name_with_initials = name_with_initials;
        this.address = address;
        this.dob = dob;
        this.nic = nic;
        this.tclass = tclass;
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

    public String getName_with_initials() {
        return name_with_initials;
    }

    public void setName_with_initials(String name_with_initials) {
        this.name_with_initials = name_with_initials;
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

    public String getTclass() {
        return tclass;
    }

    public void setTclass(String tclass) {
        this.tclass = tclass;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
