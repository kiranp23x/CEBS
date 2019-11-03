package Model;

public class CreditCard {
    private int userID;
    private String cardNumber;
    private String expirationMonth;
    private String expirationYear;
    private String nameOnCard;
    private BillingAddress billAddr;


    public CreditCard(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return this.userID;
    }
    public String getCardNumber(){return this.cardNumber;}
    public String getExpirationMonth(){return this.expirationMonth;}
    public String getExpirationYear(){return this.expirationYear;}
    public String getNameOnCard(){return this.nameOnCard;}
    public BillingAddress getBillingAddr() {
        return billAddr;
    }

    public void setUserID(int userID) { this.userID = userID; }
    public void setCardNumber(String cardNumber){this.cardNumber = cardNumber;}
    public void setExpirationMonth(String expirationMonth){this.expirationMonth = expirationMonth;}
    public void setExpirationYear(String expirationYear){this.expirationYear = expirationYear;}
    public void setNameOnCard(String nameOnCard1){this.nameOnCard = nameOnCard;}
}
