package testedeanimais

import core.Animal

class QuestionController {

    def yesQuestion() {
		render(view:"/animal/success")
	}

	def noQuestion () {
		Animal animal = Animal.get(params.id)
		render(view:"/animal/whatAnimal", model:[animal: animal])
	}
}
