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
		var foodpic = "resources/images/"+food.picture
		console.log(foodpic);
		$('#foodList').append(
					
				'<div class="card">'
				+'<a href="#">'+' <img height=300 width = 200 src='+foodpic  + ' class="card-img-top" alt="..."/> </a>'
				+'<div class="card-body">'+'<h5 class= "card-title">' + food.name + '</h5>' 
				+ '<p class="card-text">'
				+ food.price + '&euro;</p>' + '<a href = "#" class ="btn btn-primary btn-lg btn-block">' + "Order Now" + '</a>' 
				+'</div></div>');
	});
};
$(document).ready(function(){
	console.log("asfasdfasf");
	findAll();
	
});

