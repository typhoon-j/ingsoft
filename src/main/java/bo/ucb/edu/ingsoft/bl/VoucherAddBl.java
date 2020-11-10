package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dao.VoucherDao;
import bo.ucb.edu.ingsoft.model.Transaction;

import bo.ucb.edu.ingsoft.dto.VoucherAdd;
import bo.ucb.edu.ingsoft.model.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoucherAddBl {
    private VoucherDao voucherDao;
    private TransactionDao transactionDao;


    @Autowired
    public VoucherAddBl(VoucherDao voucherDao, TransactionDao transactionDao){
        this.voucherDao = voucherDao;
        this.transactionDao = transactionDao;
    }
    public VoucherAdd createVoucher(VoucherAdd voucherAdd, Voucher voucher, Transaction transaction){
        voucher.setOrderId(voucherAdd.getOrderId());
        voucher.setPaymentId(voucherAdd.getPaymentId());
        voucher.setDate(voucherAdd.getDate());
        voucher.setTotal(voucherAdd.getTotal());
        voucher.setTxId(transaction.getTxId());
        voucher.setTxUserId(transaction.getTxUserId());
        voucher.setTxHost(transaction.getTxHost());
        voucher.setTxDate(transaction.getTxDate());
        voucherDao.create(voucher);
        Integer getLastId = transactionDao.getLastInsertId();
        voucher.setvoucherId(getLastId);

        return voucherAdd;
    }
}
