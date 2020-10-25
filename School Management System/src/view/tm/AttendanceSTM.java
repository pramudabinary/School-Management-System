package view.tm;

public class AttendanceSTM {
    private String sreg_no;
    private String sdate;

    public AttendanceSTM() {
    }

    public AttendanceSTM(String sreg_no, String sdate) {
        this.sreg_no = sreg_no;
        this.sdate = sdate;
    }

    public String getSreg_no() {
        return sreg_no;
    }

    public void setSreg_no(String sreg_no) {
        this.sreg_no = sreg_no;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }
}
