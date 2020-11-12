package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.User;
import bo.ucb.edu.ingsoft.model.Order;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    //Creacion de Usuarios
    public void create(User user);

    //Actualizacion de datos de usuario
    public void update(User user);
    public Integer selectAddressId(Integer userId);



}
