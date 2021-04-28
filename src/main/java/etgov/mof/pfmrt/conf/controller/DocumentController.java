package etgov.mof.pfmrt.conf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import etgov.mof.pfmrt.conf.model.Directorate;
import etgov.mof.pfmrt.conf.model.Document;
import etgov.mof.pfmrt.conf.service.DirectorateService;
import etgov.mof.pfmrt.conf.service.DocumentService;

@Controller

public class DocumentController {

    @Autowired
    private DocumentService docservice;
    @Autowired
    private DirectorateService dirservice;
    
    @GetMapping("/document")
	public String getDocuments(Model model) {	
		
		List<Document> documentList = docservice.getDocuments();	
		model.addAttribute("document", documentList);	
		
		List<Directorate> directorateList = dirservice.GetAllDirectorates();
		model.addAttribute("directorates",directorateList);
		
		return "emcp/document-register";
	}
    @PostMapping("/document/addNew")
	public String addNew(Document document) {
		docservice.save(document);
		return "redirect:/documents";
	}
	
	
	@RequestMapping("document/findById")
	@ResponseBody
	public Optional<Document> findById(String id) {
	  return docservice.findBy(id)	;
	}	
	
	@RequestMapping(value="/document/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Document document) {
		docservice.save(document);
		return "redirect:/document";
	}
	
	@RequestMapping(value="/document/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(String id) {
		docservice.delete(id);
		return "redirect:/document";
	}
	
	
}

