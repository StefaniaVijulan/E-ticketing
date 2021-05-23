package event;

import java.util.Date;

public class Hour {
    public Integer minute;
    public Integer hour;

    public Hour(Integer minute, Integer hour) {
        this.minute = minute;
        this.hour = hour;
    }

    public Hour() {
        //00:00
        this.minute = 0;
        this.hour =0;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public int compareTo(Hour hour){
        if (this.hour == hour.hour)
            return 0;
        else if (this.hour < hour.hour) // start hour <end hour
            return 1;
        else
            return -1;
    }
}
