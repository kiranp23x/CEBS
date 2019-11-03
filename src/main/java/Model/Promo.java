package Model;

public class Promo {
    private int promoID;
    private double value;
    private String promoCode;

    public int getPromoID() {
        return promoID;
    }
    public double getValue() {
        return value;
    }
    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoID(int promoID) {
        this.promoID = promoID;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }
}
