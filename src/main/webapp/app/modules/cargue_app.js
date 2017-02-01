angular.module('cargue',['ngRoute','angularCSS']).config(function($routeProvider){
	$routeProvider.when("/",{
		css: 'app/styles/principal.css',
		templateUrl: 'app/views/main.html'	
	})
	.when("/cargarArchivo",{
		controller:'cargueController', 
		templateUrl: 'app/views/cargarArchivoPerezoso.html'
	})
	.otherwise({redirectTo:'/'});
});