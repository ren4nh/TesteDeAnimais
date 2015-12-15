package testedeanimais

import core.Animal;
import testedeanimais.AnimalService;

class AnimalController {
	
	AnimalService animalService

	def index() {
		List<Animal> lista = Animal.list()
		if (lista.isEmpty()) {
			animalService.createTree()			
		}
		render(view : "/animal/index")
	}

	def play() {
		render(view:"/animal/start")
	}

	def start() {
		Animal root = Animal.list().get(0)
		render(view:"/animal/game", model:[animal: root])
	}

	def yes() {
		Animal animal = Animal.get(params.id)
		if(!animalService.isLeaf(animal.leftAnwser)) {
			render(view:"/animal/game", model:[animal: animal.leftAnwser])
		} else {
			render(view:"/animal/question", model:[animal: animal.leftAnwser])
		}
	}

	def yesQuestion() {
		render(view:"/animal/success")
	}

	def noQuestion () {
		Animal animal = Animal.get(params.id)
		render(view:"/animal/whatAnimal", model:[animal: animal])
	}
	
	def save() {
		animalService.save(params.nome,params.carac, params.id)
		render(view:"/animal/start")
	}


	def no() {
		Animal animal = Animal.get(params.id)
		if(!animalService.isLeaf(animal.rightAnwser)) {
			render(view:"/animal/game", model:[animal: animal.rightAnwser])
		} else {
			render(view:"/animal/question", model:[animal: animal.rightAnwser])
		}
	}

	def clear() {
		Animal.executeUpdate("delete from Animal")
		redirect(view : "/animal/play")

	}
}
