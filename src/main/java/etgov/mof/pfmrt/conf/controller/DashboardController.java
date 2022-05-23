package etgov.mof.pfmrt.conf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("admin/dashboard")
public class DashboardController {
	
@RequestMapping("/dashboard1")
public String dashboard1() {
	return "admin/dashboard1";
}
@RequestMapping("/dashboard2")
public String dashboard2() {
	return "admin/dashboard2";
}
}
