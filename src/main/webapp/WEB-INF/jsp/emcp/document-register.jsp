<%@ include file="/WEB-INF/jsp/common/headers.jsp"%>
<%@ include file="/WEB-INF/jsp/common/footers.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Document List</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.css"/>
 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/fixedheader/3.1.7/css/fixedHeader.dataTables.min.css"/>
 <script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
 </head>
 <body>
<div class="container">
<br>
<br>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal" >New Document</button>
<br><br>
	<div class="panel panel-primary">
					<table class="table table-striped table-advance  table-bordered " id="datatable"  >
                <thead class="thead-dark">
                  <tr>
                    
                    <th><i class="icon_table"></i>Document ID</th>
                    <th><i class="icon_table"></i>Directorate</th>
                    <th><i class="icon_table"></i>Doc Type</th>
                    <th><i class="icon_table"></i>Deadline</th>
                    
                    <th><i class="icon_cogs"></i>Actions</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${documents}" var="dirdoc">
						<tr>
						    <td>${dirdoc.doc_id}</td>
						    <td>${dirdoc.dir_name}</td>
						    <td>${dirdoc.doc_type}</td>
							<td>${dirdoc.sub_deadline}</td>
								<td><a type="button" class="btn btn-success" id="editButton"
								href="/documents/findById?id=${dirdoc.doc_id}">Update</a>
							<a type="button" class="btn btn-warning" id="deleteButton"
								href="/documents/delete?id=${dirdoc.doc_id}">Delete</a></td>
								  
						</tr>
					</c:forEach>
        </tbody>
        
       </table>
	</div>
</div>
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">  New Document</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="/documents/addNew" method="post" enctype  ="multipart/form-data">
             
             
             <div class="form-group">
		    <label for="ddlCountryDetails" class="col-form-label">Directorate: </label>
			    <select class="form-control" id="ddlDocumentAdd" name="director_name" required>
			       <option>-SELECT-</option>
			          
			       <c:forEach items="${directorates}" var="dir">
				      <option value="${dir.dir_name}">${dir.dir_name}
				   </option>
				   </c:forEach>
			    </select>	
			    		    
		  </div>  
		  
		  <div class="form-group">
            <label for="recipient-name" class="col-form-label">Document ID:</label>
            <input type="text" class="form-control" id="recipient-name" name="doc_id"  required>
          </div>        
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Doc Type:</label>
            <input type="text" class="form-control" id="recipient-name" name="doc_type"  required>
          </div>
        
        
        <div class="form-group">
            <label for="recipient-name" class="col-form-label">submission deadline:</label>
            <input type="text" class="form-control" id="recipient-name" name="sub_deadline"  required>
          </div>
          <div class="form-group">
          <button type="submit" class="btn btn-primary">Save</button>  
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>      
        </div>             
        </form>
      </div>
      <div class="modal-footer">
        
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="editModal" tabindex="-1"  role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Update Documents</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="/documents/update" method="put"> 
            
          
           <div class="form-group">
            <label for="recipient-name" class="col-form-label">Document ID:</label>
            <input type="text" class="form-control" id="idedit" name="doc_id"   readonly >
          </div>
        
        <div class="form-group">
		    <label for="ddlCountryDetails" class="col-form-label">Directorate: </label>
			    <select class="form-control" id="diredit" name="director_name" required>
			       <option>-SELECT-</option>
			          
			       <c:forEach items="${directorates}" var="dir">
				      <option value="${dir.dir_name}">${dir.dir_name}
				   </option>
				   </c:forEach>
			    </select>	
			    		    
		  </div>  
          <div class="form-group">
            <label for="recipient-email" class="col-form-label">Report Type:</label>
            <input type="text" class="form-control" id="docTypeEdit" name="doc_type">
          </div>
          
           <div class="form-group">
            <label for="recipient-email" class="col-form-label">Deadline:</label>
            <input type="text" class="form-control" id="deadlineEdit" name="sub_deadline">
          </div>
        
          <div class="form-group">
          <button type="submit" class="btn btn-primary">Submit</button> 
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>       
        </div>             
       
      
      
         </form>
                 
      </div>
    </div>
  </div>
</div>
<div class="modal" id="deleteModal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Confirm Delete</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Are you sure you want to delete this record?</p>
      </div>
      <div class="modal-footer">
        <a class="btn btn-primary" id="confirmDeleteButton" href="">Yes, Delete</a>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
      </div>
    </div>
  </div>
</div>

<%@ include file="/WEB-INF/jsp/common/footers.jsp"%>
<script type ="text/javascript"  src="js/document.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.flash.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.print.min.js"></script>
<script>
$(document).ready(function() {
    $('#datatable').DataTable( {
    	"iDisplayLength": 5,
        dom: 'Bfrtip',
        buttons: [
             'excel', 'pdf', 'print'
        ]
        } );
} );
</script>

</body>
</html>





  