package bo.ucb.edu.ingsoft.dto;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MakeOrder {
    private Integer orderId;
    private Integer productId;
    private Integer userId;
    private Integer deliveryId;
    private Integer addressId;
    private Date date;
    private Integer status;
    private Float total;

    public MakeOrder() {

    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "MakeOrder{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                ", userId=" + userId +
                ", deliveryId=" + deliveryId +
                ", addressId=" + addressId +
                ", date=" + date +
                ", status=" + status +
                ", total=" + total +
                '}';
    }
}
