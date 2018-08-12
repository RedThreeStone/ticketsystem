routerApp.controller('registerController',function ($state,$stateParams,$scope,loginService) {
    $scope.register=function () {

        loginService.register($scope.formData).$promise.then(function (value) {
            if(value.success){
                alert("注册成功!!!");
            }else {
                alert(value.message);
            }
        });
    }
    $scope.toLogin=function () {
        $state.go("index.login");
    }
})