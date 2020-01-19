public class Address {
    private String street;
    private String houseNum;
    private String apartNum;
    private String postcode;
    private String postOffice;

    public Address(String street, String houseNum, String apartNum, String postcode, String postOffice) {
        this.street = street;
        this.houseNum = houseNum;
        this.apartNum = apartNum;
        this.postcode = postcode;
        this.postOffice = postOffice;
    }

    @Override
    public String toString() {
        return "Address: " +
                "street = '" + street + '\'' +
                ", houseNum = '" + houseNum + '\'' +
                ", apartNum = '" + apartNum + '\'' +
                ", postcode = '" + postcode + '\'' +
                ", postOffice = '" + postOffice + '\'';
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getApartNum() {
        return apartNum;
    }

    public void setApartNum(String apartNum) {
        this.apartNum = apartNum;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }
}
