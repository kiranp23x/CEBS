package Model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Showtime {
    private int showID;
    public int roomID;
    private LocalTime time;
    private LocalDate date;
    private int runtime;

    public int getShowID() {
        return showID;
    }
    public int getRoomID() {
        return roomID;
    }
    public LocalTime getTime() {
        return time;
    }
    public LocalDate getDate() {
        return date;
    }
    public int getRuntime() {
        return runtime;
    }
}

