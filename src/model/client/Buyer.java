package model.client;

import java.util.Scanner;

public class Buyer extends Client{

    private Integer age;
    public Buyer() {}

    public Buyer(String first_name, String last_name, String phone_number, String email, String password, Integer age) {
        super(first_name, last_name, phone_number, email, password);
        this.age = age;
    }

    public void Read_Info(String last_name, String first_name, String email, String phone, String password){
        Scanner read = new Scanner(System.in);


        this.last_name = last_name;
        this.first_name = first_name;
        this.email = email;
        this.phone_number = phone;
        this.password = password;
        System.out.print("\tAge:");
        this.age =read.nextInt();

    }
    @Override
    public String toString() {
        return "Buyer info "+
                "\n\tFirst name: " + getFirst_name() +
                "\n\tLast name: " + getLast_name() +
                "\n\tEmail address: " + getEmail() +
                "\n\tPhone nuber: " + getPhone_number() +
                "\n\tAge: " + age ;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}
