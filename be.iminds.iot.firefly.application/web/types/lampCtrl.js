
(function(){

	'use strict';

	angular.module('be.iminds.iot.firefly').controller('lampCtrl', function ($scope, $modalInstance, actions, thing) {
		  
		  $scope.thing = thing;
		  $scope.color = $scope.thing.state.color;
		  $scope.level = $scope.thing.state.level;
		  
		  // should not happen?
		  if($scope.color === undefined)
			  $scope.color = "#FFFFFF";
		  if($scope.level === undefined)
			  $scope.level = "100";
		  
		  $scope.$watch('color', function(newValue, oldValue) {
			  console.log("COLOR! "+newValue);
			  if(newValue!== undefined)
				  actions.action($scope.thing.id, $scope.thing.type, "color", $scope.color);
		  });
		  
		  $scope.$watch('level', function(newValue, oldValue) {
			  console.log("LEVEL!");
			  if(newValue!== undefined)
				  actions.action($scope.thing.id, $scope.thing.type, "level", $scope.level);
		  });
		  
		  $scope.toggle = function(){
			  console.log("TOGGLE!");
			  actions.action($scope.thing.id, $scope.thing.type);
		  };
		  
		  $scope.ok = function () {
			  $modalInstance.close();
		  };
	
		  $scope.cancel = function () {
			  $modalInstance.dismiss('cancel');
		  };
	});

})();