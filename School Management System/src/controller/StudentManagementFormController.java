package controller;

import java_cup.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class StudentManagementFormController {
    public AnchorPane root2;
    private void initUi(String location) throws IOException {
        this.root2.getChildren().clear();
        this.root2.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/" + location)));
    }
    public void SRegisterOnAction(ActionEvent actionEvent) throws IOException {
        initUi("RegisterStudentForm.fxml");
    }


    public void SManageOnAction(ActionEvent actionEvent) throws IOException {
        initUi("StudentManageForm.fxml");
    }


    public void sViewOnAction(ActionEvent actionEvent) throws IOException {
        initUi("ViewStudentForm.fxml");
    }

    public void sPrintOnAction(ActionEvent actionEvent) {
    }
}
