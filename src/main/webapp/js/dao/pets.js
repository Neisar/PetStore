var PetsDAO = (function() {
	var resourcePath;
	var requestByAjax = function(data, done, fail, always) {
		done = typeof done !== 'undefined' ? done : function() {};
		fail = typeof fail !== 'undefined' ? fail : function() {};
		always = typeof always !== 'undefined' ? always : function() {};
		
		$.ajax(data)
			.done(done)
			.fail(fail)
			.always(always);
	};
	
	function PetsDAO(ownerId) {
		resourcePath = "rest/people/"+ownerId+"/pets/";
		
		this.listPets = function(done, fail, always) {
			requestByAjax({
				url: resourcePath,
				type: 'GET'
			}, done, fail, always);
		};
		
		this.addPet = function(pet, done, fail, always) {
			requestByAjax({
				url: resourcePath,
				type: 'POST',
				data: pet
			}, done, fail, always);
		};
		
		this.modifyPet = function(pet, done, fail, always) {
			requestByAjax({
				url: resourcePath + pet.id,
				type: 'PUT',
				data: pet
			}, done, fail, always);
		};
		
		this.deletePet = function(id, done, fail, always) {
			requestByAjax({
				url: resourcePath + id,
				type: 'DELETE',
			}, done, fail, always);
		};
	}
	
	return PetsDAO;
})();