package client;

import client.Client;

import java.util.*;

public class Login { //clasa singleton
    private Set <Client> clientSet;
    private static Login single_instance = null;
    private Client curent;


    private Login()
    {
        this.clientSet =new HashSet<Client>();
        String first_name="admin";
        String last_name = "admin";
        String phone_number="0760774768";
        String email="admin@gmail.com";
        String password="admin";
        Client admin = new Client(first_name, last_name, phone_number, email, password);
        this.curent=null;
        this.clientSet.add(admin);
    }
    public static Login getInstance()
    {
        if (single_instance == null)
            single_instance = new Login();

        return single_instance;
    }
    //connection
    public boolean signIn(String email, String password){
        if(clientSet!=null) {
            for (Client it : clientSet)
                if (email.equals(it.getEmail()) && password.equals(it.getPassword())) {
                    this.curent = it;
                    return true;
                }

        }
        return false;
    }
    //register
    public boolean signUp(Client u){
        if(clientSet!=null) {
            for (Client it : clientSet)
                if ((u.getEmail()).equals(it.getEmail()) && (u.getPassword()).equals(it.getPassword()))
                    return false;
        }

        this.clientSet.add(u);
        return true;
    }

    public Set<Client> getClientSet() {
        return clientSet;
    }

    public void setClientSet(Set<Client> clientSet) {
        this.clientSet = clientSet;
    }

    public static Login getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(Login single_instance) {
        Login.single_instance = single_instance;
    }

    public Client getCurent() {
        return curent;
    }

    public void setCurent(Client curent) {
        this.curent = curent;
    }
}