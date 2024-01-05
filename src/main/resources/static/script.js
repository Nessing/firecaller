angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080';

    $scope.fillTable = function () {
        $http.get(contextPath + '/all')
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

    // $scope.fillTable = function () {
    //     $http({
    //         url: contextPath + '/products',
    //         method: 'GET',
    //         params: {
    //             min_price: $scope.filter ? $scope.filter.min_price : null,
    //             max_price: $scope.filter ? $scope.filter.max_price : null
    //         }
    //     }).then(function (response) {
    //         $scope.ProductsList = response.data;
    //     });
    // };
    //
    // $scope.submitCreateNewProduct = function () {
    //     $http.post(contextPath + '/products', $scope.newProduct)
    //         .then(function (response) {
    //             // console.log('sended:');
    //             // console.log($scope.newProduct);
    //             // console.log('received');
    //             // console.log(response.data);
    //             $scope.newProduct = null;
    //             $scope.fillTable();
    //         });
    // };
    //
    $scope.fillTable();
});