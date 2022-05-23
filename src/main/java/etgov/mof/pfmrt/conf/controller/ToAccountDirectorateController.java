package etgov.mof.pfmrt.conf.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ToAccountDirectorateController {
	

	@GetMapping("/accountdirectorates")
	public String GetAccountDirectorate() {
		  return "organization-users/to-director-account";
	     }
	
		
	
}

