app.service('$broker',  ['$http',  function ($http) { 

	var self = this;	
	var serviceUrlBase = appBaseUrl + 'webservice/';	
	
	self.UserWebService = {
			
		saveUser: function(user){
			var userData = {
				name: user.getName(),
				lastName: user.getLastName(),
				email: user.getEmail()
			};
			return $http.post(serviceUrlBase + 'user/save', userData);
		},
		
		getUsers: function(){
			return $http.get(serviceUrlBase + 'user/list');
		}	
	};
	
	self.PublicWebService = function() {
		
	};
		
}]);

