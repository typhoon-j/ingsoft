package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.ProductDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;

import bo.ucb.edu.ingsoft.dto.*;
import bo.ucb.edu.ingsoft.model.Brand;
import bo.ucb.edu.ingsoft.model.Product;
import bo.ucb.edu.ingsoft.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBl {
    private ProductDao productDao;
    private TransactionDao transactionDao;

    @Autowired
    public ProductBl(ProductDao productDao, TransactionDao transactionDao){
        this.productDao = productDao;
        this.transactionDao = transactionDao;
    }

    public ProductAdd createProduct(ProductAdd productAdd, Product product, Brand brand, Tag tag, Transaction transaction){

        brand.setName(productAdd.getBrand());
        brand.setTxId(transaction.getTxId());
        brand.setTxHost(transaction.getTxHost());
        brand.setTxUserId(transaction.getTxUserId());
        brand.setTxDate(transaction.getTxDate());
        productDao.createBrand(brand);
        Integer brandId = transactionDao.getLastInsertId();
        product.setBrandId(brandId);

        tag.setCategory(productAdd.getCategory());
        tag.setTxId(transaction.getTxId());
        tag.setTxHost(transaction.getTxHost());
        tag.setTxUserId(transaction.getTxUserId());
        tag.setTxDate(transaction.getTxDate());
        productDao.createTag(tag);
        Integer tagId = transactionDao.getLastInsertId();
        product.setTagId(tagId);

        product.setProductName(productAdd.getProductName());
        product.setDetail(productAdd.getDetail());
        product.setModel(productAdd.getModel());
        product.setPrice(productAdd.getPrice());
        product.setDescription(productAdd.getDescription());
        product.setStock(productAdd.getStock());
        product.setStoreAvailable(productAdd.getStoreAvailable());
        product.setDeliveryAvailable(productAdd.getDeliveryAvailable());
        product.setImage(productAdd.getImage());
        product.setTxId(transaction.getTxId());
        product.setTxHost(transaction.getTxHost());
        product.setTxUserId(transaction.getTxUserId());
        product.setTxDate(transaction.getTxDate());
        productDao.createProduct(product);
        return productAdd;
    }
    public ProductUpdate updateProduct(ProductUpdate productUpdate, Transaction transaction, Product product, Integer productId){
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

    public ProductDelete deleteProduct(ProductDelete productDelete, Transaction transaction, Product product, Integer productId){

        product.setTxStatus(productDelete.getTxStatus());
        product.setProductId(productId);
        product.setTxDate(transaction.getTxDate());
        product.setTxUserId(transaction.getTxUserId());
        product.setTxHost(transaction.getTxHost());
        product.setTxId(transaction.getTxId());
        productDao.deleteProduct(product);

        return productDelete;
    }

    public List<ProductGetId> getProductId(Integer productId)
    {

        return productDao.getProductbyId(productId);

    }


}
