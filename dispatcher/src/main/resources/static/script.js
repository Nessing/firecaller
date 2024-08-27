angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080';

    var socket = new WebSocket('ws://localhost:8080/my-websocket-endpoint');

    $scope.fireStationAndSquares = [];

    socket.onopen = function() {
        console.log('WebSocket connection opened');
        sendMessage('автоматическое сообщение');
    }

    socket.onmessage = function(event) {
        console.log('Received message: ' + event.data);
    }

    function sendMessage(message) {
        socket.send(message);
    }

    $scope.fillTable = function () {
        $http.get(contextPath + '/getFireStations')
            .then(function (response) {
                $scope.allFireStation = response.data;
            });
    };

    // $scope.getSquares = function () {
        $http.get(contextPath + '/getFireStationsAndSquares')
            .then(function (response) {
                $scope.fireStationAndSquares = response.data;
            }, function (error) {
                // handle error
            });
    // }

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

    $scope.fillTable();
});