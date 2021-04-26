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

import etgov.mof.pfmrt.conf.model.Organization;
import etgov.mof.pfmrt.conf.service.OrganizationService;

@Controller 
public class OrganizationController {
	@Autowired
	private OrganizationService organizationservice;
	
	
	
	@GetMapping("/organizations")
	
	public String GetOrganization(Model model) {
		
		List<Organization> orglist = organizationservice.getOrganizations();
		  model.addAttribute("organizations",orglist);
		  
		  return "emcp/organization-register";
	}
	
	@PostMapping("/organizations/addNew")
	public String addNew( Organization organization) {
		organizationservice.save(organization);
		return "redirect:/organizations";
	}
	
	
	@RequestMapping("organizations/findById")
	@ResponseBody
	public Optional<Organization> findById(String id) {
	  return organizationservice.findById(id);	
	}	
	
	@RequestMapping(value="/organizations/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Organization organization) {
		organizationservice.save(organization);
		return "redirect:/organizations";
	
		
	}
	
	@RequestMapping(value="/organizations/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(String id) {
		organizationservice.delete(id);
		return "redirect:/organizations";
	}

}
