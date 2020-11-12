package bo.ucb.edu.ingsoft.api;


import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.bl.VoucherBl;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/products")
public class VoucherApi {
    private TransactionBl transactionBl;
    private VoucherBl voucherBl;

    @Autowired
    public VoucherApi(TransactionBl transactionBl, VoucherBl voucherBl){
        this.transactionBl = transactionBl;
        this.voucherBl = voucherBl;
    }
/*
    @RequestMapping( method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ProductAdd createProduct(@RequestBody ProductAdd productAdd, Product product, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        ProductAdd productResponse = productBl.createProduct(productAdd, product, transaction);
        return productResponse;
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ProductUpdate updateProduct(@RequestBody ProductUpdate productUpdate,Product product, HttpServletRequest request, @PathVariable int productId){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        ProductUpdate productResponse = productBl.updateProduct(productUpdate,transaction, product, productId);
        return productResponse;
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDelete deleteProduct (@RequestBody ProductDelete productDelete, Product product, HttpServletRequest request, @PathVariable int productId){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        ProductDelete productResponse = productBl.deleteProduct(productDelete, transaction, product, productId);
        return productResponse;
    }*/

}
