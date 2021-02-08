package cz.educanet.opsapimanagers;


public class Users {
    private String fullname;
    private String username;
    private String email;
    private String password;

    public Users( String fullname, String username, String email,  String password){
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    public String changeUsername(String newUsername){
        return this.username = newUsername;
    }
    public String changePassword(String newPassword){
        return this.username = newPassword;
    }
}
