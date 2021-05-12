package client;

import java.util.Scanner;

public class Client {
    protected String first_name;
    protected String last_name;
    protected String phone_number;
    protected String email;
    protected String password;

    public  Client (){
        this.first_name="";
        this.last_name="";
        this.phone_number="";
        this.email="";
        this.password="";
    }

    public Client(String first_name, String last_name, String phone_number, String email, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    public void Read_Info(){
        Scanner read = new Scanner(System.in);

        System.out.print("\tLast name:");
        String last_name= read.nextLine();
        this.last_name = last_name;

        System.out.print("\tFirst name:");
        String first_name= read.nextLine();
        this.first_name = first_name;

        String email;
        while (true) {
            System.out.print("\tEmail address");
            email = read.nextLine();
            boolean bool = isValidEmailAddress(email);
            if (bool){
                break;
            }
            else{
                System.out.println("Sorry!Email address is not good! ");
            }}
        this.email = email;

        String phone;
        while (true){
            System.out.print("\tPhone number:");
            phone= read.nextLine();
            boolean bool = phone.matches("0[0-9]{9}");
            if(bool){
                break;
            }
            else
            {
                System.out.println("Sorry! Phone number is not good! ");
            }}
        System.out.print("\tPassword:");
        String password1 = read.nextLine();
        this.password  = password1;
    }
    @Override
    public String toString() {
        return "Client:" +
                "\n\tFirst name: " + first_name +
                "\n\tLlast name: " + last_name +
                "\n\tPhone number: " + phone_number +
                "\n\t Email: " + email + '\'' +
                '\n';
    }
}
