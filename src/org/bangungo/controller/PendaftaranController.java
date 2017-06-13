/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bangungo.controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.bangungo.dao.LoginDao;
import org.bangungo.dao.UserDao;
import org.bangungo.dao.impl.LoginDaoImplHibernate;
import org.bangungo.dao.impl.UserDaoImplHibernate;
import org.bangungo.model.Login;
import org.bangungo.model.User;

/**
 * FXML Controller class
 *
 * @author Sandro Y M Nababan
 */
public class PendaftaranController implements Initializable {

    UserDao userDao;
    LoginDao loginDao;
    Stage primaryStage = new Stage();
    private final String pattern = "MM-dd-yyyy";
    @FXML
    private TextField userNameTF;
    @FXML
    private PasswordField passwordTF;
    @FXML
    private PasswordField reTypePasswordTF;
    @FXML
    private TextField namaUserTF;
    @FXML
    private DatePicker tanggalLahirDP;
    @FXML
    private TextField noTelpTF;
    @FXML
    private TextField emailTF;
    @FXML
    private RadioButton lakiLakiRB;
    @FXML
    private RadioButton perempuanRB;
    @FXML
    private TextArea alamatTA;
    ObservableList<User> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        clear();
    }

    public PendaftaranController() {

        userDao = new UserDaoImplHibernate();
        loginDao = new LoginDaoImplHibernate();
    }

    @FXML
    private void unggahFoto(ActionEvent event) {
    }

    @FXML
    private void daftarkan(ActionEvent event) throws IOException {
        tanggalLahirDP.setPromptText(pattern.toLowerCase());
        String username = userNameTF.getText();
        String password = passwordTF.getText();
        String reTypePassord = reTypePasswordTF.getText();
        String namaUser = namaUserTF.getText();
        String email = emailTF.getText();
        String noTelp = noTelpTF.getText();
        String alamat = alamatTA.getText();

        if (username != null && password != null && reTypePassord != null && namaUser != null && alamat != null && noTelp != null && alamat != null) {

            try {

                String jenisKelamin = new String();
                if (lakiLakiRB.isSelected()) {
                    jenisKelamin = "Laki-Laki";
                } else {
                    jenisKelamin = "Perempuan";
                }

                DatePicker datePicker = new DatePicker();
                String date = (tanggalLahirDP.getValue().format(DateTimeFormatter.ISO_DATE).split("-")[2]) + "/" + (tanggalLahirDP.getValue().format(DateTimeFormatter.ISO_DATE).split("-")[1]) + "/" + (tanggalLahirDP.getValue().format(DateTimeFormatter.ISO_DATE).split("-")[0]);

                boolean penandaUser = true;

                for (int i = 0; i < username.length(); i++) {
                    if (username.charAt(i) < 97 || username.charAt(i) > 122) {
                        penandaUser = false;
                        break;
                    }
                }

                if (penandaUser == false) {

                    JOptionPane.showMessageDialog(null, "user name bermasalah");

                } else if (passwordTF.getText().equals(reTypePasswordTF.getText()) == false) {

                    JOptionPane.showMessageDialog(null, "pasword dan retype password tidak sama");

                } else {

                    User m = new User(username, password, reTypePassord, namaUser, jenisKelamin, date, email, noTelp, alamat);
                    Login n = new Login(0, username, password, 0);
                    userDao.saveUser(m);
                    loginDao.saveAkunLogin(n);
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                    JOptionPane.showMessageDialog(null, "Pendaftaran berhasil.");
                    batal();

                }

            } catch (NullPointerException np) {

                //teksField(namaUser, username, password);
                JOptionPane.showMessageDialog(null, "Pilih kategori");

                clear();
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        }

    }

    private void clear() {

        userNameTF.setText(null);
        passwordTF.setText(null);
        reTypePasswordTF.setText(null);
        namaUserTF.setText(null);
        emailTF.setText(null);
        noTelpTF.setText(null);
        alamatTA.setText(null);
        lakiLakiRB.setSelected(false);
        perempuanRB.setSelected(false);
    }

    private void teksField(String nama, String un, String pass) {
        if (nama == null || un == null || pass == null) {
            JOptionPane.showMessageDialog(null, "Ada field yang kosong.\nField tidak boleh kosong");

        }

    }

    @FXML
    private void batal(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        batal();
    }

    private void batal() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/org/bangungo/view/Login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.getIcons().add(new Image("Actions-go-home-icon.png"));
        stage.setTitle("Login akun");
        stage.show();

    }

    @FXML
    private void lakiLaki(ActionEvent event) {
        if (lakiLakiRB.isSelected()) {
            perempuanRB.setSelected(false);
        } else {
            lakiLakiRB.setSelected(false);
        }
    }

    @FXML
    private void perempuan(ActionEvent event) {
        if (perempuanRB.isSelected()) {
            lakiLakiRB.setSelected(false);
        } else {
            perempuanRB.setSelected(false);
        }
    }

}
