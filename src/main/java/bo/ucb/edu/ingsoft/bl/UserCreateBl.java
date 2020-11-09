package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.UserCreateDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dao.HUserDao;

import bo.ucb.edu.ingsoft.dto.UserCreate;

import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.model.User;
import bo.ucb.edu.ingsoft.model.HUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserCreateBl {

    private UserCreateDao userCreateDao;
    private TransactionDao transactionDao;
    private HUserDao hUserDao;

    @Autowired
    public UserCreateBl(UserCreateDao userCreateDao, TransactionDao transactionDao, HUserDao hUserDao){
        this.userCreateDao = userCreateDao;
        this.transactionDao = transactionDao;
        this.hUserDao = hUserDao;
    }

    public UserCreate createUser(UserCreate userCreate, Transaction transaction, HUser hUser, User user){
        user.setFirstname(userCreate.getFirstname());
        user.setLastname(userCreate.getLastname());
        user.setPhone(userCreate.getPhone());
        user.setEmail(userCreate.getEmail());
        user.setTxDate((Timestamp) transaction.getTxDate());
        user.setTxId(transaction.getTxId());
        user.setTxHost(transaction.getTxHost());
        user.setTxUserId(transaction.getTxUserId());
        userCreateDao.create(user);
        Integer getLastId = transactionDao.getLastInsertId();
        user.setUserId(getLastId);

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

        return userCreate;

    }
}
