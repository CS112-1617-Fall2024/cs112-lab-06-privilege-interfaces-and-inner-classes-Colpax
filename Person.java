/**
 * Class for creating person object
 * 
 * @author Artem Iakovlev
 * @version 1
 */

public class Person implements Comparable
{
	/***** TODO: (Part 2) create helper inner class for Identity*****/

	// CONSTANT VARIABLES
	public static final String DEFAULT_NAME = "Jamie Doe";
	public static final String DEFAULT_PRONOUNS = "he/him/his";
	public static final String DEFAULT_BACKGROUND =  "Unknown";
	public static final int DEFAULT_PRIVILEGE = 100;

	// INSTANCE VARIABLES
	private String name;
	private Identity identity;
	private int privilege;

	// CONSTRUCTORS	
	public Person(String name, String pronouns, String background, int privilege) {
		this.setName(name);
		this.setPrivilege(privilege);
		identity = new Identity(pronouns, background);
	}
		
	public Person() {
		this(DEFAULT_NAME, DEFAULT_PRONOUNS, DEFAULT_BACKGROUND, DEFAULT_PRIVILEGE);
	}
	
	public Person(Person original) {
		if(original == null) {
			throw new IllegalArgumentException("Cannot copy null obect in Person copy constructor");
		} else {
			this.setName(original.name);
			this.setPrivilege(original.privilege);
			identity = new Identity(original.getPronouns(), original.getBackground());
		}
	}

	// MUTATORS/SETTERS
	public void setName(String name) {
		this.name = name;
	}

	public void setPronouns(String pronouns) {
		identity.pronouns = pronouns;
	}

	public void setBackground(String background) {
		identity.background = background;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public void setAll(String name, String pronoun, String background, int privilege) {
		this.setPrivilege(privilege);
		this.setName(name);
		this.setPronouns(pronoun);
		this.setBackground(background);
	}

	// ACCESSORS / GETTERS
	public String getName() {
		return this.name;
	}
		
	public String getPronouns() {
		return identity.pronouns;
	}

	public String getBackground() {
		return identity.background;
	}

	public int getPrivilege() {
		return this.privilege;
	}

	// OTHER REQUIRED METHODS
	@Override
	public String toString()
	{
		return "My name is "+ this.name + ". "+ identity.toString() + "\n"
				+ "According to this calculator I ended up with "+ this.privilege + " estimated privilege points";
	}
	
	@Override
	public boolean equals(Object other) 
	{
		if(other == null || (!(other instanceof Person))) {
		      return false;
		}
		
		Person otherPerson = (Person) other;
		return this.name.equals(otherPerson.name) &&
				identity.equals(otherPerson.identity) &&
				this.privilege == otherPerson.privilege;
	}

	// INTERFACE METHODS
	/***** TODO: (Part 1) override compareTo method to implement Comparable interface*****/

	@Override
	public int compareTo(Object o) {
		if (o == null) {
			return -1;
		} else if (!(o instanceof Person)) {
			return -1;
		} else {
			Person p = (Person) o;
			return privilege - p.privilege;
		}
	}

	/**
 	* Class for creating Identity for a person
 	* 
 	* @author Artem Iakovlev
 	* @version 1
 	*/
	public class Identity {
		// INSTANCE VARIABLES
		private String pronouns;
		private String background;

		// CONSTRUCTORS	
		/**
		* Full construcnor for Identity class
		* 
		* @param String pronouns
		* @param String background
		*/
		public Identity(String pronouns, String background) {
			this.pronouns = pronouns;
			this.background = background;
		}

		/**
		* Default construcnor for Identity class, uses default variables
		*/
		public Identity() {
			this(DEFAULT_PRONOUNS, DEFAULT_BACKGROUND);
		}

		@Override
		public String toString() {
			return "My pronouns are: " + pronouns + ". My story is: " + background;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == null) {
				return false;
			} else if (!(o instanceof Identity)) {
				return false;
			} else {
				Identity id = (Identity) o;
				return background.equals(id.background) && pronouns.equals(id.pronouns);
			}
		}
	}
}