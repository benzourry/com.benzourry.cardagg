//<div class="navbar-icon"></div>\
                

angular.module("app")
    .component("pageTitle", {
        template:'<div class="nav-icon"  ng-click="$ctrl.toggle()"><div></div></div>\
        <div class="title-text" ng-transclude></div>',
        transclude:true,
        controller: PageTitleComponent,
        require:{
            appRoot:'^appRoot'
        }
    });
function PageTitleComponent(){
    var $ctrl = this;
    $ctrl.toggle = toggle;
    function toggle(){
        this.appRoot.toggle();
    }
}