/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bangungo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sandro Y M Nababan
 */
public class UserUbahProfilController implements Initializable {

    @FXML
    private TextField noTelpTF;
    @FXML
    private TextField alamatTF;
    @FXML
    private TextField namaTF;
    @FXML
    private DatePicker datePickerDP;
    @FXML
    private ComboBox<?> jenisKelaminTF;
    @FXML
    private PasswordField passwordTF;
    @FXML
    private TextField emailTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    



    @FXML
    private void jenisKelaminAction(ActionEvent event) {
    }

    @FXML
    private void ubahFotoProfil(ActionEvent event) {
    }

    @FXML
    private void simpanB(ActionEvent event) {
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
    private void beliBarangB(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/bangungo/view/UserBeliBarang.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.getIcons().add(new Image("Actions-go-home-icon.png"));
        stage.setTitle("User - Beli Barang");
        stage.show();
    }
    
    @FXML
    private void keluhanB(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/bangungo/view/Userkomentar.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.getIcons().add(new Image("Actions-go-home-icon.png"));
        stage.setTitle("User - Keluhan");
        stage.show();
    }

    @FXML
    private void ubahProfilB(ActionEvent event) throws IOException {
//        ((Node) (event.getSource())).getScene().getWindow().hide();
//        Parent parent = FXMLLoader.load(getClass().getResource("/org/bangungo/view/UserUbahProfil.fxml"));
//        Stage stage = new Stage();
//        Scene scene = new Scene(parent);
//        stage.setScene(scene);
//        stage.getIcons().add(new Image("Actions-go-home-icon.png"));
//        stage.setTitle("User - Ubah Profil");
//        stage.show();        
    }

    
}
