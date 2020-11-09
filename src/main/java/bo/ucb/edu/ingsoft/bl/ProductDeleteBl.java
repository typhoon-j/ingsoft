package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.ProductAddDao;
import bo.ucb.edu.ingsoft.dto.ProductDelete;
import org.springframework.stereotype.Service;

@Service
public class ProductDeleteBl {
    private ProductAddDao productAddDao;

    public ProductDeleteBl(ProductAddDao productAddDao){
        this.productAddDao = productAddDao;
    }
    public ProductDelete deleteProduct(ProductDelete productDelete){
        productAddDao.deleteProduct(productDelete);
        return productDelete;
    }
}
