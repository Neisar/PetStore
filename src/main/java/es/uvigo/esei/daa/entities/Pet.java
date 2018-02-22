package es.uvigo.esei.daa.entities;

import static java.util.Objects.requireNonNull;


/**
 * An entity that represents a pet.
 * 
 * @author Jonatan Iglesias Belmonte
 */
public class Pet {
	private int id;
	private String name;
	
	// Constructor needed for the JSON conversion
	Pet() {}
	
	/**
	 * Constructs a new instance of {@link Pet}.
	 *
	 * @param id identifier of the pet.
	 * @param name name of the pet.
	 * @param surname surname of the pet.
	 */
	public Pet(int id, String name) {
		this.id = id;
		this.setName(name);
	}
	
	/**
	 * Returns the identifier of the pet.
	 * 
	 * @return the identifier of the pet.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the name of the pet.
	 * 
	 * @return the name of the pet.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of this pet.
	 * 
	 * @param name the new name of the pet.
	 * @throws NullPointerException if the {@code name} is {@code null}.
	 */
	public void setName(String name) {
		this.name = requireNonNull(name, "Name can't be null");
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Pet))
			return false;
		Pet other = (Pet) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
