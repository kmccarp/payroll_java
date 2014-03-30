var controllers = angular.module('controllers', [])

controllers.controller('MainCtrl', function($scope) {
	console.log('hit main controller')
})

controllers.controller('TimesheetCtrl', function($scope, Restangular) {
	console.log('hit timesheet controller')
})

controllers.controller('EmployeeTimesheetCtrl', function($scope, Restangular) {
	console.log('hit emp timesheet controller')
})

controllers.controller('ManageEmployeeCtrl', function($scope, Restangular) {
	console.log('hit manage emps controller')
})

controllers.controller('SettingsCtrl', function($scope, Restangular) {
	console.log('hit settings controller')
})