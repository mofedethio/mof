package etgov.mof.pfmrt.conf.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import etgov.mof.pfmrt.conf.model.Document;
import etgov.mof.pfmrt.conf.model.MasterTransaction;
import etgov.mof.pfmrt.conf.service.DocumentService;
import etgov.mof.pfmrt.conf.service.MasterTransactionService;

@Controller

public class DirectorAuditTransactionController {
	 
	@Autowired
	private MasterTransactionService masterTransactionService;
	@Autowired
	private DocumentService documentService;
	
	@GetMapping("/audittransactionlists")
	public String  showTransaction(Model  model,String keyword) {
		keyword ="audit";
	List<MasterTransaction> transactionlist =  masterTransactionService.getMasterTransaction(keyword);
		model.addAttribute("mastertransactionlists", transactionlist);
		
		List<Document> doclist = documentService.getDocuments();
		model.addAttribute("documents",doclist);
		
		return  "directorate/audit-transaction";		
	}
	//for transaction update
		 @RequestMapping(value="/audittransactionlists/update", method= {RequestMethod.PUT, RequestMethod.GET})
		 public String update(MasterTransaction  mastertransaction) {
			 

			 masterTransactionService.save(mastertransaction);
			 return "redirect:/audittransactionlists";
	}	
	
}
