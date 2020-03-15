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
			console.log(user.userType);
			if(user.userType =='customer'){
				sessionStorage.setItem('customer', true);
				$('#logout').css('visibility', 'visible');
				location.href="makeAnOrder.html";	
			}
			else{
				sessionStorage.setItem('staff', true);
				location.href="orders.html";
			}
			
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('Login error' + textStatus);
		}
	});
};

$(document).ready(function(){
	
	if(!sessionStorage.getItem('customer')){
		$('#logout').css('display', 'none');	
	}
	
	$(document).on("click","#orderButton",function(){
		if(!sessionStorage.getItem('customer')){
			$('#modalButton').trigger('click');
		}
		else{
			location.href="makeAnOrder.html";
		}
	});	
	$(document).on("click", "#login", function(){
		
		if(!sessionStorage.getItem('staff')){
			$('#modalButton').trigger('click');
		}
		else{
			location.href="orders.html";
		}
	});
	$(document).on("submit","#loginForm",function(e){
		e.preventDefault();
		findUser();
	});	
	
	$(document).on("click", '#logout', function(){
		sessionStorage.removeItem('customer');
		$('#logout').css('display', 'none');
		
	});
	$(document).on("click", '#logoutButton', function(){
		sessionStorage.removeItem('staff');
		location.href="index.html";
	});
});