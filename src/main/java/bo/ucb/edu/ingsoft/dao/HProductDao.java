package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.HProduct;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HProductDao {
    public void createHProduct(HProduct hProduct);
}
