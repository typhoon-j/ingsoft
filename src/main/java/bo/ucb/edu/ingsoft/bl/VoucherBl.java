package bo.ucb.edu.ingsoft.bl;


import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dao.VoucherDao;

import bo.ucb.edu.ingsoft.dto.Transaction;
import bo.ucb.edu.ingsoft.dto.VoucherDelete;
import bo.ucb.edu.ingsoft.dto.VoucherUpdate;
import bo.ucb.edu.ingsoft.model.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoucherBl {
    private VoucherDao voucherDao;
    private TransactionDao transactionDao;

    @Autowired
    public VoucherBl(VoucherDao voucherDao, TransactionDao transactionDao){
        this.voucherDao = voucherDao;
        this.transactionDao = transactionDao;
    }



    public VoucherDelete deleteVoucher(VoucherDelete voucherDelete, Transaction transaction, Voucher voucher, Integer voucherId){

        voucher.setTxStatus(voucherDelete.getTxStatus());
        voucher.setVoucherId(voucherId);
        voucher.setTxDate(transaction.getTxDate());
        voucher.setTxUserId(transaction.getTxUserId());
        voucher.setTxHost(transaction.getTxHost());
        voucher.setTxId(transaction.getTxId());
        voucherDao.deleteVoucher(voucher);

        return voucherDelete;
    }


    public VoucherUpdate updateVoucher(VoucherUpdate voucherUpdate, Transaction transaction, Voucher voucher, int voucherId) {
        voucher.setVoucherId(voucherId);
        voucher.setTxDate(transaction.getTxDate());
        voucher.setTxUserId(transaction.getTxUserId());
        voucher.setTxHost(transaction.getTxHost());
        voucher.setTxId(transaction.getTxId());
        voucher.setDate(voucherUpdate.getDate());
        voucher.setTotal(voucherUpdate.getTotal());
        voucherDao.updateVoucher(voucher);

        return voucherUpdate;
    }
}
