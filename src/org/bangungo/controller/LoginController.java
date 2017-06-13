/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bangungo.controller;

import org.bangungo.controller.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.bangungo.dao.LoginDao;
import org.bangungo.dao.impl.LoginDaoImplHibernate;
import org.bangungo.model.Admin;

/**
 * FXML Controller class
 *
 * @author Sandro Y M Nababan
 */
public class LoginController implements Initializable {

    static String namaUser;
    LoginDao loginDao;
    @FXML
    private TextField userNameTF;
    @FXML
    private Button loginButton;
    @FXML
    private PasswordField passwordTF;

    public LoginController() {
        loginDao = new LoginDaoImplHibernate();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loginB(ActionEvent event) throws IOException {
        String username = userNameTF.getText();
        String password = passwordTF.getText();
        int penandaUser = 0;
        int penandaAdmin = 1;

        List<Admin> admins = loginDao.getAllAdmin();///////////
        System.out.println("" + admins.size());
        if (loginDao.login(username, password, penandaUser) == true) {
            System.out.println("MASUK");

            //PenandaLogin p = new PenandaLogin(username, 1);
            //pDao.updatePenandaLogin(p);
            namaUser = loginDao.getNama(username, password, penandaUser);
            ((Node) (event.getSource())).getScene().getWindow().hide();
            loginB();

        } else if (loginDao.login(username, password, penandaAdmin) == true) {
            System.out.println("MASUK SEBAGAI ADMIN");
            //PenandaLogin p = new PenandaLogin(username, 1);
            //pDao.updatePenandaLogin(p);

            namaUser = loginDao.getNama(username, password, penandaAdmin);

            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("/org/bangungo/view/AdminCRUDMaterial.fxml"));
            Stage stage = new Stage();
            stage.getIcons().add(new Image("Actions-go-home-icon.png"));
            stage.setTitle("Admin - CRUD");
            Scene scene = new Scene(parent);
            stage.setScene(scene);

            JOptionPane.showMessageDialog(null, "Hi admin , " + namaUser);

            stage.show();

        } else {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            JOptionPane.showMessageDialog(null, "Login gagal, coba lagi !");

            Parent parent = FXMLLoader.load(getClass().getResource("/org/bangungo/view/Login.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.getIcons().add(new Image("Actions-go-home-icon.png"));
            stage.setTitle("Login akun");
            stage.show();

            System.out.println("GAGAL");
        }

    }

    public void loginB() throws IOException {
        System.out.println("masuk loginnn");
        Parent parent = FXMLLoader.load(getClass().getResource("/org/bangungo/view/UserBeliBarang.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);

        JOptionPane.showMessageDialog(null, "Hai, " + namaUser);
        stage.getIcons().add(new Image("Actions-go-home-icon.png"));
        stage.setTitle("User - Beli Barang");
        stage.show();
    }

    @FXML
    private void registrasi(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        registrasi();
    }

    private void registrasi() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/org/bangungo/view/Pendaftaran.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.getIcons().add(new Image("Actions-go-home-icon.png"));
        stage.setTitle("Form Pendaftaran");
        stage.show();

    }

    @FXML
    private void exitIV(MouseEvent event) {
        System.exit(0);
    }

}
