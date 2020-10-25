package view.tm;

public class StudentTM {
    private String reg_no;
    private String full_name;
    private String initial_with_name;
    private String adddress;
    private String dob;
    private String nic;
    private String doa;
    private String grade;

    public StudentTM() {
    }

    public StudentTM(String reg_no, String full_name, String initial_with_name, String adddress, String dob, String nic, String doa, String grade) {
        this.reg_no = reg_no;
        this.full_name = full_name;
        this.initial_with_name = initial_with_name;
        this.adddress = adddress;
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

    public String getInitial_with_name() {
        return initial_with_name;
    }

    public void setInitial_with_name(String initial_with_name) {
        this.initial_with_name = initial_with_name;
    }

    public String getAdddress() {
        return adddress;
    }

    public void setAdddress(String adddress) {
        this.adddress = adddress;
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
}
