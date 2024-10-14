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
	/**
	* Full constructor to create person object
	* 
	* @param String name
	* @param String pronouns
	* @param String background
	* @param int privilege
	*/
	public Person(String name, String pronouns, String background, int privilege) {
		this.setName(name);
		this.setPrivilege(privilege);
		identity = new Identity(pronouns, background);
	}
		
	/**
	* Default constructor to create person object, uses default variables
	*/
	public Person() {
		this(DEFAULT_NAME, DEFAULT_PRONOUNS, DEFAULT_BACKGROUND, DEFAULT_PRIVILEGE);
	}
	
	/**
	* Copy constructor to create deep copy of a person object
	* 
	* @param Person original person object
	*/
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
	
	/**
	* Method to set a name for a Person object
	* 
	* @param String name
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	* Method to set a pronouns for a Person object
	* 
	* @param String pronouns
	*/
	public void setPronouns(String pronouns) {
		identity.pronouns = pronouns;
	}

	/**
	* Method to set a background for a Person object
	* 
	* @param String background
	*/
	public void setBackground(String background) {
		identity.background = background;
	}

	/**
	* Method to set a privilege value for a Person object
	* 
	* @param int privilege
	*/
	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	/**
	* Method to set all variables for a Person object
	* 
	* @param String name
	* @param String pronouns
	* @param String background
	* @param int privilege
	*/
	public void setAll(String name, String pronoun, String background, int privilege) {
		this.setPrivilege(privilege);
		this.setName(name);
		this.setPronouns(pronoun);
		this.setBackground(background);
	}

	// ACCESSORS / GETTERS

	/**
	* Method to get a name of a Person object
	* 
	* @return name of a person
	*/
	public String getName() {
		return this.name;
	}
		
	/**
	* Method to get a pronouns of a Person object
	* 
	* @return pronouns of a person
	*/
	public String getPronouns() {
		return identity.pronouns;
	}

	/**
	* Method to get a background of a Person object
	* 
	* @return background of a person
	*/
	public String getBackground() {
		return identity.background;
	}

	/**
	* Method to get a privilege value of a Person object
	* 
	* @return privilege of a person
	*/
	public int getPrivilege() {
		return this.privilege;
	}

	// OTHER REQUIRED METHODS
	/**
	* Method that returns Person object as formatted string
	* 
	* @return string representing object
	*/
	@Override
	public String toString()
	{
		return "My name is "+ this.name + ". "+ identity.toString() + "\n"
				+ "According to this calculator I ended up with "+ this.privilege + " estimated privilege points";
	}
	
	/**
	* Method that compares two person objects
	* 
	* @param Object other person
	*
	* @return true if objects are the same, false otherwise
	*/
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

	/**
	* Method that compares privilages two person objects
	* 
	* @param Object other person
	*
	* @return difference of persons' priveleges as a number
	*/
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

		/**
		* Method that returns Identity object as formatted string
		* 
		* @return string representing object
		*/
		@Override
		public String toString() {
			return "My pronouns are: " + pronouns + ". My story is: " + background;
		}
		
		/**
		* Method that compares two Identity objects
		* 
		* @param Object other identity
		*
		* @return true if identities are the same, false otherwise
		*/
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