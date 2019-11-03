package Model;

public class Customer extends User{
    private static String lastName;
    private static String firstName;
    private static String emailAddress;
    private static String emailPromo;
    private static CreditCard cCard; // implement as array/list?
    private static String uname;


    public Customer(int uid, String uname, String pw, String status) {
        super(uid, uname, pw, status);
    }
   /* public Booking getBooking() {
        //create string to be passed along to DBAccess layer?
        // OR
        //sequential calls to relevant getters in Booking object
        //where to store Booking?

    }

    public void CreditCard getCardInfo() {
        //
    }
    */
    public void addCard(){

    }
    public void editCard() {

    }
    public static String getFirstName() {
        return firstName;
    }
    public static String getLastName() {
        return lastName;
    }
    public static String getEmailAddress() {
        return emailAddress;
    }
    public static String getUname() {
        return uname;
    }
    public static String getEmailPromo(){return emailPromo;}

    public void setEmailPromo(String emailPromo){this.emailPromo = emailPromo;}
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmailAddress(String email) { this.emailAddress = email; }
    public void setUname(String uname) { this.uname = uname; }



}
