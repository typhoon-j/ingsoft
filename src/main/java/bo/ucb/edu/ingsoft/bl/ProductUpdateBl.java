package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.HProductDao;
import bo.ucb.edu.ingsoft.dao.ProductAddDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.ProductUpdate;
import bo.ucb.edu.ingsoft.model.HProduct;
import bo.ucb.edu.ingsoft.model.Product;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public class ProductUpdateBl {
    private ProductAddDao productAddDao;
    private TransactionDao transactionDao;
    private HProductDao hProductDao;
    public ProductUpdateBl(ProductAddDao productAddDao, TransactionDao transactionDao, HProductDao hProductDao){
        this.hProductDao = hProductDao;
        this.productAddDao = productAddDao;
        this.transactionDao = transactionDao;
    }
    public ProductUpdate updateProduct(ProductUpdate productUpdate, Product product, Transaction transaction, HProduct hProduct){
        productAddDao.updateProduct(productUpdate);

        hProduct.setProductId(product.getProductId());
        hProduct.setBrand(product.getBrand());
        hProduct.setModel(product.getModel());
        hProduct.setPrice(product.getPrice());
        hProduct.setDescription(product.getDescription());
        hProduct.setStock(product.getStock());
        hProduct.setTxId(transaction.getTxId());
        hProduct.setTxUserId(transaction.getTxUserId());
        hProduct.setTxHost(transaction.getTxHost());
        hProduct.setTxDate(transaction.getTxDate());
        hProductDao.createHProduct(hProduct);

        return productUpdate;
    }
}
