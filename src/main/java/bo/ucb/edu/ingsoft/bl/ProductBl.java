package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.ProductDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.*;
import bo.ucb.edu.ingsoft.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductBl {
    private ProductDao productDao;
    private TransactionDao transactionDao;

    @Autowired
    public ProductBl(ProductDao productDao, TransactionDao transactionDao){
        this.productDao = productDao;
        this.transactionDao = transactionDao;
    }

    public ProductAdd createProduct(ProductAdd productAdd, Product product, Transaction transaction){
        product.setBrand(productAdd.getBrand());
        product.setModel(productAdd.getModel());
        product.setPrice(productAdd.getPrice());
        product.setDescription(productAdd.getDescription());
        product.setStock(productAdd.getStock());
        product.setTxId(transaction.getTxId());
        product.setTxHost(transaction.getTxHost());
        product.setTxUserId(transaction.getTxUserId());
        product.setTxDate(transaction.getTxDate());
        productDao.createProduct(product);
        Integer getLastId = transactionDao.getLastInsertId();
        product.setProductId(getLastId);

        return productAdd;
    }
    public ProductUpdate updateProduct(ProductUpdate productUpdate,Transaction transaction, Product product, Integer productId){
        product.setProductId(productId);
        product.setTxDate(transaction.getTxDate());
        product.setTxUserId(transaction.getTxUserId());
        product.setTxHost(transaction.getTxHost());
        product.setTxId(transaction.getTxId());
        product.setStock(productUpdate.getStock());
        product.setPrice(productUpdate.getPrice());
        productDao.updateProduct(product);

        return productUpdate;
    }

    public Product deleteProduct(  Transaction transaction, Product product, Integer productId){

        product.setProductId(productId);
        product.setTxDate(transaction.getTxDate());
        product.setTxUserId(transaction.getTxUserId());
        product.setTxHost(transaction.getTxHost());
        product.setTxId(transaction.getTxId());
        productDao.deleteProduct(product);

        return product;
    }


}
