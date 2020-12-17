package bo.ucb.edu.ingsoft.dto;

import java.util.Date;

public class OrderAdd {
    private Integer neighbourId;
    private String street;
    private String number;
    private String reference;
    private Integer cartId;
    private Integer status;
    private Integer state;
    public OrderAdd(){

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

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "OrderAdd{" +
                "neighbourId=" + neighbourId +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", reference='" + reference + '\'' +
                ", cartId=" + cartId +
                ", status=" + status +
                ", state=" + state +
                '}';
    }
}
