$(function() {
	
	$("#detailDelete").on("click", function(){
		let pass = $("#pass").val();
		
		if(pass.length <= 0){
			alert("비밀번호 입력")
			return false;
		}
		
		$("#rPass").val(pass);
		$("#checkForm").attr("action", "delete");
		$("#checkForm").attr("method", "post");
		$("#checkForm").submit();
	})
	
	$("#updateForm").on("submit", function(){
		if($("#writer").val().length <= 0){
			alert("작성자가 입력되지않음");
			return false;	
		}
		if($("#title").val().length <= 0){
			alert("제목이 입력되지않음");
			return false;	
		}
		if($("#content").val().length <= 0){
			alert("내용이 입력되지않음");
			return false;	
		}
		if($("#pass").val().length <= 0){
			alert("비밀번호가 입력되지않음");
			return false;	
		}
	})
	
	$("#detailUpdate").on("click", function(){
		let pass = $("#pass").val();
		
		if(pass.length <= 0) {
			alert("비밀번호를 입력하시오.")
			return false;
		}
		
		$("#rPass").val(pass);
		$("#checkForm").attr("action", "updateForm");
		$("#checkForm").attr("method", "post");
		$("#checkForm").submit();
	})
	
	$("#writeForm").on("submit", function(){
		if($("#writer").val().length <= 0){
			alert("작성자가 입력되지 않았습니다.")
			return false;
		}
		if($("#title").val().length <= 0){
			alert("제목이 입력되지 않았습니다.")
			return false;
		}
		if($("#content").val().length <= 0){
			alert("내용이 입력되지 않았습니다.")
			return false;
		}
		if($("#pass").val().length <= 0){
			alert("비밀번호가 입력되지 않았습니다.")
			return false;
		}
	})
})