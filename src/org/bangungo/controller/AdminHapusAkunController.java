/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bangungo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.bangungo.dao.LoginDao;
import org.bangungo.dao.UserDao;
import org.bangungo.dao.impl.LoginDaoImplHibernate;
import org.bangungo.dao.impl.UserDaoImplHibernate;
import org.bangungo.model.Admin;
import org.bangungo.model.Login;
import org.bangungo.model.Material;
import org.bangungo.model.User;

/**
 * FXML Controller class
 *
 * @author Sandro Y M Nababan
 */
public class AdminHapusAkunController implements Initializable {

    @FXML
    private TableView<User> userTV;
    @FXML
    private TableColumn<User, String> userNameTC;
    @FXML
    private TableColumn<User, String> namaTC;
    @FXML
    private TableColumn<User, String> alamatTC;

    ObservableList<User> data;
    UserDao userDao;
    LoginDao loginDao;
    @FXML
    private TextField userNameTF;

    public AdminHapusAkunController() {
        userDao = new UserDaoImplHibernate();
        loginDao = new LoginDaoImplHibernate();
    }

    /**
     * Initializes the controller class.
     */
    public void loadData() {
        List<User> user = userDao.getAllUser();

        for (User u : user) {
            System.out.println("id user" + u.getUserName());
        }

        data = FXCollections.observableArrayList(user);
        userNameTC.setCellValueFactory(new PropertyValueFactory<User, String>("userName"));
        namaTC.setCellValueFactory(new PropertyValueFactory<User, String>("namaUser"));
        alamatTC.setCellValueFactory(new PropertyValueFactory<User, String>("alamat"));

        userTV.setItems(data);

        userTV.setOnMouseClicked((MouseEvent me) -> {
            if (me.getClickCount() >= 1) {
                String userName = userTV.getItems().get(userTV.getSelectionModel().getSelectedIndex()).getUserName();
                userNameTF.setText(userName);
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadData();
    }

    @FXML
    private void hapusAkunB(ActionEvent event) {
    }///gak usahhhhh

    @FXML
    private void keluhanB(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/bangungo/view/AdminBalasKeluhan.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.getIcons().add(new Image("Actions-go-home-icon.png"));
        stage.setTitle("Admin - Keluhan");
        stage.show();
    }

    @FXML
    private void logOutB(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/bangungo/view/Login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.getIcons().add(new Image("Actions-go-home-icon.png"));
        stage.setTitle("Login akun");
        stage.show();
    }

    @FXML
    private void CRUDMaterialB(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/bangungo/view/AdminCRUDMaterial.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.getIcons().add(new Image("Actions-go-home-icon.png"));
        stage.setTitle("Admin - CRUD");
        stage.show();
    }

    @FXML
    private void hapusB(ActionEvent event) {
        String userName = userTV.getItems().get(userTV.getSelectionModel().getSelectedIndex()).getUserName();
        User u = new User(userName);
        Login l = new Login(userName);

        userDao.deleteUser(u);
        loginDao.deleteLog(l, 0);

        refreshTable();
        clearText();
        JOptionPane.showMessageDialog(null, "Berhasil delete user");

    }

    void refreshTable() {
        final List<User> users = userTV.getItems();
        if (users == null || users.size() == 0) {
            return;
        }

        final User user = userTV.getItems().get(0);
        users.remove(0);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                users.add(0, user);
            }
        });
        loadData();
    }

    private void clearText() {
        userNameTF.setText(null);
    }

}
