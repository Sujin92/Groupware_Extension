/*
var checkFirst = true;
var lastkeyword = "";
var loopSendKeyword = false;
var firstKey = "";
*/

/*
function getkeyword() {
	if(document.getElementById("keyword").value == "")
		checkFirst = true;
	
	if(checkFirst == true) {
		firstKey = "first";
		loopSendKeyword = true;
		window.setTimeout("sendkeyword();", 50);
	} else {
		firstKey = "";
	}
	checkFirst = false;
}

function sendkeyword() {
	if(loopSendKeyword == false)
		return;
	
	var keyword = document.getElementById("keyword").value;
	//alert(keyword);
	if(keyword == "") {
		checkFirst = true;
		lastkeyword = "";
		hide("search");
	} else if(keyword != lastkeyword) {
		lastkeyword = keyword;
		if(lastkeyword != "") {
			var url = "/kitri_project/findkeyword";
			var param = "first=" + firstKey + "&keyword=" + encodeURI(lastkeyword);
			sendRequest(url, param, displayResult, "GET");
		}
	}
	window.setTimeout("sendkeyword();", 50);
}

function displayResult() {
	if(httpRequest.readyState == 4) {
		if(httpRequest.status == 200) {
			var txt = httpRequest.responseText;
			//alert(txt); // 3| 자바,자바스크립트,제주도
			var result = txt.split("|");	// be result as array.
			var count = parseInt(result[0]);	// find the number '3'	//parseInt , in the Object. translate string to number
			if(count != 0){
				var list = result[1].split(",");
				var viewStr = "";
				var len = list.length;
				for(var i=0;i<len;i++){
					viewStr += "<a href=\"javascript:selectKeyword('" + list[i] + "');\">";
					viewStr += list[i].replace(lastkeyword, "<font color='#ff0000'>" + lastkeyword + "</font>") + "</a><br>";	
					//turn searchletter to red color
				}
				var view = document.getElementById("searchlist");
				view.innerHTML = viewStr;	//put into the div tag find to 'view.innerHTML'
				show("search");
			} else {
				hide("search")
			}
			
		} else {
			alert("문제발생 : " + httpRequest.status);
		}
	}
}
*/

/*
function startrank(){
	sendRequest("/naver/rank", null, displayrank, "GET");
	
}*/


/*
function search(kw){
	document.getElementById("keyword").value = kw;
	document.searchform.submit();
}
*/

