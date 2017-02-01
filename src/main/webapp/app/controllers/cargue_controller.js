angular.module('cargue').controller("cargueController" , function($scope, cargueService, $window){
	
	 $scope.uploadFile = function(){
	      var file = document.getElementById('archivoPerezoso').files[0];
	     
	      cargueService.loadingFile(file)	
	        .success(function (data, status) {
	        	
	        		swal('Buen Trabajo...',
	   	        		 'Archivo cargado exitosamente...',
	   	        		 'success');

	        }).error(function (error, status, headers) {
	        	
	        	swal('Oops...',
	        		 'Existe un problema al cargar el archivo...' + headers("ERR_DESC"),
	        		 'error');
	        });

	    };
});