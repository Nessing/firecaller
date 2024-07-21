angular.module('app', []).controller('addEmployeeController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080';

    $scope.positions = new Map();
    $scope.ranks = new Map();
    $scope.fire_stations = new Map();
    $scope.teams = new Map();
    $scope.person = {};

    $http.get(contextPath + '/getAllPositions')
        .then(function (response) {
            $scope.positions = Object.fromEntries(response.data.map(position =>[position.id, position.name]));
        }, function (error) {
            // handle error
        }).catch(error => {
            console.error(error);
        });

    $http.get(contextPath + '/getAllRanks')
        .then(function (response) {
            $scope.ranks = Object.fromEntries(response.data.map(rank =>[rank.id, rank.name]));
        }, function (error) {
            // handle error
        }).catch(error => {
        console.error(error);
    });

    $http.get(contextPath + '/getFireStations')
        .then(function (response) {
            $scope.fire_stations = Object.fromEntries(response.data.map(fireStation =>[fireStation.id, fireStation.name]));
        })

    $http.get(contextPath + '/getTeams')
        .then(function (response) {
            $scope.teams = Object.fromEntries(response.data.map(team =>[team.id, team.name]));
        })

    $scope.save = function (employee) {
        console.log(employee);
        if (employee !== undefined &&
            employee.lastName !== undefined && employee.lastName.trim().length !== 0 &&
            employee.firstName !== undefined && employee.firstName.trim().length !== 0 &&
            employee.position !== undefined && employee.position.trim().length !== 0 &&
            employee.fireStation !== undefined && employee.fireStation.trim().length !== 0 &&
            employee.team !== undefined && employee.team.trim().length !== 0) {
            console.log("yes");
            employee.position = {
                id: employee.position,
                name: $scope.positions[employee.position]
            };
            employee.fireStation = {
                id: employee.fireStation,
                name: $scope.fire_stations[employee.fireStation]
            };
            employee.rank = {
                id: employee.rank,
                name: $scope.ranks[employee.rank]
            };
            employee.team = {
                id: employee.team,
                name: $scope.teams[employee.team]
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
    }
});