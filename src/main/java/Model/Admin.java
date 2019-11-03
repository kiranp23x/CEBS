package Model;

public class Admin extends User{
    enum Status {ACTIVE, INACTIVE, SUSPENDED;}
    private String stat;
    public Admin(int uid, String uname, String pw, String status) {
        super(uid, uname, pw, status);
    }

    public void editPromo() {
        //SQL calls to retrieve promo if it is not found in active items?
        //or prefetch all promos and place on view layer, chosen promo has ID (and new values?) plugged in for alteration
    }

    public void createNewShowtime() {
        //basic structure: call constructor, populate with values, then upload to database through DBConn
    }

    public void editMovie() {
        //similar deal to editPromo, maybe fetch a limit of movies
        // would Admin enter the name of a movie to change, or choose from a list?
    }

    public void editTicket() {
        //more editing
    }

    // admin can additionally set status of any user
    public void setStatus(String s) {
        // if invalid string, do not change status (todo)
        if (s.equalsIgnoreCase("suspended"))
            this.stat = Status.SUSPENDED.toString();
        else if (s.equalsIgnoreCase("inactive"))
            this.stat = Status.INACTIVE.toString();
        else
            this.stat = Status.ACTIVE.toString();
    }
}
