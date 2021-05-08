$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
			
		var href = $(this).attr('href');
			$.get(href, function(trainee, status){
			$('#idEdit').val(trainee.train_id);
			$('#idstartdate').val(trainee.train_start_date);
			
			$('#nameEdit').val(trainee.first_name);
			$('#lastnameEdit').val(trainee.middle_name);
			$('#traineecourseEdit').val(trainee.trainee_course_id);
			$('#traineeorgEdit').val(trainee.trainee_org_id);
			
			});					
		$('#editModal').modal();
	});
	
	$('table #deleteButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeleteButton').attr('href', href);
		
		$('#deleteModal').modal();
	});
		
});