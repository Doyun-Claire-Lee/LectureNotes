<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/ajax/css/bootstrap.css">
<script src="/ajax/js/jquery-1.12.4.js"></script>
<script src="/ajax/js/bootstrap.js"></script>
<style>

	.container {
		width: 500px;
		position: relative;
	}
	#list {
		border: 1px solid #ddd;
		background-color: white;
		width: 335px;
		position: absolute;
		left: 24px;
		top: 112px;
		border-radius: 3px;
		display: none;
	}
	#list footer {
		font-size: 12px;
		background-color: #ddd;
		text-align: right;
		padding: 5px 5px 3px 3px;
	}
	#list .item {
		padding: 5px;
		padding-left: 10px;
		cursor: pointer;
	}
/*
	#list .item:hover {
		background-color: #eee;
	}
*/	
</style>
</head>
<body>
	<div class="container"> 
		
		<h1>추천 검색어</h1>
		
		<table class="table table-bordered">
			<tr>
				<td><input type="text" name="search" id="search" class="form-control"></td>
				<td><button type="button" class="btn btn-default">검색</button></td>
			</tr>
		</table>
		
		<div id="list">
			<section>

			</section>
			<footer>추천 검색어</footer>
		</div>
	
	
	
	</div>
	
	
	<script>
	
		var index = -1;
	
		$("#search").keyup(function() {
			
			//위아래 방향키로 검색어 선택하기
			if (event.keyCode == 38) {	//위 방향키
				
				index --;
				if (index < 0) { index = 0; }	//맨위일때 더이상 위로 갈수 없도록
				$("#list .item").css("background-color", "white")			//전체 상자의 색 하얗게 초기화
				$("#list .item").eq(index).css("background-color", "#eee")	//선택된 항목에 색상주기
				$("#search").val($("#list .item").eq(index).text());		//선택된 내용이 텍스트박스에 나타나도록
				return;
				
			} else if (event.keyCode == 40) {	//아래 방향키

				index++;
				if(index > $("#list .item").length-1) { index--; }
				$("#list .item").css("background-color", "white")
				$("#list .item").eq(index).css("background-color", "#eee")
				$("#search").val($("#list .item").eq(index).text());
				return;
				
			} else if (event.keyCode == 13) {	//엔터키
				
				$("#search").val($("#list .item").eq(index).text());
				$("#list").hide();		
				
				index = -1;
				return;
			}
			
			
			//사용자가 입력한 검색어 -> 서버로 전송
			var word = $("#search").val();
			
			//검색어가 있을때만 전송하기
			if (word.trim().length > 0) {
				
				//검색어에 초성이 없는 경우에만 전송하기
				//검색어에 영어 대소문자 + 숫자 + 공백 + 특수문자(_) + 한글만 쓸 수 있다고 가정
				//정규식 사용 -> ^[A-Za-z0-9\s_가-힣]{1,}$
				
				//자바스크립트에서 정규표현식을 쓰는 방법 -> 슬래시 안에 넣고, g(글로벌 : 한 단어 안에서도 여러번 찾겠다는 뜻) i(insensitive: 대소문자 무시하겠다는 뜻)
				var regex = /^[A-Za-z0-9\s_가-힣]{1,}$/gi;
				
				if (regex.test(word)) {
					
					$.ajax({
						
						type: "GET",
						url: "/ajax/ex09ok.do",
						data: "word=" + word,
						dataType: "json",
						success: function(result) {
							
							//누적되는것을 방지하기 위해 박스 안을 초기화해주기
							$("#list > section").html("");
							
							$(result).each(function(index, item) {
								//하나씩 출력해주기
								$("#list > section").append('<div class="item" onclick="sel();" onmouseover="itemover();" onmouseout="itemout();">'+ item + '</div>');
							});
		
							//display: none 속성 설정되어있음. 화면에 출력하기 위해 show 메소드 사용
							$("#list").show();
						},
						error: function(a,b,c) {
							console.log(a,b,c);
						}
					});//ajax끝
				}
			} else {
				$("#list").hide();
			}
		});
		
		function sel() {
			
			//$(this) -> jQuery로 이벤트를 걸었을 때만 쓸 수 있음! 
			var word = event.srcElement.innerText;
			$("#search").val(word);
			$("#list").hide();		
			
			// 보통은 검색어를 전송 후 검색결과 화면으로까지 이동! 
		}
		
		function itemover() {
		
			$("#list .item").css("background-color", "white")
			$(event.srcElement).css("background-color", "#eee");
			index = $(event.srcElement).index();
		}
		
		function itemout() {
			
			$(event.srcElement).css("background-color", "white")
		
		}

	</script>
</body>
</html>