package etgov.mof.pfmrt.conf.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToInspectionDirectorateController {

	@GetMapping("/inspectiondirectorates")
	
	public String GetInspectionDirector() {	 
		  return "inspectiondirectorate";
	}
	
	
}

