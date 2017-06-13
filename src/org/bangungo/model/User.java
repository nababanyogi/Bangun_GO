/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author BangunGO
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByReTypePassword", query = "SELECT u FROM User u WHERE u.reTypePassword = :reTypePassword"),
    @NamedQuery(name = "User.findByNamaUser", query = "SELECT u FROM User u WHERE u.namaUser = :namaUser"),
    @NamedQuery(name = "User.findByJenisKelamin", query = "SELECT u FROM User u WHERE u.jenisKelamin = :jenisKelamin"),
    @NamedQuery(name = "User.findByTanggalLahir", query = "SELECT u FROM User u WHERE u.tanggalLahir = :tanggalLahir"),
    @NamedQuery(name = "User.findByAlamatEmail", query = "SELECT u FROM User u WHERE u.alamatEmail = :alamatEmail"),
    @NamedQuery(name = "User.findByNoTelp", query = "SELECT u FROM User u WHERE u.noTelp = :noTelp"),
    @NamedQuery(name = "User.findByAlamat", query = "SELECT u FROM User u WHERE u.alamat = :alamat")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "userName")
    private String userName;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "reTypePassword")
    private String reTypePassword;
    @Basic(optional = false)
    @Column(name = "namaUser")
    private String namaUser;
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

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, String password, String reTypePassword, String namaUser, String jenisKelamin, String tanggalLahir, String alamatEmail, String noTelp, String alamat) {
        this.userName = userName;
        this.password = password;
        this.reTypePassword = reTypePassword;
        this.namaUser = namaUser;
        this.jenisKelamin = jenisKelamin;
        this.tanggalLahir = tanggalLahir;
        this.alamatEmail = alamatEmail;
        this.noTelp = noTelp;
        this.alamat = alamat;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bangungo.model.User[ userName=" + userName + " ]";
    }
    
}
