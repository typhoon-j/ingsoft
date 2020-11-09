package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.UserGetDao;
import bo.ucb.edu.ingsoft.dto.UserGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGetBl {
    private UserGetDao userGetDao;

    @Autowired
    public UserGetBl(UserGetDao userGetDao) {
        this.userGetDao = userGetDao;
    }

    public UserGet findUserById(Integer userId) {
        return  userGetDao.findByUserId(userId);
    }
}