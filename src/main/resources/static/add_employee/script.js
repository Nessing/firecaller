angular.module('app', []).controller('addEmployeeController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080';

    $scope.firefighters = [];
    $scope.fire_stations = [];

    // $http.get(contextPath + '/getPositions')
    //     .then(function (response) {
    //         alert("Сохранен");
    //         // $scope.positions = response.data;
    //     });

    $scope.getFirefighters = function () {
        $http.get(contextPath + '/getAllPositions')
            .then(function (response) {
                for (let fireFighter of response.data) {
                    $scope.firefighters.push(fireFighter.name);
                }
            }, function (error) {
                // handle error
            });
    }

    $scope.getFireStations = function () {
        $http.get(contextPath + '/getFireStations')
            .then(function (response) {
                for (let fireStation of response.data) {
                    $scope.fire_stations.push(fireStation.name);
                }
            })
    }

    $scope.save = function (employee) {
        if (employee !== undefined &&
            employee.last_name !== undefined && employee.last_name.trim().length !== 0 &&
            employee.first_name !== undefined && employee.first_name.trim().length !== 0 &&
            employee.position !== undefined && employee.position.trim().length !== 0 &&
            employee.fire_station !== undefined && employee.fire_station.trim().length !== 0) {
            alert(employee.last_name + " " + employee.first_name + " " + employee.mid_name + " " + employee.position + " " + employee.fire_station);
        }
        // $http.get(contextPath + '/getFirefighters/' + numberStation)
        //     .then(function (response) {
        //         $scope.firefighters.length = 0;
        //         $scope.numberOfStation = numberStation;
        //         $scope.firefightersOfStation = response.data;
        //         for (let fireFighter of response.data) {
        //             $scope.firefighters.push(fireFighter.name);
        //         }
        //     }, function (error) {
        //         // handle error
        //     });
    }

    $scope.getFirefighters();
    $scope.getFireStations();
});