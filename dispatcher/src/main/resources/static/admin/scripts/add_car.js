angular.module('app', []).controller('addCarController', function ($scope, $http) {
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

    $scope.save = function (car) {
        if (car !== undefined &&
            car.name !== undefined && car.name.trim().length !== 0 &&
            car.numberCar !== undefined && car.numberCar.trim().length !== 0 &&
            car.fireStation !== undefined && car.fireStation.trim().length !== 0) {
            car.fireStation = {
                id: car.fireStation,
                name: $scope.fire_stations[car.fireStation]
            };
            if (car.team !== undefined && car.team.trim().length !== 0) {
                car.team = {
                    id: car.team,
                    name: $scope.teams[car.team]
                };
            }
            $http.post(contextPath + "/createCar", car)
                .then(function (response) {
                    if (response.data) {
                        alert("Машина " + car.name + " " + car.numberCar + " " + " добавлен в часть: " + car.fire_station);
                    } else {
                        alert("Произошла ошибка при добавлении машины!");
                    }
            });
        }
    }
});