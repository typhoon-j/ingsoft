package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.UserCreateBl;
import bo.ucb.edu.ingsoft.bl.UserUpdateBl;
import bo.ucb.edu.ingsoft.bl.UserGetBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;

import bo.ucb.edu.ingsoft.dto.UserCreate;
import bo.ucb.edu.ingsoft.dto.UserGet;

import bo.ucb.edu.ingsoft.dto.UserUpdate;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.model.HUser;
import bo.ucb.edu.ingsoft.model.User;

import bo.ucb.edu.ingsoft.util.TransactionUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
public class UserApi {

    private UserCreateBl userCreateBl;
    private UserGetBl userGetBl;
    private TransactionBl transactionBl;
    private UserUpdateBl userUpdateBl;

    @Autowired
    public UserApi(UserCreateBl userCreateBl, TransactionBl transactionBl, UserGetBl userGetBl, UserUpdateBl userUpdateBl){
        this.transactionBl = transactionBl;
        this.userCreateBl = userCreateBl;
        this.userGetBl = userGetBl;
        this.userUpdateBl = userUpdateBl;
    }

    @RequestMapping(path = "/users/",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserGet findById(HttpServletRequest request){
        return userGetBl.findUserById(0);
    }

    @RequestMapping(path= "/users/signup",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserCreate createUser(@RequestBody UserCreate userCreate, User user, HUser hUser, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);

        UserCreate userCreateResponse = userCreateBl.createUser(userCreate, transaction, hUser, user);

        return userCreateResponse;
    }

    @RequestMapping(path = "/users/edit/{userId}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserUpdate updateUser(@RequestBody UserUpdate userUpdate, Transaction transaction, User user, HUser hUser, HttpServletRequest request){
        Transaction transaction1 = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction1);

        UserUpdate userUpdateResponse = userUpdateBl.updateUser(userUpdate, transaction, hUser, user);

        return userUpdateResponse;
    }

}
