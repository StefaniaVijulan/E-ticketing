package service.modelService;

import model.client.Buyer;
import model.client.Client;
import model.client.Login;
import model.client.Organizer;
import service.csvService.CSVAudit;
import service.csvService.CSVRead;
import service.csvService.CSVWrite;

import java.io.IOException;
import java.util.Scanner;

public class LoginService {
    private static LoginService single_instance = null;
    private CSVAudit csvAudit;
    private CSVWrite csvWrite;
    private CSVRead csvRead;
    private Login login;
    private Client curent;
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    private LoginService() throws IOException {
        this.csvAudit = CSVAudit.getInstance();
        this.csvWrite = CSVWrite.getInstance();
        this.csvRead = CSVRead.getInstance();
        this.login = Login.getInstance();
    }
    public static synchronized LoginService getInstance() throws IOException {
        if (single_instance == null){
            single_instance = new LoginService();
        }
        return single_instance;
    }
    public int logIn() throws IOException {
        //LOgIn
        login = Login.getInstance();
        int type=0;
        while (true) {
            Scanner read = new Scanner(System.in);
            System.out.print("What do you want to do?\n\t\t1. Register\n\t\t2. Log In\nAnswer: ");
            String connection = read.nextLine();
            connection.toUpperCase();
            if (connection.equalsIgnoreCase("LOG IN")) {
                //LogIn

                System.out.print("Email: ");
                String email = read.nextLine();
                if (isValidEmailAddress(email))
                {System.out.print("Password: ");
                    String password = read.nextLine();

                    if (login.signIn(email, password)) {
                       csvAudit.write_in_audit("Login", "");
                        System.out.println("Login successfully");
                        curent =login.getCurent();
                        if (email.equals("admin@gmail.com"))
                            type=1;
                        break;
                    }
                    else {
                        System.out.println("Sorry, login unsuccessfully, because "+email+" doesn't exists! Try again!");

                    }}

            } else if (connection.equalsIgnoreCase("REGISTER")) {
                //Register

                Client client = new Client();
                client.Read_Info();
                if(login.signUp(client))
                {   csvAudit.write_in_audit("Register","");
                    System.out.println("Registration succssefully");
                    curent=client;
                }
                else
                    System.out.println("You are already signed");

            }
            else{
                System.out.println("You must LogIn or Register before attempting any other actions");
            }
        }
        return type;
    }
    public String getCurentClientEmail(){
        return curent.getEmail();
    }
    public void logOut() throws IOException {
        //delogare
        csvAudit.write_in_audit("Log","Off");
        login.setCurent(null);
        System.out.println("Thanks for your time! I hope i will see you soon!");
    }
    public Buyer AddBuyer() throws IOException {
        csvAudit.write_in_audit("Add","Buyer");
        Buyer buyer = new Buyer();
        buyer.Read_Info(curent.getLast_name(), curent.getFirst_name(), curent.getEmail(), curent.getPhone_number(), curent.getPassword());//DE FACUT CU PARAMETRII
        try {
            csvWrite.write_in_csv(buyer, "client/buyer");
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
        csvRead.getBuyers().add(buyer);
        return buyer;
    }
    public Organizer AddOrganizer() throws IOException {
        csvAudit.write_in_audit("Add","Organizer");
        Organizer organizer = new Organizer();
        organizer.Read_Info(curent.getLast_name(), curent.getFirst_name(), curent.getEmail(), curent.getPhone_number(), curent.getPassword());
      /*  try {
            write_in_csv(organizer, "organizer");
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }*/
        csvRead.getOrganizers().add(organizer);
        return organizer;
    }
}
