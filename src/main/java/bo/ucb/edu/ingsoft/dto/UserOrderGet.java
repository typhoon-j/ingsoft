package bo.ucb.edu.ingsoft.dto;

import java.util.Date;

public class UserOrderGet {

    private Integer orderId;
    private Date date;
    private Integer state;

    public UserOrderGet(){
    }

    public Integer getOrderId() { return orderId; }
    public void setOrderId(Integer orderId) { this.orderId = orderId; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public Integer getState() { return state; }
    public void setState(Integer state) { this.state = state; }

    @Override
    public String toString() {
        return "UserOrderGet{" +
                "orderId=" + orderId +
                ", date=" + date +
                ", state=" + state +
                '}';
    }
}
