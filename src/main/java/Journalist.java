public class Journalist {

    private final Integer cpr;
    private final String firstName;
    private final String lastName;
    private final String streetName;
    private final Integer civicNumber;

    private final String city;
    private final Integer zipCode;
    private final String country;

    public Journalist(Integer cpr, String firstName, String lastName, String streetName, Integer civicNumber, String city, Integer zipCode, String country) {
        this.cpr = cpr;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetName = streetName;
        this.civicNumber = civicNumber;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }

    public Integer getCPR() { return cpr; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetName() {
        return streetName;
    }

    public Integer getCivicNumber() {
        return civicNumber;
    }

    public Integer getZIPCode() { return zipCode; }

    public String getCountry() {
        return country;
    }


    @Override
    public String toString() {
        final String D = "','";

        return "('" + getCPR() + D + getFirstName() + D + getLastName() + D + getStreetName() + D + getCivicNumber() + D + getZIPCode() + D + getCountry() + "')";
    }

}

