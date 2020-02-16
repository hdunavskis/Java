var rootURL = "http://localhost:8080/Rest_FastFood/V1/view/";

var findAll=function() {
	
	$.ajax({
		type: 'GET',
		url: rootURL,
		dataType: "json", 
		success: renderCards
	});
};

var renderCards= function(data) {
	
	$.each(data, function(index, food) {
		
		$('#foodList').append(
				
				'<div class="card">'
				+$('#pic').attr('src', 'resources/images/' + food.picture)
				+'<img id="#pic" class="card-img-top" alt="..."/>'
				+'<div class="card-body">'+'<h5 class= "card-title">' + food.name + '</h5>' 
				+ '<p class="card-text">'
				+ food.price + '&euro;</p>' + '<a href = "#" class ="btn btn-primary">' + "Go" + '</a>' 
				+'</div></div>');
	});
};
$(document).ready(function(){
	findAll();
	
});

