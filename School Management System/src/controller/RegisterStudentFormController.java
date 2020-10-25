package controller;

import bo.BoFactory;
import bo.custom.StudentBO;
import bo.custom.TeacherBO;
import bo.custom.impl.StudentBoImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.scene.paint.Paint;

import java.util.regex.Pattern;

public class RegisterStudentFormController {
    StudentBO bo = BoFactory.getInstance().getBo(BoFactory.BOType.STUDENT);

    public JFXTextField txtSRegNo;
    public JFXTextField txtFullName;
    public JFXTextField txtNameIni;
    public JFXTextField txtAddress;
    public JFXTextField txtDOB;
    public JFXComboBox txtGrade;
    public JFXButton btnSRegister;
    public JFXTextField txtNic;
    public JFXTextField txtDOA;




    public void sRegisterOnAction(ActionEvent actionEvent) throws Exception {

        if(Pattern.compile("^(S0)[0-9]{1,3}$").matcher(txtSRegNo.getText()).matches()) {
            if(Pattern.compile("^[A-z ]{1,15}[A-z ]{1,15}$").matcher(txtFullName.getText()).matches()) {
                if (Pattern.compile("^[A-Z ]{1,15}[A-z ]{1,15}[A-z]{1,15}$").matcher(txtNameIni.getText()).matches()) {
                    if (Pattern.compile("^[A-z ]{1,9}[A-z ]{1,9}[A-z]{1,9}$").matcher(txtAddress.getText()).matches()){
                        if (Pattern.compile("^(20)[0-9]{2}[-][0-9]{2}[-][0-9]{2}$").matcher(txtDOB.getText()).matches()){
                            if (Pattern.compile("^[0-9]{1,12}$").matcher(txtNic.getText()).matches()){
                                if (Pattern.compile("^(20)[0-9]{2}[-][0-9]{2}[-][0-9]{2}$").matcher(txtDOA.getText()).matches()){
                                    bo.saveRegistration(new StudentDTO(
                                            txtSRegNo.getText(),
                                            txtFullName.getText(),
                                            txtNameIni.getText(),
                                            txtAddress.getText(),
                                            txtDOB.getText(),
                                            txtNic.getText(),
                                            txtDOA.getText(),
                                            txtGrade.getValue().toString()));
                                }else{
                                txtDOA.setFocusColor(Paint.valueOf("red"));
                                txtDOA.requestFocus();
                            }
                            }else{
                                txtNic.setFocusColor(Paint.valueOf("red"));
                                txtNic.requestFocus();
                            }
                        }else{
                            txtDOB.setFocusColor(Paint.valueOf("red"));
                            txtDOB.requestFocus();
                        }
                        }else {
                        txtAddress.setFocusColor(Paint.valueOf("red"));
                        txtAddress.requestFocus();
                    }
                }else{txtNameIni.setFocusColor(Paint.valueOf("red"));
                    txtNameIni.requestFocus();}
            }else{
                txtFullName.setFocusColor(Paint.valueOf("red"));
                txtFullName.requestFocus();
            }
        }else{
            txtSRegNo.setFocusColor(Paint.valueOf("red"));
            txtSRegNo.requestFocus();



        }
    }
}
