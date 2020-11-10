package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.HProductDao;
import bo.ucb.edu.ingsoft.dao.ProductAddDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.MakeOrder;
import bo.ucb.edu.ingsoft.dto.ProductAdd;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.model.HProduct;
import bo.ucb.edu.ingsoft.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MakeOrderBl {
    private ProductAddDao productAddDao;
    private TransactionDao transactionDao;

    @Autowired
    public MakeOrderBl(ProductAddDao productAddDao, TransactionDao transactionDao) {
        this.productAddDao = productAddDao;
        this.transactionDao = transactionDao;

    }
}