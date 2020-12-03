package bo.ucb.edu.ingsoft.dto;

import org.springframework.stereotype.Service;

@Service
public class OrderAddress {
    private Integer neighbourId;
    private String street;
    private String number;
    private String reference;
    public OrderAddress(){

    }

    public Integer getNeighbourId() {
        return neighbourId;
    }

    public void setNeighbourId(Integer neighbourId) {
        this.neighbourId = neighbourId;
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

    @Override
    public String toString() {
        return "OrderAddress{" +
                "neighbourId=" + neighbourId +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}
