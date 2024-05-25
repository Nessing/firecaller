angular.module('app', []).controller('editRanksController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080';
    $scope.positions = [];
    // $http.get(contextPath + '/getPositions')
    //     .then(function (response) {
    //         alert("Сохранен");
    //         // $scope.positions = response.data;
    //     });

    $scope.getPositions = function () {
        $http.get(contextPath + '/getAllPositions')
            .then(function (response) {
                for (let position of response.data) {
                    $scope.positions.push(position.name);
                }
            }, function (error) {
                // handle error
            });
    }

    $scope.save = function (newPosition) {
        if (newPosition !== undefined && newPosition.name !== undefined && newPosition.name.trim().length !== 0) {
            $http.post(contextPath + '/createPosition', newPosition)
                .then(function (response) {
                    if (response.data) {
                        console.log(response.data);
                        // Обрабатываем возвращенную строку
                        console.log('Должность \"' + newPosition.name + '\" добавлена');
                        alert('Должность \"' + newPosition.name + '\" добавлена')
                        $scope.updatePositions();
                        // Добавьте здесь логику для дальнейшей обработки строки
                    } else {
                        console.error('Должность уже существует');
                        alert('Должность уже существует')
                    }
                })
                .catch(function (error) {
                    console.log(error.response);
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
    };

    $scope.remove = function (position) {
        if (position !== undefined) {
            $http.post(contextPath + '/removePosition', position)
                .then(function (response) {
                    if (response.data) {
                        console.log(response.data);
                        alert('Должность \"' + position.name + '\" удалена');
                        $scope.updatePositions();
                    }
                });
        }
    };

    $scope.updatePositions = function () {
        $scope.positions = [];
        $scope.getPositions();
    }

    $scope.getPositions();
});