var controllers = angular.module('controllers', [])

controllers.controller('MainCtrl', function($scope, Restangular) {
	$scope.auth = {username: '', password: ''}
	$scope.authError = null
	Restangular.one('isAuthenticated').get().then(function(response) {
		$scope.authenticated = response.authenticated
	})
	
	$scope.login = function() {
		$scope.authError = null
		Restangular.all('login').post($scope.auth).then(function(response) {
			$scope.authenticated = response.authenticated;
			if (!$scope.authenticated) {
				$scope.authError = 'Username or password incorrect'
			} else {
				
			}
		})
	}
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