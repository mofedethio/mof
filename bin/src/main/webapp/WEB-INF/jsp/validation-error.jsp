<%@ include file="/WEB-INF/jsp/common/headers.jsp"%>
<%@ include file="/WEB-INF/jsp/common/footers.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%> 
<br>
<br>
<br>


<div class="container">
<h3>User Registration Form Validation</h3>

        <form:form action="/signup" method="POST" modelAttribute="user">
        <table width="100%">
			<tr>
				<td width="50%">
				
			<spring:bind path="firstName">
             <div class="form-group row ${status.error ? 'has-error' : ''}">
                <label for="recipient-name" class="col-sm-4 col-form-label">FirstName:</label>
               <div class="col-sm-6">
                   <input type="text" class="form-control" id="recipient-name" name="firstName"  >
                
              </div>
            </div>
            </spring:bind>
            
            <spring:bind path="lastName">
         <div class="form-group row ${status.error ? 'has-error' : ''}">
            <label for="recipient-name" class="col-sm-4 col-form-label">LastName:</label>
            <div class="col-sm-6">
            <input type="text" class="form-control" id="recipient-name" name="lastName"  >
           
            </div>
          </div>
          </spring:bind>
          
               
             
             <spring:bind path="username">      
          <div class="form-group row ${status.error ? 'has-error' : ''}">
            <label for="recipient-name" class="col-sm-4 col-form-label">Username:</label>
            <div class="col-sm-6">
            <input type="text" class="form-control" id="recipient-name" name="username"  required>
             <form:errors path="username"></form:errors>
            </div>
          </div>
          </spring:bind>
          </td>
		<td width="50%" style="padding-left:10px">
        <spring:bind path="password">
          <div class="form-group row ${status.error ? 'has-error' : ''}">
            <label for="recipient-name" class="col-sm-4 col-form-label">Password:</label>
            <div class ="col-sm-6">
            <input type="text" class="form-control" id="recipient-name" name="password"  >
            <form:errors path="password"></form:errors>
            </div>
          </div>
          </spring:bind>
          
          <spring:bind path="confirmPassword">
           <div class="form-group row ${status.error ? 'has-error' : ''}">
            <label for="recipient-name" class="col-sm-4 col-form-label">Confirm:</label>
            <div class ="col-sm-6">
            <input type="text" class="form-control" id="recipient-name" name="confirmPassword" >
           <form:errors path="confirmPassword"></form:errors>
            
            </div>
          </div>
          
          </spring:bind>
          
          <div class="form-group row">
		    <label for="trainee" class="col-sm-4 col-form-label">Organization: </label>
		    <div class ="col-sm-6">
			    <select class="form-control" id="orgid" name="org_id"  >
			       <option>--SELECT--</option>
			     	 <c:forEach items="${organizations}" var="course">
				      <option value="${course.id}">${course.orgname}
				   </option>
				   </c:forEach>
			    </select>	
			    </div>		    
		  </div> 
		  
          
          
          <!-- the following id="roles" and name ="roles" is very important to add user_id and role_id in to db -->

		<div class="form-group row">
			<label class="col-sm-4 control-lable" for="roles">
					Roles:</label>
				<div class="col-sm-6">
					<select class="form-control"  id="roles"  name="roles">
						<option>--SELECT--</option>
							<c:forEach items="${roles}"  var="role">
						<option value="${role.id}">${role.name} </option>
							</c:forEach>
					</select>

				</div>
			</div>
	 						

     <!--  
        the following is another jsp for role list
        
        <div class="form-group row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="roles"> Roles:</label>
                <div class="col-md-7">
                    <form:select  path="roles" role="${roles}" 
                    items="${roles}" multiple="true"  itemValue="id"
                    itemLabel="name" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="roles" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
    
        -->


      </td>
      </tr>
      </table>
      </form:form>
       
  

</div>
     
        
    
      