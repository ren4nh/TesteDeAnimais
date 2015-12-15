package testedeanimais;
import core.Animal;



import grails.transaction.Transactional

@Transactional
class AnimalService {
	
	/**
	 * Method responsible for creating the initial tree
	 */

    void createTree() {

			Animal root = new Animal();
			Animal leaf = new Animal();
	
			root.setQuestion("O animal que vc pensou vive na água")
			root.save(flush:true)
			leaf.setQuestion("Tubarão")
			leaf.save(flush:true)
			root.setLeftAnwser(leaf);
			leaf = new Animal();
			leaf.setQuestion("Macaco")
			leaf.save(flush:true)
			root.setRightAnwser(leaf);
			root.save(flush:true)

    }
	
	/**
	 * Method responsible for testing if the object is a leaf of the tree
	 * @param animal
	 * @return
	 */
	boolean isLeaf(Animal animal) {
		return (animal.getLeftAnwser() == null && animal.getRightAnwser() == null)
	}
	
	/**
	 * Method responsible for cleaning the database
	 */
	void clearDatabase() {
		Animal.executeUpdate("delete from Animal")
	}
	
	/**
	 * Method responsible for learning the new animal and save it in the database
	 * @param name
	 * @param carac
	 * @param id
	 */
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
