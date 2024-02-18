angular.module('app', []).controller('addEmployeeController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080';

    // $http.get(contextPath + '/getPositions')
    //     .then(function (response) {
    //         alert("Сохранен");
    //         // $scope.positions = response.data;
    //     });

    $scope.save = function (employee) {
        if (employee !== undefined && employee.last_name !== undefined && employee.last_name.trim().length !== 0 &&
            employee.first_name !== undefined && employee.first_name.trim().length !== 0) {
            alert(employee.last_name + " " + employee.first_name + " " + employee.mid_name);
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
});