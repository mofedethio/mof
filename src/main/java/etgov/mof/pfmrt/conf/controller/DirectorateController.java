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
import etgov.mof.pfmrt.conf.service.DirectorateService;

@Controller

public class DirectorateController {

	@Autowired

	private DirectorateService directorateService;

	@GetMapping("/directorates")
	  public String GetDirectorates(Model model) {
		  List<Directorate> directorList = directorateService.GetAllDirectorates();
		  model.addAttribute("directorates",directorList);
		  return "emcp/directorate";
	}
	
	
	@PostMapping("/directorates/addNew")
	public String addNew( Directorate directorate) {
		directorateService.save(directorate);
		return "redirect:/directorates";
	}
	
	@RequestMapping("directorates/findById")
	@ResponseBody
	public Optional<Directorate> findById(String id) {
	  return directorateService.findById(id);	
	}	
	
	@RequestMapping(value="/directorates/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Directorate directorate) {
		directorateService.save(directorate);
		return "redirect:/directorates";
	}
	
	@RequestMapping(value="/directorates/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(String id) {
		directorateService.delete(id);
		return "redirect:/directorates";
	}
	
}