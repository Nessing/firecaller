angular.module('app', []).controller('editRanksController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080';

    // $http.get(contextPath + '/getPositions')
    //     .then(function (response) {
    //         alert("Сохранен");
    //         // $scope.positions = response.data;
    //     });

    $scope.save = function (rank) {
        if (rank !== undefined && rank.name !== undefined && rank.name.trim().length !== 0) {
            $http.post(contextPath + '/createPosition', rank)
                .then(function (response) {
                    if (response.data) {
                        // Обрабатываем возвращенную строку
                        console.log('Должность \"' + response.data.name + '\" добавлена');
                        alert('Должность \"' + response.data.name + '\" добавлена')
                        // Добавьте здесь логику для дальнейшей обработки строки
                    } else {
                        console.error('Должность уже существует');
                        alert('Должность уже существует')
                    }
                })
                .catch(function (error) {
                    console.log(error);
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
});