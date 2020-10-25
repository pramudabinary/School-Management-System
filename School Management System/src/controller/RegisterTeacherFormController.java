package controller;

import bo.BoFactory;
import bo.custom.StudentBO;
import bo.custom.TeacherBO;
import bo.custom.impl.TeacherBoImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import dto.StudentDTO;
import dto.TeacherDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Paint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class RegisterTeacherFormController {
    TeacherBO bo = BoFactory.getInstance().getBo(BoFactory.BOType.TEACHER);

    public JFXTextField txtClass;
    @FXML
    private JFXTextField txtRegNo;

    @FXML
    private JFXTextField txtFullName;

    @FXML
    private JFXTextField txtNameIni;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtDob;

    @FXML
    private JFXButton btnRegister;

    @FXML
    private JFXTextField txtNic;

    @FXML
    private JFXTextField txtDoa;

    @FXML
    private JFXComboBox<?> txtSubject;


    public void tRegisterOnAction(ActionEvent actionEvent) throws Exception {
        if (Pattern.compile("^(T0)[0-9]{1,3}$").matcher(txtRegNo.getText()).matches()) {
            if (Pattern.compile("^[A-z ]{1,15}[A-z ]{1,15}$").matcher(txtFullName.getText()).matches()) {
                if (Pattern.compile("^[A-Z ]{1,15}[A-z ]{1,15}[A-z]{1,15}$").matcher(txtNameIni.getText()).matches()) {
                    if (Pattern.compile("^[A-z ]{1,9}[A-z ]{1,9}[A-z]{1,9}$").matcher(txtAddress.getText()).matches()) {
                        if (Pattern.compile("^(19)[0-9]{2}[-][0-9]{2}[-][0-9]{2}$").matcher(txtDob.getText()).matches()) {
                            if (Pattern.compile("^[0-9]{1,12}$").matcher(txtNic.getText()).matches()) {
                                if (Pattern.compile("^[1-13]{1,2}[A-Z]{1}$").matcher(txtClass.getText()).matches()) {
                                    bo.saveRegistration(new TeacherDTO(
                                            txtRegNo.getText(),
                                            txtFullName.getText(),
                                            txtNameIni.getText(),
                                            txtAddress.getText(),
                                            txtDob.getText(),
                                            txtNic.getText(),
                                            txtClass.getText(),
                                            txtSubject.getValue().toString()));
                                } else {
                                    txtClass.setFocusColor(Paint.valueOf("red"));
                                    txtClass.requestFocus();
                                }
                            } else {
                                txtNic.setFocusColor(Paint.valueOf("red"));
                                txtNic.requestFocus();
                            }
                        } else {
                            txtDob.setFocusColor(Paint.valueOf("red"));
                            txtDob.requestFocus();
                        }
                    } else {
                        txtAddress.setFocusColor(Paint.valueOf("red"));
                        txtAddress.requestFocus();
                    }
                } else {
                    txtNameIni.setFocusColor(Paint.valueOf("red"));
                    txtNameIni.requestFocus();
                }
            } else {
                txtFullName.setFocusColor(Paint.valueOf("red"));
                txtFullName.requestFocus();
            }
        } else {
            txtRegNo.setFocusColor(Paint.valueOf("red"));
            txtRegNo.requestFocus();


        }
    }
}
