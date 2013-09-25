function drawChart() {	
	$.getJSON("allStatis", readJson);
	function readJson(data) {
		var aDocCount = data.docCount;
		var aPicCount = data.picCount;
		var aMusicCount = data.musicCount;
		var aVideoCount = data.videoCount;
		
		var barChartData = {
				labels : ["Picture", "Music", "Document", "Video"],
				datasets : [
					{
						fillColor : "rgba(151,187,205,0.5)",
						strokeColor : "rgba(151,187,205,1)",
						data : [aPicCount, aMusicCount, aDocCount, aVideoCount]
					}
				]
			};
		
		var douData = [
			            {
			            	value: aPicCount,
					        color:"#66CCFF"
					    },
					    {
					    	value : aMusicCount,
					        color : "#E4F6FF"
					    },
					    {
					    	value : aDocCount,
					        color : "#BEEAFF"
					    },
					    {
					        value : aVideoCount,
					        color : "#4698C1"
					    }
			];
		
		var globalGraphSettings = {animation : true};
		
		function showBarChart() {
			var ctx = $("#allBarChart").get(0).getContext("2d");
			new Chart(ctx).Bar(barChartData, globalGraphSettings);
		};
		
		function showDouChart() {
			var ctx = $("#allDouChart").get(0).getContext("2d");
			new Chart(ctx).Doughnut(douData, globalGraphSettings);
		};
		
		showDouChart();
		showBarChart();
	};
};

$(document).ready(drawChart);
