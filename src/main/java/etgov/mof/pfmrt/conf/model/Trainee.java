package etgov.mof.pfmrt.conf.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
private Date train_start_date;
	
private String middle_name;
private String first_name;

	@ManyToOne
	@JoinColumn(name="trainee_course_id",insertable=false,updatable=false)
	private Course course;
	private String trainee_course_id;
	
	
	@ManyToOne
	@JoinColumn(name="trainee_org_id",insertable=false,updatable =false)
	private Organization organization;
	private String trainee_org_id;
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
	
	
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public String getTrainee_org_id() {
		return trainee_org_id;
	}
	public void setTrainee_org_id(String trainee_org_id) {
		this.trainee_org_id = trainee_org_id;
	}
	public String getTrainee_course_id() {
		return trainee_course_id;
	}
	public void setTrainee_course_id(String trainee_course_id) {
		this.trainee_course_id = trainee_course_id;
	}
	
	
		
	
	
	
	
}
