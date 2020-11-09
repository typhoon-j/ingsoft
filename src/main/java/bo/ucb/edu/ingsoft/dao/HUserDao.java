package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.HUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HUserDao {

    public HUser create(HUser hUser);

}