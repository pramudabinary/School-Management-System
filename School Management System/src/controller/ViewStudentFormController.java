package controller;

import bo.BoFactory;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import dao.CrudUtil;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.StudentTM;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ViewStudentFormController {

    public TableView<StudentTM> tblStudent;
    public TableColumn tblReg_No;
    public TableColumn tblFull_Name;
    public TableColumn tblName_With_Initials;
    public TableColumn tblAddress;
    public TableColumn tblDob;
    public TableColumn tblNic;
    public TableColumn tblDoa;
    public TableColumn tblGrade;
    StudentBO bo = BoFactory.getInstance().getBo(BoFactory.BOType.STUDENT);

    public void initialize() {
        tblReg_No.setCellValueFactory(new PropertyValueFactory<>("reg_no"));
        tblFull_Name.setCellValueFactory(new PropertyValueFactory<>("full_name"));
        tblName_With_Initials.setCellValueFactory(new PropertyValueFactory<>("initial_with_name"));
        tblAddress.setCellValueFactory(new PropertyValueFactory<>("adddress"));
        tblDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblDoa.setCellValueFactory(new PropertyValueFactory<>("doa"));
        tblGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        loadTable();
    }
    ObservableList<StudentTM> list = FXCollections.observableArrayList();

    void loadTable() {
        try {
            List<StudentDTO> dtoList = bo.getAllRegistration();

            for (StudentDTO dto : dtoList) {
                StudentTM tm = new StudentTM(dto.getReg_no(), dto.getFull_name(), dto.getName_with_initials(), dto.getAddress(), dto.getDob(), dto.getNic(), dto.getDoa(), dto.getGrade());
                list.add(tm);
            }
            tblStudent.setItems(list);

        } catch (NullPointerException e){} catch (Exception e) {
            e.printStackTrace();
        }

    }

}


