package org.bangungo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "keluhan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Keluhan.findAll", query = "SELECT k FROM Keluhan k"),
    @NamedQuery(name = "Keluhan.findByIdKeluhan", query = "SELECT k FROM Keluhan k WHERE k.idKeluhan = :idKeluhan"),
    @NamedQuery(name = "Keluhan.findByKeluhan", query = "SELECT k FROM Keluhan k WHERE k.keluhan = :keluhan"),
    @NamedQuery(name = "Keluhan.findByBalasanKeluhan", query = "SELECT k FROM Keluhan k WHERE k.balasanKeluhan = :balasanKeluhan"),
    @NamedQuery(name = "Keluhan.findByIdBarang", query = "SELECT k FROM Keluhan k WHERE k.idBarang = :idBarang"),
    @NamedQuery(name = "Keluhan.findByUserNameUser", query = "SELECT k FROM Keluhan k WHERE k.userNameUser = :userNameUser")})
public class Keluhan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idKeluhan")
    private Integer idKeluhan;
    @Basic(optional = false)
    @Column(name = "keluhan")
    private String keluhan;
    @Basic(optional = false)
    @Column(name = "balasanKeluhan")
    private String balasanKeluhan;
    @Basic(optional = false)
    @Column(name = "idBarang")
    private String idBarang;
    @Basic(optional = false)
    @Column(name = "userNameUser")
    private String userNameUser;

    public Keluhan() {
    }

    public Keluhan(Integer idKeluhan) {
        this.idKeluhan = idKeluhan;
    }

    public Keluhan(Integer idKeluhan, String keluhan, String balasanKeluhan, String idBarang, String userNameUser) {
        this.idKeluhan = idKeluhan;
        this.keluhan = keluhan;
        this.balasanKeluhan = balasanKeluhan;
        this.idBarang = idBarang;
        this.userNameUser = userNameUser;
    }

    public Integer getIdKeluhan() {
        return idKeluhan;
    }

    public void setIdKeluhan(Integer idKeluhan) {
        this.idKeluhan = idKeluhan;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getBalasanKeluhan() {
        return balasanKeluhan;
    }

    public void setBalasanKeluhan(String balasanKeluhan) {
        this.balasanKeluhan = balasanKeluhan;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getUserNameUser() {
        return userNameUser;
    }

    public void setUserNameUser(String userNameUser) {
        this.userNameUser = userNameUser;
    }

    /**
     *
     * @return mengembalikan integer yang diset pada keluhan
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKeluhan != null ? idKeluhan.hashCode() : 0);
        return hash;
    }

    /**
     *
     * @param object parameter yang akan dibandingkan
     * @return mengembalikan nilai true ketika objek sama
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Keluhan)) {
            return false;
        }
        Keluhan other = (Keluhan) object;
        if ((this.idKeluhan == null && other.idKeluhan != null) || (this.idKeluhan != null && !this.idKeluhan.equals(other.idKeluhan))) {
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
        return "org.bangungo.model.Keluhan[ idKeluhan=" + idKeluhan + " ]";
    }

}
