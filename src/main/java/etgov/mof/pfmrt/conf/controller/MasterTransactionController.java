package etgov.mof.pfmrt.conf.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import etgov.mof.pfmrt.conf.dao.UserRepository;
import etgov.mof.pfmrt.conf.model.Document;
import etgov.mof.pfmrt.conf.model.FileUploadResponse;
import etgov.mof.pfmrt.conf.model.MasterTransaction;
import etgov.mof.pfmrt.conf.service.DocumentService;
import etgov.mof.pfmrt.conf.service.FileStorageService;
import etgov.mof.pfmrt.conf.service.MasterTransactionService;


@Controller

public class MasterTransactionController {
	
	@Autowired
	private FileStorageService fileStorageService;
	@Autowired
	private UserRepository  urepo;
	


	Path copyLocation;
	@Autowired
	private MasterTransactionService masterTransactionService;
	@Autowired
	private DocumentService documentService;
	
	

@GetMapping("/mastertransactionlists")
	public String  showTransaction(Model  model,String keyword) {
		keyword ="";
	List<MasterTransaction> transactionlist =  masterTransactionService.getMasterTransaction(keyword);
		model.addAttribute("mastertransactionlists", transactionlist);
		 
		List<Document> doclist = documentService.getDocuments();
		model.addAttribute("documents",doclist);
		
		return  "emcp/mastertransactionlist";		
	}
	
	@RequestMapping("mastertransactionlists/findById")
	@ResponseBody
	public Optional<MasterTransaction> findBy(Long id) {
	 return masterTransactionService.findById(id);
 }
 
 @RequestMapping(value="/mastertransactionlists/update", method= {RequestMethod.PUT, RequestMethod.GET})
 public String update(MasterTransaction  mastertransaction) {
	 

	 masterTransactionService.save(mastertransaction);
	 return "redirect:/mastertransactionlists";
 }
		

	@PostMapping("/uploadFiles")
	public String uploadMultipleFiles(@RequestParam("files") MultipartFile file,
			@RequestParam("transactiondocumentid") String transactiondocumentid,
			@RequestParam("reportstatus") String reportstatus,ModelMap modelMap,
			
			Principal principal,MasterTransaction trans,
			RedirectAttributes ra) throws IOException {

         String name= principal.getName();
         etgov.mof.pfmrt.conf.model.User user= this.urepo.getUserByUsername(name);
		 String org_id= user.getOrg_id();
	     trans.setUser(user);
		 trans.setOrg_id(org_id);
		//MasterTransaction trans = new MasterTransaction();
		 trans.setTransactiondocumentid(transactiondocumentid);
		 trans.setReportstatus(reportstatus);
		
		 trans.setDocname(file.getOriginalFilename());
		
		
		singleFileUpload(file).getUrl();
	      ra.addFlashAttribute("message",
		                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
		
		masterTransactionService.save(trans);
				
		return "redirect:/uploadstatus";
	
	}
	
	





	FileUploadResponse singleFileUpload(@RequestParam("file") MultipartFile file){
				
		String docname = fileStorageService.storeFile(file);
		String url = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/download")
				.path(docname)
				.toString();
		String contentType = file.getContentType();
		FileUploadResponse response = new FileUploadResponse(docname,contentType,url);
		return response;
	}
	
	
	
	
	@RequestMapping("/download")
	public ResponseEntity<Resource>  download(@RequestParam("id") Long id, HttpServletResponse response) throws MalformedURLException{
		MasterTransaction trans = masterTransactionService.findById(id).get();
		
		
	
		Resource resource=null;
		try {
			resource = fileStorageService.downloadFile(trans.getDocname());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MediaType contentType= MediaType.APPLICATION_OCTET_STREAM;
		
		return ResponseEntity.ok()
				.contentType(contentType)
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachement;filename="+resource.getFilename())
				.body(resource);
			}	
	}

	
	
	
	

