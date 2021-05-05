package etgov.mof.pfmrt.conf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class DashboardChartController {
	@RequestMapping("/chartjs")
	public String chartjs() {
		return "admin/chartjs";
	}
	
}
