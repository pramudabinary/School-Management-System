package controller;

import bo.BoFactory;
import bo.custom.AdminBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dto.AdminDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.AdminTM;

import java.util.ArrayList;

import static sun.net.www.MimeTable.loadTable;

public class AdminFormController {
    public JFXButton btnAdd;
    public JFXButton btnDelete;
    public JFXButton btnUpdate;
    public TableView tblAdmin;
    public TableColumn tblId;
    public TableColumn tblName;
    public TableColumn tblUserName;
    public TableColumn tblPassword;
    public JFXTextField txtID;
    public JFXTextField txtName;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    AdminBO bo = BoFactory.getInstance().getBo(BoFactory.BOType.ADMIN);

    public void addOnAction(ActionEvent actionEvent) throws Exception {
        bo.saveAdmin(new AdminDTO(txtID.getText(),txtName.getText(),txtUserName.getText(),txtPassword.getText()));
    }

    public void deleteOnAction(ActionEvent actionEvent) throws Exception {
        bo.deleteAdmin(txtID.getText());
    }

    public void updateOnAction(ActionEvent actionEvent) throws Exception {
        bo.updateAdmin(new AdminDTO(txtID.getText(),txtName.getText(),txtUserName.getText(),txtPassword.getText()));
    }

    public void backOnAction(ActionEvent actionEvent) {
    }

    public void initialize(){
        tblId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblUserName.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        tblPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        loadTable();
    }
    ObservableList<AdminDTO> list=FXCollections.observableArrayList();

    void loadTable(){
        try {
            ArrayList<AdminDTO> arrayList = bo.getAllAdmins();
            for (AdminDTO dto : arrayList){
                AdminTM tm = new AdminTM(
                        dto.getId(),
                        dto.getName(),
                        dto.getUser_name(),
                        dto.getPassword());
                list.add(tm);
            }
            tblAdmin.setItems(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }
}
