
var idx = 1; // 생성될 객체 idx
var img_L = 0;
var img_T = 0;
var targetObj;
var httpRequest;

function add_div1() {
	
//	$("#btn_cr1").on("click", function() {
//	var param = $("#writeForm1").serialize();
//	alert(param);
//	 $.ajax({   
//	   type: "POST"  
//	  ,url: "<%=root%>/project"
//	  ,data: param
//      ,dataType: "xml"
//	  ,success:registerResult
//	  ,error:function(data){
//	    alert("error");
//	  }
//	});
//});

	 document.writeForm1.action ="<%=root%>/project";
	 document.writeForm1.submit();
	 
	var div = document.createElement('DIV'); // DIV 객체 생성
	div.style.margin = "6px";
	div.style.border = "1px solid black";
	div.style.padding = "20px";
	div.setAttribute('card', 'div'+idx); // id 지정
	div.innerHTML = document.getElementById("area1").value;
	document.getElementById('inbox1').appendChild(div).style.backgroundColor = "white";
	idx++;



}

function registerResult(xhr){
	alert(xhr);
}

function add_div2() {

	var div = document.createElement('DIV');
	div.style.margin = "6px";
	div.style.border = "1px solid black";
	div.style.padding = "20px";
	div.setAttribute('card', 'div' + idx); // id 지정
	div.innerHTML = document.getElementById("area2").value;
	document.getElementById('inbox2').appendChild(div).style.backgroundColor = "white";
	idx++;

}
function add_div3() {
	var div = document.createElement('DIV'); // DIV 객체 생성
	div.style.margin = "6px";
	div.style.border = "1px solid black";
	div.style.padding = "20px";
	div.setAttribute('card', 'div' + idx); 
	div.innerHTML = document.getElementById("area3").value;
	document.getElementById('inbox3').appendChild(div).style.backgroundColor = "white";
	idx++;

}
function add_div4() {
	var div = document.createElement('DIV'); // DIV 객체 생성
	div.style.margin = "6px";
	div.style.border = "1px solid black";
	div.style.padding = "20px";
	div.setAttribute('card', 'div' + idx);
	div.innerHTML = document.getElementById("area4").value;
	document.getElementById('inbox4').appendChild(div).style.backgroundColor = "white";
	idx++;
}

function press(f) {
	if (f.keyCode == 13) {
		// forname.submit()
		var box = document.getElementById('card');
		box.style.backgroundColor = black;
	}
}

function modal(a) {
	document.getElementById("modal-a").textContent = document.getElementById(a).textContent;
	$('#myModal').modal("show");
}


