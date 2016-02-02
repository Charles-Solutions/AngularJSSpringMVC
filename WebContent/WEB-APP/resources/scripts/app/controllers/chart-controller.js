app.controller('ChartController', function ($scope, $broker) { 
	
		var self = $scope;
	
		self.chartObject = {};
		self.chartTypeSelected = "PieChart";
		
		
		self.loadChart = function(){			
			
			self.chartObject.type = self.chartTypeSelected; 
			
			switch(self.chartTypeSelected){
				case "PieChart":
				case "BarChart":
				case "ColumnChart":{
					self.chartObject.data = 
				    {
					    "cols": [ 
					              {id: "t", label: "Topping", type: "string"},
					              {id: "s", label: "Slices", type: "number"}
					            ], 
					    
					     "rows": [
					        {c: [{v: "Mushrooms"}, {v: 3}]},
					        {c: [{v: "Onions"}, {v: 3}]},
					        {c: [{v: "Olives"}, {v: 31}]},
					        {c: [{v: "Zucchini"}, {v: 1}]},
					        {c: [{v: "Pepperoni"},{v: 2}]}
					    ]
				    };

					self.chartObject.options = {
				        'title': 'How Much Pizza I Ate Last Night'
				    };
				}break;
				
				case "Gauge":{
					self.chartObject.data = [
					      ['Label', 'Value'],
					      ['Memory', 80],
					      ['CPU', 55],
					      ['Network', 68]
				    ];
				    
				    self.chartObject.options = {
					      width: 400,
					      height: 120,
					      redFrom: 90,
					      redTo: 100,
					      yellowFrom: 75,
					      yellowTo: 90,
					      minorTicks: 5
				    };				    
				}break;
			}		
		};
	 	
		self.loadChart();
      
});



