<%@ include file="/WEB-INF/jsp/common/headers.jsp"%>
<%@ include file="/WEB-INF/jsp/common/footers.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Trainee</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.css"/>
 <script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
 </head>
 <body>
<div class="container">
<br>
<br>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal" >New Trainee</button>
<br><br>
	<div class="panel panel-primary">
					<table class="table table-striped table-advance  table-bordered " id="datatable"  >
                <thead class="thead-dark">
                  <tr>
                    
                    <th><i class="icon_table"></i>Id</th>
                    <th><i class="icon_table"></i>First Name</th>
                     <th><i class="icon_table"></i>Middle Name</th>
                    <th><i class="icon_table"></i>Train Start Date</th>
                    <th><i class="icon_table"></i>Course Id</th>
                    <th><i class="icon_table"></i>Train Course Id</th>
                    <th><i class="icon_cogs"></i>Actions</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${trainees}" var="trainee">
                 
						<tr>
						    <td>${trainee.train_id}</td>
							<td>${trainee.first_name}</td>
							<td>${trainee.middle_name}</td>
							<td>${trainee.train_start_date}</td>
							<td>${trainee.trainee_course_id}</td>
							<td>${trainee.trainee_org_id}</td>
							
							
							
							<td><a type="button" class="btn btn-success" id="editButton"
								href="/trainees/findById?id=${trainee.train_id}">Update</a>
							<a type="button" class="btn btn-warning" id="deleteButton"
								href="/trainees/delete?id=${trainee.train_id}">Delete</a></td>
							
								  
						</tr>
					</c:forEach>
        </tbody>
        
       </table>
	</div>
</div>
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document" style="width:100%">
    <div class="modal-content">
      <div class="modal-header">
        <h3 class="modal-title" id="exampleModalLabel">New Trainee  Registration</h3>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="/trainees/addNew" method="post">
        
        
		<table width="100%">
			<tr>
				<td width="50%">
				
				<div class="form-group row">
            <label for="recipient-name" class="col-sm-4 col-form-label">Id:</label>
             <div class="col-sm-6">
            <input type="text" class="form-control" id="recipient-name" name="train_id" >
             </div>
          </div> 
          
             <div class="form-group row">
            <label for="recipient-name"  class="col-sm-4 col-form-label">Start Date:</label>
            <div class="col-sm-6">
            <input type="date" class="form-control" id="recipient-name" name="train_start_date"  >
            </div>
          </div> 
          
          <!--  
          <div class="form-group row" class="col-sm-4 col-form-label">
            <label for="recipient-name" class="col-sm-4 col-form-label">End Date:</label>
            <div class="col-sm-6">
            <input type="date" class="form-control" id="recipient-name" name="enddate"  required>
            </div>
          </div>
          -->
                   
          <div class="form-group row" class="col-sm-4 col-form-label">
            <label for="recipient-name" class="col-sm-4 col-form-label">  First Name:</label>
            <div class="col-sm-6">
            <input type="text" class="form-control" id="recipient-name" name="first_name"  required>
            </div>
          </div>
        
        </td>
        
        
		<td width="50%" style="padding-left:10px">
          <div class="form-group row" class="col-sm-4 col-form-label">
            <label for="recipient-name" class="col-sm-4 col-form-label">Middle Name:</label>
            <div class="col-sm-6">
            <input type="text" class="form-control" id="recipient-name" name="middle_name"    required>
            </div>
          </div>
        <div class="form-group row"  class="col-sm-4 col-form-label">
		    <label for="trainee" class="col-sm-4 col-form-label">Course: </label>
		    <div class="col-sm-6">
			    <select class="form-control" id="ddlDocumentAdd" name="trainee_course_id" required>
			       <option>-SELECT-</option>
			     	   
			       <c:forEach items="${courses}" var="course">
				      <option value="${course.course_id}">${course.course_name}
				   </option>
				   </c:forEach>
			    </select>	
			    </div>		    
		  </div>  
         <div class="form-group row"  class="col-sm-4 col-form-label">
		    <label for="ddlCountryDetails" class="col-sm-4 col-form-label">Organization: </label>
		    <div class="col-sm-6">
			    <select class="form-control" id="ddlDocumentAdd" name="trainee_org_id" required>
			       <option>-SELECT-</option>
			     	   
			       <c:forEach items="${organizations}" var="org">
				      <option value="${org.org_id}">${org.org_name}
				   </option>
				   </c:forEach>
			    </select>	
			  </div>  		    
		  </div> 
		    
		  <!--  
		  <div class="form-group row" class="col-sm-4 col-form-label">
            <label for="recipient-name" class="col-sm-4 col-form-label">Exam Score:</label>
            <div class="col-sm-6">
            <input type="text" class="form-control" id="recipient-name" name="examscore" required>
            </div>
          </div>  
        -->
          
        
      <div class="modal-footer">
        <div class="form-group row" class="col-sm-4 col-form-label">
          <button type="submit" class="btn btn-primary">Save</button>  
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>      
        </div> 
      </div>
      </td>
        </tr> 
        </table>           
        </form>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="editModal" tabindex="-1"  role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document" style="width:100%">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Update Trainee</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="/trainees/update" method="put"> 
            
            
            
         <table width="100%">
			<tr>
				<td width="50%">
				
				<div class="form-group row">
            <label for="recipient-name" class="col-sm-4 col-form-label">Id:</label>
             <div class="col-sm-6">
            <input type="text" class="form-control" id="idEdit" name="train_id">
             </div>
          </div> 
          
             <div class="form-group row">
            <label for="recipient-name"  class="col-sm-4 col-form-label">Start Date:</label>
            <div class="col-sm-6">
            <input type="date" class="form-control" id="idstartdate" name="train_start_date">
            </div>
          </div> 
          
       
                   
          <div class="form-group row" class="col-sm-4 col-form-label">
            <label for="recipient-name" class="col-sm-4 col-form-label">  First Name:</label>
            <div class="col-sm-6">
            <input type="text" class="form-control" id="nameEdit" name="first_name">
            </div>
          </div>
        
        </td>
        
		<td width="50%" style="padding-left:10px">
          <div class="form-group row" class="col-sm-4 col-form-label">
            <label for="recipient-name" class="col-sm-4 col-form-label">Middle Name:</label>
            <div class="col-sm-6">
            <input type="text" class="form-control" id="lastnameEdit" name="middle_name" >
            </div>
          </div>
        <div class="form-group row"  class="col-sm-4 col-form-label">
		    <label for="trainee" class="col-sm-4 col-form-label">Course: </label>
		    <div class="col-sm-6">
			    <select class="form-control" id="traineecourseEdit" name="trainee_course_id" >
			       <option>-SELECT-</option>
			     	   
			       <c:forEach items="${courses}" var="course">
				      <option value="${course.course_id}">${course.course_name}
				   </option>
				   </c:forEach>
			    </select>	
			    </div>		    
		  </div>  
         <div class="form-group row"  class="col-sm-4 col-form-label">
		    <label for="ddlCountryDetails" class="col-sm-4 col-form-label">Organization: </label>
		    <div class="col-sm-6">
			    <select class="form-control" id="traineeorgEdit" name="trainee_org_id" >
			       <option>-SELECT-</option>
			     	   
			       <c:forEach items="${organizations}" var="org">
				      <option value="${org.org_id}">${org.org_name}
				   </option>
				   </c:forEach>
			    </select>	
			  </div>  		    
		  </div>   
 
      
       <div class="modal-footer">
        <div class="form-group row" class="col-sm-4 col-form-label">
          <button type="submit" class="btn btn-primary">Save</button>  
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>      
        </div> 
      </div>
      </td>
      </tr>
      </table>
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
<script type ="text/javascript"  src="js/trainee.js"></script>
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

  