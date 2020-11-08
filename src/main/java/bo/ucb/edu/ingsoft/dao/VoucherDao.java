package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Transaction;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VoucherDao {
    public Voucher findByUserId(Integer voucherId);
    public Voucher findByOrderId(Integer voucherId);

    public Voucher create(Voucher voucher);

    public Voucher updateVoucher();
}
