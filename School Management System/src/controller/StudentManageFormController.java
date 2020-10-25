package controller;

import bo.BoFactory;
import bo.custom.StudentBO;
import bo.custom.impl.StudentBoImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.custom.Impl.StudentDAOImpl;
import db.DBConnection;
import dto.StudentDTO;
import entity.Student;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.hssf.record.formula.functions.T;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class StudentManageFormController {
    public JFXTextField txtFullName;
    public JFXTextField txtNameIni;
    public JFXTextField txtAddress;
    public JFXTextField txtDOB;
    public JFXComboBox txtGrade;
    public JFXTextField txtNic;
    public JFXTextField txtDOA;
    public JFXTextField txtRegNo;
    public JFXButton btnSearch;
    public JFXButton btnUpdate;
    StudentBO bo = BoFactory.getInstance().getBo(BoFactory.BOType.STUDENT);

    public void printOnAction(ActionEvent actionEvent)  {

        try {
            InputStream resourceAsStream = this.getClass().getResourceAsStream("/report/student.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(resourceAsStream);

            HashMap hashMap = new HashMap();
            hashMap.put("reg_no",txtRegNo.getText());
            hashMap.put("full_name",txtFullName.getText());
            hashMap.put("name_with_initials",txtNameIni.getText());
            hashMap.put("address",txtAddress.getText());
            hashMap.put("dob",txtDOB.getText());
            hashMap.put("nic",txtNic.getText());
            hashMap.put("doa",txtDOA.getText());
            hashMap.put("grade",txtGrade.getValue().toString());



        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,hashMap, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    public void deleteOnAction(ActionEvent actionEvent) throws Exception {
        String id = txtRegNo.getText();
        boolean result = bo.deleteRegistration(id);
        if(result){
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted").showAndWait();
        }else{
            new Alert(Alert.AlertType.CONFIRMATION,"Not Deleted").showAndWait();
        }
    }

    public void UpdateOnAction(ActionEvent actionEvent) throws Exception {
                bo.updateRegistration(new StudentDTO(
                txtRegNo.getText(),
                txtFullName.getText(),
                txtNameIni.getText(),
                txtAddress.getText(),
                txtDOB.getText(),
                txtNic.getText(),
                txtDOA.getText(),
                txtGrade.getValue().toString()));

    }


    public void searchOnAction(ActionEvent actionEvent) throws Exception {
            String id = txtRegNo.getText();
            StudentDTO dto = bo.getRegistration(id);
            if (dto != null) {
                txtRegNo.setText(dto.getReg_no());
                txtFullName.setText(dto.getFull_name());
                txtNameIni.setText(dto.getName_with_initials());
                txtAddress.setText(dto.getAddress());
                txtDOB.setText(dto.getDob());
                txtNic.setText(dto.getNic());
                txtDOA.setText(dto.getDoa());
                txtGrade.setValue(dto.getGrade().toString());
            }


        }







    public void viewOnAction(ActionEvent actionEvent) {
    }
}