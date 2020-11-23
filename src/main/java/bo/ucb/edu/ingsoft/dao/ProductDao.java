package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.ProductGetId;
import bo.ucb.edu.ingsoft.model.Brand;
import bo.ucb.edu.ingsoft.model.Product;
import bo.ucb.edu.ingsoft.model.Tag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao {
    public void createBrand(Brand brand);

    public void createTag(Tag tag);
    public void createProduct(Product product);

    public void updateProduct(Product product);

    public void deleteProduct(Product product);

    public ProductGetId getProductbyId(Integer productId);
}
