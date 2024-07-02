angular.module('app', []).controller('addEmployeeController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080';

    $scope.positions = new Map();
    $scope.fire_stations = new Map();
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
            }, function (error) {
                // handle error
            }).catch(error => {
                console.error(error);
            });
    }

    $scope.getFireStations = function () {
        $http.get(contextPath + '/getFireStations')
            .then(function (response) {
                $scope.fire_stations = Object.fromEntries(response.data.map(fire_station =>[fire_station.id, fire_station.name]));
                // for (let fireStation of response.data) {
                //     $scope.fire_stations.push(fireStation.name);
                // }
            })
    }

    $scope.save = function (employee) {
        console.log(employee);
        if (employee !== undefined &&
            employee.lastName !== undefined && employee.lastName.trim().length !== 0 &&
            employee.firstName !== undefined && employee.firstName.trim().length !== 0 &&
            employee.position !== undefined && employee.position.trim().length !== 0 &&
            employee.fireStation !== undefined && employee.fireStation.trim().length !== 0) {
            console.log("yes");
            employee.position = {
                id: employee.position,
                name: $scope.positions[employee.position]
            };
            employee.fireStation = {
                id: employee.fireStation,
                name: $scope.fire_stations[employee.fireStation]
            };
            $http.post(contextPath + "/addPerson", employee)
                .then(function (response) {
                    if (response.data) {
                        alert("Сотрудник " + employee.lastName + " " + employee.firstName + " " + employee.midName + " " + employee.position + " добавлен в часть: " + employee.fire_station);
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