package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainFormController {
    public AnchorPane root;


    public void initialize() throws IOException {
        initUi("DefaultForm.fxml");
    }

    private void initUi(String location) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/" + location)));
    }
    public void InfoOnAction(ActionEvent actionEvent) throws IOException {
        initUi("SInformationForm.fxml");
    }

    public void studentMOnAction(ActionEvent actionEvent) throws IOException {
        initUi("StudentManagementForm.fxml");
    }


    public void staffManagementOnAction(ActionEvent actionEvent) throws IOException {
        initUi("StaffManagementForm.fxml");
    }

    public void subjectsOnAction(ActionEvent actionEvent) throws IOException {
        initUi("SubjectForm.fxml");
    }

    public void AttendanceOnAction(ActionEvent actionEvent) throws IOException {
        initUi("AttendanceForm.fxml");
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


    public void homeOnAction(ActionEvent actionEvent) throws IOException {
        initUi("DefaultForm.fxml");
    }

    public void adminOnAction(ActionEvent actionEvent) throws IOException {
        initUi("AdminForm.fxml");
    }


    public void aminOnAction(ActionEvent actionEvent) {
    }
}
