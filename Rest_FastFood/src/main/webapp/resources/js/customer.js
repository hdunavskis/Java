var rootURL = "http://localhost:8080/Rest_FastFood/V1/";

var findAllNotPaidOrders =function() {
	$.ajax({
		type: 'GET',
		url: rootURL + "orders/customer/" +localStorage.getItem("customerID"),
		dataType: "json", 
		success: renderTable
	});
};

var findAllFood=function() {
	$.ajax({
		type: 'GET',
		url: rootURL+"food",
		dataType: "json", 
		success: renderFood
	});
};

var renderFood= function(data) {
	
	$.each(data, function(index, food) {
		$('#food').append(
					
			'<option id="'+food.name +'">' + food.name + '</option>'
		);
	});
};

var renderTable= function(data) {
    var list=data;
	
	$.each(list, function(index, order) {
		$('#customerOrders').append(
				'<tr><td>' + order.orderId + 
				'</td><td>'+order.foodName+
				'</td><td>' +order.amount + 
				'</td><td><textarea readonly class="form-control" rows="2">'+order.noteToKitchenStaff+'</textarea>'+
				'</td><td> <button id="'+order.orderId+'" type="button" class="btn btn-info">' + "Change" +'</button>'+
				'</td><td> <button id="'+order.orderId+'" type="button" class="btn btn-success">' + "Pay" +'</button>'+
				'</td></tr>');
	});
};
/*
var placeAnOrder =function() {
	$.ajax({
		type: 'POST',
		data:{
			orderId: null,
			customerId: localStorage.getItem("customerID"),
			foodName: "FoodName4",
			"amount": 1,
			"noteToKitchenStaff": "note",
			"isReady": false,
			"isPaid": true
		}
		url: rootURL + "orders/",
		dataType: "json", 
		success: renderTable
	});
};*/

$(document).ready(function(){
	
	if(!sessionStorage.getItem('customer')){
		location.href="index.html";
	}
	findAllFood();
	findAllNotPaidOrders();
});