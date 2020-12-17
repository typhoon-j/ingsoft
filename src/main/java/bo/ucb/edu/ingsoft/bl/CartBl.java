package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.CartDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.CartDetailAdd;
import bo.ucb.edu.ingsoft.dto.CartGet;
import bo.ucb.edu.ingsoft.dto.CartGetDetail;
import bo.ucb.edu.ingsoft.dto.Transaction;
import bo.ucb.edu.ingsoft.model.Cart;
import bo.ucb.edu.ingsoft.model.CartDetail;
import bo.ucb.edu.ingsoft.model.Product;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartBl {
    private CartDao cartDao;
    private TransactionDao transactionDao;


    @Autowired
    public CartBl(CartDao cartDao, TransactionDao transactionDao){
        this.cartDao = cartDao;
        this.transactionDao = transactionDao;
    }

    public CartDetailAdd createCartDetail(CartDetailAdd cartDetailAdd, CartDetail cartDetail, Product product,Cart cart, Transaction transaction){

       cartDetail.setCartId(cartDetailAdd.getCartId());
       cartDetail.setProductId(cartDetailAdd.getProductId());
       cartDetail.setQtty(cartDetailAdd.getQtty());
       cartDetail.setTxId(transaction.getTxId());
       cartDetail.setTxHost(transaction.getTxHost());
       cartDetail.setTxUserId(transaction.getTxUserId());
       cartDetail.setTxDate(transaction.getTxDate());

       cartDao.createCartDetail(cartDetail);

        return cartDetailAdd;
    }
    public List<CartGetDetail> getCartDetail(){
        return cartDao.getCartDetail();
    }

    public List<CartGet> getCart(Integer cartId){
        return  cartDao.getCart(cartId);
    }
}
