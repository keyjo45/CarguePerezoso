angular.module("cargue").service("cargueService",  function($http){
	
	this.loadingFile=function(data){
		
         var fd = new FormData();
         fd.append('file', data);
         return $http.post('rest/file/loadingFile', 
             fd, {transformRequest: angular.identity, headers: {'Content-Type': undefined}});
	}

});