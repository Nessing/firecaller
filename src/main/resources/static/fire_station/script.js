angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080';

    let params = (new URL(document.location)).searchParams;
    let numberStation = params.get("number");
    $scope.numberOfStation = numberStation;
    $scope.name = params.get("name");

    $scope.editMode = false;
    $scope.firefighters = [];

    $http.get(contextPath + '/getPositions')
        .then(function (response) {
            $scope.positions = response.data;
        }, function (error) {
            // handle error
        });

    $http.get(contextPath + '/getSquare/' + numberStation)
        .then(function (response) {
            $scope.numberOfStation = numberStation;
            $scope.square = response.data;
        }, function (error) {
            // handle error
        });

    $scope.getFirefighters = function () {
        $http.get(contextPath + '/getFirefighters/' + numberStation)
            .then(function (response) {
                $scope.firefighters.length = 0;
                $scope.numberOfStation = numberStation;
                $scope.firefightersOfStation = response.data;
                for (let fireFighter of response.data) {
                    $scope.firefighters.push(fireFighter.name);
                }
            }, function (error) {
                // handle error
            });
    }

    $scope.getFirefighters();
});