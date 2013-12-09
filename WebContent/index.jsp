<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trello Analyzer</title>
</head>
<body>
	
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script src="js/highcharts.js"></script>
	<script src="js/data.js"></script>
	<script src="js/exporting.js"></script>
	
	<table width="100%">
		<tr>
			<td width="40%">
				<div id="chartLists" style="width: 100%; height: 350px; margin: 0 auto"></div>
			</td>
			<td width="60%">
				<div id="chartTasksType" style="width: 100%; height: 350px; margin: 0 auto"></div>
			</td>
		</tr>
	</table>
	
</body>

<script>
	$(function () {		
		$.get('./charts?type=lists', function (datajson) {							
				$('#chartLists').highcharts({
			        
					chart: {
			            zoomType: 'xy'
			        },
			        title: {
			            text: '% Lists in the Board'
			        },
			        yAxis: {
			            allowDecimals: false			            
			        },
			        series: [{
			         	type: 'pie',
			            data: datajson 
			      	}],
			      	tooltip: {
			    	    pointFormat: '<b>{point.percentage:.1f}%</b>'
			        },
			        plotOptions: {
			            pie: {
			                allowPointSelect: true,
			                cursor: 'pointer',
			                dataLabels: {
			                    enabled: true,
			                    color: '#000000',
			                    connectorColor: '#000000',
			                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
			                }
			            }
			        }
			    });
		});
		
		
		$.get('./charts?type=tasksType', function (datajson) {							
			$('#chartTasksType').highcharts({
		        
				chart: {
		            zoomType: 'xy'
		        },
		        title: {
		            text: '% Tasks Type'
		        },
		        xAxis: {
		            categories: []
		        },
		        yAxis: {
		            allowDecimals: false
		        },
		        series: [{
		         	type: 'bar',
		            data: datajson 
		      	}],
		      	tooltip: {
		    	    pointFormat: '<b>{point.y:.1f}</b>'
		        },
	            legend: {
			        enabled: false
			    }
		    });
	});
			
	});			    

</script>

</html>