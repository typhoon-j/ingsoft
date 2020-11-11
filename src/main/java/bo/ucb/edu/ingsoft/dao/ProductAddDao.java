package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.ProductDelete;
import bo.ucb.edu.ingsoft.dto.ProductUpdate;
import bo.ucb.edu.ingsoft.model.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductAddDao {
    public void create(Product product);

    public void updateProduct(ProductUpdate productUpdate);

    public void deleteProduct(ProductDelete productDelete);
}
