function getUrlParams() {
	var url = window.location.href;
	if (url.indexOf("?") >= 0) {
		var hrefParams = url.split("?")[1];
		var arr = hrefParams.split("&");
		var result = {};
		for ( var i = 0; i < arr.length; i++) {
			result[arr[i].split("=")[0]] = decodeURI(arr[i].split("=")[1]);
		}
		return result;
	}
}