var app = angular.module('app', ['ngRoute', 'ngSanitize', 'ui.bootstrap', 'googlechart']);

var baseUrl = 'WEB-APP/resources/templates/';
app.config(['$routeProvider', function ($routeProvider) {
      $routeProvider.
        when('/welcome', {
            templateUrl: baseUrl + 'welcome.html',
            controller: 'WelcomeController'
        }).   
        when('/home', {
            templateUrl: baseUrl + 'home.html',
            controller: 'HomeController'
        }). 
        when('/google-chart', {
            templateUrl: baseUrl + 'google-chart.html',
            controller: 'ChartController'
        }). 
        otherwise({
            redirectTo: '/welcome'
        });
}]);