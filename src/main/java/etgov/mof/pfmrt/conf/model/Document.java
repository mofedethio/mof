package etgov.mof.pfmrt.conf.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


    public class Document {
	
	@Id
	private String doc_id;
	
	private String doc_type;
	private String sub_deadline;
	
	@ManyToOne
	@JoinColumn(name="director_name",insertable=false,updatable=false)
	private Directorate directorate;
	private String director_name;
	
	
	
	public String getDirector_name() {
		return director_name;
	}
	public void setDirector_name(String director_name) {
		this.director_name = director_name;
	}
	@OneToMany(mappedBy="document")
	private List<PenaltyRule> penaltyrules;
	
	public Directorate getDirectorate() {
		return directorate;
	}
	public void setDirectorate(Directorate directorate) {
		this.directorate = directorate;
	}
	public String getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	public String getDoc_type() {
		return doc_type;
	}
	public void setDoc_type(String doc_type) {
		this.doc_type = doc_type;
	}
	public String getSub_deadline() {
		return sub_deadline;
	}
	public void setSub_deadline(String sub_deadline) {
		this.sub_deadline = sub_deadline;
	}
	public String getDir_name() {
		return director_name;
	}
	public void setDir_name(String dir_name) {
		this.director_name = dir_name;
	}
	
	
}
