var httpRequest;

function getXMLHttpRequest() {
	if(window.ActiveXObject) {
		try {
			return new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e1) {
			try {
				return new ActiveXObject("Microsoft.XMLHTTP");	
			} catch (e2) {
				alert("지원하지 않는 브라우저입니다.");
				return null;
			}
		}
	} else if(window.XMLHttpRequest) {
		return new XMLHttpRequest;
	} else {
		alert("지원하지 않는 브라우저입니다.");
		return null;
	}
}

function sendRequest(url, param, callback, method) {
	httpRequest = getXMLHttpRequest();
	
	var httpMethod = method ? method : "GET"; //java의 경우 : method != null ? method : "GET";
	if(httpMethod != "GET" && httpMethod != "POST") { //사용자가 GET이나 POST가 아닌 값을 입력하였을 경우
		httpMethod = "GET"; //default는 GET
	}
	
	var httpParam = (param == null || param == "") ? null : param;
	
	var httpUrl = url;
	if(httpMethod == "GET" && httpParam != null) {
		httpUrl = httpUrl + "?" + httpParam; //get방식은 ?뒤에 보냄
	}
	
	httpRequest.onreadystatechange=callback;
	httpRequest.open(httpMethod, httpUrl, true); //httpUrl로 요청을 보냄
	httpRequest.send(httpMethod == "POST" ? httpParam : null); //post방식은 send에서 보냄
}

