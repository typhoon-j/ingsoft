package bo.ucb.edu.ingsoft.dto;

import java.math.BigDecimal;

public class CartGet {
    private BigDecimal total;
    public CartGet(){

    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CartGet{" +
                "total=" + total +
                '}';
    }
}
