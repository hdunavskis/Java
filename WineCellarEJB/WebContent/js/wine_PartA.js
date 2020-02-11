// JavaScript Document
var rootUrl="http://localhost:8080/WineCellarEJB/V1/wines/";

//findAll function initiated a REST call HTTPRequest to the server
//When the server replies the function renderList will be called
//renderList is a callback function

var findAll=function(){
	$.ajax({
		   type:'GET',
		   url: rootUrl,
		   dataType:"json",
		   success:renderList
		   });
};

var findById=function(id){
	$.ajax({
		type:'GET',
		data: id,
		url: rootUrl+id,
		dataType:"json",
		success:renderMainArea
	});
};

var renderMainArea = function(wine){
	$('#pic').attr('src','pics/'+wine.picture);
	$('#wineId').val(wine.id);
	$('#name').val(wine.name);
	$('#grapes').val(wine.grapes);
	$('#country').val(wine.country);
	$('#region').val(wine.region);
	$('#year').val(wine.year);
	$('#description').val(wine.description);
	
}

//data contains the json data for all the wines as an array of objects
//.each is a jQuery method that iterates through the array list of objects
//each object is placed in wine and its attributes can be accessed.
//wineList is an id in the HTML page
var renderList=function(data){
	$.each(data, function(index,wine){
	$('#wineList').append('<li><a href="#" id="'+wine.id+
						  '">'+wine.name+'</a></li>');
						  });
}

//When the DOM (Document Object Model is loaded, call the findAll function
$(document).ready(function(){
	findAll();
});

$(document).on("click", "#wineList a", function(){
	findById(this.id);
});