package bo.ucb.edu.ingsoft.dto;

import org.springframework.stereotype.Service;

@Service
public class OrderAddress {
    private Integer addressId;
    private String neighbour;
    private String street;
    private String number;
    private String reference;
    public OrderAddress(){

    }

    public String getNeighbour() {
        return neighbour;
    }

    public void setNeighbour(String neighbour) {
        this.neighbour = neighbour;
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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "OrderAddress{" +
                "addressId='" + addressId + '\'' +
                ", neighbour='" + neighbour + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}
