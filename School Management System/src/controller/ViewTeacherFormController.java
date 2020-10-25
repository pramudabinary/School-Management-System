package controller;

import bo.BoFactory;
import bo.custom.TeacherBO;
import dto.TeacherDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.TeacherTM;

import java.util.ArrayList;

public class ViewTeacherFormController {
    public TableView tblTeacher;
    public TableColumn tblReg_No;
    public TableColumn tblFull_Name;
    public TableColumn tblName_With_Initials;
    public TableColumn tblAddress;
    public TableColumn tblDob;
    public TableColumn tblNic;
    public TableColumn tblClass;
    public TableColumn tblSubject;
    TeacherBO bo = BoFactory.getInstance().getBo(BoFactory.BOType.TEACHER);

    public void initialize(){
        tblReg_No.setCellValueFactory(new PropertyValueFactory<>("reg_no"));
        tblFull_Name.setCellValueFactory(new PropertyValueFactory<>("full_name"));
        tblName_With_Initials.setCellValueFactory(new PropertyValueFactory<>("initial_with_name"));
        tblAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tblDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblClass.setCellValueFactory(new PropertyValueFactory<>("classt"));
        tblSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        loadTable();
    }
    ObservableList<TeacherTM> list = FXCollections.observableArrayList();

    void loadTable(){
        try {
            ArrayList<TeacherDTO>  dtoList = bo.getAllRegistration();
            for (TeacherDTO dto : dtoList){
                TeacherTM tm = new TeacherTM(
                        dto.getReg_no(),
                        dto.getFull_name(),
                        dto.getName_with_initials(),
                        dto.getAddress(),
                        dto.getDob(),
                        dto.getNic(),
                        dto.getTclass(),
                        dto.getSubject());
                list.add(tm);
        }
            tblTeacher.setItems(list);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
