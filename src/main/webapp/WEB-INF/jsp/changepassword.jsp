<%@ include file="/WEB-INF/jsp/common/headers.jsp"%>
  <%@ include file="/WEB-INF/jsp/common/footers.jsp"%>
  
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="container">
<div class="col-md-6">

<form action="/editUser/changePassword" method="post">
<div class="container">
<h3 class="mb-3">Change Password</h3>
<div class="col-md-6">


<!-- Enter old password -->
 <div class="form-group">
        	<div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text">
                        <span class="fa fa-lock"></span>
                    </span>                    
                </div>
                <input type="password" class="form-control" name="password" placeholder="Enter Old Password" required="required">				
            </div>
        </div>


<!-- Enter new password -->

<div class="form-group">
        	<div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text">
                        <span class="fa fa-lock"></span>
                    </span>                    
                </div>
                <input type="password" class="form-control" name="newPassword" placeholder="Enter New Password" required="required">				
            </div>
        </div>
       


<!-- Enter confirm password -->

        
        <div class="form-group">
        	<div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text">
                        <span class="fa fa-lock"></span>
                    </span>                    
                </div>
                <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm Password" required="required">				
            </div>
        </div>

<div class="container ">
<button type="submit" class="btn btn-success"> Change Password</button>
</div>
</div>
</div>
</form>
</div>

</div>

<script type="text/javascript">
function submitChangePassword(){
	var params = {};
	params["id"] = $("#id").val();
	params["password"] = $("#password").val();
	params["newPassword"] = $("#newPassword").val();
	params["confirmPassword"] = $("#confirmPassword").val();
	
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/editUser/changePassword",
        data: JSON.stringify(params),
        dataType: 'text',
        cache: false,
        timeout: 600000,
        success: function (data) {
        	$("#changePasswordForm")[0].reset();
        	
        	$("#changePasswordError").addClass( "d-none" );
        	$("#formSuccess").removeClass( "d-none" );
            $("#formSuccess").html("Password Actualizado exitosmante!.");

            $('#changePasswordModal').modal('toggle');
            setTimeout(function(){	$("#formSuccess").hide('slow'); }, 2000);
        },
        error: function (e) {
            $("#changePasswordError").removeClass( "d-none" );
            $("#formSuccess").addClass( "d-none" );
            $("#changePasswordError").html(e.responseText);
        }
    });

}
</script>
  