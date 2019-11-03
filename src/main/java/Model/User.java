package Model;

public class User {
    private String status;
    private String userName;
    private String password;
    private int userID;

    public User(int userID, String uname, String pword, String status) {
        this.userName = uname;
        this.password = pword;
        this.userID = userID;
        this.status = status;

    }


    public String getUserName(){
        return this.userName;
    }
    public String getPassword() {
        return password;
    }
    public int getUserID() {return userID;}
    public String getStatus() {return status;}


    public void setUserName(String uname){
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
