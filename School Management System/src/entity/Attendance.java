package entity;

public class Attendance implements SuperEntity {
    private String reg_no;
    private String date;

    public Attendance() {
    }

    public Attendance(String reg_no, String date) {
        this.reg_no = reg_no;
        this.date = date;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "reg_no='" + reg_no + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
