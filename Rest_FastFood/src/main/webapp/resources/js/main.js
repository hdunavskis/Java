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
		success: table
	});
};

var table = function(data){
	$('#dataTable').DataTable({
		"aaData": data,
		columns:[
			{data: 'orderId'},
			{data: 'foodName'},
			{data: 'amount'},
			{data: 'noteToKitchenStaff'},
			{data: function(){
				return '<button id="confirmButton" type="button" class="btn btn-success">' + "Confirm" +'</button>';
			}},
			{data: function(){
				return '<button id="removeButton" type="button" class="btn btn-danger">' + "Ready" +'</button>';
			}}
			
		],
	});
};

var myTable = $('#dataTable').DataTable();
$(document).on("click", "#removeButton", function(){
	$(this).parent().parent().remove();
	
	
});

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

var renderTable= function(data) {
    var list=data;
	
	$.each(list, function(index, order) {
		$('#dataTable').append(
				'<tr><td>' + order.orderId + 
				'</td><td>'+order.foodName+
				'</td><td>' +order.amount + 
				'</td><td>' + order.noteToKitchenStaff + 
				'</td></tr>');
	});
};



var findUser=function() {
	var username = $('#username').val().trim();
	var password = $('#password').val().trim();
	$.ajax({
		type: 'GET',
		url: rootURL+ "/login",
		dataType: "text",
		beforeSend: function (xhr) {
		    xhr.setRequestHeader ("Authorization", "Basic " + btoa(username + ":" + password));
		},
		success: function(){
			
			sessionStorage.setItem('valid', true);
			$('#logout').show();
			location.href="makeAnOrder.html";
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('Login error' + textStatus);
		}
	});
};

$(document).ready(function(){
	
	if(!sessionStorage.getItem('valid')){
		$('#logout').hide();	
	}

	if(top.location.pathname === '/Rest_FastFood/menu.html'){
		
		findAll();
	}
	else if(top.location.pathname === '/Rest_FastFood/orders.html'){
		findAllOrders();
	}
	
	$(document).on("click","#orderButton",function(){
		if(!sessionStorage.getItem('valid')){
			$('#modalButton').trigger('click');
		}
		else{
			location.href="makeAnOrder.html";
		}
	});	
	$(document).on("submit","#loginForm",function(e){
		e.preventDefault();
		findUser();
	});	
	
	$(document).on("click", '#logout', function(){
		sessionStorage.clear();
		$('#logout').hide();
		
	});
	
	
});

