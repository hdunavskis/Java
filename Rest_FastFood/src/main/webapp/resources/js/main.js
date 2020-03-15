var rootURL = "http://localhost:8080/Rest_FastFood/V1/";

var findAll=function() {
	$.ajax({
		type: 'GET',
		url: rootURL+"food",
		dataType: "json", 
		success: renderCards
	});
};

var renderCards= function(data) {
	
	$.each(data, function(index, food) {
		var foodpic = "resources/images/"+food.picture
		
		$('#foodList').append(
					
				'<div class="card">'
				+'<img height=300 width = 200 src='+ foodpic  + ' class="card-img-top" alt="..."/> </img>'
				+'<div class="card-body">'+'<h5 class= "card-title">' + food.name + '</h5>' 
				+ '<p class="card-text">'
				+ parseFloat(food.price).toFixed(2) + '&euro;</p>' + '<button id="orderButton" class ="btn btn-primary btn-lg btn-block">' + "Order Now</button>" 
				+'</div></div>');
	});
};

$(document).ready(function(){
	findAll();
	
});

