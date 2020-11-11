package bo.ucb.edu.ingsoft.dto;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductUpdate {

    private BigDecimal price;
    private Integer stock;

    public ProductUpdate(){

    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ProductUpdate{" +
                "price=" + price +
                ", stock=" + stock +
                '}';
    }
}
