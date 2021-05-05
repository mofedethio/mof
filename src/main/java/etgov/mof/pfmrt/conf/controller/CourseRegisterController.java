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
import etgov.mof.pfmrt.conf.service.CourseService;

@Controller
public class CourseRegisterController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
	
	public String allCourse(Model model) {
		List <Course> allcourses = courseService.getAllCourse();
		model.addAttribute("courses",allcourses);
		return "emcp/course-register";
	}
	
	
	@PostMapping("/courses/addNew")
	
	public String addNew(Course  course) {
		courseService.save(course);
		return "redirect:/courses";
			}
	
	@RequestMapping("courses/findById")
	@ResponseBody
	public Optional<Course> findById(String  id){
		return courseService.findById(id);
			}
	
	@RequestMapping(value="/courses/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update (Course course) {
		courseService.save(course);
		return "redirect:/courses";
	}
	
	
	@RequestMapping(value="/courses/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete (String id) {
		courseService.delete(id);
		return "redirect:/courses";
		}
	
	

}
