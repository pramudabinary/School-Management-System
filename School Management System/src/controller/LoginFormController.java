package controller;

import bo.BoFactory;
import bo.custom.AdminBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {

    AdminBO bo = BoFactory.getInstance().getBo(BoFactory.BOType.ADMIN);

    public JFXButton loginbtn;
    public JFXTextField txtxUsername;
    public JFXPasswordField txtpsswd;


    public void LoginOnAction(ActionEvent actionEvent) {

        try {
            String user = txtxUsername.getText();
            String pwd = txtpsswd.getText();

            if (user.length() > 0 && pwd.length() > 0) {

                boolean isSuccess = false;

                isSuccess = bo.adminLogin(user, pwd);

                if (isSuccess) {
                    URL resource = this.getClass().getResource("/view/MainForm.fxml");
                    Parent load = FXMLLoader.load(resource);
                    Scene scene = new Scene(load);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("DashBoard");
                    stage.show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Incorrect User or Password").showAndWait();
                }

            } else {
                new Alert(Alert.AlertType.WARNING, "Please fill the empty fields").showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Something went wrong. Please try again.").showAndWait();
        }
    }
}
