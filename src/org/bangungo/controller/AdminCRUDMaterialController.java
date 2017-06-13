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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.bangungo.dao.MaterialDao;
import org.bangungo.dao.impl.MaterialDaoImplHibernate;
import org.bangungo.model.Material;

/**
 * FXML Controller class
 *
 * @author Sandro Y M Nababan
 */
public class AdminCRUDMaterialController implements Initializable {

    private String idMaterials;

    public String getIdMaterials() {
        return idMaterials;
    }

    public void setIdMaterials(String idMaterials) {
        this.idMaterials = idMaterials;
    }

    @FXML
    private TableView<Material> DataMaterialTV;
    @FXML
    private TableColumn<Material, String> idMaterialTC;
    @FXML
    private TableColumn<Material, String> namaMaterialTC;
    @FXML
    private TableColumn<Material, Integer> hargaMaterialTC;
    @FXML
    private TableColumn<Material, Integer> stokMaterialTC;
    @FXML
    private TableColumn<Material, String> keteranganTC;
    @FXML
    private TextField idMaterialTF;
    @FXML
    private TextField namaMaterialTF;
    @FXML
    private TextField hargaMaterialTF;
    @FXML
    private TextField stokMaterialTF;

    ObservableList<Material> data;

    MaterialDao materialDao;

    @FXML
    private ComboBox kategoriFX;

    ObservableList<String> kategori = FXCollections.observableArrayList("Cat", "Batu", "Pasir", "Semen", "Genteng", "Pipa", "Broti", "Paku");
    @FXML
    private TextField keteranganTF;

    public AdminCRUDMaterialController() {
        DataMaterialTV = new TableView<>();
        materialDao = new MaterialDaoImplHibernate();
    }

    public void loadData() {
        List<Material> materials = materialDao.getAllMaterial();

        for (Material m : materials) {
            System.out.println("id Material" + m.getIdMaterial());

        }

        data = FXCollections.observableArrayList(materials);
        idMaterialTC.setCellValueFactory(new PropertyValueFactory<Material, String>("idMaterial"));
        namaMaterialTC.setCellValueFactory(new PropertyValueFactory<Material, String>("namaMaterial"));
        hargaMaterialTC.setCellValueFactory(new PropertyValueFactory<Material, Integer>("hargaMaterial"));
        stokMaterialTC.setCellValueFactory(new PropertyValueFactory<Material, Integer>("stokMaterial"));
        keteranganTC.setCellValueFactory(new PropertyValueFactory<Material, String>("keteranganPerStok"));
        DataMaterialTV.setItems(data);

        DataMaterialTV.setOnMouseClicked((MouseEvent me) -> {
            if (me.getClickCount() >= 1) {
                String idMaterial = DataMaterialTV.getItems().get(DataMaterialTV.getSelectionModel().getSelectedIndex()).getIdMaterial();
                idMaterialTF.setText(idMaterial);
            }
        });
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadData();
        kategoriFX.setItems(kategori);

    }

    /**
     *
     * @param event tidak digunakan karena jika di panggil akan melempar tetap
     * ke halaman ini
     *
     */
    @FXML
    private void CRUDMaterialB(ActionEvent event) {
    }

    @FXML
    private void hapusAkunB(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/bangungo/view/AdminHapusAkun.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.getIcons().add(new Image("Actions-go-home-icon.png"));
        stage.setTitle("Admin - Hapus Akun");
        stage.show();
    }

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
    private void entriB(ActionEvent event) throws IOException {
        System.out.println("dipanggil!");
        String idMaterial = idMaterialTF.getText();
        String namaMaterial = namaMaterialTF.getText();
        String kategoriMaterial = (String) kategoriFX.getValue();
        String keterangan = keteranganTF.getText();
        if (idMaterial != null && namaMaterial != null && kategori != null && keterangan != null && kategoriMaterial != null) {

            System.out.println("masukkk");
            int stokMaterial = 0;
            int hargaMaterial = 0;
            try {
                stokMaterial = Integer.parseInt(stokMaterialTF.getText());
                hargaMaterial = Integer.parseInt(hargaMaterialTF.getText());

                if (hargaMaterial <= 0) {
                    JOptionPane.showMessageDialog(null, "Harga tidak boleh negatif atau nol");

                } else if (stokMaterial <= 0) {
                    JOptionPane.showMessageDialog(null, "Stok tidak boleh negatif atau nol");

                } else {

                    Material material = new Material(idMaterial, namaMaterial, hargaMaterial, kategoriMaterial, stokMaterial, keterangan);

                    materialDao.saveMaterial(material);

                    clearText();
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                    JOptionPane.showMessageDialog(null, "Berhasil Input barang");
                    loadData();
                    Parent parent = FXMLLoader.load(getClass().getResource("/org/bangungo/view/AdminCRUDMaterial.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(parent);
                    stage.setScene(scene);
                    stage.getIcons().add(new Image("Actions-go-home-icon.png"));
                    stage.setTitle("Login akun");
                    stage.show();

                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Harga/Stok tidak boleh huruf");

            } catch (Exception s) {
                JOptionPane.showMessageDialog(null, "Id Bermasalah");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Field harus diisi");

        }

    }

    @FXML
    private void updateB(ActionEvent event) throws IOException {
        idMaterials = DataMaterialTV.getItems().get(DataMaterialTV.getSelectionModel().getSelectedIndex()).getIdMaterial();

        String namaMaterial = namaMaterialTF.getText();
        String kategoriMaterial = (String) kategoriFX.getValue();
        String keterangan = keteranganTF.getText();

        if (namaMaterial != null && kategori != null && keterangan != null && kategoriMaterial != null) {

            System.out.println("masukkk");
            int stokMaterial = 0;
            int hargaMaterial = 0;
            try {
                String idMaterial = idMaterialTF.getText();
                stokMaterial = Integer.parseInt(stokMaterialTF.getText());
                hargaMaterial = Integer.parseInt(hargaMaterialTF.getText());

                if (materialDao.getMaterialByKode(idMaterial).getIdMaterial().equalsIgnoreCase(keterangan)) {
                    JOptionPane.showMessageDialog(null, "id telah digunakan");

                } else if (hargaMaterial <= 0) {
                    JOptionPane.showMessageDialog(null, "Harga tidak boleh negatif atau nol");

                } else if (stokMaterial <= 0) {
                    JOptionPane.showMessageDialog(null, "Stok tidak boleh negatif atau nol");

                } else {

                    Material material = new Material(idMaterial, namaMaterial, hargaMaterial, kategoriMaterial, stokMaterial, keterangan);

                    materialDao.updateMaterials(material);
                    clearText();
                    refreshTable();
                    JOptionPane.showMessageDialog(null, "Berhasil update Material");
                    ((Node) (event.getSource())).getScene().getWindow().hide();

                    loadData();
                    Parent parent = FXMLLoader.load(getClass().getResource("/org/bangungo/view/AdminCRUDMaterial.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(parent);
                    stage.setScene(scene);
                    stage.getIcons().add(new Image("Actions-go-home-icon.png"));
                    stage.setTitle("Login akun");
                    stage.show();

                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Harga/Stok tidak boleh huruf");

            } catch (Exception s) {
                JOptionPane.showMessageDialog(null, "Id tidak ditemukan");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Field harus diisi");

        }

    }

    @FXML
    private void hapusB(ActionEvent event) {

        idMaterials = DataMaterialTV.getItems().get(DataMaterialTV.getSelectionModel().getSelectedIndex()).getIdMaterial();
        Material m = new Material(idMaterials);
        materialDao.deleteMaterial(m);
        refreshTable();
        clearText();
        JOptionPane.showMessageDialog(null, "Berhasil delete Material");
    }

    void refreshTable() {
        final List<Material> items = DataMaterialTV.getItems();
        if (items == null || items.size() == 0) {
            return;
        }

        final Material item = DataMaterialTV.getItems().get(0);
        items.remove(0);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                items.add(0, item);
            }
        });
        loadData();
    }

    private void clearText() {
        idMaterialTF.setText(null);
        namaMaterialTF.setText(null);
        hargaMaterialTF.setText(null);
        stokMaterialTF.setText(null);

    }

    @FXML
    private void kategoriCB(ActionEvent event) {
    }

}
