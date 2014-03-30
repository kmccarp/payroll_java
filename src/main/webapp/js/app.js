var payrollApp = angular.module('payrollApp', [
    'ngRoute',
    'restangular'
    , 'controllers'
    //, 'payrollFilters'
])

payrollApp.config(function($httpProvider, $routeProvider, RestangularProvider) {
	RestangularProvider.setBaseUrl('op')
	
	$routeProvider
		.when('/', {
			templateUrl: 'partials/main.html',
			controller: 'MainCtrl'
		})
		.when('/timesheets', {
			templateUrl: 'partials/timesheet.html',
			controller: 'TimesheetCtrl'
		})
		.when('/subtimes', {
			templateUrl: 'partials/employee-timesheet.html',
			controller: 'EmployeeTimesheetCtrl'
		})
		.when('/subs', {
			templateUrl: 'partials/manage-employees.html',
			controller: 'ManageEmployeeCtrl'
		})
		.when('/settings', {
			templateUrl: 'partials/settings.html',
			controller: 'SettingsCtrl'
		})
		.otherwise({
			redirectTo: '/'
		})
})