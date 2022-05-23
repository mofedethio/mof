<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- replace charset=ISO-8859-1 with " UTF-8 "  for all character just like Amharic char-->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accountable User</title>

<!-- the following is for font-awesome -->
 <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
 <!-- end of font awesome -->
 <!-- css start for drop down menu -->
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" >
 <!-- css end for drop down menu -->
  
 <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
 
    
    <link href="${pageContext.request.contextPath}/css/style2.css" rel="stylesheet">
  
    
</head>
<body>
<nav class="navbar  navbar-expand-lg navbar-dark bg-dark navbar-fixed-top" style="height: 100px; ">

<div Class="container">
<div class="col-md-4">
<img src ="img/mofed.png"  height= "95" width = "110" alt="mofed logo" />
</div>




<div Class="col-md-2">

  <a class="navbar-brand" href="#">EMCP  System </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  </div>
  </div>
  
  
  
  <div Class="container">
  <div Class="col-md-5">
  <div Class="collapse navbar-collapse" id="collapse_target">
  <ul class="navbar-nav">
      <li class="nav-item  ">
        <a class="nav-link" href="welcome">Home</a>
      </li>
                  <sec:authorize access="hasRole('ADMIN')">
						
							<li class="nav-item dropdown "  >
							<a	class="nav-link dropdown-toggle" data-toggle="dropdown"
								data-target="dropdown_target"> Register </a>
								<div Class="dropdown-menu" aria-labelledby="dropdown_target">
									<a Class="dropdown-item" href="organizations">Organization
									</a>
									<div Class="dropdown-divider"></div>
									<a Class="dropdown-item" href="documents">Document </a>
									<div Class="dropdown-divider"></div>
									<a Class="dropdown-item" href="directorates">Directorate</a>
									<div Class="dropdown-divider"></div>
									<a Class="dropdown-item" href="trainees">Training </a>
									<div Class="dropdown-divider"></div>
									<a Class="dropdown-item" href="courses">Course </a>
									<div Class="dropdown-divider"></div>
									<a Class="dropdown-item" href="penaltyrules"> penalty rule</a>
									<div Class="dropdown-divider"></div>


								</div></li>


							<li class="nav-item dropdown "><a
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								data-target="dropdown_target"> User </a>
								<div Class="dropdown-menu" aria-labelledby="dropdown_target">
									<a Class="dropdown-item" href="userlist"> User</a> 
									 
									<div Class="dropdown-divider"></div>
									<a Class="dropdown-item" href="roles">Role</a> <a
										Class="dropdown-item" href="userprivilleges">Privilege</a>
								</div></li>



							<li class="nav-item dropdown "><a
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								data-target="dropdown_target"> Transaction </a>
								<div Class="dropdown-menu" aria-labelledby="dropdown_target">
									<a Class="dropdown-item" href="mastertransactionlists">Reports </a> 
									<a Class="dropdown-item" href="mastertransactionlists">Organization Reports </a> 
										<a Class="dropdown-item" href="#">Record Penalty </a>

									<div Class="dropdown-divider"></div>

								</div></li>
                           </sec:authorize>

					<sec:authorize access="hasRole('AUDIT')">

						
							<li class="nav-item dropdown "><a
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								data-target="dropdown_target"> Reports </a>
								<div Class="dropdown-menu" aria-labelledby="dropdown_target">
									<a Class="dropdown-item" href="audittransactionlists">View
										Reports</a>
									<div Class="dropdown-divider"></div>

								</div></li>
							<li class="nav-item dropdown "><a
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								data-target="dropdown_target"> Notification </a>
								<div Class="dropdown-menu" aria-labelledby="dropdown_target">
									<a Class="dropdown-item" href="index"> Messages</a>
									<div Class="dropdown-divider"></div>
								</div></li>
						
						
						</sec:authorize>

						<sec:authorize access="hasRole('BUDGET')">
							<li class="nav-item dropdown "><a
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								data-target="dropdown_target"> Reports </a>
								<div Class="dropdown-menu" aria-labelledby="dropdown_target">
									<a Class="dropdown-item" href="budgettransactionlists">View
										Reports</a>
									<div Class="dropdown-divider"></div>

								</div></li>
							<li class="nav-item dropdown "><a
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								data-target="dropdown_target"> Notification </a>
								<div Class="dropdown-menu" aria-labelledby="dropdown_target">
									<a Class="dropdown-item" href="index"> Messages</a>
									<div Class="dropdown-divider"></div>
								</div></li>
						</sec:authorize>


						<sec:authorize access="hasRole('INSPECTION')">
							<li class="nav-item dropdown "><a
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								data-target="dropdown_target"> Reports </a>
								<div Class="dropdown-menu" aria-labelledby="dropdown_target">
									<a Class="dropdown-item" href="inspectiontransactionlists">View
										Reports</a>
									<div Class="dropdown-divider"></div>

								</div></li>
							<li class="nav-item dropdown "><a
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								data-target="dropdown_target"> Notification </a>
								<div Class="dropdown-menu" aria-labelledby="dropdown_target">
									<a Class="dropdown-item" href="index"> Messages</a>
									<div Class="dropdown-divider"></div>
								</div></li>
						</sec:authorize>



                   <sec:authorize access="hasRole('CASH')">
							<li class="nav-item dropdown "><a
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								data-target="dropdown_target"> Reports </a>
								<div Class="dropdown-menu" aria-labelledby="dropdown_target">
									<a Class="dropdown-item" href="cashtransactionlists">View
										Reports</a>
									<div Class="dropdown-divider"></div>

								</div></li>
							<li class="nav-item dropdown "><a
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								data-target="dropdown_target"> Notification </a>
								<div Class="dropdown-menu" aria-labelledby="dropdown_target">
									<a Class="dropdown-item" href="index"> Messages</a>
									<div Class="dropdown-divider"></div>
								</div></li>
						</sec:authorize>



						<sec:authorize access="hasRole('ACCOUNT')">
							<li class="nav-item dropdown "><a
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								data-target="dropdown_target"> Reports </a>
								<div Class="dropdown-menu" aria-labelledby="dropdown_target">
									<a Class="dropdown-item" href="accounttransactionlists">View
										Reports</a>
									<div Class="dropdown-divider"></div>

								</div></li>
							<li class="nav-item dropdown "><a
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								data-target="dropdown_target"> Notification </a>
								<div Class="dropdown-menu" aria-labelledby="dropdown_target">
									<a Class="dropdown-item" href="index"> Messages</a>
									<div Class="dropdown-divider"></div>
								</div></li>

						</sec:authorize>



						<sec:authorize access="hasRole('PROPERTY')">
							<li class="nav-item dropdown "><a
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								data-target="dropdown_target"> Reports </a>
								<div Class="dropdown-menu" aria-labelledby="dropdown_target">
									<a Class="dropdown-item" href="propertytransactionlists">View
										Reports</a>
									<div Class="dropdown-divider"></div>

								</div></li>
							<li class="nav-item dropdown "><a
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								data-target="dropdown_target"> Notification </a>
								<div Class="dropdown-menu" aria-labelledby="dropdown_target">
									<a Class="dropdown-item" href="index"> Messages</a>
									<div Class="dropdown-divider"></div>
								</div></li>
						</sec:authorize>







						<sec:authorize access="hasRole('USER')">
							<li class="nav-item dropdown "><a
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								data-target="dropdown_target"> Reports </a>
								<div Class="dropdown-menu" aria-labelledby="dropdown_target">
									<a Class="dropdown-item" href="uploadToDirectors">Upload
										Report</a>


								</div></li>
							<li class="nav-item dropdown "><a
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								data-target="dropdown_target"> Resources </a>
								<div Class="dropdown-menu" aria-labelledby="dropdown_target">
									<a Class="dropdown-item" href="manuals">Manuals</a>
									<div Class="dropdown-divider"></div>
									<a Class="dropdown-item" href="downloads">downloads</a>
									<div Class="dropdown-divider"></div>
								</div></li>

							<li class="nav-item dropdown "><a
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								data-target="dropdown_target"> File History </a>
								<div Class="dropdown-menu" aria-labelledby="dropdown_target">
									<a Class="dropdown-item" href="orgtransactionlists">File History</a>
									<div Class="dropdown-divider"></div>
								</div></li>



						</sec:authorize>
						
					</ul>
      </div>
        
      </div>
  </div>

  <div Class="container">
  <div Class="col-md-1">
  <nav id="sideNav">
				<ul>
					<li><a href="dashboard1">Dashboard</a></li>
					
					<li><a href="login">Logout</a></li>
					<li><a href="profile">Profile</a></li>
					<li><a href="changePassword">Change Password</a></li>
					<li><a href="index">Dynamic Chart</a></li>
				</ul>

			</nav>
			<span class="navbar-toggler-icon" id="menuBtn"></span> 
			
  </div>
  </div>
</nav>
  
  
  
 




<!-- the following j-query is for active button menu when clickable and its very important for the side bar to move -->

   <script
  src="https://code.jquery.com/jquery-3.5.1.js">
  </script>
  
  <script type="text/javascript">
  $(document).on('click','ul li',function(){
	  $(this).addClass('active') .siblings().removeClass('active')
  })
  </script>
<!-- the above jquery and javascript is for adding and removing clickable button -->


	<script>
var $slides = $('.slides');
var $slide =  $('.slide1');
var count = 1;

$(document).ready(function(){
	setInterval(function(){
	$slides.animate({'margin-left':'-=68vw'},1200,function(){
		count++;
		if(count === 4){
			$slides.css("margin-left", 0);
			count = 1;
		}
	});	
		
	},4000);
});

var menuBtn=document.getElementById("menuBtn");
var sideNav=document.getElementById("sideNav");
sideNav.style.right="-250px";
menuBtn.onclick=function(){
	if(sideNav.style.right == "-250px"){
		sideNav.style.right = "0";	
}
	else {
		sideNav.style.right = "-250px";
	}
}

var scroll = new SmoothScroll('a[href*="#"]',{
	speed:1000,
	speedAsDuration: true
});


</script>



<!-- start for drop down menu  -->

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" ></script>
<!-- end for drop down menu -->




	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}webjars/bootstrap/3.3.6/css/js/bootstrap.min.js"></script>
</body>
</html>