package etgov.mof.pfmrt.conf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardCalendar {

	@RequestMapping("/calendar")
	public String dashboard1() {
		return "admin/calendar";
	}
	
	
	
}
