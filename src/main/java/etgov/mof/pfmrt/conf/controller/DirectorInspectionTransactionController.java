package etgov.mof.pfmrt.conf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import etgov.mof.pfmrt.conf.model.Document;
import etgov.mof.pfmrt.conf.model.MasterTransaction;
import etgov.mof.pfmrt.conf.service.DocumentService;
import etgov.mof.pfmrt.conf.service.MasterTransactionService;

@Controller
public class DirectorInspectionTransactionController {
	@Autowired
	private MasterTransactionService masterTransactionService;
	@Autowired
	private DocumentService documentService;
	
	@GetMapping("/inspectiontransactionlists")
	public String  showTransaction(Model  model,String keyword) {
		keyword ="inspection";
	List<MasterTransaction> transactionlist =  masterTransactionService.getMasterTransaction(keyword);
		model.addAttribute("mastertransactionlists", transactionlist);
		
		List<Document> doclist = documentService.getDocuments();
		model.addAttribute("documents",doclist);
		
		return  "directorate/inspection-transaction";		
	}
	//for transaction update
		 @RequestMapping(value="/inspectiontransactionlists/update", method= {RequestMethod.PUT, RequestMethod.GET})
		 public String update(MasterTransaction  mastertransaction) {
			 

			 masterTransactionService.save(mastertransaction);
			 return "redirect:/inspectiontransactionlists";
	}
		
	
}
