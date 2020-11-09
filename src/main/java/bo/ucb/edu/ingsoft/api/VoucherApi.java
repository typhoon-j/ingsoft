package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.ProductAddBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.bl.VoucherAddBl;
import bo.ucb.edu.ingsoft.dto.ProductAdd;
import bo.ucb.edu.ingsoft.dto.Transaction;
import bo.ucb.edu.ingsoft.model.HProduct;
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
@RequestMapping(value = "/voucher")
public class VoucherApi {
    private VoucherAddBl voucherAddBl;
    private TransactionBl transactionBl;

    /* private static final logger LOGGER = ILoggerFactory.getLogger(ProductApi.class); */

    @Autowired
    public VoucherApi(VoucherAddBl voucherAddBl, TransactionBl transactionBl){
        this.voucherAddBl = voucherAddBl;
        this.transactionBl = transactionBl;

    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public VoucherAdd createProduct(@RequestBody VoucherAdd voucherAdd, Voucher voucher, HVoucher hVoucher, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        VoucherAdd voucherResponse = voucherAddBl.createProduct(voucherAdd, voucher, transaction, hVoucher);
        return voucherAdd;
    }
}
