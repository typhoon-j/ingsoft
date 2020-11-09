package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.MakeOrder;
import org.springframework.stereotype.Service;

@Service
public interface MakeOrderDao {

    public void create(MakeOrder makeOrder);
}