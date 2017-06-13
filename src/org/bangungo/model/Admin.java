
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
@Table(name = "admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findByUserNameAdmin", query = "SELECT a FROM Admin a WHERE a.userNameAdmin = :userNameAdmin"),
    @NamedQuery(name = "Admin.findByPassword", query = "SELECT a FROM Admin a WHERE a.password = :password"),
    @NamedQuery(name = "Admin.findByReTypePassword", query = "SELECT a FROM Admin a WHERE a.reTypePassword = :reTypePassword"),
    @NamedQuery(name = "Admin.findByNamaAdmin", query = "SELECT a FROM Admin a WHERE a.namaAdmin = :namaAdmin"),
    @NamedQuery(name = "Admin.findByJenisKelamin", query = "SELECT a FROM Admin a WHERE a.jenisKelamin = :jenisKelamin"),
    @NamedQuery(name = "Admin.findByTanggalLahir", query = "SELECT a FROM Admin a WHERE a.tanggalLahir = :tanggalLahir"),
    @NamedQuery(name = "Admin.findByAlamatEmail", query = "SELECT a FROM Admin a WHERE a.alamatEmail = :alamatEmail"),
    @NamedQuery(name = "Admin.findByNoTelp", query = "SELECT a FROM Admin a WHERE a.noTelp = :noTelp"),
    @NamedQuery(name = "Admin.findByAlamat", query = "SELECT a FROM Admin a WHERE a.alamat = :alamat")})
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "userNameAdmin")
    private String userNameAdmin;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "reTypePassword")
    private String reTypePassword;
    @Basic(optional = false)
    @Column(name = "namaAdmin")
    private String namaAdmin;
    @Basic(optional = false)
    @Column(name = "jenisKelamin")
    private String jenisKelamin;
    @Basic(optional = false)
    @Column(name = "tanggalLahir")
    private String tanggalLahir;
    @Basic(optional = false)
    @Column(name = "alamatEmail")
    private String alamatEmail;
    @Basic(optional = false)
    @Column(name = "noTelp")
    private String noTelp;
    @Basic(optional = false)
    @Column(name = "alamat")
    private String alamat;

    public Admin() {
    }

    public Admin(String userNameAdmin) {
        this.userNameAdmin = userNameAdmin;
    }

    public Admin(String userNameAdmin, String password, String reTypePassword, String namaAdmin, String jenisKelamin, String tanggalLahir, String alamatEmail, String noTelp, String alamat) {
        this.userNameAdmin = userNameAdmin;
        this.password = password;
        this.reTypePassword = reTypePassword;
        this.namaAdmin = namaAdmin;
        this.jenisKelamin = jenisKelamin;
        this.tanggalLahir = tanggalLahir;
        this.alamatEmail = alamatEmail;
        this.noTelp = noTelp;
        this.alamat = alamat;
    }

    public String getUserNameAdmin() {
        return userNameAdmin;
    }

    public void setUserNameAdmin(String userNameAdmin) {
        this.userNameAdmin = userNameAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReTypePassword() {
        return reTypePassword;
    }

    public void setReTypePassword(String reTypePassword) {
        this.reTypePassword = reTypePassword;
    }

    public String getNamaAdmin() {
        return namaAdmin;
    }

    public void setNamaAdmin(String namaAdmin) {
        this.namaAdmin = namaAdmin;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamatEmail() {
        return alamatEmail;
    }

    public void setAlamatEmail(String alamatEmail) {
        this.alamatEmail = alamatEmail;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * 
     * @return mengembalikan integer yang telah diset untuk admin
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userNameAdmin != null ? userNameAdmin.hashCode() : 0);
        return hash;
    }

    /**
     * 
     * @param object parameter yang akan dibandingkan dengan objek lain
     * @return mengembalikan nilai true ketika objek sama
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.userNameAdmin == null && other.userNameAdmin != null) || (this.userNameAdmin != null && !this.userNameAdmin.equals(other.userNameAdmin))) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @return mengembalikan objek ke string
     */
    @Override
    public String toString() {
        return "org.bangungo.model.Admin[ userNameAdmin=" + userNameAdmin + " ]";
    }
    
}
