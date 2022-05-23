package etgov.mof.pfmrt.conf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import etgov.mof.pfmrt.conf.model.Document;
import etgov.mof.pfmrt.conf.service.DocumentService;

@Controller
public class ToPropertyDirectorateController {
	
	@Autowired
	private DocumentService docservice;
	
	@GetMapping("/uploadToDirectors")
	public String GetPropertyDirectorate(Model model) {
		
		List<Document> doclist = docservice.getDocuments();
		 model.addAttribute("documents", doclist);
		  return "organization-users/to-directors";
	}
	
	
}

