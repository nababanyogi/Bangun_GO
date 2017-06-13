package org.bangungo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.bangungo.dao.MaterialDao;
import org.bangungo.model.Material;
import org.bangungo.util.HibernateUtil;
import org.hibernate.Session;

public class MaterialDaoImplHibernate implements MaterialDao {

    @Override
    public void updateMaterial(Material material) {
        for (Material m : getAllMaterial()) {
            if (m.getIdMaterial() == material.getIdMaterial()) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                m.setStokMaterial(material.getStokMaterial());
                session.update(material);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public void saveMaterial(Material m) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(m);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public List<Material> getAllMaterial() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Material> materials = session.createCriteria(Material.class).list();
        session.getTransaction().commit();
        return materials;
    }

    @Override
    public Material getMaterialByKode(String idMaterial) {
        Material material = new Material();

        for (Material m : getAllMaterial()) {
            if (m.getIdMaterial().equalsIgnoreCase(idMaterial)) {
                material = m;
                break;
            }
        }
        return material;

    }

    @Override
    public List<Material> getAllMaterialByKategori(String kategoriMaterial) {
        List<Material> m = new ArrayList<>();
        for (Material material : getAllMaterial()) {
            if (material.getKategoriMaterial().equalsIgnoreCase(kategoriMaterial)) {
                m.add(material);
            }
        }
        return m;
    }
    
        @Override
    public List<Material> getAllMaterialByIdMaterial(String idMaterial) {
        List<Material> m = new ArrayList<>();
        for (Material material : getAllMaterial()) {
            if (material.getIdMaterial().equalsIgnoreCase(idMaterial)) {
                m.add(material);
            }
            else{
                return null;
            }
        }
        return m;
    }

    @Override
    public Material getMaterialByNama(String namaMaterial) {
        Material material = new Material();

        for (Material m : getAllMaterial()) {
            if (m.getNamaMaterial().equals(namaMaterial)) {
                material = m;
                JOptionPane.showMessageDialog(null, "Barang ditemukan");
                break;
            }
        }
        return material;

    }

    @Override
//    public void updateBarangByKode(int kode, int jumlah)
    public void updateMaterialByKode(String idMaterial, int stokMaterial) {
        Material material = new Material();
        for (Material m : getAllMaterial()) {
            if (m.getIdMaterial().equalsIgnoreCase(idMaterial)) {
                material = m;
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                material.setStokMaterial(m.getStokMaterial() - stokMaterial);
                session.update(material);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    //public Barang getJumlahBarang(int kodeBarang) 
    public Material getJumlahMaterial(String idMaterial) {
        Material material = new Material();
        for (Material m : getAllMaterial()) {
            if (m.getIdMaterial().equalsIgnoreCase(idMaterial)) {
                material = m;
                break;
            }
        }
        return material;
    }

    @Override
    public void deleteMaterial(Material idMaterial) {
        for (Material materials : getAllMaterial()) {
            if (materials.getIdMaterial().equalsIgnoreCase(idMaterial.getIdMaterial())) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                session.delete(materials);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            } else {
                System.out.println("Failed to Delete!");
            }
        }
    }


    @Override
    public void updateMaterials(Material idmaterial) {
        for (Material m : getAllMaterial()) {
            if (m.getIdMaterial().equalsIgnoreCase(idmaterial.getIdMaterial())) {
                System.out.println("mangstas");
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                m.setNamaMaterial(idmaterial.getNamaMaterial());
                m.setHargaMaterial(idmaterial.getHargaMaterial());
                m.setStokMaterial(idmaterial.getStokMaterial());
                m.setKategoriMaterial(idmaterial.getKategoriMaterial());
                m.setKeteranganPerStok(idmaterial.getKeteranganPerStok());
                session.update(m);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            } else {
                System.out.println("UPDATE GAGAL");
            }
        }
    }
}















