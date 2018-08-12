routerApp.controller('loginController',function ($state,$stateParams,$scope,loginService) {
    $scope.toRegister=function () {
        $state.go("index.register");
    }
    $scope.login=function () {
        $state.go("index.home");
       /* loginService.login($scope.formData).$promise.then(function (value) {
            if(value.success){
                $state.go("index.home");
            }else{
                alert(value.message)
            }
        });*/
    }
})