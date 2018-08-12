/**
 * Created by Administrator on 2017-12-6.
 */
var TestServiceUrl = "/SpringMvcAno/redPacketController"
angular.module('TestService', [])
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
routerApp.factory('TestService', ["$resource", function ($resource) {

    return $resource(TestServiceUrl, {}, {
        testSer: {
            method: "POST",
            url: TestServiceUrl + "/hello.do",
            data: {}
        },
        normalTest: {
            method: "POST",
            url: TestServiceUrl + "/normarl.do",
            data: {}
        },
        multiViewJson: {
            method: "POST",
            url: TestServiceUrl + "/multiView.do",
            data: {}
        },
        multiViewXml: {
            method: "POST",
            url: TestServiceUrl + "/multiView.Xml",
            data: {}
        },
        testMapper:{
            method: "POST",
            url: TestServiceUrl + "/testBaseMapper.do",
            data: {}
        },
        testUserMapper:{
            method: "POST",
            url: TestServiceUrl + "/testUserMapper.do",
            data: {}
        },
        grapRedPacket:{
            method: "POST",
            url: TestServiceUrl + "/grapRedPacket.do",
            data: {}
        }
    })
}]);