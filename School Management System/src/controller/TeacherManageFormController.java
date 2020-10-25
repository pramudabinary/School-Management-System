package controller;

import bo.BoFactory;
import bo.custom.StudentBO;
import bo.custom.TeacherBO;
import bo.custom.impl.TeacherBoImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import dto.StudentDTO;
import dto.TeacherDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.batik.svggen.SVGFont;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TeacherManageFormController {
    TeacherBO bo = BoFactory.getInstance().getBo(BoFactory.BOType.TEACHER);
    public JFXTextField txtFullName;
    public JFXTextField txtNameIni;
    public JFXTextField txtAddress;
    public JFXTextField txtDob;
    public JFXComboBox txtSubject;
    public JFXTextField txtNic;
    public JFXTextField txtClass;
    public JFXTextField txtRegNo;

    public void searchOnAction(ActionEvent actionEvent) throws Exception {
        TeacherDTO dto = bo.getRegistration(txtRegNo.getText());
        if (dto != null) {
            txtRegNo.setText(dto.getReg_no());
            txtFullName.setText(dto.getFull_name());
            txtNameIni.setText(dto.getName_with_initials());
            txtAddress.setText(dto.getAddress());
            txtDob.setText(dto.getDob());
            txtNic.setText(dto.getNic());
            txtClass.setText(dto.getTclass());
            txtSubject.setValue(dto.getSubject());
        }
    }

    public void updateOnAction(ActionEvent actionEvent) throws Exception {
        bo.updateRegistration(new TeacherDTO(
                txtRegNo.getText(),
                txtFullName.getText(),
                txtNameIni.getText(),
                txtAddress.getText(),
                txtDob.getText(),
                txtNic.getText(),
                txtClass.getText(),
                txtSubject.getValue().toString()));
    }
    public void deleteOnAction(ActionEvent actionEvent) throws Exception {
        boolean b = bo.deleteRegistration(txtRegNo.getText());
        if (b){
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted").showAndWait();
        }else{
            new Alert(Alert.AlertType.CONFIRMATION,"Not Deleted").showAndWait();
        }
    }

    public void viewOnAction(ActionEvent actionEvent) {

    }

    public void printOnAction(ActionEvent actionEvent) throws JRException, SQLException, ClassNotFoundException {
            InputStream resourceAsStream = this.getClass().getResourceAsStream("/report/Teacher.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(resourceAsStream);

            HashMap hashMap = new HashMap();
            hashMap.put("reg_no", txtRegNo.getText());
            hashMap.put("full_name", txtFullName.getText());
            hashMap.put("name_with_initials", txtNameIni.getText());
            hashMap.put("address", txtAddress.getText());
            hashMap.put("Dob", txtDob.getText());
            hashMap.put("nic", txtNic.getText());
            hashMap.put("class", txtClass.getText());
            hashMap.put("subject", txtSubject.getValue().toString());

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,hashMap, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
    }
}
