package event;

import location.Location;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class TheatricalPiece extends Event{
    private String theme;
    private String name_of_team;
    private Float price_of_team;


    //Tickets
    public Type_ticket type_ticket;

    public TheatricalPiece(){}

    public TheatricalPiece(Integer idEvent, Location location, String name_event, Integer number_of_tickets, LocalDate date_start, LocalDate date_end, Hour hour_start, Hour hour_end, Integer number_of_pause, String theme, String name_of_team, Float price_of_team, Type_ticket type_ticket) {
        super(idEvent, location, name_event, number_of_tickets, date_start, date_end, hour_start, hour_end, number_of_pause);
        this.theme = theme;
        this.name_of_team = name_of_team;
        this.price_of_team = price_of_team;
        this.type_ticket = type_ticket;
    }

    @Override
    public void Read_Info() {
        Scanner read = new Scanner(System.in);

        System.out.print("\t\tTheatrical piece name:");
        String event_name= read.nextLine();
        this.setName_event(event_name);

        System.out.print("\t\tTheme:");
        String theme= read.nextLine();
        this.theme = theme;

        System.out.print("\t\tThe name of the team of actors :");
        String name= read.nextLine();
        this.name_of_team=  name;

        System.out.print("\t\tPrice of team:");
        Float price= read.nextFloat();
        this.price_of_team =price;

        System.out.print("\t\tNumber of tickets:");
        int number_tickets= read.nextInt();
        this.setNumber_of_tickets(number_tickets);

        System.out.println("\t\tType of ticket\n\t\t\t1. VIP \n\t\t\t 2. Normal\n\t\tAnswer: ");
        String type= read.nextLine();
        type = type.toUpperCase();
        if (type.equals("VIP")){
            this.type_ticket = Type_ticket.VIP;
        } else if (type.equals("NORMAL")){
            this.type_ticket = Type_ticket.NORMAL;
        }
        else{
            System.out.print("\n\t\tSorry! Try again");

        }
        System.out.print("\t\tData start: ");
        String date_start1= read.next();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate data_start = LocalDate.parse(date_start1, dateTimeFormatter);
        this.setDate_start(data_start);

        System.out.print("\t\tHour_start:\n\t\t\t Hour: ");
        int hour_s = read.nextInt();
        System.out.print("\t\t\tMinute:");
        int minute_S = read.nextInt();
        this.setHour_start(new Hour(hour_s,minute_S));



        System.out.print("\t\tData end:");
        String date_end1= read.next();
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate data_end = LocalDate.parse(date_end1, dateTimeFormatter1);
        this.setDate_end(data_end);

        System.out.print("\t\tHour_end:\n\t\t\t Hour: ");
        int hour_e = read.nextInt();
        System.out.print("\t\t\tMinute:");
        int minute_e = read.nextInt();
        this.setHour_start(new Hour(hour_e,minute_e));

        System.out.print("\t\tNumber of brack:");
        int number_of_pause= read.nextInt();
        this.setNumber_of_pause(number_of_pause);


    }


    @Override
    public String toString() {
        return "TheatricalPiece: " +
                "\n\t Location name: " + getLocation() +
                "\n\t Name event: " +getName_event()+
                "\n\t Number of ticket: " +getNumber_of_tickets()+
                "\n\t Data start: " + getDate_start() +
                "\n\t Hour start: " +getHour_start() +
                "\n\t Data end: " + getDate_end() +
                "\n\t Hour end: " +getHour_end() +
                "\n\t Number of break: "+getNumber_of_pause() +
                "\n\t Theme: " + theme  +
                "\n\t Name of team: " + name_of_team+
                "\n\t Price of team: " + price_of_team +
                "\n\t Type ticket=" + type_ticket +"\n";
    }
    public float ticket_value() {
        float price_ticket;
        price_ticket = (this.getLocation().price_location() + price_of_team ) / getNumber_of_tickets();
        return price_ticket;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getName_of_team() {
        return name_of_team;
    }

    public void setName_of_team(String name_of_team) {
        this.name_of_team = name_of_team;
    }

    public Float getPrice_of_team() {
        return price_of_team;
    }

    public void setPrice_of_team(Float price_of_team) {
        this.price_of_team = price_of_team;
    }

    public Type_ticket getType_ticket() {
        return type_ticket;
    }

    public void setType_ticket(Type_ticket type_ticket) {
        this.type_ticket = type_ticket;
    }
}
