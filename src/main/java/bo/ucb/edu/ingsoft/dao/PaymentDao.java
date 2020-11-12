package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Payment;
import bo.ucb.edu.ingsoft.model.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    public void createPayment(Payment payment);
}
