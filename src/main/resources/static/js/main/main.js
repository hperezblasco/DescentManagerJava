'use strict';

angular.module('descentManagerApp')
  .config(['$stateProvider', function($stateProvider) {
    $stateProvider
      .state('main', {
        url: '/main',
        templateUrl: 'js/main/main.html',
        controller: 'MainCtrl'
      });
  }]);
