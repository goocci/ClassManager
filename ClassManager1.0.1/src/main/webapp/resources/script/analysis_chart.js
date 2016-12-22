var chartData_univScore = new Array();

var chartData_MyScore = new Array();

/**
 * Create the chart
 */
$.getJSON("http://localhost:8080/classmanager/MyScore", function(data) {
	$.each(data, function(inx, obj) {
		chartData_MyScore.push(obj.standard);
	});
});
$.getJSON("http://localhost:8080/classmanager/UnivScore", function(data) {
	$.each(data, function(inx, obj) {
		chartData_univScore.push(obj.standard);
	});
});

function createChart(data) {
	  
	  return AmCharts.makeChart("chartdiv", {
	    "type": "serial",
	    "theme": "light",
	    "dataProvider": data,
	    "valueAxes": [{
	      "gridAlpha": 0.07,
	      "position": "left",
	      "title": "표준점수"
	    }],
	    "graphs": [{
	      "lineThickness": 2,
	      "bullet": "round",
	      "title": "Cars",
	      "valueField": "cars"
	    }, {
	      "lineThickness": 2,
	      "bullet": "diamond",
	      "bulletSize": 12,
	      "title": "Motorcycles",
	      "valueField": "motorcycles"
	    }, {
	      "lineThickness": 2,
	      "bullet": "square",
	      "title": "Bicycles",
	      "valueField": "bicycles"
	    }],
	    "chartCursor": {},
	    "categoryField": "year",
	    "categoryAxis": {
	      "startOnAxis": true
	    }
	  });
	  
}
/**
* Define initial data
*/
var MyScore0 = chartData_MyScore[0];
console.log("로그가 찍히는거냐");
console.log(MyScore0+"뜨냐");
console.log(chartData_MyScore.toString()+"뜨냐");
console.log(chartData_MyScore[standard]+"뜨냐");

var sourceData = [
	['1학년 3월', chartData_univScore, chartData_MyScore[0], 0],
	['1학년 6월', chartData_univScore, chartData_MyScore[1], 0],
	['1학년 9월', chartData_univScore, chartData_MyScore[2], 0],
	['2학년 3월', chartData_univScore, chartData_MyScore[3], 0],
	['2학년 6월', chartData_univScore, chartData_MyScore, 0],
	['2학년 9월', chartData_univScore, chartData_MyScore, 0],
	['3학년 3월', chartData_univScore, chartData_MyScore, 0],
	['3학년 6월', chartData_univScore, chartData_MyScore, 0],
	['3학년 9월', chartData_univScore, chartData_MyScore, 0]
];

/**
* Create the Handsontable editable grid
*/
AmCharts.ready(function() {

var container = document.getElementById("data");
var chart;

var hot = new Handsontable(container, {
  "data": sourceData,
  "height": 250,
  "colHeaders": ['구분','기준 점수','내 점수','차이'],
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
      "year":         tableData[i][0],
      "cars":         tableData[i][1],
      "motorcycles":  tableData[i][2],
      "bicycles":     tableData[i][3]
    });
  }
  return chartData;
}

});

