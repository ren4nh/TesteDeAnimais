package testedeanimais;
import core.Animal;



import grails.transaction.Transactional

@Transactional
class AnimalService {

    void createTree() {

			Animal pai = new Animal();
			Animal filho = new Animal();
	
			pai.setQuestion("O animal que vc pensou vive na água?")
			pai.save(flush:true)
			filho.setQuestion("Tubarão")
			filho.save(flush:true)
			pai.setLeftAnwser(filho);
			filho = new Animal();
			filho.setQuestion("Macaco")
			filho.save(flush:true)
			pai.setRightAnwser(filho);
			pai.save(flush:true)

    }
	
	boolean isLeaf(Animal animal) {
		return (animal.getLeftAnwser() == null && animal.getRightAnwser() == null)
	}
	
	void clearDatabase() {
		Animal.executeUpdate("delete from Animal")
	}
	
	void save(String name, String carac, String id) {
		Animal animal = Animal.get(id)
		Animal left = new Animal();
		Animal right = new Animal();
		left.setQuestion(name)
		left.save(flush:true)
		right.setQuestion(animal.getQuestion())
		right.save(flush:true)
		animal.setQuestion("O animal que vc pensou " + carac)
		animal.setLeftAnwser(left)
		animal.setRightAnwser(right)
	}
}
