var rootUrl = "http://localhost:8080/Racing/rest/horses/";

var findAll= function () {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootUrl,
		dataType: "json", 
		success: displayResults
	});
};
var findByName= function (name) {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootUrl+'search/'+name,
		dataType: "json", 
		success: displayResults
	});
};
var findById= function (id) {
	$.ajax({
		type: 'GET',
		url: rootUrl+id,
		dataType: "json", 
		success: function(data){
			$('.modal-title').text('More details for ' +data.name);
			$('#age').val(data.age);
			$('#owner').val(data.owner);
			$('#breeder').val(data.breeder);
			$('#sire').val(data.sire);
			$('#dam').val(data.dam);
			$('#myModal').modal('show');
		}
	});
};

var displayResults = function(allHorses){
	
	$('#horseTable tr').remove();
	$.each(allHorses, function(index, horse){
		var picture = "resources/images/"+horse.picture;
		var className = "normal";
		var pos = horse.betting.indexOf('f');
		if(pos != -1){
			className = "fav";
		}
		$('#horseTable')
		.append(
				'<tr class="'+className+'"><td>' +horse.id+'</td>'
				+'<td>' + horse.name + '</td>'
				+'<td>'+ '<img src=' +picture + '></img></td>'
				+'<td>' + horse.jockey + '</td>'
				+'<td>' + horse.trainer + '</td>'
				+'<td>' + horse.betting + '</td>'
				+'<td>'+ '<span id= "'+horse.id+'"class="fa fa-info-circle">'+ '</td>'
				+'<td>'+'<span class="fa fa-trash-o">'+'</td></tr>'
		)
	});
}

$(document).ready(function(){
	console.log("document ready");
	findAll();
	
	$(document).on("click", ".fa-info-circle", function(){
		findById(this.id);
	});
	$(document).on("click", ".fa-trash-o", function(){
		$(this).closest('tr').remove();	
	});
	$(document).on("click", '#btnSearch', function(){
		if($('#searchKey').val() === ''){
			findAll();
		}
		else{
			findByName($('#searchKey').val());	
		}
		
	});
});
	
