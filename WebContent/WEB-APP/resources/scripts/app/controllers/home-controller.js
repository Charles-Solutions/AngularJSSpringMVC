app.controller('HomeController', function ($scope, $window, $modal, $broker, User) { 
	
      $scope.alertMe = function() {
        setTimeout(function() {
          $window.alert('You\'ve selected the alert tab!');
        });
      };    
      
      $scope.loadUsers = function(){
    	  $broker.UserWebService.getUsers().success(function(data, status, headers, config) {
			    console.log(data);			   
		  }).error(function(data, status, headers, config) {
		    
		  });
      };
      
      $scope.open = function () {
           $modal.open({
		      templateUrl: 'WEB-APP/resources/templates/partials/new-user-dialog.html',		      
		      controller: 'UserDialogController',
		      backdrop: true,
		      backdropClick: true,
		      dialogFade: false,
		      keyboard: true,			      
		      resolve: {
		    	  dialogData: function(){
		    		  return new User('Alber', 'Clavijo', 'alber@gmail.com');		    		  
		    	  }
		      }			      
	      });
          
         /* modalInstance.result.then(function (selectedItem) {
              $scope.selected = selectedItem;
            }, function () {
              $log.info('Modal dismissed at: ' + new Date());
            });*/
     };	
});

app.controller('UserDialogController', function ($scope, $broker, $modalInstance, dialogData) {	 
	  $scope.ok = function () {		  
		  
		  $broker.UserWebService.saveUser(dialogData).success(function(data, status, headers, config) {
			    console.log(data);		
			    $modalInstance.close();
		  }).error(function(data, status, headers, config) {
		    
		  });
	  };

	  $scope.cancel = function () {
	    $modalInstance.dismiss('cancel');
	  };
});


