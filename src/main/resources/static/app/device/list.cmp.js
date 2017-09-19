/**
 * Created by MohdRazif on 5/12/2017.
 */
angular.module("app")
    .component("deviceList", {
        templateUrl: "app/device/list.html",
        controller: DeviceListComponent
    })
DeviceListComponent.$inject = [ "$http", "userService","$uibModal"];
function DeviceListComponent($http, userService, $uibModal) {
    var $ctrl = this;

    $ctrl.editDevice = editDevice;
    $ctrl.deleteDevice = deleteDevice;

    $ctrl.$onInit = function(){
        userService.get().then(function(res){
            getList();
        });

        $http.get("api/client").then(function(res){
            $ctrl.clientList = res.data.content;
        })
    }


    function getList(){
        $http.get("api/device")
        .then(function(res){
           $ctrl.list = res.data.content;
        });
    }

    function editDevice(data, isNew) {
        editModal("deviceEdit.html",data,{clientList: $ctrl.clientList},isNew)
            .result.then(function(device){
            $http.post('api/device',device)
                .then(function (res) {
                    getList(1);
                    // alertService.addAlert("success", "The device has been successfully saved");
                });
        });
    }

    function deleteDevice(data, isNew) {
        editModal("deviceDelete.html",data,{},isNew)
            .result.then(function(device){
            $http.delete('api/device/'+device.id)
                .then(function (res) {
                    getList(1);
                },function(res){
                    alert("Failed. Cannot delete. You should clear the client assignment first.")
                });
        });
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