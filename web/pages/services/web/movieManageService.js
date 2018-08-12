/**
 * Created by Administrator on 2017-12-6.
 */
var movieManageServiceUrl = "/ticketsystem/movieAction"
angular.module('movieManageService', [])
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
routerApp.factory('movieManageService', ["$resource", function ($resource) {

    return $resource(movieManageServiceUrl, {}, {
        saveOrUpdateMovie: {
            method: "POST",
            url: movieManageServiceUrl + "/saveOrUpdateMovie.do",
            data: {}
        },
        selectMovieForPaging: {
            method: "POST",
                url: movieManageServiceUrl + "/selectMovieForPaging.do",
                data: {}
        }
    })
}]);