package etgov.mof.pfmrt.conf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etgov.mof.pfmrt.conf.dao.MasterTransactionRepository;
import etgov.mof.pfmrt.conf.model.MasterTransaction;


@Service
public class OrganizationTransactionService {
	
	@Autowired
	private MasterTransactionRepository  masterTransactionRepository;
	
	public List<MasterTransaction> getTransactionByUsername(String username){
		 {
			return masterTransactionRepository.findTransactionByUsername(username);
		}
		 
						
		}
	public Optional <MasterTransaction> findById(Long id){
			    return  masterTransactionRepository.findById(id);
		}
	
	public void delete(Long id) {
		masterTransactionRepository.deleteById(id);
	}
	
	 public Optional<MasterTransaction> getUser(Long fileId) {
		  return masterTransactionRepository.findById(fileId);
	  }

	public void save(MasterTransaction trans) {
		// TODO Auto-generated method stub
		masterTransactionRepository.save(trans);
	}
	
	
}

