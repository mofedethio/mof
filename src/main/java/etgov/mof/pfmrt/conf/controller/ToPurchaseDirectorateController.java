package etgov.mof.pfmrt.conf.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ToPurchaseDirectorateController {

	@GetMapping("/purchasedirectorates")
	public String GetAccountDirectorate() {
		 
		  return "organization-users/to-director-purchase";
	     }

}

