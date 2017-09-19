/**
 * Created by MohdRazif on 10/14/2016.
 */

angular
    .module('app')
    .config(config);
config.$inject=['$routeProvider'];

function config($routeProvider) {
    $routeProvider.
    /* Profile */
    when('/', {redirectTo:'/client'}).
    when('/client', {template: '<div oc-lazy-load="app/client/list.cmp.js"><client-list></client-list></div>', reloadOnSearch:"false"}).
    when('/device', {template: '<div oc-lazy-load="app/device/list.cmp.js"><device-list></device-list></div>', reloadOnSearch:"false"}).
    when('/userlink', {template: '<div oc-lazy-load="app/userlink/list.cmp.js"><userlink-list></userlink-list></div>', reloadOnSearch:"false"});
}
