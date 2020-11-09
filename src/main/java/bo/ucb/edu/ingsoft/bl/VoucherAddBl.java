package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.hVoucherDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dao.VoucherDao;
import bo.ucb.edu.ingsoft.dto.Transaction;
import bo.ucb.edu.ingsoft.model.hVoucher;
import bo.ucb.edu.ingsoft.model.voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoucherAddBl<HVoucherDao> {
    private VoucherDao voucherAddDao;
    private TransactionDao transactionDao;
    private HVoucherDao hVocuherDao;

    @Autowired
    public VoucherAddBl(voucherAddDao voucherAddDao, hVoucherDao hVoucherDao, TransactionDao transactionDao){
        this.voucherAddDao = voucherAddDao;
        this.transactionDao = transactionDao;
        this.hVoucherDao = hVoucherDao;
    }
    public voucherAdd createvoucher(voucherAdd voucherAdd, voucher voucher, Transaction transaction, hVoucher hVoucher){
        voucher.setBrand(voucherAdd.getBrand());
        voucher.setModel(voucherAdd.getModel());
        voucher.setPrice(voucherAdd.getPrice());
        voucher.setDescription(voucherAdd.getDescription());
        voucher.setStock(voucherAdd.getStock());
        voucher.setTxId(transaction.getTxId());
        voucher.setTxUserId(transaction.getTxUserId());
        voucher.setTxHost(transaction.getTxHost());
        voucher.setTxDate(transaction.getTxDate());
        voucherAddDao.create(voucher);
        Integer getLastId = transactionDao.getLastInsertId();
        voucher.setvoucherId(getLastId);

        hVoucher.setvoucherId(voucher.getvoucherId());
        hVoucher.setBrand(voucherAdd.getBrand());
        hVoucher.setModel(voucherAdd.getModel());
        hVoucher.setPrice(voucherAdd.getPrice());
        hVoucher.setDescription(voucherAdd.getDescription());
        hVoucher.setStock(voucherAdd.getStock());
        hVoucher.setTxId(transaction.getTxId());
        hVoucher.setTxUserId(transaction.getTxUserId());
        hVoucher.setTxHost(transaction.getTxHost());
        hVoucher.setTxDate(transaction.getTxDate());
        hVoucherDao.createhVoucher(hVoucher);

        return voucherAdd;
    }
}
