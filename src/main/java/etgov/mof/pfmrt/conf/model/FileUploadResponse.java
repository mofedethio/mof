package etgov.mof.pfmrt.conf.model;



public class FileUploadResponse {
	
	private String docname;
	private String contentType;
	private String url;
	
	public FileUploadResponse(String docname, String contentType, String url) {
		super();
		this.docname = docname;
		this.contentType = contentType;
		this.url = url;
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
	
	

		
	}

	
