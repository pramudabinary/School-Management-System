package controller;

import bo.BoFactory;
import bo.custom.SInformationBO;
import bo.custom.StudentBO;
import bo.custom.impl.SInformationBoImpl;
import com.jfoenix.controls.JFXTextField;
import dto.SInformationDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.sql.SQLException;

public class SInformationFormController {


    public JFXTextField txtNameOfSchool;
    public JFXTextField txtAddressSchool;
    public JFXTextField txtZone;
    public JFXTextField txtAdDistrict;
    public JFXTextField txtProvinceSchool;
    public JFXTextField txtPrincipleName;
    public JFXTextField txtPrincipleC;
    SInformationBO bo = BoFactory.getInstance().getBo(BoFactory.BOType.SINFORMATION);

    public void search() throws SQLException, ClassNotFoundException {

    }

    public boolean updateOnAction(ActionEvent actionEvent) throws Exception {
       return bo.updateInformation(new SInformationDTO(
                txtNameOfSchool.getText(),
                txtAddressSchool.getText(),
                txtZone.getText(),
                txtAdDistrict.getText(),
                txtProvinceSchool.getText(),
                txtPrincipleName.getText(),
                txtPrincipleC.getText()));

    }

    public void printOnAction(ActionEvent actionEvent) {
    }
}
