package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.UserGet;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserGetDao {
    public UserGet findByUserId(Integer userId);
}