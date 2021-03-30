package event;

import client.Buyer;
import location.Location;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public abstract  class Event implements Comparable<Event>{

    private Location location;
    private String name_event;
    private Integer number_of_tickets;
    //About date
    private LocalDate date_start;
    private LocalDate date_end;
    private Hour hour_start;
    private Hour hour_end;
    private Integer number_of_pause;
    //private List<Buyer> buyerList;
    public Event(){

    }

    public Event(Location location, String name_event, Integer number_of_tickets, LocalDate date_start, LocalDate date_end, Hour hour_start, Hour hour_end, Integer number_of_pause) {
        this.location = location;
        this.name_event = name_event;
        this.number_of_tickets = number_of_tickets;
        this.date_start = date_start;
        this.date_end = date_end;
        this.hour_start = hour_start;
        this.hour_end = hour_end;
        this.number_of_pause = number_of_pause;
      //  this.buyerList = new ArrayList<Buyer>();

    }

    public int compareTo(Event ev){
        return this.name_event.compareTo(ev.name_event);
    }
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setName_event(String name_event) {
        this.name_event = name_event;
    }

    public String getName_event() {
        return name_event;
    }

    public Integer getNumber_of_tickets() {
        return number_of_tickets;
    }

    public LocalDate getDate_start() {
        return date_start;
    }

    public LocalDate getDate_end() {
        return date_end;
    }

    public Hour getHour_start() {
        return hour_start;
    }

    public Hour getHour_end() {
        return hour_end;
    }

    public void setHour_end(Hour hour_end) {
        this.hour_end = hour_end;
    }

    public Integer getNumber_of_pause() {
        return number_of_pause;
    }

    public void setNumber_of_tickets(Integer number_of_tickets) {
        this.number_of_tickets = number_of_tickets;
    }

    public void setDate_start(LocalDate date_start) {
        this.date_start = date_start;
    }

    public void setDate_end(LocalDate date_end) {
        this.date_end = date_end;
    }

    public void setHour_start(Hour hour_start) {
        this.hour_start = hour_start;
    }

    public void setNumber_of_pause(Integer number_of_pause) {
        this.number_of_pause = number_of_pause;
    }

    public abstract void Read_Info();

    @Override
    public abstract String toString();
    public abstract float ticket_value();

}
