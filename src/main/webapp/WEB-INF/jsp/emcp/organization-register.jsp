<%@ include file="/WEB-INF/jsp/common/headers.jsp"%>
<%@ include file="/WEB-INF/jsp/common/footers.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Organization List</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.css"/>
 <script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
 </head>
 <body>
<div class="container">
<br>
<br>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal" >New Organization</button>
<br><br>
	<div class="panel panel-primary">
					<table class="table table-striped table-advance  table-bordered " id="datatable"  >
                <thead class="thead-dark">
                  <tr>
                  
                    <th><i class="icon_table"></i>Organization Code</th>
                    <th><i class="icon_table"></i>Organization</th>
                    <th><i class="icon_table"></i>Financial Head</th>
                    <th><i class="icon_table"></i>Email</th>
                    <th><i class="icon_table"></i>Telephone</th>
                    <th><i class="icon_cogs"></i>Actions</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${organizations}" var="org">
						<tr>
						     <td>${org.org_id}</td>
							<td>${org.org_name}</td>
							<td>${org.email}</td>
							<td>${org.telephone}</td>
							<td>${org.status}</td>
							
							<td><a type="button" class="btn btn-success" id="editButton"
								href="/organizations/findById?id=${org.org_id}">Update</a>
							<a type="button" class="btn btn-warning" id="deleteButton"
								href="/organizations/delete?id=${org.org_id}">Delete</a></td>
							
								  
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
        <h5 class="modal-title" id="exampleModalLabel">New Organization</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="/organizations/addNew" method="post">
        
        <div class="form-group">
            <label for="recipient-name" class="col-form-label">OrganizationID:</label>
            <input type="text" class="form-control" id="recipient-name" name="org_id"  required>
          </div>
                       
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Organization:</label>
            <input type="text" class="form-control" id="recipient-name" name="org_name"  required>
          </div>
          
        
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Email:</label>
            <input type="email" class="form-control" id="recipient-name" name="email"    required>
          </div>
        
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Telephone:</label>
            <input type="text" class="form-control" id="recipient-name" name="telephone">
          </div>
           <div class="form-group">
            <label for="recipient-name" class="col-form-label">Organization Head:</label>
            <input type="text" class="form-control" id="recipient-name" name="status"  required>
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
        <h5 class="modal-title" id="exampleModalLabel">Update Organization</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="/organizations/update" method="put"> 
            
          <div class="form-group">
            <label for="recipient-id" class="col-form-label">ID:</label>
            <input type="text" class="form-control" id="idEdit" name="id" readonly>
          </div>
        
                    
          <div class="form-group">
            <label for="recipient-email" class="col-form-label">Organization:</label>
            <input type="text" class="form-control" id="orgEdit" name="orgname">
          </div>
        
        <div class="form-group">
            <label for="recipient-email" class="col-form-label">Organization Head:</label>
            <input type="text" class="form-control" id="orgheadEdit" name="organizationhead">
          </div>
          
          <div class="form-group">
            <label for="recipient-email" class="col-form-label">Email:</label>
            <input type="text" class="form-control" id="emailEdit" name="email">
          </div>
        
          <div class="form-group">
            <label for="recipient-telephone" class="col-form-label">telephone:</label>
            <input type="text" class="form-control" id="telephoneEdit" name="telephone">
          </div>
          
          <!--  
          <div class="form-group">
            <button type="submit" class="btn btn-primary">Submit</button>     
        </div>             
       -->
      
      <div class="modal-footer">
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
<script type ="text/javascript"  src="js/organization.js"></script>
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
</script></body>
</html>

  