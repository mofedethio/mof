package etgov.mof.pfmrt.conf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@DynamicUpdate
  public class MasterTransaction extends Auditable<String> {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long transaction_id;
	 	    
	    private String upload_doc;
		//private Date submission_date;  replaced by auditable createdDate
		// private Date verifydate;
		// private String verify by     // replaced by auditable 
		
		@Column(length=50)
		private String remarks;
		
		private String status;
		
		
	
		public Long getTransaction_id() {
			return transaction_id;
		}

		public void setTransaction_id(Long transaction_id) {
			this.transaction_id = transaction_id;
		}

		public String getUpload_doc() {
			return upload_doc;
		}

		public void setUpload_doc(String upload_doc) {
			this.upload_doc = upload_doc;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Organization getOrganiza() {
			return organiza;
		}

		public void setOrganiza(Organization organiza) {
			this.organiza = organiza;
		}

		public Document getTransactiondocument() {
			return transactiondocument;
		}

		public void setTransactiondocument(Document transactiondocument) {
			this.transactiondocument = transactiondocument;
		}

		public User getUser2() {
			return user2;
		}

		public void setUser2(User user2) {
			this.user2 = user2;
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		@JsonIgnore
		@ManyToOne
		@JoinColumn(name="user_id", updatable =false)
		private User user;
		
		@ManyToOne
		@JoinColumn(name="organizaid", insertable =false,updatable =false)
		private Organization organiza;
		String organizaid;
		
		public String getOrganizaid() {
			return organizaid;
		}

		public void setOrganizaid(String organizaid) {
			this.organizaid = organizaid;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		
		@ManyToOne
		@JoinColumn(name="trans_doc_id",insertable=false,updatable=false)
		private Document transactiondocument;
		private  String trans_doc_id;
		

		
		public String getTransc_doc_id() {
			return trans_doc_id;
		}

		public void setTransc_doc_id(String transc_doc_id) {
			this.trans_doc_id = transc_doc_id;
		}

		@JsonIgnore
		@ManyToOne
		@JoinColumn(name="assigned_expert_user_id", insertable= false ,updatable =false)
		private User user2;

  }

