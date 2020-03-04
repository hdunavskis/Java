var rootURL = "http://localhost:8080/Rest_FastFood/V1/food";

var findAll=function() {
	
	$.ajax({
		type: 'GET',
		url: rootURL,
		dataType: "json", 
		success: renderCards
	});
};

var findAllOrders=function() {
	$.ajax({
		type: 'GET',
		url: rootURL + "/orders",
		dataType: "json", 
		success: function(data){
			$('#dataTable').DataTable({
				"aaData": data,
				columns:[
					{data: null,
			            defaultValue: ''},
					{data: 'orderId'},
					{data: 'foodName'},
					{data: 'amount'},
					{data: 'noteToKitchenStaff'}
				],
				columnDefs: [
				      {
				         'targets': 0,
				         'orderable': false,
				         'checkboxes': {
				        	 'selectRow': true
				         }
				      	
				      }
				   ],
				   
			});
		}
	});
};


var renderCards= function(data) {
	
	$.each(data, function(index, food) {
		var foodpic = "resources/images/"+food.picture
		
		$('#foodList').append(
					
				'<div class="card">'
				+'<a id="myPic" href="#">'+' <img height=300 width = 200 src='+ foodpic  + ' class="card-img-top" alt="..."/> </a>'
				+'<div class="card-body">'+'<h5 class= "card-title">' + food.name + '</h5>' 
				+ '<p class="card-text">'
				+ parseFloat(food.price).toFixed(2) + '&euro;</p>' + '<a href = "#" class ="btn btn-primary btn-lg btn-block" data-toggle="modal" data-target="#loginModal">' + "Order Now" + '</a>' 
				+'</div></div>');
	});
};

var renderTable= function(data) {
    var list=data;
	
	$.each(list, function(index, order) {
		$('#dataTable').append(
				'<tr><td>' + order.orderId + 
				'</td><td>'+order.foodName+
				'</td><td>' +order.amount + 
				'</td><td>' + order.noteToKitchenStaff + 
				'</td><td>'+ '<input type="checkbox" id="vehicle1" name="vehicle1" value="Bike">'+
				'</td></tr>');
	});
};



$(document).ready(function(){
	
	if(top.location.pathname === '/Rest_FastFood/menu.html'){
		findAll();
	}
	else if(top.location.pathname === '/Rest_FastFood/orders.html'){
		findAllOrders();
	}
});

