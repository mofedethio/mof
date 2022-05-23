package etgov.mof.pfmrt.conf.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GraphController {

	@GetMapping("/bar-graph")
	public String displayBarGraph(Model model) {
		Map<String,Integer> surveyMap=new LinkedHashMap<>();
		surveyMap.put("java", 40);
		surveyMap.put("Dev oops", 15);
		surveyMap.put("Python", 20);
		surveyMap.put(".NET", 20);
		model.addAttribute("surveyMap", surveyMap);
		
		return "graph/bar-graph";
	}
	@GetMapping("/pie-chart")
	public String displayPieChart(Model model) {
		model.addAttribute("pass", 70);
		model.addAttribute("fail", 30);
		return "graph/pie-chart";
	}
	
	
}
