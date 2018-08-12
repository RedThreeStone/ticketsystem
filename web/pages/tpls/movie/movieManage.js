routerApp.controller('movieManageController2',function ($state,$stateParams,$scope,$modal,movieManageService) {
    $scope.openAdd=function () {
        $scope.openModal();

    };
    $scope.openModal = function() {
        var data={

        };
        var modalInstance = $modal.open({
            templateUrl : '/ticketsystem/pages/tpls/movie/movieAdd.html',//script标签中定义的id
            controller : movieAddController,//modal对应的Controller
            size:'lg',
            resolve : {
                items : function() {//data作为modal的controller传入的参数
                    return data;//用于传递数据
                }
            }
        });
        modalInstance.opened.then(function() {// 模态窗口打开之后执行的函数
            console.log('modal is opened');
        });
        modalInstance.result.then(function(result) {
            console.log("result"+result);
        });
    };
    $scope.seleted={};
    $scope.filterOptions = {
        filterText: "",
        useExternalFilter: true
    };

    $scope.totalServerItems = 0;

    $scope.pagingOptions = {
        pageSizes: [5, 10, 20],
        pageSize: 5,
        currentPage: 1
    };
    $scope.movieData=[];
    //列表
    $scope.gridOptions = {

        data: 'movieData',
        pagingOptions: $scope.pagingOptions,
        enablePinning: true,
        enablePaging: true,
        showFooter: true,
        enableColumnResize: true,
        enableCellSelection: true,
        columnDefs: [
            {
                field: "movieName",
                width: 180,
                pinned: true,
                enableCellEdit: true
            },
            {
                field: "movieMainrole",
                width: 200,
                enableCellEdit: true
            },
            {
                field: "movieDirector",
                width: 100,
                enableCellEdit: true
            },
            {
                displayName: "Action",
                width: 200,
                enableCellEdit: false,
                cellTemplate: '<button id="editBtn" type="button" class="btn btn-xs btn-info"  ng-click="updateCell()" >Click a Cell for Edit </button>'
            }]

    };
    $scope.selectMovieForPaging = function() {
        movieManageService.selectMovieForPaging().$promise.then(function (value) {
            if(value.success){
                $scope.movieData=value.movieList;

            }else {
                alert("获取失败");
            }
        });
    };
    $scope.initPage=function(){
        $scope.selectMovieForPaging();
    }
    $scope.initPage();

});
var movieAddController = function($scope, $modalInstance,items,movieManageService,FileUploader) {
    $scope.formData = items;

    $scope.saveOrUpdateMovie = function() {
        movieManageService.saveOrUpdateMovie($scope.formData).$promise.then(function (value) {
            if(value.success){
                alert("保存成功");
            }else {
                alert("保存失败");
            }
        });
    };
    $scope.cancel = function() {
        $modalInstance.dismiss('cancel');
    };
    //上传组件区
    var uploader=$scope.uploader = new FileUploader({
        url:'/ticketsystem/movieAction/uploadMovieNotice.do',
        formData:{
            fileName2:'66'
        }
    });
    uploader.filters.push({
        name:'fileNumber',
        fn:function (item,options) {
            return this.queue.length < 10;
        }
    });
    uploader.onWhenAddingFileFailed = function(item /*{File|FileLikeObject}*/, filter, options) {
        console.info('onWhenAddingFileFailed', item, filter, options);
    };
    uploader.onAfterAddingFile = function(fileItem) {
        console.info('onAfterAddingFile', fileItem);
    };
    uploader.onAfterAddingAll = function(addedFileItems) {
        console.info('onAfterAddingAll', addedFileItems);
    };
    uploader.onBeforeUploadItem = function(item) {
        console.info('onBeforeUploadItem', item);
    };
    uploader.onProgressItem = function(fileItem, progress) {
        console.info('onProgressItem', fileItem, progress);
    };
    uploader.onProgressAll = function(progress) {
        console.info('onProgressAll', progress);
    };
    uploader.onSuccessItem = function(fileItem, response, status, headers) {
        // alert(response)
        $scope.formData.movieNoticeUrl=response.movieNoticeUrl;
        console.info('onSuccessItem', response.data.url);
    };
    uploader.onErrorItem = function(fileItem, response, status, headers) {
        console.info('onErrorItem', fileItem, response, status, headers);
    };
    uploader.onCancelItem = function(fileItem, response, status, headers) {
        console.info('onCancelItem', fileItem, response, status, headers);
    };
    uploader.onCompleteItem = function(fileItem, response, status, headers) {
        console.info('onCompleteItem', fileItem, response, status, headers);
    };
    uploader.onCompleteAll = function() {
        console.info('onCompleteAll');
    };

};
