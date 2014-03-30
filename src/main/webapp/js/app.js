var payrollApp = angular.module('payrollApp', [
    'ngRoute',
    'restangular'
    , 'controllers'
    //, 'payrollFilters'
])

payrollApp.config(function($httpProvider, $routeProvider, RestangularProvider) {
	RestangularProvider.setBaseUrl('op')
})