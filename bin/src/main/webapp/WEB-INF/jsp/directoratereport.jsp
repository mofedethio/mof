

<%@ include file="/WEB-INF/jsp/common/headers.jsp"%>
<%@ include file="/WEB-INF/jsp/common/footers.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Master Transaction Lists</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.css"/>
 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/fixedheader/3.1.7/css/fixedHeader.dataTables.min.css"/>
 </head>
 <body>
<div class="container">
<br>
<br>
<br><br>
	<div>
					<table class="table table-striped table-advance  table-bordered " id="datatable"  >
                <thead class="thead-dark">
                  <tr>
                     
                     <th><i class="icon_table"></i>Submission Date</th>
                    <th><i class="icon_table"></i> Username</th>
                     <th><i class="icon_table"></i>Document</th>
                     <th><i class="icon_table"></i>Status</th>
                      <th><i class="icon_table"></i>File Name</th>
                     <th><i class="icon_table"></i>Download</th>
                                        
                    <th><i class="icon_cogs"></i>Actions</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${mastertransactionlists}" var="transaction">
						<tr>
							<td>${transaction.createdDate}</td>
							<td>${transaction.createdBy}</td>
							<td>${transaction.transactiondocumentid}</td>
							<td>${transaction.docName}</td>
							<td>${transaction.docName}</td>
					        <td><a href="download?id=${transaction.id}">Download</a></td>
					         					 
							<td><a type="button" class="btn btn-success"
								href="">Update</a>
							<a type="button" class="btn btn-warning"
								href="">Details</a></td>
								
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
            <label for="recipient-name" class="col-form-label">Organization:</label>
            <input type="text" class="form-control" id="recipient-name" name="orgname"  required>
          </div>
        
          
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Telephone:</label>
            <input type="text" class="form-control" id="recipient-name" name="telephone">
          </div>
        
                  
        
          <div class="form-group">
          <button type="submit" class="btn btn-primary">Save</button>        
        </div>             
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>




<script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>
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
    	"iDisplayLength": 2,
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
        } );
} );
</script>
</body>
</html>

  