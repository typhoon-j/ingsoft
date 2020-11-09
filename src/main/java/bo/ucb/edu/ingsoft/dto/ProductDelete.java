package bo.ucb.edu.ingsoft.dto;

public class ProductDelete {
    private Integer productId;

    public ProductDelete(){

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ProductDelete{" +
                "productId=" + productId +
                '}';
    }
}
