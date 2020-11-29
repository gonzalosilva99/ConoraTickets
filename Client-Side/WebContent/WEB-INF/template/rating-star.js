function valorarEspectaculo(cantEstrellas){
    		event.preventDefault();
			var data = {
					tipoPost:'valorarEspectaculo',
		    		espectaculo:'<%= dtesp.getNombre() %>',
					cantEstrellas:cantEstrellas};
		    console.log(data);
	    	$.ajax({
		        type: 'POST',
		        url:  'consultaespectaculo',
		        data: data,
		        async: false,
		        success: function (data) {
						console.log(data);
						if(data==="SUCCESS"){
							location.reload();	
						}
						else{
							alert(data);
							location.reload();
						}
				}
			});
		}