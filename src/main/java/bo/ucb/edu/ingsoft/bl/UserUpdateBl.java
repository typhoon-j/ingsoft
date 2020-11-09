package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dto.UserUpdate;
import bo.ucb.edu.ingsoft.model.User;
import bo.ucb.edu.ingsoft.model.HUser
;
import bo.ucb.edu.ingsoft.dao.UserUpdateDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dao.HUserDao;

import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserUpdateBl {
    private UserUpdateDao userUpdateDao;
    private TransactionDao transactionDao;
    private HUserDao hUserDao;
    public UserUpdateBl(UserUpdateDao userUpdateDao, TransactionDao transactionDao, HUserDao hUserDao){
        this.transactionDao = transactionDao;
        this.userUpdateDao = userUpdateDao;
        this.hUserDao = hUserDao;
    }

    public UserUpdate updateUser(UserUpdate userUpdate, Transaction transaction, HUser hUser, User user){
        userUpdateDao.update(userUpdate);

        hUser.setUserId(user.getUserId());
        hUser.setFirstname(user.getFirstname());
        hUser.setLastname(user.getLastname());
        hUser.setPhone(user.getPhone());
        hUser.setEmail(user.getEmail());
        hUser.setTxStatus(user.getTxStatus());
        hUser.setTxDate((Timestamp) transaction.getTxDate());
        hUser.setTxId(transaction.getTxId());
        hUser.setTxHost(transaction.getTxHost());
        hUser.setTxUserId(transaction.getTxUserId());
        hUserDao.create(hUser);

        return userUpdate;
    }
}
