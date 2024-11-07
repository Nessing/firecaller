angular.module('app', []).controller('positionAndRankController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080';
    $scope.positions = [];
    $scope.ranks = [];

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

    $scope.getRanks = function () {
        $http.get(contextPath + '/getAllRanks')
            .then(function (response) {
                for (let position of response.data) {
                    $scope.ranks.push(position.name);
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
                        // Обрабатываем возвращенную строку
                        alert('Должность \"' + newPosition.name + '\" добавлена')
                        $scope.updateData();
                        // Добавьте здесь логику для дальнейшей обработки строки
                    } else {
                        console.error('Должность уже существует');
                        alert('Должность уже существует')
                    }
                })
                .catch(function (error) {
                });
        }
    };

    $scope.saveRank = function (newRank) {
        if (newRank !== undefined && newRank.name !== undefined && newRank.name.trim().length !== 0) {
            $http.post(contextPath + '/createRank', newRank)
                .then(function (response) {
                    if (response.data) {
                        // Обрабатываем возвращенную строку
                        alert('Звание \"' + newRank.name + '\" добавлено')
                        $scope.updateData();
                        // Добавьте здесь логику для дальнейшей обработки строки
                    } else {
                        console.error('Звание уже существует');
                        alert('Звание уже существует')
                    }
                })
                .catch(function (error) {
                });
        }
    };

    $scope.remove = function (position) {
        if (position !== undefined) {
            $http.post(contextPath + '/removePosition', position)
                .then(function (response) {
                    if (response.data) {
                        alert('Должность \"' + position.name + '\" удалена');
                        $scope.updateData();
                    }
                });
        }
    };

    $scope.removeRank = function (rank) {
        if (rank !== undefined) {
            $http.post(contextPath + '/removeRank', rank)
                .then(function (response) {
                    if (response.data) {
                        alert('Звание \"' + rank.name + '\" удалено');
                        $scope.updateData();
                    }
                });
        }
    };

    $scope.updateData = function () {
        $scope.positions = [];
        $scope.ranks = [];
        $scope.getPositions();
        $scope.getRanks();
    }

    $scope.getPositions();
    $scope.getRanks();
});