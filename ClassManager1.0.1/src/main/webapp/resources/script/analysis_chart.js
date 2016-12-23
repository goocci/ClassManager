var chartData_univScore = new Array();

var chartData_MyScore = new Array();
$.getJSON("http://localhost:8080/classmanager/UnivScore", function(data) {
	$.each(data, function(inx, obj) {
		chartData_univScore.push(obj.standard);
	});
});
$.getJSON("http://localhost:8080/classmanager/MyScore", function(data) {
	$.each(data, function(inx, obj) {
		chartData_MyScore.push(obj.standard);
	});
	
	/**
	 * Create the chart
	 */
	function createChart(data) {
		  
		  return AmCharts.makeChart("chartdiv", {
		    "type": "serial",
		    "theme": "light",
		    "legend": {
		        "useGraphSettings": true
		    },
		    "dataProvider": data,
		    "synchronizeGrid":true,
		    "valueAxes": [{
		      "gridAlpha": 0.07,
		      "position": "left",
		      "title": "표준점수"
		    }],
		    
		    "graphs": [{
		      "lineThickness": 2,
		      "bullet": "round",
		      "title": "기준 점수",
		      "valueField": "cut",
		    }, {
		      "lineThickness": 2,
		      "bullet": "diamond",
		      "bulletSize": 12,
		      "title": "내 점수",
		      "valueField": "myscore"
		    }/*, {
		      "lineThickness": 2,
		      "bullet": "square",
		      "title": "점수 차이",
		      "valueField": "gap"
		    }*/],
		    
		    "chartCursor": {},
		    "categoryField": "category",
		    "categoryAxis": {
		      "startOnAxis": true
		    }
		  });
	}
	/**
	* Define initial data
	*/
	var sourceData2= new Array();
	var sourceData = [
	  ['1학년 3월', chartData_univScore, chartData_MyScore[0], chartData_MyScore[0]-chartData_univScore],
	  ['1학년 6월', chartData_univScore, chartData_MyScore[1], chartData_MyScore[1]-chartData_univScore],
	  ['1학년 9월', chartData_univScore, chartData_MyScore[2], chartData_MyScore[2]-chartData_univScore],
	  ['2학년 3월', chartData_univScore, chartData_MyScore[3], chartData_MyScore[3]-chartData_univScore],
	  ['2학년 6월', chartData_univScore, chartData_MyScore[4], chartData_MyScore[4]-chartData_univScore],
	  ['2학년 9월', chartData_univScore, chartData_MyScore[5], chartData_MyScore[5]-chartData_univScore],
	  ['3학년 3월', chartData_univScore, chartData_MyScore[6], chartData_MyScore[6]-chartData_univScore],
	  ['3학년 6월', chartData_univScore, chartData_MyScore[7], chartData_MyScore[7]-chartData_univScore],
	  ['3학년 9월', chartData_univScore, chartData_MyScore[8], chartData_MyScore[8]-chartData_univScore]
	];

	for(var i = 0 ; i< sourceData.length ; i++){
	if(sourceData[i][2]!==0)
	  sourceData2.push(sourceData[i]);
	}

	
	/**
	* Create the Handsontable editable grid
	*/
	AmCharts.ready(function() {

	var container = document.getElementById("data");
	var chart;

	var hot = new Handsontable(container, {
	  "data": sourceData2,
	  "height": 250,
	  "colHeaders": ['구분','기준 점수','내 점수','점수 차이'],
	  "rowHeaders": true,
	  "stretchH": 'all',
	  "columnSorting": true,
	  "contextMenu": true,
	  "afterInit": function(firstTime) {
	    chart = createChart(
	      formatChartData( this.getData() )
	    );
	  },
	  "afterChange": function(changes, source) {
	    if (changes === null)
	      return;
	    chart.dataProvider = formatChartData(this.getData());
	    chart.validateData();
	  }
	  
	});

	// define function which reformats table data into
	// format suitable for the chart
	function formatChartData(tableData) {
	  var chartData = [];
	  for(var i = 0; i < tableData.length; i++) {
	    chartData.push({
	      "category": tableData[i][0],
	      "cut":      tableData[i][1],
	      "myscore":  tableData[i][2],
	      "gap":      tableData[i][3]
	    });
	  }
	  return chartData;
	}

	});
	
});




