package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.CartGetDetail;
import bo.ucb.edu.ingsoft.model.CartDetail;
import bo.ucb.edu.ingsoft.model.Order;
import jdk.dynalink.linker.LinkerServices;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartDao {

    public void createCartDetail(CartDetail cartDetail);

    public List<CartGetDetail> getCartDetail();
}
