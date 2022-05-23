package etgov.mof.pfmrt.conf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import etgov.mof.pfmrt.conf.util.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  public class MasterTransaction extends Auditable<String> {
	

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 private String docname;
	 private String reportstatus;
		
	 
		
		@ManyToOne
		//the updatable equalto false is used to not update the user id when the status is updated!
		@JoinColumn(name="user_id",updatable =false)
		private User user;
		
		
		@ManyToOne
		@JoinColumn(name="org_id", insertable =false,updatable =false)
		private Organization organization;
		private String org_id;
		
		public String getReportstatus() {
			return reportstatus;
		}

		public void setReportstatus(String reportstatus) {
			this.reportstatus = reportstatus;
		}

		@ManyToOne
		@JoinColumn(name="transactiondocumentid",insertable=false,updatable=false)
		private Document transactiondocument;
		private  String transactiondocumentid;
		
		
		public Document getTransactiondocument() {
			return transactiondocument;
		}

		public void setTransactiondocument(Document transactiondocument) {
			this.transactiondocument = transactiondocument;
		}

		public String getTransactiondocumentid() {
			return transactiondocumentid;
		}

		public void setTransactiondocumentid(String transactiondocumentid) {
			this.transactiondocumentid = transactiondocumentid;
		}
				
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getDocname() {
			return docname;
		}

		public void setDocname(String docname) {
			this.docname = docname;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Organization getOrganization() {
			return organization;
		}

		public void setOrganization(Organization organization) {
			this.organization = organization;
		}

		public String getOrg_id() {
			return org_id;
		}

		public void setOrg_id(String org_id) {
			this.org_id = org_id;
		}

	
		
	
  }

