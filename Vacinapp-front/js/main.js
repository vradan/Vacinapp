var main = (function () {
	'use strict';
	return {
		init: function () {
			main.openVacinnePlace();
		},

		openVacinnePlace : function(){
			$("#wrapVacinnes input[type='checkbox']").on("click", function(){
				var $state = $(this).is(":checked");
				if($state){
					$("#opa").modal();
				}else{
					console.log("Deseja desmarcar essa vacina como aplicada?");
				}
			});
		}

	};

})();

$(document).ready(main.init);