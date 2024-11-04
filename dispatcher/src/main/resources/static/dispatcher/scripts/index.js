angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080';

    var socket = new WebSocket('ws://localhost:8080/my-websocket-endpoint');

    $scope.getAllTeamOfFireStation = [];

    socket.onopen = function() {
        console.log('WebSocket connection opened');
        sendMessage('автоматическое сообщение');
    }

    socket.onmessage = function(event) {
        if (event.data === "updateStatus") {
            console.log("upd");
            $scope.getAllTeams();
            // $scope.getFirefighters();
        }
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

    $scope.getAllTeams = function () {
        $http.get(contextPath + '/getAllTeamOfFireStation')
            .then(function (response) {
                $scope.getAllTeamOfFireStation = response.data;
            }, function (error) {
                // handle error
            });
    }

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
    $scope.getAllTeams();
});