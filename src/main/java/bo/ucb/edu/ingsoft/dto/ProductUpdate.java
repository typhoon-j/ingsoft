package bo.ucb.edu.ingsoft.dto;

import org.springframework.stereotype.Service;

@Service
public class ProductUpdate {
    private Integer price;
    private Integer stock;

    public ProductUpdate(){

    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
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
