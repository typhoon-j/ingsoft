package bo.ucb.edu.ingsoft.dto;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductGetId {
   /* private Integer productId;*/
    private String brand;
    private String model;
    private BigDecimal price;
    private String description;
    public ProductGetId(){

    }
/*
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
*/
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductGetId{" +
               /* "productId=" + productId +*/
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
