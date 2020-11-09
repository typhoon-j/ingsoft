package bo.ucb.edu.ingsoft.dto;

public class Address {
    private Integer addressId;
    private String street1;
    private String street2;
    private String number;
    private String reference;

    public Address(){
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street1='" + street1 + '\'' +
                ", street2='" + street2 + '\'' +
                ", number='" + number + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}
