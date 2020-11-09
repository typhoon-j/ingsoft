package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.MakeOrderBl;
import bo.ucb.edu.ingsoft.bl.ProductAddBl;
import bo.ucb.edu.ingsoft.bl.ProductUpdateBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.MakeOrder;
import bo.ucb.edu.ingsoft.dto.ProductAdd;
import bo.ucb.edu.ingsoft.model.HProduct;
import bo.ucb.edu.ingsoft.model.Product;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/order")
public class MakeOrderApi {
    private ProductAddBl productAddBl;
    private TransactionBl transactionBl;
    private MakeOrderBl makeOrderBl;

    /* private static final logger LOGGER = ILoggerFactory.getLogger(ProductApi.class); */

    @Autowired
    public MakeOrderApi(ProductAddBl productAddBl, TransactionBl transactionBl, ProductUpdateBl productUpdateBl){
        this.productAddBl = productAddBl;
        this.transactionBl = transactionBl;
        this.makeOrderBl= makeOrderBl;

    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public MakeOrder createMakeOrder(@RequestBody ProductAdd productAdd, Product product, HProduct hProduct, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        MakeOrder orderResponse = productAddBl.createProduct(productAdd, product, transaction, hProduct);
        return productAdd;
    }
}
