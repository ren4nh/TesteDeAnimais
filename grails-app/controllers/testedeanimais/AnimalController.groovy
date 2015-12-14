package testedeanimais

import core.Animal;

class AnimalController {

	def index() {
		createTree()
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
		if(!isLeaf(animal.leftAnwser)) {
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
		Animal animal = Animal.get(params.id)
		Animal left = new Animal();
		Animal right = new Animal();
		left.setQuestion(params.nome)
		left.save(flush:true)
		right.setQuestion(animal.getQuestion())
		right.save(flush:true)
		animal.setQuestion("O animal que vc pensou " + params.carac)
		animal.setLeftAnwser(left)
		animal.setRightAnwser(right)
		animal.save(flush:true)
		render(view:"/animal/start")
	}


	def no() {
		Animal animal = Animal.get(params.id)
		if(!isLeaf(animal.rightAnwser)) {
			render(view:"/animal/game", model:[animal: animal.rightAnwser])
		} else {
			render(view:"/animal/question", model:[animal: animal.rightAnwser])
		}
	}

	private Animal createTree() {
		Animal pai = new Animal();
		Animal filho = new Animal();

		pai.setQuestion("O animal que vc pensou vive na agua?")
		pai.save(flush:true)
		filho.setQuestion("Tubarão")
		filho.save(flush:true)
		pai.setLeftAnwser(filho);
		filho = new Animal();
		filho.setQuestion("Macaco")
		filho.save(flush:true)
		pai.setRightAnwser(filho);
		pai.save(flush:true)

		return pai;
	}

	private boolean isLeaf(Animal animal) {
		return (animal.getLeftAnwser() == null && animal.getRightAnwser() == null)
	}
}
