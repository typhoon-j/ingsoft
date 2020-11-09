package bo.ucb.edu.ingsoft.dto;

import org.springframework.stereotype.Service;

@Service
public class OrderAddress {
    private String neighbour;
    private String street;
    private String number;
    public  OrderAddress(){

    }

    public String getNeighbour() {
        return neighbour;
    }

    public void setNeighbour(String neigbour) {
        this.neighbour = neigbour;
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

    @Override
    public String toString() {
        return "OrderAddress{" +
                "neighbour='" + neighbour + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
