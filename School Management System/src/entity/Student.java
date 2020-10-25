package entity;

public class Student implements SuperEntity {
    private String reg_no;
    private String full_name;
    private String name_with_initials;
    private String address;
    private String dob;
    private String nic;
    private String doa;
    private String grade;

    public Student(String reg_no, String full_name, String fullName, String address, String dob, String nic, String dtoNic, String doa, String grade) {
    }

    public Student(String reg_no, String full_name, String name_with_initials, String address, String dob, String nic, String doa, String grade) {
        this.reg_no = reg_no;
        this.full_name = full_name;
        this.name_with_initials = name_with_initials;
        this.address = address;
        this.dob = dob;
        this.nic = nic;
        this.doa = doa;
        this.grade = grade;
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

    public String getDoa() {
        return doa;
    }

    public void setDoa(String doa) {
        this.doa = doa;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "reg_no='" + reg_no + '\'' +
                ", full_name='" + full_name + '\'' +
                ", name_with_initials='" + name_with_initials + '\'' +
                ", address='" + address + '\'' +
                ", dob='" + dob + '\'' +
                ", nic='" + nic + '\'' +
                ", doa='" + doa + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
