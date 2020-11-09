package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.HProductDao;
import bo.ucb.edu.ingsoft.dao.ProductAddDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.ProductAdd;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.model.HProduct;
import bo.ucb.edu.ingsoft.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductAddBl {
    private ProductAddDao productAddDao;
    private TransactionDao transactionDao;
    private HProductDao hProductDao;

    @Autowired
    public ProductAddBl (ProductAddDao productAddDao, HProductDao hProductDao, TransactionDao transactionDao){
        this.productAddDao = productAddDao;
        this.transactionDao = transactionDao;
        this.hProductDao = hProductDao;
    }
    public ProductAdd createProduct(ProductAdd productAdd, Product product, Transaction transaction, HProduct hProduct){
        product.setBrand(productAdd.getBrand());
        product.setModel(productAdd.getModel());
        product.setPrice(productAdd.getPrice());
        product.setDescription(productAdd.getDescription());
        product.setStock(productAdd.getStock());
        product.setTxId(transaction.getTxId());
        product.setTxUserId(transaction.getTxUserId());
        product.setTxHost(transaction.getTxHost());
        product.setTxDate(transaction.getTxDate());
        productAddDao.create(product);
        Integer getLastId = transactionDao.getLastInsertId();
        product.setProductId(getLastId);

        hProduct.setProductId(product.getProductId());
        hProduct.setBrand(productAdd.getBrand());
        hProduct.setModel(productAdd.getModel());
        hProduct.setPrice(productAdd.getPrice());
        hProduct.setDescription(productAdd.getDescription());
        hProduct.setStock(productAdd.getStock());
        hProduct.setTxId(transaction.getTxId());
        hProduct.setTxUserId(transaction.getTxUserId());
        hProduct.setTxHost(transaction.getTxHost());
        hProduct.setTxDate(transaction.getTxDate());
        hProductDao.createHProduct(hProduct);

        return productAdd;
    }
}
