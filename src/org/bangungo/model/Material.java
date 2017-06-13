
package org.bangungo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bangun Go
 */
@Entity
@Table(name = "material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m"),
    @NamedQuery(name = "Material.findByIdMaterial", query = "SELECT m FROM Material m WHERE m.idMaterial = :idMaterial"),
    @NamedQuery(name = "Material.findByNamaMaterial", query = "SELECT m FROM Material m WHERE m.namaMaterial = :namaMaterial"),
    @NamedQuery(name = "Material.findByHargaMaterial", query = "SELECT m FROM Material m WHERE m.hargaMaterial = :hargaMaterial"),
    @NamedQuery(name = "Material.findByKategoriMaterial", query = "SELECT m FROM Material m WHERE m.kategoriMaterial = :kategoriMaterial"),
    @NamedQuery(name = "Material.findByStokMaterial", query = "SELECT m FROM Material m WHERE m.stokMaterial = :stokMaterial"),
    @NamedQuery(name = "Material.findByKeteranganPerStok", query = "SELECT m FROM Material m WHERE m.keteranganPerStok = :keteranganPerStok")})
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idMaterial")
    private String idMaterial;
    @Basic(optional = false)
    @Column(name = "namaMaterial")
    private String namaMaterial;
    @Basic(optional = false)
    @Column(name = "hargaMaterial")
    private int hargaMaterial;
    @Basic(optional = false)
    @Column(name = "kategoriMaterial")
    private String kategoriMaterial;
    @Basic(optional = false)
    @Column(name = "stokMaterial")
    private int stokMaterial;
    @Basic(optional = false)
    @Column(name = "keteranganPerStok")
    private String keteranganPerStok;

    public Material() {
    }

    public Material(String idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Material(String idMaterial, String namaMaterial, int hargaMaterial, String kategoriMaterial, int stokMaterial, String keteranganPerStok) {
        this.idMaterial = idMaterial;
        this.namaMaterial = namaMaterial;
        this.hargaMaterial = hargaMaterial;
        this.kategoriMaterial = kategoriMaterial;
        this.stokMaterial = stokMaterial;
        this.keteranganPerStok = keteranganPerStok;
    }

    public String getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNamaMaterial() {
        return namaMaterial;
    }

    public void setNamaMaterial(String namaMaterial) {
        this.namaMaterial = namaMaterial;
    }

    public int getHargaMaterial() {
        return hargaMaterial;
    }

    public void setHargaMaterial(int hargaMaterial) {
        this.hargaMaterial = hargaMaterial;
    }

    public String getKategoriMaterial() {
        return kategoriMaterial;
    }

    public void setKategoriMaterial(String kategoriMaterial) {
        this.kategoriMaterial = kategoriMaterial;
    }

    public int getStokMaterial() {
        return stokMaterial;
    }

    public void setStokMaterial(int stokMaterial) {
        this.stokMaterial = stokMaterial;
    }

    public String getKeteranganPerStok() {
        return keteranganPerStok;
    }

    public void setKeteranganPerStok(String keteranganPerStok) {
        this.keteranganPerStok = keteranganPerStok;
    }

    /**
     * 
     * @return mengembalikan integer yang diset pada material
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaterial != null ? idMaterial.hashCode() : 0);
        return hash;
    }

    /**
     * 
     * @param object parameter yang akan dibandingan dengan objek lain
     * @return mengembalikan true jika objek yang dibandingkan sama
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.idMaterial == null && other.idMaterial != null) || (this.idMaterial != null && !this.idMaterial.equals(other.idMaterial))) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @return mengembalikan objek menjadi string   
     */
    @Override
    public String toString() {
        return "org.bangungo.model.Material[ idMaterial=" + idMaterial + " ]";
    }
    
}
