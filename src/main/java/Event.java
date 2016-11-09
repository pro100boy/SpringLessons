import java.text.DateFormat;
import java.util.Date;

public class Event {
    private final DateFormat df;
    private int id; // Auto-generated
    private String msg;
    private Date date;

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                df.format(date) +
                '}';
    }
}
