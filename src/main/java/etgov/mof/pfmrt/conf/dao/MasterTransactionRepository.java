package etgov.mof.pfmrt.conf.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import etgov.mof.pfmrt.conf.model.MasterTransaction;
import etgov.mof.pfmrt.conf.model.User;

@Repository
public interface MasterTransactionRepository extends JpaRepository<MasterTransaction,Long> {

	@Query("SELECT p FROM MasterTransaction p WHERE CONCAT(p.id, ' ', p.transactiondocumentid) LIKE %?1%")
	public List<MasterTransaction> findByDirectorate(String keyword);
	
	 
	@Query("SELECT z FROM MasterTransaction z WHERE CONCAT(z.id, ' ', z.createdBy) LIKE %?1%")
	    public List<MasterTransaction> findTransactionByUsername(String  orgtrans);
	    
	    
	    @Query("from MasterTransaction as m where m.user.id =:userid")
		
		public List<MasterTransaction> findTransactionByOrg(@Param("userid") Long id);
	   
		
		
	    
		//public List<MasterTransaction> findByNameContainingAndUser(String docname,User user);
	    
	    @Query("SELECT t FROM MasterTransaction t where t.createdBy = :createdBy AND t.docname = :docname")
	    public List <MasterTransaction> findByUsertransaction(@Param("createdBy") String createdBy, 
	                                                    @Param("docname") User user);
	
	 
}
