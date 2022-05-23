package etgov.mof.pfmrt.conf.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import etgov.mof.pfmrt.conf.dao.MasterTransactionRepository;
import etgov.mof.pfmrt.conf.dao.UserRepository;
import etgov.mof.pfmrt.conf.model.Document;
import etgov.mof.pfmrt.conf.model.MasterTransaction;
import etgov.mof.pfmrt.conf.model.User;
import etgov.mof.pfmrt.conf.service.DocumentService;
import etgov.mof.pfmrt.conf.service.MasterTransactionService;
import etgov.mof.pfmrt.conf.service.OrganizationService;

@Controller

public class OrganizationTransactionController {
	 
	@Autowired
	private MasterTransactionService masterTransactionService;
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private OrganizationService orgService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private MasterTransactionRepository mrepo;
	
@GetMapping("/orgtransactionlists")
public String  showTransactionbyUsername(Model  model,Principal principal)
		{
		 	String username= principal.getName();
			User user= this.userRepo.getUserByUsername(username);
			
			List<MasterTransaction> orgtransactionlist = this.masterTransactionService.getOrgTrans(user.getId());
				model.addAttribute("mastertransactionlists", orgtransactionlist);
		    
			//List<Organization> orglist = orgService.getOrganizations();
			//model.addAttribute("organizations",orglist);
			
		    List<Document> doclist = documentService.getDocuments();
		    model.addAttribute("documents",doclist);
			return  "organization-users/organization-transaction-service";		
			
	         }
		    
					
					
		} 
		
		


		
	
	

