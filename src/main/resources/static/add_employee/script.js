angular.module('app', []).controller('addEmployeeController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080';

    $scope.positions = new Map();
    $scope.fire_stations = [];
    $scope.person = {};

    // $http.get(contextPath + '/getPositions')
    //     .then(function (response) {
    //         alert("Сохранен");
    //         // $scope.positions = response.data;
    //     });

    $scope.getPositions = function () {
        $http.get(contextPath + '/getAllPositions')
            .then(function (response) {
                // for (let position of response.data) {
                //     $scope.positions.set(position.id, position.name);
                // }
                $scope.positions = Object.fromEntries(response.data.map(position =>[position.id, position.name]));
                console.log($scope.positions);
            }, function (error) {
                // handle error
            }).catch(error => {
                console.error(error);
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
            employee.position = {
                id: employee.position,
                name: $scope.positions[employee.position]
            };
            $http.post(contextPath + "/addPerson", employee)
                .then(function (response) {
                    if (response.data) {
                        alert("Сотрудник " + employee.last_name + " " + employee.first_name + " " + employee.mid_name + " " + employee.position + " добавлен в часть: " + employee.fire_station);
                    } else {
                        alert("Произошла ошибка при добавлении сотрудника!");
                    }
            });
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

    $scope.getPositions();
    $scope.getFireStations();
});