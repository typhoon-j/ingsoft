package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.User;
import bo.ucb.edu.ingsoft.model.Order;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    public void create(User user);

    public void update(User user);

    public Integer selectAddressId(Integer userId);



}
