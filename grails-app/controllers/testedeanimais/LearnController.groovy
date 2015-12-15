package testedeanimais

class LearnController {
	
	AnimalService animalService

    def save() {
		animalService.save(params.nome,params.carac, params.id)
		render(view:"/animal/start")
	}
}
