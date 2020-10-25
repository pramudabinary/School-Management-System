package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class StaffManagementFormController {

    public AnchorPane root3;
    public JFXButton btnTRegister;
    public JFXButton btnTManage;
    public JFXButton btnTView;
    public JFXButton btnTPrint;

    private void initUi(String location) throws IOException {
        this.root3.getChildren().clear();
        this.root3.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/" + location)));
    }

    public void sRegisterOnAction(ActionEvent actionEvent) throws IOException {
        initUi("RegisterTeacherForm.fxml");
    }

    public void tManageOnAction(ActionEvent actionEvent) throws IOException {
        initUi("TeacherManageForm.fxml");
    }

    public void tViewOnAction(ActionEvent actionEvent) throws IOException {
        initUi("ViewTeacherForm.fxml");
    }

    public void tPrintOnAction(ActionEvent actionEvent) {
    }
}
