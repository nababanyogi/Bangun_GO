/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bangungo.dao;

import java.util.List;
import org.bangungo.model.Material;

/**
 *
 * @author Sandro Y M Nababan
 */
public interface MaterialDao {

    public void updateMaterial(Material material);

    public void saveMaterial(Material material);

    public Material getJumlahMaterial(String idMaterial);

    public List<Material> getAllMaterial();

    public Material getMaterialByKode(String idMaterial);

    public void updateMaterialByKode(String idMaterial, int stokMaterial);

    public Material getMaterialByNama(String namaMaterial);

    public List<Material> getAllMaterialByKategori(String kategoriMaterial);

    public void deleteMaterial(Material idMaterial);

    public void updateMaterials(Material idmaterial);

    public List<Material> getAllMaterialByIdMaterial(String idMaterial);
}
