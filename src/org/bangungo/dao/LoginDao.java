package org.bangungo.dao;

import java.util.List;
import org.bangungo.model.User;
import org.bangungo.model.Login;
import org.bangungo.model.Admin;
//import org.inventori.model.Login;
//import org.inventori.model.User;

public interface LoginDao {

    public List<User> getAllUser();

    public List<Admin> getAllAdmin();

    public List<Login> getAllLogin();

    public void saveAkunLogin(Login m);

    public boolean login(String username, String password, int penanda);
    //public boolean loginAdmin(String username, String password);

    public String getNama(String username, String password, int penanda);
    //public String getNamaAdmin(String username, String password);

    public void deleteLog(Login userName, int penanda);
}
