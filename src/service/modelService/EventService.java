package service.modelService;

import model.client.Organizer;
import model.event.*;
import service.csvService.CSVAudit;
import service.csvService.CSVRead;
import service.csvService.CSVWrite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventService {
    private static EventService single_instance_event =null;
    public CSVRead csvRead = CSVRead.getInstance();
    public CSVAudit csvAudit = CSVAudit.getInstance();
    public CSVWrite csvWrite = CSVWrite.getInstance();


    public static EventService getInstance() throws IOException {
        if (single_instance_event == null){
            single_instance_event = new EventService();
        }
        return single_instance_event;
    }

    private EventService() throws IOException {    }
    public void AddEvent(Organizer organizer) throws IOException {
        csvAudit.write_in_audit("Add","Event");
        Event event= null;
        Scanner read1 = new Scanner(System.in);
        System.out.println("\t\tWhat type of event do you want to add?\n\t\t\t1. Concert\n\t\t\t2. School camp \n\t\t\t3. Street food");
        System.out.print("\t\t\tAnswer: ");
        String types= read1.nextLine();
        types=types.toUpperCase();
        if (types.equals("CONCERT")) {
            Concert concert = new Concert();
            concert.Read_Info();
            event = (Event) concert;
            System.out.println(concert);
            try {
                csvWrite.write_in_csv(concert, "events/concert");
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
            csvRead.getConcerts().add(concert);

        }
        else if (types.equals("SCHOOP CAMP"))
        {
            SchoolCamp schoolCamp = new SchoolCamp();
            event = (Event) schoolCamp;
            try {
                csvWrite.write_in_csv(schoolCamp, "events/schoolcamp");
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
            csvRead.getSchoolCamps().add(schoolCamp);

        }
        else if (types.equals("STREET FOOD")){
            StreetFood streetFood = new StreetFood();
            event = (Event) streetFood;
            try {
                csvWrite.write_in_csv(streetFood, "events/streetfood");
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }

            csvRead.getStreetFoods().add(streetFood);
        }
        else if (types.equals("THEATRICAL PIECE")){
            TheatricalPiece theatricalPiece = new TheatricalPiece();
            event = (Event) theatricalPiece;
            try {
                csvWrite.write_in_csv(theatricalPiece, "theatricalpiece");
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
            csvRead.getTheatricalPieces().add(theatricalPiece);

        }
        else{
            System.out.println("Try again");
        }
        organizer.setEvents(event);
    }
    public void SeeEvent() throws IOException {
        Scanner read1 = new Scanner(System.in);
        csvAudit.write_in_audit("See","Events");

        System.out.println("What kind of events do you want to see?");
        System.out.println("\t1. Concert\n\t2. StreetFood\n\t3. SchoolCamp\n\t4. TheatricalPiece");
        System.out.print("\t\tAnswer: ");
        String types1= read1.nextLine();
        types1=types1.toUpperCase();
        if(types1.equals("CONCERT") || types1.equals("1")){
            for(int i=0; i<csvRead.getConcerts().size(); i++) {
                System.out.println(csvRead.getConcerts().get(i).toString());
            }
        }
        else if (types1.equals("STREETFOOD") ||types1.equals("2")){
            for(int i=0; i<csvRead.getStreetFoods().size(); i++) {
                System.out.println(csvRead.getStreetFoods().get(i).toString());
            }
        }
        else if (types1.equals("SCHOOLCAMP") ||types1.equals("3")){
            for(int i=0; i<csvRead.getSchoolCamps().size(); i++) {
                System.out.println(csvRead.getSchoolCamps().get(i).toString());
            }
        }
        else if (types1.equals("THEATRICALPIECE") ||types1.equals("4")){
            for(int i=0; i<csvRead.getTheatricalPieces().size(); i++) {
                System.out.println(csvRead.getTheatricalPieces().get(i).toString());
            }
        }
    }
    public void SeeOneEvent()throws IOException {
        csvAudit.write_in_audit("See","Event");
        System.out.print("The name of the event you want to see: ");
        Scanner read1 = new Scanner(System.in);
        String name_ev = read1.nextLine();
        for(int i=0; i<csvRead.getLocations().size(); i++){
            if (csvRead.getLocations().get(i).getName().toUpperCase().equals(name_ev.toUpperCase())){
                System.out.println(csvRead.getLocations().get(i));
            }
        }
    }
}
