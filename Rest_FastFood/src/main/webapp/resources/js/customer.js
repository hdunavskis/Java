var rootURL = "http://localhost:8080/Rest_FastFood/V1/";

var c= null;
var interval = 10000;
var changeButtonValue = null;
var findAllCustomerOrders =function() {
	$.ajax({
		type: 'GET',
		url: rootURL + "orders/customer/" +sessionStorage.getItem("cID"),
		dataType: "json", 
		success: function(data){
			
			if(!$.trim(data)){
				clearInterval(c);
				c = null;
			}
			renderTable(data);
		}
	});
};
var repeatCall =function() {
	changeButtonValue = $('.changeButton').text();
	$.ajax({
		type: 'GET',
		url: rootURL + "orders/customer/" +sessionStorage.getItem("cID"),
		dataType: "json", 
		success: function(data){
			
			if(!$.trim(data)){
				clearInterval(c);
				c = null;
				
			}
			checkIfPaid(data);
		}
	});
};

var checkIfPaid = function(data){
	$.each(data, function(index, order) {
		if(order.isReady){
			clearInterval(c);
			c = null;
			removeItem(order.orderId);
			alert('Order '+ order.orderId+' is ready');
		}
	});
}
var findAllFood=function() {
	$.ajax({
		type: 'GET',
		url: rootURL+"food",
		dataType: "json", 
		success: function(data){
			renderFood(data)
		}
	});
};

var renderFood= function(data) {
	$.each(data, function(index, food) {
		$('#food').append(
			'<option id="'+food.name +'">' + food.name + '</option>'
		);
	});
};

var removeItem=function(id) {
	$.ajax({
		type: 'DELETE',
		url: rootURL + "orders/" + id,
		success: function(){
			$('#customerOrders tr#remove'+id).remove();
			if(!~changeButtonValue.indexOf('Save')){
				if(c == null){
					c = setInterval("repeatCall()", interval);
				}
			}
		}
	});
};
var renderTable= function(data) {
    var list=data;
	$('#customerOrders td').remove();
	$.each(list, function(index, order) {
		$('#customerOrders').append(		
				'<tr id="remove'+order.orderId+'"><td>' + order.orderId+ 
				'</td id="foodName'+order.orderId+'"><td>'+order.foodName+
				'</td><td> <select id="foodOptions'+order.orderId+'" disabled class ="form-control">'
				+'<option>1</option>'
				+'<option>2</option>'
				+'<option>3</option>'
				+'<option>4</option>'
				+'<option>5</option>'
				+'</select>'
				+'</td><td><textarea maxlength="255" id="textArea'+order.orderId+'"readonly class="form-control" rows="1">'+order.noteToKitchenStaff+'</textarea>'
				+'</td><td> <button id="'+order.orderId+'" type="button" class="btn btn-info changeButton" >' + "Change" +'</button>'
				+'</td><td> <button id="pay'+order.orderId+'" type="button" class="btn btn-success payButton">' + "Pay" +'</button>'
				+'</td><td> <button id="cancel'+order.orderId+'" type="button" class="btn btn-warning cancelButton">' + "Cancel" +'</button>'
				+'</td></tr>');
		$(function() {
		    $('#foodOptions'+order.orderId).val(order.amount);
		    if(!order.isPaid){
		    	$('#'+order.orderId).css('visibility', 'visible');
		    	$('#pay'+order.orderId).css('visibility', 'visible');
		    	$('#cancel'+order.orderId).css('visibility', 'visible');
		    }    
		});
	});
	
};

var postOrder =function(paid) {
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		data:formToJSON(paid),
		url: rootURL + "orders/",
		dataType: "json", 
		success: function(){
			findAllCustomerOrders();
		}
	
	});
};

var updateOrder =function(id, paid, food) {

	$.ajax({
		type: 'PUT',
		contentType: 'application/json',
		data: formToJSONUpdate(id, paid, food),
		url: rootURL + "orders/",
		dataType: "json", 
		success: function(){
			findAllCustomerOrders();
		}
	});
};
var formToJSONUpdate=function (id, paid, food) {
	var amount = $('#foodOptions'+id+' option:selected').val();
	var note = $('#textArea'+id).val();
	
	return JSON.stringify({
		orderId: id,
		customerId: sessionStorage.getItem("cID"),
		foodName: food,
		amount: amount,
		noteToKitchenStaff: note,
		isReady: false,
		isPaid: paid
		});
};
var formToJSON=function (paid) {
	var food = $('#food option:selected').val().trim();
	var amount = $('#amount option:selected').val().trim();
	var note = $('#note').val();
	var id = sessionStorage.getItem("cID");
	var isPaid = paid;
	
	return JSON.stringify({
		orderId: null,
		customerId: id,
		foodName: food,
		amount: amount,
		noteToKitchenStaff: note,
		isReady: false,
		isPaid: isPaid
		});
};

$(document).ready(function(){
	
	if(!sessionStorage.getItem('customer')){
		location.href="index.html";
	}
	$(document).on("click", '#confirmButton', function(){
		if(confirm("Place an order?")){
			postOrder(false);
		}
		
	});
	$(document).on("click", '#payNow', function(){
		if(confirm("Pay now?")){
			if(c == null){
				c = setInterval("repeatCall()", interval);
			}
			postOrder(true);
		}
	});
	$(document).on("click", '#myOrders', function(){
		if(c == null){
			c = setInterval("repeatCall()", interval);
		}
		findAllCustomerOrders();
		
	})
	$(document).on("click", '.changeButton', function(){
		
		if($('#'+this.id).text() == 'Save'){
			var row = $(this).closest("tr");
			var cellValue = row.find("td:eq(1)").html();
			if(c == null){
				c = setInterval("repeatCall()", interval);
			}
			updateOrder(this.id, false, cellValue);
			alert("Update success!");
		}
		else{
			$('#'+this.id).html('Save');
			$('#foodOptions'+this.id).removeAttr('disabled');
			$('#textArea'+this.id).removeAttr('readonly');
		} 
		
	})
	$(document).on("click", '.payButton', function(){
		
		var orderId = this.id.match(/\d+/).toString();
		var row = $(this).closest("tr");
		var cellValue = row.find("td:eq(1)").html();
		if(confirm("Are you sure you want to pay?")){
			
			updateOrder(orderId, true, cellValue);	
		}
	})
	$(document).on("click", '.cancelButton', function(){
		
		if(confirm("Cancel order?")){
			removeItem(this.id.match(/\d+/));	
		}
	})
	
	findAllFood();
	
});