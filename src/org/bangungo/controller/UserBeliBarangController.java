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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.bangungo.dao.MaterialDao;
import org.bangungo.dao.impl.MaterialDaoImplHibernate;
import org.bangungo.model.Material;

/**
 * FXML Controller class
 *
 * @author Sandro Y M Nababan
 */
public class UserBeliBarangController implements Initializable {

    ObservableList<String> kategori = FXCollections.observableArrayList("Cat", "Batu", "Pasir", "Semen", "Genteng", "Pipa", "Broti", "Paku");

    ObservableList<Material> data;

    @FXML
    private TableView<Material> barangTB;
    @FXML
    private TableColumn<Material, String> idBarangTC;
    @FXML
    private TableColumn<Material, String> namaBarangTC;
    @FXML
    private TableColumn<Material, Integer> stokTC;
    @FXML
    private ComboBox kategoriCBfxid;

    MaterialDao materialDao;

    public UserBeliBarangController() {
        materialDao = new MaterialDaoImplHibernate();
    }

    /**
     * Initializes the controller class.
     */
    public void loadData() {
        List<Material> materials = materialDao.getAllMaterial();

        for (Material m : materials) {
            System.out.println("id Material" + m.getIdMaterial());

        }

        data = FXCollections.observableArrayList(materials);
        idBarangTC.setCellValueFactory(new PropertyValueFactory<Material, String>("idMaterial"));
        namaBarangTC.setCellValueFactory(new PropertyValueFactory<Material, String>("namaMaterial"));
        stokTC.setCellValueFactory(new PropertyValueFactory<Material, Integer>("keteranganPerStok"));
        barangTB.setItems(data);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadData();
        kategoriCBfxid.setItems(kategori);
    }

    @FXML
    private void kategoriCB(ActionEvent event) {
        String kategori = (String) kategoriCBfxid.getValue();
        List<Material> materials = materialDao.getAllMaterialByKategori(kategori);
        data = FXCollections.observableArrayList(materials);
        idBarangTC.setCellValueFactory(new PropertyValueFactory<Material, String>("idMaterial"));
        namaBarangTC.setCellValueFactory(new PropertyValueFactory<Material, String>("namaMaterial"));
        stokTC.setCellValueFactory(new PropertyValueFactory<Material, Integer>("keteranganPerStok"));
        barangTB.setItems(data);

    }

    @FXML
    private void pilihB(ActionEvent event) {
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
//        ((Node) (event.getSource())).getScene().getWindow().hide();
//        Parent parent = FXMLLoader.load(getClass().getResource("/org/bangungo/view/UserBeliBarang.fxml"));
//        Stage stage = new Stage();
//        Scene scene = new Scene(parent);
//        stage.setScene(scene);
//        stage.getIcons().add(new Image("Actions-go-home-icon.png"));
//        stage.setTitle("User - Beli Barang");
//        stage.show();
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
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/bangungo/view/UserUbahProfil.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.getIcons().add(new Image("Actions-go-home-icon.png"));
        stage.setTitle("User - Ubah Profil");
        stage.show();
    }

    @FXML
    private void resetKategori(ActionEvent event) {
        loadData();
    }

}
