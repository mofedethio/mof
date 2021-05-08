$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
			$.get(href, function(dirdoc, status){
			$('#idedit').val(dirdoc.doc_id);
			$('#docTypeEdit').val(dirdoc.doc_type);
			$('#diredit').val(dirdoc.director_name);
			$('#deadlineEdit').val(dirdoc.sub_deadline);
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