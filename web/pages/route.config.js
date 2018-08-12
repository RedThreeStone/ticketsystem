/**
 * Created by Administrator on 2017-11-5.
 */
/*var routerApp=angular.module("routerApp",["ui.router","oc.lazyLoad"]);*/

routerApp.config(function ($stateProvider, $urlRouterProvider, $ocLazyLoadProvider) {

    $urlRouterProvider.otherwise('/index/login');
    $stateProvider
        .state('index', {
            url: '/index',
            templateUrl: '/ticketsystem/pages/index.html'
        })
        .state('index.login', {
            url: '/login',
            controller:'loginController',
            cache:false,
            views: {
                '': {
                    templateUrl: '/ticketsystem/pages/tpls/login/login.html',
                }
            },
            resolve: {
                deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load(['loginService']).then(function () {
                        return $ocLazyLoad.load("/ticketsystem/pages/tpls/login/login.js")
                    });
                }]
            }
        }).state('index.register', {
        url: '/register',
        cache:false,
        views: {
            '': {
                templateUrl: '/ticketsystem/pages/tpls/login/register.html',

            }
        },
        controller:'registerController',
        resolve: {
            deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['loginService']).then(function () {
                    return $ocLazyLoad.load("/ticketsystem/pages/tpls/login/register.js")
                });
            }]
        }
    }).state('index.home', {
        url: '/home',
        views: {
            '': {
                templateUrl: '/ticketsystem/pages/tpls/login/home.html'

            }
        }
    }).state('index.home.movieManage', {
        url: '/movieManage',
        views: {
            '': {
                templateUrl: '/ticketsystem/pages/tpls/movie/movieManage.html',

            }
        },
        controller:'movieManageController',
        resolve: {
            deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['movieManageService']).then(function () {
                    return $ocLazyLoad.load("/ticketsystem/pages/tpls/movie/movieManage.js")
                });
            }]
        }
    })
});

routerApp.controller('routerController', function ($scope, TestService, $resource) {
    $scope.testPost = function () {
        $scope.data = {
            name: "nihao"
        }
        /*  TestService.urlRever($scope.data).$promise.then(function (obj) {
         alert("成 啦");
         });*/
        var rever = $resource("/SpringMvcAno/rest/ano/urlRever/:id", {
            id: '@id'
        });
        rever.save({}, {"id": "你好"}, function (success) {
            console.log(success);
        }, function (error) {
            console.log(error);
        });
    }
    $scope.message = 'test';
    $scope.topics = [{
        name: 'Butterscotch',
        price: 50
    }, {
        name: 'Black Current',
        price: 100
    }, {
        name: 'Mango',
        price: 20
    }];
})

