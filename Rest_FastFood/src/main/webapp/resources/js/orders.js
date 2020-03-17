var rootURL = "http://localhost:8080/Rest_FastFood/V1/";

var findAllOrders=function() {
	$.ajax({
		type: 'GET',
		url: rootURL + "orders",
		dataType: "json", 
		success: renderTable
	});
};

var removeItem=function(id) {
	$.ajax({
		type: 'DELETE',
		url: rootURL + "orders/" + id,
		success: function(){
			alert("notify user");
		}
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
				'</td><td> <button id="'+order.orderId+'" type="button" class="btn btn-info">' + "Confirm" +'</button>'+
				'</td><td> <button id="'+order.orderId+'" type="button" class="btn btn-success">' + "Ready" +'</button>'+
				'</td></tr>');
	});
};

$(document).ready(function(){
	
	if(!sessionStorage.getItem('staff')){
		location.href="index.html";
	}
	$(document).on("click", ".btn-success", function(){
		
		 if(confirm("Are you sure?") === true){
				removeItem(this.id);
				$(this).closest('tr').remove();	
		 }
	});
	findAllOrders();
});