function loginOn() {
	modal_back.style.display = 'block';
	login_modal.style.display = 'block';
	
	login_modal.innerHTML = 
	    		'<span class="modal_close" onclick="loginOff()">X</span>'+
	    		'<div class="loginBody">'+
	    			'<div class="loginTitle">Log in</div>'+
	    			'<div>id : <input type="text" id="loginId"></div>'+
	    			'<div>pwd : <input type="password" id="loginPwd"></div>'+
	    			'<div>'+
		    			'<div><input type="button" value="OK" onclick="loginSubmit()"></div>'+
		    			'<div><input type="button" value="Cancel" onclick="loginCancel()"></div>'+
	    			'</div>'+
	    		'</div>';
}
function loginOff() {
	modal_back.style.display = 'none';
	login_modal.style.display = 'none';
	login_modal.innerHTML = '';
}
function loginSubmit() {
	let params = 'id='+loginId.value+'&pwd='+loginPwd.value;
	sendXHR('loginSubmit.do', params, loginSubmitResult, 'POST');
}
function loginSubmitResult() {
	if(XHR.readyState == 4) {
		if(XHR.status == 200) {
			let data = XHR.responseText;
			window.alert(data);
			location.reload();
		}
	}
}
function loginCancel() {
	loginOff();
	loginId.value = '';
	loginPwd.value = '';
}