package etgov.mof.pfmrt.conf.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Trainee {

@Id
private String train_id;
private String middle_name;
private String first_name;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date train_start_date;


	@ManyToOne
	@JoinColumn(name="course_id",insertable=false,updatable=false)
	private Course course;
	private String course_id;
	
	
	@ManyToOne
	@JoinColumn(name="org_id",insertable=false,updatable =false)
	private Organization organization;
	private String org_id;
	
	public String getTrain_id() {
		return train_id;
	}
	public void setTrain_id(String train_id) {
		this.train_id = train_id;
	}
	public Date getTrain_start_date() {
		return train_start_date;
	}
	public void setTrain_start_date(Date train_start_date) {
		this.train_start_date = train_start_date;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getOrg_id() {
		return org_id;
	}
	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	//private Date train_start_date;
	
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	//private Date enddate;
	
	
	
	
}
