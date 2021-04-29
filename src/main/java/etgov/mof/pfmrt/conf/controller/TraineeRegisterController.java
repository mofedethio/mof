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

import etgov.mof.pfmrt.conf.model.Course;
import etgov.mof.pfmrt.conf.model.Organization;
import etgov.mof.pfmrt.conf.model.Trainee;
import etgov.mof.pfmrt.conf.service.CourseService;
import etgov.mof.pfmrt.conf.service.OrganizationService;
import etgov.mof.pfmrt.conf.service.TraineeService;

@Controller
public class TraineeRegisterController {

	 @Autowired
	 private TraineeService traineeService;
	 @Autowired
	 private OrganizationService organizationService;
	 
	 @Autowired
	 private CourseService courseService;
	 
	 
	 
	 @GetMapping("/trainees")
	 public String getTrainees(Model model) {
		 //to get list of trainee
		 List<Trainee> mytrainee = traineeService.getTrainees();
		 model.addAttribute("trainees",mytrainee);
		 //to get list of course
		 List <Course>  mycourse = courseService.getAllCourse();
		 model.addAttribute("courses",mycourse);
		 //to get list of organization
		 List <Organization> myorg = organizationService.getOrganizations();
		 model.addAttribute("organizations",myorg);
		 
				 return "emcp/trainee-register";
	 }
	 
	 
	 @PostMapping("/trainees/addNew")
	 public String  addNew (Trainee trainee) {
		 traineeService.save(trainee);
		 return "redirect:/trainees";
	   }
	 
	 @RequestMapping("trainees/findById")
		@ResponseBody
		public Optional<Trainee> findBy(String id) {
		 return traineeService.findById(id);
	 }
	 
	 @RequestMapping(value="/trainees/update", method= {RequestMethod.PUT, RequestMethod.GET})
	 public String update(Trainee  trainee) {
		 traineeService.save(trainee);
		 return "redirect:/trainees";
	 }
	 
	 @RequestMapping(value="/trainees/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	 public String delete(String id) {
		 traineeService.delete(id);
		return "redirect:/trainees";
	 }
	 
	 
	 
	 
}
