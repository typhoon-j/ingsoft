package bo.ucb.edu.ingsoft.dao;

import  bo.ucb.edu.ingsoft.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserCreateDao {

    public User create(User user);

}
