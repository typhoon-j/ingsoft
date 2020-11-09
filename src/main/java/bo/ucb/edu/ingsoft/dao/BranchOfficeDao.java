package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.BranchOffice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BranchOfficeDao {
    public BranchOffice findByBranchOfficeId(Integer branchOfficeId);

    public void create(BranchOffice branchOffice);
}



