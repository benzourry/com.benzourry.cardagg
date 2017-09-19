/**
 * Created by MohdRazif on 5/12/2017.
 */
angular.module("app")
    .component("clientList", {
        templateUrl: "app/client/list.html",
        controller: ClientListComponent
    })
ClientListComponent.$inject = [ "$http", "userService","$uibModal"];
function ClientListComponent($http, userService, $uibModal) {
    var $ctrl = this;

    $ctrl.editClient = editClient;
    $ctrl.deleteClient = deleteClient;

    $ctrl.$onInit = function(){
        userService.get().then(function(res){
            getList();
        });
    }


    function getList(){
        $http.get("api/client")
        .then(function(res){
           $ctrl.list = res.data.content;
        });
    }

    function editClient(data, isNew) {
        editModal("clientEdit.html",data,{},isNew)
            .result.then(function(client){
            $http.post('api/client',client)
                .then(function (res) {
                    getList(1);
                    // alertService.addAlert("success", "The client has been successfully saved");
                });
        });
    }

    function deleteClient(data, isNew) {
        editModal("clientDelete.html",data,{},isNew)
            .result.then(function(client){
            $http.delete('api/client/'+client.id)
            .then(function (res) {
                getList(1);
            }, function(res){
                alert("Failed. Cannot delete. Make sure the client is not being assigned to the device.")
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