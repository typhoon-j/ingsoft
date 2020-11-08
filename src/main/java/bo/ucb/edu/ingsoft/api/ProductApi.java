package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.ProductAddBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.ProductAdd;
import bo.ucb.edu.ingsoft.dto.Transaction;
import bo.ucb.edu.ingsoft.model.HProduct;
import bo.ucb.edu.ingsoft.model.Product;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.slf4j.ILoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/products")
public class ProductApi {
    private ProductAddBl productAddBl;
    private TransactionBl transactionBl;

    /* private static final logger LOGGER = ILoggerFactory.getLogger(ProductApi.class); */

    @Autowired
    public ProductApi(ProductAddBl productAddBl, TransactionBl transactionBl){
        this.productAddBl = productAddBl;
        this.transactionBl = transactionBl;

    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ProductAdd createProduct(@RequestBody ProductAdd productAdd, Product product, HProduct hProduct, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        ProductAdd productResponse = productAddBl.createProduct(productAdd, product, transaction, hProduct);
        return productAdd;
    }
}
