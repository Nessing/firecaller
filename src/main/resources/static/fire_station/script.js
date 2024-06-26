angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080';

    let params = (new URL(document.location)).searchParams;
    let numberStation = params.get("id");
    $scope.numberOfStation = numberStation;
    // $scope.name = params.get("name");

    $scope.editMode = false;
    $scope.firefighters = [];
    $scope.firefightersMap = new Map();

    $http.get(contextPath + '/getPositions')
        .then(function (response) {
            $scope.positions = response.data;
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
                    $scope.firefighters.push(fireFighter.short_name);
                }
                $scope.firefightersMap = Object.fromEntries(response.data.map(firefighter =>[firefighter.id, firefighter.short_name]));
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

    $scope.getFirefighters();
});