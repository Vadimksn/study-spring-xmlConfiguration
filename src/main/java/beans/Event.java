package beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Event {
    private int id = ThreadLocalRandom.current().nextInt(100);
    private String message;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Event {" +
                "id = " + id +
                ", message = " + message +
                ", date = " + dateFormat.format(date) +
                '}'+"\n";
    }
}
