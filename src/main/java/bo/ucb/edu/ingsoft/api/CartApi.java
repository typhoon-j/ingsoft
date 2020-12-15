package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.CartBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.CartDetailAdd;
import bo.ucb.edu.ingsoft.dto.CartGetDetail;
import bo.ucb.edu.ingsoft.dto.ProductCategory;
import bo.ucb.edu.ingsoft.dto.Transaction;
import bo.ucb.edu.ingsoft.model.*;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController

public class CartApi {
    private TransactionBl transactionBl;
    private CartBl cartBl;


    @Autowired
    public CartApi(TransactionBl transactionBl, CartBl cartBl){
        this.transactionBl = transactionBl;
        this.cartBl = cartBl;
    }

    @RequestMapping(value = "/cartDetail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    //@CrossOrigin(origins = "http://localhost:4200")
    public CartDetailAdd createCartDetail(@RequestBody CartDetailAdd cartDetailAdd, CartDetail cartDetail, Product product, Cart cart, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        CartDetailAdd cartResponse = cartBl.createCartDetail(cartDetailAdd,cartDetail,product,cart, transaction);
        return cartResponse;
    }

    @RequestMapping(value = "/cartDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<CartGetDetail> getCartDetail(HttpServletRequest request) {
        return cartBl.getCartDetail();
    }
}
