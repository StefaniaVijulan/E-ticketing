package model.location;

public abstract class Location {
  //  private static Integer IdLocation= 0;
    private Zone zone;
    private String name;
    private String country;
    private String town;
    private String street;
    private String number;

    public Location() { }

    public Location(Zone zone, String name, String country, String town, String street, String number) {
        this.zone = zone;
        this.name = name;
        this.country = country;
        this.town = town;
        this.street = street;
        this.number = number;
        //this.IdLocation +=1;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Zone getZone() {
        return zone;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getTown() {
        return town;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }


    abstract public void Read_Info();
}
