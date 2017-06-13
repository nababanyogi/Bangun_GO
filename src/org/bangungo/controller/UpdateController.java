/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bangungo.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import org.bangungo.dao.MaterialDao;
import org.bangungo.dao.impl.MaterialDaoImplHibernate;
import org.bangungo.model.Material;

/**
 * FXML Controller class
 *
 * @author Sandro Y M Nababan
 */
public class UpdateController implements Initializable {

    @FXML
    private TextField namaMaterialTF;
    @FXML
    private TextField hargaMaterialTF;
    @FXML
    private TextField stokMaterialTF;
    @FXML
    private ComboBox<?> kategoriFX;
    @FXML
    private TextField keteranganTF;

        MaterialDao materialDao;

    public UpdateController() {
    
        materialDao = new MaterialDaoImplHibernate();
    
    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void kategoriCB(ActionEvent event) {
    }

    @FXML
    private void updateB(ActionEvent event) {
        AdminCRUDMaterialController acrudmc = new AdminCRUDMaterialController();
        //Material m = new Material(acrudmc.getIdMaterials());
        String idMaterial = acrudmc.getIdMaterials();
        
        
        String namaMaterial = namaMaterialTF.getText();
        int stokMaterial = Integer.parseInt(stokMaterialTF.getText());
        int hargaMaterial = Integer.parseInt(hargaMaterialTF.getText());
        Material m = new Material(idMaterial, namaMaterial, hargaMaterial, "", stokMaterial, "");
                    
        materialDao.updateMaterials(m);
        
        
        JOptionPane.showMessageDialog(null, "Berhasil update Material");
        ((Node) (event.getSource())).getScene().getWindow().hide();
//        insialisasiAwalInputan();
//        refreshTable();        
    }
    
    
    
}
