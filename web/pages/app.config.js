/**
 * Created by Administrator on 2017-11-14.
 */
var routerApp = angular.module("routerApp", ["ui.router", "oc.lazyLoad", "ui.router.state","angularFileUpload","ngResource","ui.bootstrap"]);
routerApp.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
    function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
        routerApp.controller = $controllerProvider.register;
        routerApp.directive = $compileProvider.directive;
        routerApp.filter = $filterProvider.register;
        routerApp.factory = $provide.factory;
        routerApp.service = $provide.service;
        routerApp.constant = $provide.constant;

    }]);