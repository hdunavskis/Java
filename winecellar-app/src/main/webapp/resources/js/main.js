var rootURL = "http://localhost:8080/WineCellarEJB/V1/wines/";

var findAll=function() {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURL,
		dataType: "json", // data type of response
		success: function(data){
			$('#dataTable').DataTable({
				"aaData": data,
				columns:[
					{data: 'name'},
					{data: 'grapes'},
					{data: 'country'},
					{data: 'year'}
				]
			});
		}
	});
};

var renderTable= function(data) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
	//var list = data == null ? [] : (data instanceof Array ? data : [data]);
    var list=data;
	
	$.each(list, function(index, wine) {
		$('#dataTable').append('<tr><td>' + wine.name + '</td><td>'+wine.grapes+'</td><td>' +
				wine.country + '</td><td>' + wine.year + '</td></tr>');
	});
};

$('#dataTable').DataTable({
	"ajax":{
		"url":rootURL,
		"type": "GET"
	}
});
$(document).ready(function(){
	findAll();
	//$('#dataTable').DataTable();
});

