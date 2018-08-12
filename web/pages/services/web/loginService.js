/**
 * Created by Administrator on 2017-12-6.
 */
var loginServiceUrl = "http://127.0.0.1:8080/user"
angular.module('loginService', [])
    .config(function ($httpProvider) {
        $httpProvider.defaults.transformRequest = function (obj) {
            var arrStr = [];
            for (var p in  obj) {
                arrStr.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
            }
            return arrStr.join("&");
        }
        $httpProvider.defaults.headers.post = {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
        }
    });
routerApp.factory('loginService', ["$resource", function ($resource) {

    return $resource(loginServiceUrl, {}, {
        register: {
            method: "POST",
            url: loginServiceUrl + "/login.do",
            data: {}
        },
        login: {
            method: "POST",
            url: loginServiceUrl + "/login.do",
            data: {}
        }
    })
}]);