package etgov.mof.pfmrt.conf.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PenaltyRule {
	
	@Id
	private Long  penalty_id;
	
	
	@ManyToOne
	@JoinColumn(name="pen_rule_doc_id",insertable=false,updatable=false)
	private Document document;
	private String pen_rule_doc_id;
	
	
	
	public String getPen_rule_doc_id() {
		return pen_rule_doc_id;
	}

	public void setPen_rule_doc_id(String pen_rule_doc_id) {
		this.pen_rule_doc_id = pen_rule_doc_id;
	}

	private Integer penalty_no_days;
	
	private String penality_type;
	private Integer penalty_level;
	
	private Double director_penalty;
	private Double minister_penalty;
	
	private String letter_template;

	public Long getPenalty_id() {
		return penalty_id;
	}

	public void setPenalty_id(Long penalty_id) {
		this.penalty_id = penalty_id;
	}

	public Integer getPenalty_no_days() {
		return penalty_no_days;
	}

	public void setPenalty_no_days(Integer penalty_no_days) {
		this.penalty_no_days = penalty_no_days;
	}

	public String getPenality_type() {
		return penality_type;
	}

	public void setPenality_type(String penality_type) {
		this.penality_type = penality_type;
	}

	public Integer getPenalty_level() {
		return penalty_level;
	}

	public void setPenalty_level(Integer penalty_level) {
		this.penalty_level = penalty_level;
	}

	public Double getDirector_penalty() {
		return director_penalty;
	}

	public void setDirector_penalty(Double director_penalty) {
		this.director_penalty = director_penalty;
	}

	public Double getMinister_penalty() {
		return minister_penalty;
	}

	public void setMinister_penalty(Double minister_penalty) {
		this.minister_penalty = minister_penalty;
	}

	public String getLetter_template() {
		return letter_template;
	}

	public void setLetter_template(String letter_template) {
		this.letter_template = letter_template;
	}
	
	
}
