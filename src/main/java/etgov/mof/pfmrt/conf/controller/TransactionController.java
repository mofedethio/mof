package etgov.mof.pfmrt.conf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class TransactionController {
	
	@GetMapping("/allorganizationreports")
	public String getOrganizationPenalty() {
		return "transaction";
	}

}

