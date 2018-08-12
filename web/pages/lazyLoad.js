/**
 * Created by Administrator on 2017-11-12.
 */
/*var routerApp=angular.module("routerApp",["ui.router","oc.lazyLoad"]);*/


routerApp.constant("Modules_Config", [
    {
        name: "loginService",
        module: true,
        files: [
            "/ticketsystem/pages/services/web/loginService.js"
        ]
    },{
        name: "movieManageService",
        module: true,
        files: [
            "/ticketsystem/pages/services/web/movieManageService.js"
        ]
    }
])
    .config(["$ocLazyLoadProvider", "Modules_Config", routeFn]);
function routeFn($ocLazyLoadProvider, Modules_Config) {

    $ocLazyLoadProvider.config({
        debug: false,
        events: false,
        modules: Modules_Config
    });
};