package Model;

public class HomeAddress {
    private String homeStreet1;
    private String homeStreet2;
    private String homeCity;
    private String homeState;
    private String homeZipCode;

    public HomeAddress(String homeStreet1, String homeStreet2, String homeCity, String homeState, String homeZipCode, int userID){
        this.homeStreet1 = homeStreet1;
        this.homeStreet2 = homeStreet2;
        this.homeCity = homeCity;
        this.homeState = homeState;
        this.homeZipCode = homeZipCode;
    }
    public String getStreet1(){
        return homeStreet1;
    }
    public String getStreet2(){
        return homeStreet2;
    }
    public String getCity(){
        return homeCity;
    }
    public String getState(){
        return homeState;
    }
    public String getZipCode(){
        return homeZipCode;
    }
    public void setStreet1(String homeStreet1){
        this.homeStreet1 = homeStreet1;
    }
    public void setStreet2(String homeStreet2) {
        this.homeStreet2 = homeStreet2;
    }
    public void setCity(String homeCity){
        this.homeCity = homeCity;
    }
    public void setState(String homeState){
        this.homeState = homeState;
    }
    public void setZipCode(String homeZipCode){
        this.homeZipCode = homeZipCode;
    }

}
