package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.MakeOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MakeOrderDao {

    public void create(MakeOrder makeOrder);
}