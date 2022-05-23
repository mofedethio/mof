$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
			
		var href = $(this).attr('href');
			$.get(href, function(org, status){
			$('#idEdit').val(org.id);
			
			$('#orgEdit').val(org.orgname);
			$('#orgheadEdit').val(org.organizationhead);
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