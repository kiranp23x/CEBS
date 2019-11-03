package Model;

public class BillingAddress {
    private String billingStreet1;
    private String billingStreet2;
    private String billingCity;
    private String billingState;
    private String billingZipCode;
    private String cardNumber;
    private int userID;

    public BillingAddress(int userID){
        this.userID = userID;
    }
    public String getStreet1(){
        return billingStreet1;
    }
    public String getStreet2(){
        return billingStreet2;
    }
    public String getCity(){
        return billingCity;
    }
    public String getState(){
        return billingState;
    }
    public String getZipCode(){
        return billingZipCode;
    }
    public String getCardNumber(){
        return cardNumber;
    }
    public void setStreet1(String billingStreet1){
        this.billingStreet1 = billingStreet1;
    }
    public void setStreet2(String billingStreet2) {
        this.billingStreet2 = billingStreet2;
    }
    public void setCity(String billingCity){
        this.billingCity = billingCity;
    }
    public void setState(String billingState){
        this.billingState = billingState;
    }
    public void setZipCode(String billingZipCode){
        this.billingZipCode = billingZipCode;
    }
    public void setCardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }
}
