package bo.ucb.edu.ingsoft.model;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class User {

    private Integer userId;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private Integer addressId;
    private Integer TxStatus;
    private Timestamp TxDate;
    private Integer TxId;
    private String TxHost;
    private Integer TxUserId;

    public User(){
    }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getAddressId() { return addressId; }
    public void setAddressId(Integer addressId) { this.addressId = addressId; }

    public Integer getTxStatus() { return TxStatus; }
    public void setTxStatus(Integer txStatus) { TxStatus = txStatus; }

    public Timestamp getTxDate() { return TxDate; }
    public void setTxDate(Timestamp txDate) { TxDate = txDate; }

    public Integer getTxId() { return TxId; }
    public void setTxId(Integer txId) { TxId = txId; }

    public String getTxHost() { return TxHost; }
    public void setTxHost(String txHost) { TxHost = txHost; }

    public Integer getTxUserId() { return TxUserId; }
    public void setTxUserId(Integer txUserId) { TxUserId = txUserId; }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", addressId=" + addressId +
                ", TxStatus=" + TxStatus +
                ", TxDate=" + TxDate +
                ", TxId=" + TxId +
                ", TxHost='" + TxHost + '\'' +
                ", TxUserId=" + TxUserId +
                '}';
    }
}
