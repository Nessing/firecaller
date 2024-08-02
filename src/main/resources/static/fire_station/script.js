angular.module('app', []).controller('indexController', function ($scope, $http, $timeout) {
    const contextPath = 'http://localhost:8080';

    let params = (new URL(document.location)).searchParams;
    let numberStation = params.get("id");
    $scope.car = null;
    $scope.person = null;
    $scope.numberOfStation = numberStation;
    $scope.personBinder = null;

    // $scope.name = params.get("name");

    $scope.isShowFirefightersList = false;
    $scope.isShowCarList = false;
    $scope.isModalCarWindow = false;
    $scope.isModalPersonWindow = false;
    $scope.isHiddenNotification = false;
    $scope.showHiddenNotification = false;
    $scope.editMode = false;
    $scope.isEditSelectedPerson = false;
    $scope.isEditSelectedCar = false;
    $scope.isEditingCar = false;
    $scope.selectedTeam = null;
    $scope.selectedCarIndex = -1;
    $scope.firefighters = [];
    $scope.firefightersMap = new Map();
    $scope.squares = [];
    $scope.teams = new Map();

    $http.get(contextPath + '/getAllPositions')
        .then(function (response) {
            $scope.positions = Object.fromEntries(response.data.map(team =>[team.id, team.name]));
        }, function (error) {
            // handle error
        });
    $http.get(contextPath + '/getAllRanks')
        .then(function (response) {
            $scope.ranks = Object.fromEntries(response.data.map(team =>[team.id, team.name]));
        }, function (error) {
            // handle error
        });

    $http.get(contextPath + '/getFireStation/' + numberStation)
        .then(function (response) {
            if (response.data != null) {
                $scope.name = response.data.name;
            }
        }, function (error) {
            // handle error
        });

    $scope.getCars = function () {
        $http.get(contextPath + '/getCars/' + numberStation)
            .then(function (response) {
                if (response.data != null) {
                    $scope.fireCars = response.data;
                }
            }, function (error) {
                // handle error
            });
    }

    $http.get(contextPath + '/getTeams')
        .then(function (response) {
            $scope.teams = Object.fromEntries(response.data.map(team =>[team.id, team.name]));
        });

    $scope.getKeyByValue = function(object, value) {
        if (value == null) {
            return null;
        }
        for (var key in object) {
            if (object[key] === value) {
                return key;
            }
        }
        return null;
        // return Object.keys(object).find(key => object[key] === value);
    };

    $scope.editTeam = function() {
        $scope.isEditingCar = true;
        $scope.selectedTeam = $scope.getKeyByValue($scope.teams, $scope.car.team.name);
        console.log("editTeam" + $scope.selectedTeam);
    };

    $scope.saveTeam = function() {
        $scope.isEditingCar = false;
        $scope.car.team = $scope.teams[$scope.selectedTeam];
    };


    $http.get(contextPath + '/getSquare/' + numberStation)
        .then(function (response) {
            $scope.numberOfStation = numberStation;
            $scope.square = response.data;
        }, function (error) {
            // handle error
        });

    $scope.getSquares = function () {
        $http.get(contextPath + '/getSquareOfStation/' + numberStation)
            .then(function (response) {
                $scope.squares = response.data;
                console.log($scope.squares);
                for (let i = 0; i < $scope.squares.length; i++) {
                    console.log($scope.squares[i].firefighters);
                    console.log($scope.squares[i].team.name);
                }
            }, function (error) {
                // handle error
            });
    }

    $scope.getFirefighters = function () {
        $http.get(contextPath + '/getFirefighters/' + numberStation)
            .then(function (response) {
                $scope.firefighters.length = 0;
                $scope.numberOfStation = numberStation;
                $scope.firefightersOfStation = response.data;
                for (let fireFighter of response.data) {
                    $scope.firefighters.push(fireFighter.shortName);
                }
                $scope.firefightersMap = Object.fromEntries(response.data.map(firefighter =>[firefighter.id, firefighter.shortName]));
            }, function (error) {
                // handle error
            });
    }

    $scope.delete = function (employee) {
        // if (employee !== undefined &&
        //     employee.last_name !== undefined && employee.last_name.trim().length !== 0 &&
        //     employee.first_name !== undefined && employee.first_name.trim().length !== 0 &&
        //     employee.position !== undefined && employee.position.trim().length !== 0 &&
        //     employee.fire_station !== undefined && employee.fire_station.trim().length !== 0) {
            // employee.position = {
            //     id: employee.position,
            //     name: $scope.positions[employee.position]
            // };
        if (employee !== undefined && employee.id !== undefined) {
            $http.post(contextPath + "/deletePerson", employee.id)
                .then(function (response) {
                    console.log(response.data);
                    // if (response.data) {
                    //     alert("Сотрудник " + employee.last_name + " " + employee.first_name + " " + employee.mid_name + " " + employee.position + " добавлен в часть: " + employee.fire_station);
                    // } else {
                    //     alert("Произошла ошибка при добавлении сотрудника!");
                    // }
                });
        }
        // }
    }

    $scope.deleteCar = function (car) {
        $http.post(contextPath + "/deleteCar", car)
            .then(function (response){
                console.log(response.data);
                $scope.getSquares();
                $scope.getCars();
                $scope.isModalCarWindow = false;
                $scope.isHiddenNotification = true;
                $scope.showHiddenNotification = true;
                $timeout(function () {
                    $scope.isHiddenNotification = false;
                }, 1000);
            });
    }

    $scope.showFirefightersList = function() {
        $scope.isShowFirefightersList = !$scope.isShowFirefightersList;
    };

    $scope.showCarList = function() {
        $scope.isShowCarList = !$scope.isShowCarList;
    };

    $scope.openModalPersonWindow = function(person) {
        $scope.person = person;
        $scope.isModalPersonWindow = true;
    };
    $scope.closeModalPersonWindow = function() {
        $scope.isModalPersonWindow = false;
        $scope.isEditSelectedPerson = false;
        $scope.getFirefighters();
    };

    $scope.editPerson = function () {
        $scope.editSelectedPerson();
    }
    $scope.editSelectedPerson = function () {
        $scope.isEditSelectedPerson = !$scope.isEditSelectedPerson;
    }

    $scope.updatePerson = function (person) {
        if (person.position !== null && person.position !== undefined && person.position.trim().length !== 0) {
            person.position = {
                id: person.position,
                name: $scope.positions[person.position]
            };
        } else {
            person.position = null;
        }

        if (person.rank !== null && person.rank !== undefined && person.rank.trim().length !== 0) {
            person.rank = {
                id: person.rank,
                name: $scope.ranks[person.rank]
            };
        } else {
            person.rank = null;
        }

        if (person.team !== null && person.team !== undefined && person.team.trim().length !== 0) {
            person.team = {
                id: person.team,
                name: $scope.teams[person.team]
            };
        } else {
            person.team = null;
        }
        $http.post(contextPath + "/updatePerson", person)
            .then(function (response) {
                $scope.closeModalPersonWindow();
                $scope.getSquares();
                $scope.getFirefighters();
            });
    }

    $scope.openModalCarWindow = function(car) {
        $scope.car = car;
        console.log("show: " + car.name + " " + car.numberCar);
        $scope.isModalCarWindow = true;
    };
    $scope.closeModalCarWindow = function() {
        $scope.isModalCarWindow = false;
    };

    $scope.editCar = function (index) {
        $scope.selectedCarIndex = index;
        $scope.editSelectedCar();
    }

    $scope.editSelectedCar = function () {
        $scope.isEditSelectedCar = !$scope.isEditSelectedCar;
    }
    $scope.cancelEditCar = function () {
        $scope.selectedCarIndex = -1;
        $scope.editSelectedCar();
        $scope.getCars();
    }

    $scope.updateCar = function (car) {
        console.log(car);
        if (car.team !== null && car.team !== undefined && car.team.trim().length !== 0) {
            car.team = {
                id: car.team,
                name: $scope.teams[car.team]
            };
        } else {
            car.team = null;
        }
        $http.post(contextPath + "/updateCar", car)
            .then(function (response) {
                $scope.cancelEditCar();
                $scope.getSquares();
                $scope.getCars();
            });
    }

    $scope.getSquares();
    $scope.getFirefighters();
    $scope.getCars();
});