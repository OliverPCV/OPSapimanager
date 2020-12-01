package cz.educanet.opsapimanagers;

import java.util.ArrayList;

public class UsersManager {

    private ArrayList<String> users = new ArrayList<>();

    public ArrayList<String> getAll(){
        return users;
    }

    public boolean addUser(String user){
        return true;
    }
    public boolean editUser(String username, String newUsername){
        return  true;
    }

    public boolean usernameCheck(Users user){
        return true;
    }
}
