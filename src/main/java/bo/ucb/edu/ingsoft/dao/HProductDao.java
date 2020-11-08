package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.HProduct;
import org.springframework.stereotype.Service;

@Service
public interface HProductDao {
    public void createHProduct(HProduct hProduct);
}
