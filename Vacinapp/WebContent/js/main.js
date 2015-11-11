var main = (function () {
	'use strict';
	return {
		init: function () {
			main.openVacinnePlace();
			main.AddVacinne();
			main.RemoveAccount();
		},

		openVacinnePlace : function(){
			$("#wrapVacinnes input[type='checkbox']").on("click", function(){
				var $state = $(this).is(":checked");
				if($state){
					$("#MyVacinnes").modal();
				}else{
					console.log("Deseja desmarcar essa vacina como aplicada?");
				}
			});
		},

		AddVacinne : function(){
			$("#VacinneList a").on("click", function(){
				$("#ContentAddVacinne").modal();
			});
		},

		RemoveAccount : function(){
			$("#RemoveAccount").on("click", function(){
				window.location = 'login.html';
			});
		},
	};

})();

$(document).ready(main.init);