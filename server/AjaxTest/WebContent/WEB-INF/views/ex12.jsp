<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		width: 900px;
	}
	
</style>
</head>
<body>
	<div class="container"> 
		
		<h1>Chart</h1>
		
			<select id="buseo" name="buseo">
				<option value="-1">부서 선택</option>
				<c:forEach items="${list}" var="buseo">
				<option value="${buseo}">${buseo}</option>
				</c:forEach>
			</select>
		
		<div id="container"></div>
	
	
	
	</div>
	
	<script src="/ajax/js/highcharts.js"></script>
	<script>
	
		$("#buseo").change(function() {
			
			var buseo = $(this).val();
			//alert(buseo);
			
			$.ajax({
				type: "GET",
				url: "/ajax/ex12ok.do",
				data: "buseo=" + buseo,
				dataType: "json",
				success: function (result) {
					
					options.series[0].data = result;
					Highcharts.chart('container', options);
					
				},
				error: function (a,b,c) {
					condole.log(a,b,c);
				}				
			});
			
			//필요한 부분만 떼어내서 동적으로 추가하기 위해 떼어내줌
			//alert(options.series[0].data);
			/*
			options.series[0].data = [
	        	{
		            name: 'Chrome',
		            y: 61.41,
		            sliced: true,
		            selected: true
	   	 		}
			];
			*/

			//매번 차트를 다시 그려줘야 함.
			
			
		});
	
		
		//옵션을 분리하여 동적으로 추가해주기 위해 차트에서 떼어줌.
		var options = {
		    chart: {
		        plotBackgroundColor: null,
		        plotBorderWidth: null,
		        plotShadow: false,
		        type: 'pie'
		    },
		    title: {
		        text: '직급별 인원수'
		    },
		    tooltip: {
		        pointFormat: '{series.name}: <b>{point.y:.0f}명</b>'
		    },
		    accessibility: {
		        point: {
		            valueSuffix: '명'
		        }
		    },
		    plotOptions: {
		        pie: {
		            allowPointSelect: true,
		            cursor: 'pointer',
		            dataLabels: {
		                enabled: true,
		                format: '<b>{point.name}</b>: {point.y:.0f} 명'
		            }
		        }
		    },
		    series: [{
		        name: '인원수',
		        colorByPoint: true,
		        data: [

		       ]
		    }]
		};
		

		Highcharts.chart('container', options);

	</script>
</body>
</html>