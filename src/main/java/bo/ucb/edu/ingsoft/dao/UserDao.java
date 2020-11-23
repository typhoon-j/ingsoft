package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.User;
import bo.ucb.edu.ingsoft.dto.UserGet;
import bo.ucb.edu.ingsoft.model.Order;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    //Creacion de Usuarios
    public void create(User user);

    //Get de usuario por Id
    public UserGet findUserById(Integer userId);

    //Actualizacion de datos de usuario
    public void update(User user);
    public Integer selectAddressId(Integer userId);



}
