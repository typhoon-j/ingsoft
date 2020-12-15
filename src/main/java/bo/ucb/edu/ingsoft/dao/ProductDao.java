package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.ProductCategory;
import bo.ucb.edu.ingsoft.dto.ProductGetDetail;
import bo.ucb.edu.ingsoft.dto.ProductGetId;
import bo.ucb.edu.ingsoft.dto.ProductsGetAdmin;
import bo.ucb.edu.ingsoft.model.Brand;
import bo.ucb.edu.ingsoft.model.Product;
import bo.ucb.edu.ingsoft.model.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDao {

    public void createProduct(Product product);

    public void updateProduct(Product product);

    public void deleteProduct(Product product);

    public List<ProductCategory> getProductCategory(Integer categoryId);

    public List<ProductGetId>  getProductbyId(Integer productId);

    public List<ProductsGetAdmin> getProducts ();

    public List<ProductGetDetail> getProductDetail(Integer productId);
}
