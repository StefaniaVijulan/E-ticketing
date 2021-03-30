package client;


import event.Concert;
import event.Event;
import event.SchoolCamp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Organizer extends Client{
    private Integer seniority_in_the_field;
    protected List<Event> events;

    public Organizer(){this.events = new ArrayList<Event>();}

    public Organizer(String first_name, String last_name, String phone_number, String email, String password, Integer seniority_in_the_field, List<Event> events) {
        super(first_name, last_name, phone_number, email, password);
        this.seniority_in_the_field = seniority_in_the_field;
        this.events = events;
    }

    public Integer getSeniority_in_the_field() {
        return seniority_in_the_field;
    }

    public void setSeniority_in_the_field(Integer seniority_in_the_field) {
        this.seniority_in_the_field = seniority_in_the_field;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void Read_Info(String last_name, String first_name, String email, String phone) {
        Scanner read = new Scanner(System.in);

        this.last_name = last_name;
        this.first_name = first_name;
        this.email = email;
        this.phone_number = phone;

        System.out.print("\tSeniority_in_the_field:");
        this.seniority_in_the_field =read.nextInt();


    }

    @Override
    public String toString() {
        return "Buyer info "+
                "\n\tFirst name: " + getFirst_name() +
                "\n\tLast name: " + getLast_name() +
                "\n\tEmail address: " + getEmail() +
                "\n\tPhone nuber: " + getPhone_number() +
                "\n\tSeniority in the field: " + seniority_in_the_field ;
    }
}