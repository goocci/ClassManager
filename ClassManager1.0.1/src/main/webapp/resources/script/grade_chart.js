var chartData_schooltest = new Array();

var chartLabels_language = new Array();
var chartData1_language = new Array();
var chartData2_language = new Array();
var chartData3_language = new Array();

var chartLabels_math = new Array();
var chartData1_math = new Array();
var chartData2_math = new Array();
var chartData3_math = new Array();

var chartLabels_english = new Array();
var chartData1_english = new Array();
var chartData2_english = new Array();
var chartData3_english = new Array();

var chartLabels_science = new Array();
var chartData1_science = new Array();
var chartData2_science = new Array();
var chartData3_science = new Array();

var chartLabels_society = new Array();
var chartData1_society = new Array();
var chartData2_society = new Array();
var chartData3_society = new Array();

/*내신*/
$.getJSON("http://localhost:8080/classmanager/list_schooltest", function(data) {
	$.each(data, function(inx, obj) {
		chartData_schooltest.push(obj.AVG);
	});
	var ctx = document.getElementById("school_grade");
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : ["1학년 1학기", "1학년 2학기", "2학년 1학기", "2학년 2학기", "3학년 1학기", "3학년 2학기",],
			datasets : [ {
				label : '# of 등급',
				data : chartData_schooltest,
				backgroundColor : ['rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)'],
				borderColor : ['rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)'],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
});

/* 언어 */
$.getJSON("http://localhost:8080/classmanager/list_language", function(data) {
	$.each(data, function(inx, obj) {
		chartLabels_language.push(obj.grademonth);
		chartData1_language.push(obj.standard);
		chartData2_language.push(obj.percent);
		chartData3_language.push(obj.rate);
	});
	/* 언어 표준점수 */
	var ctx = document.getElementById("language_stdd");
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : chartLabels_language,
			datasets : [ {
				label : '# of 표준점수',
				data : chartData1_language,
				backgroundColor : ['rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)'],
				borderColor : ['rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)'],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
	/* 언어 백분위 */
	var ctx = document.getElementById("language_pct");
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : chartLabels_language,
			datasets : [ {
				label : '# of 백분위',
				data : chartData2_language,
				backgroundColor : ['rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)'],
				borderColor : ['rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)'],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
	/* 언어 등급 */
	var ctx = document.getElementById("language_rate");
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : chartLabels_language,
			datasets : [ {
				label : '# of 등급',
				data : chartData3_language,
				backgroundColor : ['rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)'],
				borderColor : ['rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)'],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
});


/* 수리 */
$.getJSON("http://localhost:8080/classmanager/list_math", function(data) {
	$.each(data, function(inx, obj) {
		chartLabels_math.push(obj.grademonth);
		chartData1_math.push(obj.standard);
		chartData2_math.push(obj.percent);
		chartData3_math.push(obj.rate);
	});
	/* 수리 표준점수 */
	var ctx = document.getElementById("math_stdd");
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : chartLabels_math,
			datasets : [ {
				label : '# of 표준점수',
				data : chartData1_math,
				backgroundColor : ['rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)'],
				borderColor : ['rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)'],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
	/* 수리 백분위 */
	var ctx = document.getElementById("math_pct");
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : chartLabels_math,
			datasets : [ {
				label : '# of 백분위',
				data : chartData2_math,
				backgroundColor : ['rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)'],
				borderColor : ['rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)'],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
	/* 수리 등급 */
	var ctx = document.getElementById("math_rate");
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : chartLabels_math,
			datasets : [ {
				label : '# of 등급',
				data : chartData3_math,
				backgroundColor : ['rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)'],
				borderColor : ['rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)'],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
});



/* 외국어 */
$.getJSON("http://localhost:8080/classmanager/list_english", function(data) {
	$.each(data, function(inx, obj) {
		chartLabels_english.push(obj.grademonth);
		chartData1_english.push(obj.standard);
		chartData2_english.push(obj.percent);
		chartData3_english.push(obj.rate);
	});
	/* 외국어 표준점수 */
	var ctx = document.getElementById("english_stdd");
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : chartLabels_english,
			datasets : [ {
				label : '# of 표준점수',
				data : chartData1_english,
				backgroundColor : ['rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)'],
				borderColor : ['rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)'],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
	/* 외국어 백분위 */
	var ctx = document.getElementById("english_pct");
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : chartLabels_english,
			datasets : [ {
				label : '# of 백분위',
				data : chartData2_english,
				backgroundColor : ['rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)'],
				borderColor : ['rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)'],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
	/* 외국어 등급 */
	var ctx = document.getElementById("english_rate");
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : chartLabels_english,
			datasets : [ {
				label : '# of 등급',
				data : chartData3_english,
				backgroundColor : ['rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)'],
				borderColor : ['rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)'],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
});


/* 과학탐구 */
$.getJSON("http://localhost:8080/classmanager/list_science", function(data) {
	$.each(data, function(inx, obj) {
		chartLabels_science.push(obj.subject);
		chartData1_science.push(obj.standard);
		chartData2_science.push(obj.percent);
		chartData3_science.push(obj.rate);
	});
	/* 과학탐구 표준점수 */
	var ctx = document.getElementById("science_stdd");
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : chartLabels_science,
			datasets : [ {
				label : '# of 표준점수',
				data : chartData1_science,
				backgroundColor : ['rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)'],
				borderColor : ['rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)'],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
	/* 과학탐구 백분위 */
	var ctx = document.getElementById("science_pct");
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : chartLabels_science,
			datasets : [ {
				label : '# of 백분위',
				data : chartData2_science,
				backgroundColor : ['rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)'],
				borderColor : ['rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)'],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
	/* 과학탐구 등급 */
	var ctx = document.getElementById("science_rate");
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : chartLabels_science,
			datasets : [ {
				label : '# of 등급',
				data : chartData3_science,
				backgroundColor : ['rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)'],
				borderColor : ['rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)'],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
});




/* 사회탐구 */
$.getJSON("http://localhost:8080/classmanager/list_society", function(data) {
	$.each(data, function(inx, obj) {
		chartLabels_society.push(obj.grademonthsubject);
		chartData1_society.push(obj.standard);
		chartData2_society.push(obj.percent);
		chartData3_society.push(obj.rate);
	});
	/* 사회탐구 표준점수 */
	var ctx = document.getElementById("society_stdd");
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : chartLabels_society,
			datasets : [ {
				label : '# of 표준점수',
				data : chartData1_society,
				backgroundColor : ['rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)'],
				borderColor : ['rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)'],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
	/* 사회탐구 백분위 */
	var ctx = document.getElementById("society_pct");
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : chartLabels_society,
			datasets : [ {
				label : '# of 백분위',
				data : chartData2_society,
				backgroundColor : ['rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)'],
				borderColor : ['rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)'],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
	/* 사회탐구 등급 */
	var ctx = document.getElementById("society_rate");
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : chartLabels_society,
			datasets : [ {
				label : '# of 등급',
				data : chartData3_society,
				backgroundColor : ['rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)','rgba(75, 192, 192, 0.2)'],
				borderColor : ['rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)','rgba(75, 192, 192, 1)'],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
});
