package bo.ucb.edu.ingsoft.bl;


import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dao.VoucherDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoucherBl {
    private VoucherDao voucherDao;
    private TransactionDao transactionDao;

    @Autowired
    public VoucherBl(VoucherDao voucherDao, TransactionDao transactionDao){
        this.voucherDao = voucherDao;
        this.transactionDao = transactionDao;
    }

   /* public ProductAdd createProduct(ProductAdd productAdd, Product product, Transaction transaction){
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

    public ProductDelete deleteProduct(ProductDelete productDelete,  Transaction transaction, Product product, Integer productId){

        product.setTxStatus(productDelete.getTxStatus());
        product.setProductId(productId);
        product.setTxDate(transaction.getTxDate());
        product.setTxUserId(transaction.getTxUserId());
        product.setTxHost(transaction.getTxHost());
        product.setTxId(transaction.getTxId());
        productDao.deleteProduct(product);

        return productDelete;
    }

*/
}
