package base.JavaThread.chapter1.daemon;

import java.util.Date;

/**
 * Description:
 * GET-version:
 * Date:2020-05-13  16:23
 * Author:wuxinrui
 */

public class virtualEvent {
    private Date date;
    private String event;

    @Override
    public String toString() {
        return "virtualEvent{" +
                "date=" + date +
                ", event='" + event + '\'' +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
