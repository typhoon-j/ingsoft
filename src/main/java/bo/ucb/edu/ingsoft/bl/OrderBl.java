package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.AddressDao;
import bo.ucb.edu.ingsoft.dao.OrderDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.MakeOrder;
import bo.ucb.edu.ingsoft.dto.OrderAddress;
import bo.ucb.edu.ingsoft.dto.OrderState;
import bo.ucb.edu.ingsoft.dto.Transaction;
import bo.ucb.edu.ingsoft.model.Address;
import bo.ucb.edu.ingsoft.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderBl {
    private OrderDao orderDao;
    private TransactionDao transactionDao;
    private AddressDao addressDao;

    @Autowired
    public OrderBl(OrderDao orderDao,TransactionDao transactionDao, AddressDao addressDao){
        this.orderDao = orderDao;
        this.transactionDao = transactionDao;
        this.addressDao = addressDao;
    }
    public Order updateOrderState (Order order, OrderState orderState, Transaction transaction, Integer orderId){
       /* order.setState(orderState.getState());*/
        order.setOrderId(orderId);
        order.setTxDate(transaction.getTxDate());
        order.setTxUserId(transaction.getTxUserId());
        order.setTxHost(transaction.getTxHost());
        order.setTxId(transaction.getTxId());
        orderDao.updateOrderState(order);
        return order;
    }

    public OrderAddress updateOrderAddress (Order order, OrderAddress orderAddress, Address address, Transaction transaction, Integer orderId){

        order.setAddressId(address.getAddressId());
        order.setOrderId(orderId);
        order.setTxDate(transaction.getTxDate());
        order.setTxUserId(transaction.getTxUserId());
        order.setTxHost(transaction.getTxHost());
        order.setTxId(transaction.getTxId());
        orderDao.updateOrderAddress(order);
        Integer adId = orderDao.selectAddressId(orderId);
        orderAddress.setAddressId(adId);

        address.setAddressId(orderAddress.getAddressId());
        address.setNeighbourId(orderAddress.getNeighbourId());
        address.setStreet(orderAddress.getStreet());
        address.setNumber(orderAddress.getNumber());
        address.setReference(orderAddress.getReference());
        address.setTxDate(transaction.getTxDate());
        address.setTxId(transaction.getTxId());
        address.setTxHost(transaction.getTxHost());
        address.setTxUserId(transaction.getTxUserId());
        orderDao.updateAddress(address);


        return orderAddress;
    }
    public MakeOrder createOrder (MakeOrder makeOrder,Order order, Transaction transaction){
        order.setAddressId(makeOrder.getAddressId());
        order.setUserId(makeOrder.getUserId());
        order.setCartId(makeOrder.getCartId());
        order.setDeliveryId(makeOrder.getDeliveryId());
        order.setStatus(makeOrder.getStatus());
        order.setState(makeOrder.getState());
        order.setTxDate(transaction.getTxDate());
        order.setTxUserId(transaction.getTxUserId());
        order.setTxHost(transaction.getTxHost());
        order.setTxId(transaction.getTxId());
        orderDao.createOrder(order);
        Integer getLastId= transactionDao.getLastInsertId();
        order.setOrderId(getLastId);

        return makeOrder;



    }
}

