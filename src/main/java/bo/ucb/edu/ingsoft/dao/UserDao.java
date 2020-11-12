package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.UserCreate;

import bo.ucb.edu.ingsoft.model.User;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    public void create(User user);

    public void update(User user);

    public Integer selectAddressId(Integer userId);

}
