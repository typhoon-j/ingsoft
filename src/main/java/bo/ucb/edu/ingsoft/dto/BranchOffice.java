package bo.ucb.edu.ingsoft.dto;

import java.util.Date;

public class BranchOffice {
        private Integer BranchOfficeId;
        private String storeName;
        private String description;
        private Integer txId;
        private String txHost;
        private Integer txUserId;
        private Date txDate;

        public BranchOffice(){

        }

        public Integer getBranchOfficeId() {
                return BranchOfficeId;
        }

        public void setBranchOfficeId(Integer branchOfficeId) {
                BranchOfficeId = branchOfficeId;
        }

        public String getStoreName() {
                return storeName;
        }

        public void setStoreName(String storeName) {
                this.storeName = storeName;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public Integer getTxId() {
                return txId;
        }

        public void setTxId(Integer txId) {
                this.txId = txId;
        }

        public String getTxHost() {
                return txHost;
        }

        public void setTxHost(String txHost) {
                this.txHost = txHost;
        }

        public Integer getTxUserId() {
                return txUserId;
        }

        public void setTxUserId(Integer txUserId) {
                this.txUserId = txUserId;
        }

        public Date getTxDate() {
                return txDate;
        }

        public void setTxDate(Date txDate) {
                this.txDate = txDate;
        }

        @Override
        public String toString() {
                return "BranchOffice{" +
                        "BranchOfficeId=" + BranchOfficeId +
                        ", storeName='" + storeName + '\'' +
                        ", description='" + description + '\'' +
                        ", txId=" + txId +
                        ", txHost='" + txHost + '\'' +
                        ", txUserId=" + txUserId +
                        ", txDate=" + txDate +
                        '}';
        }
}
