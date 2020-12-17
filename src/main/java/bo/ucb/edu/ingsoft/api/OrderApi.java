package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.OrderBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.*;
import bo.ucb.edu.ingsoft.model.Address;
import bo.ucb.edu.ingsoft.model.Order;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.OrderColumn;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/orders")
public class OrderApi {
    private TransactionBl transactionBl;
    private OrderBl orderBl;

    @Autowired
    public OrderApi(TransactionBl transactionBl, OrderBl orderBl){
        this.orderBl = orderBl;
        this.transactionBl = transactionBl;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderApi.class);
    /*
     * Este endpoint no sirve para cambiar el estado de una orden en la base de datos, buscandolo mediante la varible 'orderId'.
     */
    @RequestMapping(value = "/state/{orderId}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public Order updateProduct(@RequestBody Order order, OrderState orderState, HttpServletRequest request, @PathVariable int orderId){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        Order productResponse = orderBl.updateOrderState(order,orderState,transaction, orderId );
        return productResponse;
    }

    /*
     * Este endpoint no sirve para cambiar la dirrecion de entrega de una orden en la base de datos, buscandolo mediante la varible 'orderId'.
     */
    @RequestMapping(value = "/address/{orderId}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public OrderAddress updateProduct(@RequestBody Order order, OrderAddress orderAddress, Address address, HttpServletRequest request, @PathVariable int orderId){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        OrderAddress productResponse = orderBl.updateOrderAddress(order,orderAddress,address,transaction, orderId );
        return productResponse;
    }



    @RequestMapping ( method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderAdd createOrder  (@RequestBody OrderAdd orderAdd, Address address, Order order, HttpServletRequest request){
        Transaction transaction= TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        OrderAdd orderResponse = orderBl.createOrder(orderAdd,transaction,address,order);
        return orderResponse;
    }
}
