var main = (function () {
	'use strict';
	return {
		init: function () {
//			main.openVacinnePlace();
			main.SeeVacinne();
			main.SeePlace();
			main.RemoveAccount();
			main.ApprovesVacine();
		},

		openVacinnePlace : function(){
			$("[id*=wrapVacinnes] li").on("change", function() {
				var checkbox = $(this).find('input[type="checkbox"]');
				
				var $state = checkbox.is(":checked");
				var $disabled = checkbox.is(":disabled");
				var id = $(this).attr('data-id');
				if($state){
					if (!$disabled) {
						$("#MyVacinnes").modal();
						$('[id*=aplicacao-id]').val(id);
						$('[id*=modal-load-aplicacao]').click();
					}
				} else {
					console.log("Deseja desmarcar essa vacina como aplicada?");
				}
			});
		},

		SeeVacinne : function(){
			$("#VacinneList a").on("click", function(){
				var id = $(this).attr('data-id');
				
				$('[id*=vacina-id]').val(id);
				$('[id*=modal-vacina]').click();
				
				$("#ContentSeeVacinne").modal();
			});
		},

		SeePlace : function(){
			$("#PlaceList a").on("click", function(){
				$("#ContentSeePlace").modal();
			});
		},

		ApprovesVacine : function(){
			$("#solicitacoesTable a").on("click", function(){
				$("#ContentSolicitacao").modal();
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