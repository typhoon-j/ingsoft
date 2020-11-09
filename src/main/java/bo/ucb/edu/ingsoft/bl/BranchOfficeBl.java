package bo.ucb.edu.ingsoft.bl;
import bo.ucb.edu.ingsoft.dao.AddressDao;
import bo.ucb.edu.ingsoft.dao.BranchOfficeDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.Address;
import bo.ucb.edu.ingsoft.dto.BranchOffice;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BranchOfficeBl {
    private BranchOfficeDao branchOfficeDao;
    private TransactionDao transactionDao;
    private AddressDao addressDao;

    @Autowired
    public BranchOfficeBl(BranchOfficeDao branchOfficeDao, TransactionDao transactionDao, AddressDao addressDao) {
        this.branchOfficeDao = branchOfficeDao;
        this.transactionDao = transactionDao;
        this.addressDao = addressDao;
    }
    public BranchOffice findByBranchOfficeId(Integer branchOfficeId ){
        return branchOfficeDao.findByBranchOfficeId(branchOfficeId);
    }
    public BranchOffice createBranchOffice(BranchOffice branchOffice, Transaction transaction){
        BranchOffice branchOfficeA = new BranchOffice();
        branchOfficeA.setStoreName(branchOffice.getStoreName());
        branchOfficeA.setDescription(branchOffice.getDescription());
        branchOfficeDao.create(branchOffice);

        Address addressA = new Address();
        addressA.setStreet1(addressA.getStreet1());
        addressA.setStreet2(addressA.getStreet2());
        addressA.setNumber(addressA.getNumber());
        addressA.setReference(addressA.getReference());
        addressA.setTxId(transaction. getTxId());
        addressA.setTxUserId(transaction.getTxUserId());
        addressA.setTxHost(transaction.getTxHost());
        addressA.setTxDate(transaction.getTxDate());
        addressDao.create(addressA);

        return branchOfficeA;
    }
}
