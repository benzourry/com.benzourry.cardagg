/**
 * Created by MohdRazif on 5/12/2017.
 */
angular.module("app")
    .component("userlinkList", {
        templateUrl: "app/userlink/list.html",
        controller: UserlinkListComponent
    })
UserlinkListComponent.$inject = [ "$http", "userService","$uibModal"];
function UserlinkListComponent($http, userService, $uibModal) {
    var $ctrl = this;

    $ctrl.editUserlink = editUserlink;
    $ctrl.deleteUserlink = deleteUserlink;
    $ctrl.testLog = testLog;

    $ctrl.$onInit = function(){
        userService.get().then(function(res){
            getList();
        });
    }


    function getList(){
        $http.get("api/userlink")
        .then(function(res){
           $ctrl.list = res.data.content;
        });
    }

    function editUserlink(data, isNew) {
        editModal("userlinkEdit.html",data,{},isNew)
            .result.then(function(userlink){
            $http.post('api/userlink',userlink)
                .then(function (res) {
                    getList(1);
                    // alertService.addAlert("success", "The userlink has been successfully saved");
                });
        });
    }

    function deleteUserlink(data, isNew) {
        editModal("userlinkDelete.html",data,{},isNew)
            .result.then(function(userlink){
            $http.delete('api/userlink/'+userlink.id)
                .then(function (res) {
                    getList(1);
                    // alertService.addAlert("success", "The userlink has been successfully saved");
                });
        });
    }

    function testLog(data){
        $http.get('api/activity/test-log?cuid='+data.cuid+'&device=sr1')
            .then(function(res){});
    }


    function editModal(template, data, items, isNew) {
        var data = isNew ? data : Object.create(data);
        return $uibModal.open({
            templateUrl: template,
            controller: function ($uibModalInstance, items) {
                this.isNew = isNew;
                this.items = items;
                this.data = data;
                this.cancel = function () {
                    $uibModalInstance.dismiss('cancel');
                };
                this.update = function (data) {
                    $uibModalInstance.close(data);
                }
            },
            resolve: {
                items: function () {
                    return items;
                }
            },
            controllerAs: '$mdl'
        });
    }



}