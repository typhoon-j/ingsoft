package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.util.TransactionUtil;

import bo.ucb.edu.ingsoft.model.User;
import bo.ucb.edu.ingsoft.model.Address;

import bo.ucb.edu.ingsoft.dto.UserCreate;
import bo.ucb.edu.ingsoft.dto.Transaction;

import bo.ucb.edu.ingsoft.bl.UserBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping()
public class UserApi {

    private UserBl userBl;
    private TransactionBl transactionBl;

    @Autowired
    public UserApi(UserBl userBl, TransactionBl transactionBl){
        this.userBl = userBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(path = "users/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserCreate createUser(@RequestBody UserCreate userCreate, User user, Address address, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        UserCreate userResponse = userBl.createUser(userCreate, user, transaction, address);

        return userResponse;
    }

}