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

@Controller

public class ToCashDirectorateController {

	@GetMapping("/cashdirectorates")
	public String GetCashDirectorate() {
		
		  return "organization-users/to-director-cash";
	}
	
	
   
}

