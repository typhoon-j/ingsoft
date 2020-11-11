package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.ProductBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.ProductAdd;
import bo.ucb.edu.ingsoft.dto.ProductDelete;
import bo.ucb.edu.ingsoft.dto.ProductUpdate;
import bo.ucb.edu.ingsoft.dto.Transaction;
import bo.ucb.edu.ingsoft.model.Product;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/products")
public class ProductApi {
    private TransactionBl transactionBl;
    private ProductBl productBl;

    @Autowired
    public ProductApi(TransactionBl transactionBl,ProductBl productBl){
        this.transactionBl = transactionBl;
        this.productBl = productBl;
    }

    @RequestMapping( method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ProductAdd createProduct(@RequestBody ProductAdd productAdd, Product product, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        ProductAdd productResponse = productBl.createProduct(productAdd, product, transaction);
        return productResponse;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ProductUpdate updateProduct(@RequestBody ProductUpdate productUpdate,Product product, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        ProductUpdate productResponse = productBl.updateProduct(productUpdate,transaction, product);
        return productResponse;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public Product deleteProduct (@RequestBody Product product, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        Product productResponse = productBl.deleteProduct( transaction, product);
        return productResponse;
    }

}
