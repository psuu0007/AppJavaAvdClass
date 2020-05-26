function navBtnCngFnc(){
	var navObj = '';
	var locStr = location.pathname.split("/")[2];
	
	if (locStr == "member") {
		navObj = document.getElementById("navMember");
	} else if(locStr == "bulletin"){
		navObj = document.getElementById("navBulletin");
	} else if(locStr == "notice"){
		navObj = document.getElementById("navNotice");
	}

	if(navObj != ''){
		navObj.style.backgroundColor = "#FFFFFF";
		navObj.style.color = "#59b1eb";
	}
}

function pageBtnCngFnc(){
	var navObjArr = document.getElementsByClassName("pageBtn");
	var locInt = document.getElementById("hiddenPageNo").value;
	var navObj = '';
	
	for (var i = 0; i < navObjArr.length; i++) {
		if(navObjArr[i].value == locInt){
			navObj = navObjArr[i];
			break;
		}
	}
	
	if(navObj != ''){
		navObj.style.backgroundColor = "#FFFFFF";
		navObj.style.color = "#59b1eb";
	}
}