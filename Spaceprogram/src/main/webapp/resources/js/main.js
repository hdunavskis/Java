var url = "http://localhost:8080/Spaceprogram/rest/";

var findAllMissions= function () {
	$.ajax({
		type: 'GET',
		url: url + "missions",
		dataType: "json", 
		success: displayResults
	});
};
var findAllShuttles=function() {
	$.ajax({
		type: 'GET',
		url: url+"shuttles",
		dataType: "json", 
		success: renderShuttles
	});
};
var renderShuttles= function(data) {
	$('#orbitors')
		.append('<option> All orbitors </option>');
	$.each(data, function(index, shuttle) {
		$('#orbitors').append(
					
			'<option id="'+shuttle.id +'">' + shuttle.name + '</option>'
		);
	});
};
var findById= function (id) {
	$.ajax({
		type: 'GET',
		url: url +"missions/"+id,
		dataType: "json", 
		success: function(data){
			var image = 'resources/images/'+data.orbitor.toLowerCase()+"_main.jpg";
			$('.modal-title').text('Mission details for ' +data.name);
			$('#pic').attr('src', image);
			$('#launch').val(data.launch);
			$('#landing').val(data.landing);
			$('#landing_site').val(data.landing_site);
			$('#duration').val(data.duration);
			$('#notes').val(data.notes);
			$('#myModal').modal('show');
		}
	});
};
var findShuttleByName= function (id) {
	
	$.ajax({
		type: 'GET',
		url: url +"missions/searchshuttle/"+id,
		dataType: "json", 
		success: displayResults
	});
};

var displayResults = function(allShuttles){
	
	$('.list_missions').empty();
	$('.list_missions').append('<div class="row">');
	$.each(allShuttles, function(index, shuttle){
		var image = 'resources/images/'+shuttle.name+'.jpeg';

		$('.row')
		.append(
				'<div class="col-sm-6 col-md-4 col-lg-3">'
				+'<div class="details">'
				+'<img src=' + image+ ' height="50">'
				+'<h2>'+ shuttle.name + '</h2>'
				+'<h2> <a href="#">'+shuttle.orbitor+'</h2>'
				+'<span id="'+shuttle.id+'" class="fa fa-info-circle fa-3x"></span>'
				+'</div>'
		);
		
	});
	$('.list_missions')
	.append('</div>');
}


$(document).ready(function(){
	findAllShuttles();
	findAllMissions();
	
	$(document).on("click", ".fa-info-circle", function(){
		findById(this.id);
	});
	$(document).on("change", "#orbitors", function(){
		alert($('#orbitors option:selected').val());
		var shuttleName = $('#orbitors option:selected').val().trim();
		if(shuttleName === "All orbitors"){
			findAllShuttles();
			findAllMissions();
		}
		else{
			findShuttleByName(shuttleName);
		}
	});
})
