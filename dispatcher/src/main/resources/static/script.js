angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080';

    $scope.fillTable = function () {
        $http.get(contextPath + '/getFireStations')
            .then(function (response) {
                $scope.allFireStation = response.data;
            });
    };

    $scope.getFirefightersOfStation = function (numberStation) {
        $http.get(contextPath + '/getFirefighters/' + numberStation)
            .then(function (response) {
                $scope.numberOfStation = numberStation;
                $scope.firefightersOfStation = response.data;
            }, function (error) {
                // handle error
            });
    };

    $scope.createNewPerson = function () {
        $http.post(contextPath + '/addPerson', $scope.newFirefighter)
            .then(function (response) {
                $http.get(contextPath + '/getFirefighters/' + $scope.newFirefighter.fireStation)
                    .then(function (response) {
                        $scope.firefightersOfStation = response.data;
                        $scope.newFirefighter = null;
                    });
            });
    }

    $scope.fillTable();
});