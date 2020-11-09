package bo.ucb.edu.ingsoft.bl;
import bo.ucb.edu.ingsoft.dao.AddressDao;
import bo.ucb.edu.ingsoft.dao.BranchOfficeDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.Address;
import bo.ucb.edu.ingsoft.dto.BranchOffice;
import org.apache.ibatis.transaction.Transaction;
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
        branchOfficeDao.;

        productAddDao.create(product);
        Integer getLastId = transactionDao.getLastInsertId();
        product.setProductId(getLastId);

        hProduct.setProductId(product.getProductId());
        hProduct.setBrand(productAdd.getBrand());
        hProduct.setModel(productAdd.getModel());
        hProduct.setPrice(productAdd.getPrice());
        hProduct.setDescription(productAdd.getDescription());
        hProduct.setStock(productAdd.getStock());
        hProduct.setTxId(transaction.getTxId());
        hProduct.setTxUserId(transaction.getTxUserId());
        hProduct.setTxHost(transaction.getTxHost());
        hProduct.setTxDate(transaction.getTxDate());
        hProductDao.createHProduct(hProduct);

        return productAdd;
    }
}
