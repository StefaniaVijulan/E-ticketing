package location;

abstract public class Location {
    private Zone zone;
    private String name;
    private String country;
    private String town;
    private String street;
    private String number;

    public Location(){};
    public Location(Zone zone, String name, String country, String town, String street, String number) {
        this.zone = zone;
        this.name = name;
        this.country = country;
        this.town = town;
        this.street = street;
        this.number = number;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    abstract public void Read_Info();
    abstract public float price_location();
}
