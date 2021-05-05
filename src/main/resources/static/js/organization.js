$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
			
		var href = $(this).attr('href');
			$.get(href, function(org, status){
			$('#idEdit').val(org.org_id);
			
			$('#orgEdit').val(org.org_name);
			
			$('#emailEdit').val(org.email);
			$('#telephoneEdit').val(org.telephone);
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