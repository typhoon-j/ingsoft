package bo.ucb.edu.ingsoft.api;


import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.bl.VoucherBl;
import bo.ucb.edu.ingsoft.dto.Transaction;
import bo.ucb.edu.ingsoft.dto.VoucherDelete;
import bo.ucb.edu.ingsoft.dto.VoucherUpdate;
import bo.ucb.edu.ingsoft.model.Voucher;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/")
public class VoucherApi {
    private TransactionBl transactionBl;
    private VoucherBl voucherBl;

    @Autowired
    public VoucherApi(TransactionBl transactionBl, VoucherBl voucherBl){
        this.transactionBl = transactionBl;
        this.voucherBl = voucherBl;
    }



    @RequestMapping(value = "/{productId}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public VoucherUpdate updateProduct(@RequestBody VoucherUpdate voucherUpdate, Voucher voucher, HttpServletRequest request, @PathVariable int voucherId){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        VoucherUpdate voucherResponse = voucherBl.updateVoucher(voucherUpdate,transaction, voucher, voucherId);
        return voucherResponse;
    }

    @RequestMapping(value = "/{voucherId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public VoucherDelete deleteVoucher (@RequestBody VoucherDelete voucherDelete, Voucher voucher, HttpServletRequest request, @PathVariable int voucherId){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        VoucherDelete voucherResponse = voucherBl.deleteVoucher(voucherDelete, transaction, voucher, voucherId);
        return voucherResponse;
    }

}
