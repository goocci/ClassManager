/*
 * https://www.amcharts.com/
 * Single website license
 * Copyright © 2006-2017, amCharts. All rights reserved.
 * */
var chartData_univScore1 = new Array();
var chartData_univScore2 = new Array();
var chartData_univScore3 = new Array();

var chartData_MyScore1 = new Array();
var chartData_MyScore2 = new Array();
var chartData_MyScore3 = new Array();

$.getJSON("http://192.168.219.104:8080/classmanager/UnivScore", function(data) {
	$.each(data, function(inx, obj) {
		chartData_univScore1.push(obj.standard);
		chartData_univScore2.push(obj.percent);
		chartData_univScore3.push(obj.rate);
	});
});
// 표준점수
$.getJSON("http://192.168.219.104:8080/classmanager/MyScore", function(data) {
	$.each(data, function(inx, obj) {
		chartData_MyScore1.push(obj.standard);
	});
	
	/**
	 * Create the chart
	 */
	function createChart(data) {
		  
		  return AmCharts.makeChart("chartdiv1", {
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
		      "lineColor" : "#f94343"
		    }, {
		      "lineThickness": 2,
		      "bullet": "diamond",
		      "bulletSize": 12,
		      "title": "내 점수",
		      "valueField": "myscore",
		      "lineColor" : "#43e1f9"
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
	  ['1학년 3월', chartData_univScore1, chartData_MyScore1[0], (chartData_MyScore1[0]-chartData_univScore1).toFixed(1)],
	  ['1학년 6월', chartData_univScore1, chartData_MyScore1[1], (chartData_MyScore1[1]-chartData_univScore1).toFixed(1)],
	  ['1학년 9월', chartData_univScore1, chartData_MyScore1[2], (chartData_MyScore1[2]-chartData_univScore1).toFixed(1)],
	  ['2학년 3월', chartData_univScore1, chartData_MyScore1[3], (chartData_MyScore1[3]-chartData_univScore1).toFixed(1)],
	  ['2학년 6월', chartData_univScore1, chartData_MyScore1[4], (chartData_MyScore1[4]-chartData_univScore1).toFixed(1)],
	  ['2학년 9월', chartData_univScore1, chartData_MyScore1[5], (chartData_MyScore1[5]-chartData_univScore1).toFixed(1)],
	  ['3학년 3월', chartData_univScore1, chartData_MyScore1[6], (chartData_MyScore1[6]-chartData_univScore1).toFixed(1)],
	  ['3학년 6월', chartData_univScore1, chartData_MyScore1[7], (chartData_MyScore1[7]-chartData_univScore1).toFixed(1)],
	  ['3학년 9월', chartData_univScore1, chartData_MyScore1[8], (chartData_MyScore1[8]-chartData_univScore1).toFixed(1)]
	];
	for(var i = 0 ; i< sourceData.length ; i++){

		if(sourceData[i][2]==0 || isNaN(sourceData[i][2]) === true){
			sourceData[i][2]="모든 과목의 성적을 입력하지 않았습니다.";
			sourceData[i][3]="모든 과목의 성적을 입력하지 않았습니다.";
			}
		sourceData2.push(sourceData[i]);

	}
	/**
	* Create the Handsontable editable grid
	*/
	/*
	 * https://handsontable.com
	 * released under the MIT license
	 * Copyright (c) 2015 Handsoncode sp. z o.o. hello@handsoncode.net
	 * Copyright (c) 2012-2014 Marcin Warpechowski
	 * */
	AmCharts.ready(function() {

	var container = document.getElementById("data1");
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
// 백분위
$.getJSON("http://192.168.219.104:8080/classmanager/MyScore", function(data) {
	$.each(data, function(inx, obj) {
		chartData_MyScore2.push(obj.percent);
	});
	
	/**
	 * Create the chart
	 */
	function createChart(data) {
		  
		  return AmCharts.makeChart("chartdiv2", {
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
		      "title": "백분위"
		    }],
		    
		    "graphs": [{
		      "lineThickness": 2,
		      "bullet": "round",
		      "title": "기준 점수",
		      "valueField": "cut",
		      "lineColor" : "#f94343"
		    }, {
		      "lineThickness": 2,
		      "bullet": "diamond",
		      "bulletSize": 12,
		      "title": "내 점수",
		      "valueField": "myscore"
		    }, /*{
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
	  ['1학년 3월', chartData_univScore2, chartData_MyScore2[0], (chartData_MyScore2[0]-chartData_univScore2).toFixed(1)],
	  ['1학년 6월', chartData_univScore2, chartData_MyScore2[1], (chartData_MyScore2[1]-chartData_univScore2).toFixed(1)],
	  ['1학년 9월', chartData_univScore2, chartData_MyScore2[2], (chartData_MyScore2[2]-chartData_univScore2).toFixed(1)],
	  ['2학년 3월', chartData_univScore2, chartData_MyScore2[3], (chartData_MyScore2[3]-chartData_univScore2).toFixed(1)],
	  ['2학년 6월', chartData_univScore2, chartData_MyScore2[4], (chartData_MyScore2[4]-chartData_univScore2).toFixed(1)],
	  ['2학년 9월', chartData_univScore2, chartData_MyScore2[5], (chartData_MyScore2[5]-chartData_univScore2).toFixed(1)],
	  ['3학년 3월', chartData_univScore2, chartData_MyScore2[6], (chartData_MyScore2[6]-chartData_univScore2).toFixed(1)],
	  ['3학년 6월', chartData_univScore2, chartData_MyScore2[7], (chartData_MyScore2[7]-chartData_univScore2).toFixed(1)],
	  ['3학년 9월', chartData_univScore2, chartData_MyScore2[8], (chartData_MyScore2[8]-chartData_univScore2).toFixed(1)]
	];
	for(var i = 0 ; i< sourceData.length ; i++){

		if(sourceData[i][2]==0 || isNaN(sourceData[i][2]) === true){
			sourceData[i][2]="모든 과목의 성적을 입력하지 않았습니다.";
			sourceData[i][3]="모든 과목의 성적을 입력하지 않았습니다.";
			}
		sourceData2.push(sourceData[i]);

	}
	/**
	* Create the Handsontable editable grid
	*/
	AmCharts.ready(function() {

	var container = document.getElementById("data2");
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
// 등급
$.getJSON("http://192.168.219.104:8080/classmanager/MyScore", function(data) {
	$.each(data, function(inx, obj) {
		chartData_MyScore3.push(obj.rate);
	});
	
	/**
	 * Create the chart
	 */
	function createChart(data) {
		  
		  return AmCharts.makeChart("chartdiv3", {
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
		      "title": "등급",
		      "reversed": true
		    }],
		    
		    "graphs": [{
		      "lineThickness": 2,
		      "bullet": "round",
		      "title": "기준 점수",
		      "valueField": "cut",
		      "lineColor" : "#f94343"
		    }, {
		      "lineThickness": 2,
		      "bullet": "diamond",
		      "bulletSize": 12,
		      "title": "내 점수",
		      "valueField": "myscore",
		      "lineColor" : "#1ec943"
		    }, /*{
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
	  ['1학년 3월', chartData_univScore3, chartData_MyScore3[0], (chartData_univScore3-chartData_MyScore3[0]).toFixed(1)],
	  ['1학년 6월', chartData_univScore3, chartData_MyScore3[1], (chartData_univScore3-chartData_MyScore3[1]).toFixed(1)],
	  ['1학년 9월', chartData_univScore3, chartData_MyScore3[2], (chartData_univScore3-chartData_MyScore3[2]).toFixed(1)],
	  ['2학년 3월', chartData_univScore3, chartData_MyScore3[3], (chartData_univScore3-chartData_MyScore3[3]).toFixed(1)],
	  ['2학년 6월', chartData_univScore3, chartData_MyScore3[4], (chartData_univScore3-chartData_MyScore3[4]).toFixed(1)],
	  ['2학년 9월', chartData_univScore3, chartData_MyScore3[5], (chartData_univScore3-chartData_MyScore3[5]).toFixed(1)],
	  ['3학년 3월', chartData_univScore3, chartData_MyScore3[6], (chartData_univScore3-chartData_MyScore3[6]).toFixed(1)],
	  ['3학년 6월', chartData_univScore3, chartData_MyScore3[7], (chartData_univScore3-chartData_MyScore3[7]).toFixed(1)],
	  ['3학년 9월', chartData_univScore3, chartData_MyScore3[8], (chartData_univScore3-chartData_MyScore3[8]).toFixed(1)]
	];
	for(var i = 0 ; i< sourceData.length ; i++){

		if(sourceData[i][2]==0 || isNaN(sourceData[i][2]) === true){
			sourceData[i][2]="모든 과목의 성적을 입력하지 않았습니다.";
			sourceData[i][3]="모든 과목의 성적을 입력하지 않았습니다.";
			}
		sourceData2.push(sourceData[i]);

	}
	/**
	* Create the Handsontable editable grid
	*/
	AmCharts.ready(function() {

	var container = document.getElementById("data3");
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




