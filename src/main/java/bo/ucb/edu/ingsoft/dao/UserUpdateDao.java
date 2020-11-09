package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.UserUpdate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserUpdateDao {
    public UserUpdate update(UserUpdate userUpdate);
}