package model.event;

import model.location.Location;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StreetFood extends Event{

    private Float price_rented_space;

    public StreetFood(){}

    public StreetFood(Location location, String name_event, Integer number_of_tickets, LocalDate date_start, LocalDate date_end, event.Hour hour_start, event.Hour hour_end, Integer number_of_pause, Float price_rented_space) {
        super(location, name_event, number_of_tickets, date_start, date_end, hour_start, hour_end, number_of_pause);
        this.price_rented_space = price_rented_space;
    }

    @Override
    public void Read_Info() {
        Scanner read = new Scanner(System.in);

        System.out.print("\t\tStreetFood event name:");
        String event_name= read.nextLine();
        this.setName_event(event_name);

        System.out.print("\t\tNumber of tickets:");
        int number_tickets= read.nextInt();
        this.setNumber_of_tickets(number_tickets);

        System.out.print("\t\tData start: ");
        String date_start1= read.next();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate data_start = LocalDate.parse(date_start1, dateTimeFormatter);
        this.setDate_start(data_start);

        System.out.print("\t\tHour_start:\n\t\t\t Hour: ");
        int hour_s = read.nextInt();
        System.out.print("\t\t\tMinute:");
        int minute_S = read.nextInt();
        this.setHour_start(new event.Hour(hour_s,minute_S));


        System.out.print("\t\tData end:");
        String date_end1= read.next();
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate data_end = LocalDate.parse(date_end1, dateTimeFormatter1);
        this.setDate_end(data_end);

        System.out.print("\t\tHour_end:\n\t\t\t Hour: ");
        int hour_e = read.nextInt();
        System.out.print("\t\t\tMinute:");
        int minute_e = read.nextInt();
        this.setHour_start(new event.Hour(hour_e,minute_e));

        System.out.print("\t\tNumber of brack:");
        int number_of_pause= read.nextInt();
        this.setNumber_of_pause(number_of_pause);

        System.out.print("\t\tNumber of brack:");
        Float price_rented_space= read.nextFloat();
        this.price_rented_space = price_rented_space;
    }

    @Override
    public String toString() {
        return "StreetFood: " +
                "\n\t Location name: " + getLocation().getName() +
                "\n\t Name event: " +getName_event()+
                "\n\t Number of ticket: " +getNumber_of_tickets()+
                "\n\t Data start: " + getDate_start() +
                "\n\t Hour start: " +getHour_start() +
                "\n\t Data end: " + getDate_end() +
                "\n\t Hour end: " +getHour_end() +
                "\n\t Number of break: "+getNumber_of_pause() +
                "\n\t Price rented space: " + price_rented_space + "\n";
    }
    public Float getPrice_rented_space() {
        return price_rented_space;
    }

    public void setPrice_rented_space(Float price_rented_space) {
        this.price_rented_space = price_rented_space;
    }
}
