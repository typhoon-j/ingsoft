package bo.ucb.edu.ingsoft.dto;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CartDetailAdd {
    private Integer cartId;
    private Integer productId;
    @NotNull
    @Min(value = 1,message = "la cantidad de productos debe ser mayor a 0")
    private Integer qtty;

    public CartDetailAdd() {
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQtty() {
        return qtty;
    }

    public void setQtty(Integer qtty) {
        this.qtty = qtty;
    }

    @Override
    public String toString() {
        return "CartDetailAdd{" +
                "cartId=" + cartId +
                ", productId=" + productId +
                ", qtty=" + qtty +
                '}';
    }
}
