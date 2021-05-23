package model.event;

import model.location.Location;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Concert extends Event {
    //Singer info
    private String name_of_singer;
    private Float singer_price;

    public Concert(){}

    public Concert( Location location, String name_event, Integer number_of_tickets, LocalDate date_start, LocalDate date_end, event.Hour hour_start, event.Hour hour_end, Integer number_of_pause, String name_of_singer, Float singer_price) {
        super(location, name_event, number_of_tickets, date_start, date_end, hour_start, hour_end, number_of_pause);
        this.name_of_singer = name_of_singer;
        this.singer_price = singer_price;
    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
    @Override
    public void Read_Info()  {
        Scanner read = new Scanner(System.in);

        System.out.print("\t\tEvent name:");
        String event_name= read.nextLine();
        this.setName_event(event_name);


        System.out.print("\t\tSinger name:");
        String name_S= read.nextLine();
        this.name_of_singer= name_S;

        System.out.print("\t\tSinger price:");
        Float price_t = read.nextFloat();
        this.singer_price= price_t;

        System.out.print("\t\tNumber of tickets:");
        int number_tickets= read.nextInt();
        this.setNumber_of_tickets(number_tickets);

        System.out.print("\t\tData start: ");
        String date_start1= read.next();
        try {
            Date data_start = new SimpleDateFormat("yyyy-MM-dd").parse(date_start1);
            this.setDate_start(convertToLocalDateViaInstant(data_start));
        }
        catch (ParseException e){e.printStackTrace();}

        System.out.print("\t\tHour_start:\n\t\t\t Hour: ");
        int hour_s = read.nextInt();
        System.out.print("\t\t\tMinute:");
        int minute_S = read.nextInt();
        this.setHour_start(new event.Hour(hour_s,minute_S));


        System.out.print("\t\tData end:");
        String date_end1= read.next();
        try {
            Date data_end = new SimpleDateFormat("yyyy-MM-dd").parse(date_end1);
            this.setDate_end(convertToLocalDateViaInstant(data_end));
        }
        catch (ParseException e){e.printStackTrace();}
        System.out.print("\t\tHour_end:\n\t\t\t Hour: ");
        int hour_e = read.nextInt();
        System.out.print("\t\t\tMinute:");
        int minute_e = read.nextInt();
        this.setHour_end(new event.Hour(hour_e,minute_e));

        System.out.print("\t\tNumber of brack:");
        int number_of_pause= read.nextInt();
        this.setNumber_of_pause(number_of_pause);
    }

    @Override
    public String toString() {
        return "Concert:" +
                "\n\t Location name: " + getLocation().getName() +
                "\n\t Name event: " +getName_event()+
                "\n\t Number of ticket: " +getNumber_of_tickets()+
                "\n\t Data start: " + getDate_start() +
                "\n\t Hour start: " +getHour_start() +
                "\n\t Data end: " + getDate_end() +
                "\n\t Hour end: " +getHour_end() +
                "\n\t Number of break: "+getNumber_of_pause() +
                "\n\t Singer price: " + singer_price+"\n";
    }


    public String getName_of_singer() {
        return name_of_singer;
    }

    public void setName_of_singer(String name_of_singer) {
        this.name_of_singer = name_of_singer;
    }

    public String getSinger_price() {
        return singer_price.toString();
    }

    public void setSinger_price(Float singer_price) {
        this.singer_price = singer_price;
    }
}
