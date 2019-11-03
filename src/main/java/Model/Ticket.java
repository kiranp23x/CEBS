package Model;

public class Ticket {
    enum TicketType {ADULT, SENIOR, CHILD;}
    private int ticketID;
    private int seatNum;
    private int price;
    private String type;

    public int getTicketID() {
        return ticketID;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }


    public void setPrice(int price) {
        this.price = price;
    }
    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }
    public void setType(String type) {
        this.type = type;
    }
}
