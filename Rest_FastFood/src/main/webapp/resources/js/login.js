var rootURL = "http://localhost:8080/Rest_FastFood/V1/";
var findUser=function() {
	var username = $('#username').val().trim();
	var password = $('#password').val().trim();
	$.ajax({
		type: 'GET',
		url: rootURL+ "login",
		dataType: "json",
		beforeSend: function (xhr) {
		    xhr.setRequestHeader ("Authorization", "Basic " + btoa(username + ":" + password));
		},
		success: function(user){
			sessionStorage.setItem("cID", user.userID);
			if(user.userType =='customer'){
				sessionStorage.setItem('customer', true);
				location.href="makeAnOrder.html";	
			}
			else if(user.userType =='staff'){
				sessionStorage.setItem('staff', true);
				location.href="orders.html";
			}
		},
		error: function(){
			alert('Authentication failed!');
		}
		
	});
};

$(document).ready(function(){

	$(document).on("click","#orderButton",function(){
		if(!sessionStorage.getItem('customer')){
			$('#modalButton').trigger('click');
		}
		else{
			location.href="makeAnOrder.html";
		}
	});	
	$(document).on("click", "#login", function(){
		
		if(!sessionStorage.getItem('staff') && !sessionStorage.getItem('customer')){
			$('#modalButton').trigger('click');
		}
		else if (sessionStorage.getItem('customer')){
			location.href="makeAnOrder.html";
		}
		else if (sessionStorage.getItem('staff')){
			location.href="orders.html";
		}
	});
	$(document).on("submit","#loginForm",function(e){
		e.preventDefault();
		findUser();
	});	
	
	$(document).on("click", '#logout', function(){
		sessionStorage.removeItem('customer');
		
	});
	$(document).on("click", '#logoutButton', function(){
		if(sessionStorage.removeItem('staff')){
			sessionStorage.removeItem('staff');	
		}
		else{
			sessionStorage.removeItem('customer');	
		}
		location.href="index.html";
	});
});