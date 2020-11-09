package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.ProductAddBl;
import bo.ucb.edu.ingsoft.bl.ProductUpdateBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.ProductAdd;
import bo.ucb.edu.ingsoft.dto.ProductUpdate;
import bo.ucb.edu.ingsoft.model.Transaction;
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
    private ProductUpdateBl productUpdateBl;

    /* private static final logger LOGGER = ILoggerFactory.getLogger(ProductApi.class); */

    @Autowired
    public ProductApi(ProductAddBl productAddBl, TransactionBl transactionBl, ProductUpdateBl productUpdateBl){
        this.productAddBl = productAddBl;
        this.transactionBl = transactionBl;
        this.productUpdateBl = productUpdateBl;

    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ProductAdd createProduct(@RequestBody ProductAdd productAdd, Product product, HProduct hProduct, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        ProductAdd productResponse = productAddBl.createProduct(productAdd, product, transaction, hProduct);
        return productAdd;
    }

    @RequestMapping(value = "/student", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ProductUpdate updateProduct(@RequestBody ProductUpdate productUpdate, Product product, HProduct hProduct, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        ProductUpdate productResponse = productUpdateBl.updateProduct(productUpdate, product, transaction, hProduct);
        return productUpdate;
    }

}


