package etgov.mof.pfmrt.conf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardNotification {
	@RequestMapping("/notification")
	public String notification() {
		return "admin/notification";
	}
}
