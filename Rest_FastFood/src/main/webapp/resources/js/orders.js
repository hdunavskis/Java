var rootURL = "http://localhost:8080/Rest_FastFood/V1/";

var c= null;
var interval = 10000;

var findAllOrders=function() {
	$.ajax({
		type: 'GET',
		url: rootURL + "orders",
		dataType: "json", 
		success: renderTable
	});
};

var updateOrder=function(id, customerId, foodName, amount, note) {
	$.ajax({
		type: 'PUT',
		contentType: 'application/json',
		data: formToJSON(id, customerId, foodName, amount, note),
		url: rootURL + "orders/",
		dataType: "json", 
		success: function(){
			findAllOrders();
		}
	});
};

var renderTable= function(data) {
    var list=data;
    $('#dataTable td').remove();
	$.each(list, function(index, order) {
		$('#dataTable').append(
				'<tr><td>'+ order.orderId 
				+ '</td><td>' + order.customerId 
				+ '</td><td>'+order.foodName
				+'</td><td>' +order.amount 
				+ '</td><td><textarea maxlength="255" id="textArea'+order.orderId+'"readonly class="form-control" rows="2">'+order.noteToKitchenStaff+'</textarea>'
				+'</td><td> <button id="'+order.orderId+'" type="button" class="btn btn-success">' + "Ready" +'</button>'
				+'</td></tr>');
	});
};
var formToJSON=function (id, customerId, foodName, amount, note) {
	
	return JSON.stringify({
		orderId: id,
		customerId: customerId,
		foodName: foodName,
		amount: amount,
		noteToKitchenStaff: note,
		isReady: true,
		isPaid: true
		});
};
$(document).ready(function(){
	
	if(!sessionStorage.getItem('staff')){
		location.href="index.html";
	}
	$(document).on("click", ".btn-success", function(){
		
		 if(confirm("Are you sure?") === true){
			 
			var orderId = this.id;
			var row = $(this).closest("tr");
			var customerId = row.find("td:eq(1)").html();
			var foodName = row.find("td:eq(2)").html();
			var amount = row.find("td:eq(3)").html();
			var notes = $('#textArea'+this.id).val();
			updateOrder(orderId, customerId,foodName,amount,notes);
			$(this).closest('tr').remove();	
			
		 }
	});
	c = setInterval("findAllOrders()", interval);
	findAllOrders();
});