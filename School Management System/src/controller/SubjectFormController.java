package controller;

import bo.BoFactory;
import bo.custom.SubjectBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.SubjectDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.SubjectTM;
import java.util.ArrayList;

public class SubjectFormController {
    public JFXTextField txtID;
    public JFXTextField txtSubName;
    public JFXButton btnAdd;
    public TableView tableSubject;
    public TableColumn tblSubject_Name;
    public TableColumn tblId;
    public TableColumn tblTeacher;
    public JFXTextField txtTeacherName1;
    SubjectBO bo = BoFactory.getInstance().getBo(BoFactory.BOType.SUBJECT);

    public void addOnAction(ActionEvent actionEvent) {
        try {
            bo.saveSubject(new SubjectDTO(txtID.getText(),txtSubName.getText(),txtTeacherName1.getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        try {
            bo.deleteSubject(txtID.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        try {
            bo.updateSubject(new SubjectDTO(txtID.getText(),txtSubName.getText(),txtTeacherName1.getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchOnAction(ActionEvent actionEvent) {
        try {
            bo.getSubject(txtID.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void initialize() {
        tblId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblSubject_Name.setCellValueFactory(new PropertyValueFactory<>("subject_name"));
        tblTeacher.setCellValueFactory(new PropertyValueFactory<>("teacher"));
        loadTable();
    }
    ObservableList<SubjectDTO> list= FXCollections.observableArrayList();

    void loadTable(){
        try {
            ArrayList<SubjectDTO> arrayList = bo.getAllSubject();
            for (SubjectDTO dto : arrayList){
                SubjectTM tm = new SubjectTM(dto.getId(),dto.getSub_name(),dto.getTeacher());
                list.add(tm);
            }
            tableSubject.setItems(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
