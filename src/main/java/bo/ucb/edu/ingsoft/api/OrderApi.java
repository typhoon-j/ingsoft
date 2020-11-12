package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.OrderBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.MakeOrder;
import bo.ucb.edu.ingsoft.dto.OrderAddress;
import bo.ucb.edu.ingsoft.dto.OrderState;
import bo.ucb.edu.ingsoft.dto.Transaction;
import bo.ucb.edu.ingsoft.model.Address;
import bo.ucb.edu.ingsoft.model.Order;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    @RequestMapping(value = "/state/{orderId}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public Order updateProduct(@RequestBody Order order, OrderState orderState, HttpServletRequest request, @PathVariable int orderId){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        Order productResponse = orderBl.updateOrderState(order,orderState,transaction, orderId );
        return productResponse;
    }
    @RequestMapping(value = "/address/{orderId}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public Address updateProduct(@RequestBody Order order, OrderAddress orderAddress, Address address, HttpServletRequest request, @PathVariable int orderId){
        Transaction transaction = TransactionUtil.createTransaction(request);

        transactionBl.createTransaction(transaction);
        Address productResponse = orderBl.updateOrderAddress(order,orderAddress,address,transaction, orderId );
        return productResponse;
    }
    @RequestMapping (value = "/order", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public MakeOrder createOrder  (@RequestBody Order order, MakeOrder makeOrder, HttpServletRequest request){
        Transaction transaction= TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        MakeOrder orderResponse = orderBl.createOrder(makeOrder,order,transaction);
        return orderResponse;
    }
}
