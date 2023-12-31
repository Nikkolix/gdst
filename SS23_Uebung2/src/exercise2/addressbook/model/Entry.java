/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker, Theo Vassiliou and Diana Serbanescu
 * Technische Universität Berlin
 */
package exercise2.addressbook.model;

/**
 * Stores the data for a single address book entry.
 * An entry contains a single name (consisting of first and sur name), a gender and contact information. 
 * Contact information is either a phone number or an emaila addresses. 
 * An entry should be uniquely identifiable by it's first and last name.
 * @author Edzard Hoefig
 */
public class Entry implements Comparable<Entry> {
	
	// The last name of a person
	private String surName;
	
	// The first name of a person
	private String firstName;
	
	// The person's gender
	private Gender gender;
	
	// A person's contact data
	private Contact contact;
	
	/**
	 * Ctor.
	 * Creates an entry and allocates the internal data structures for storing addresses and phone numbers.
	 */
	public Entry() {
	}
	
	/**
	 * Parametrised Ctor.
	 * @param surName The last name
	 * @param firstName The first name
	 * @param gender Person's gender
	 * @param contact Contact information
	 */
	public Entry(String surName, String firstName, Gender gender, Contact contact) {
		this.surName = surName;
		this.firstName = firstName;
		this.gender = gender;
		this.contact = contact;
	}

	/**
	 * Retrieve the first name.
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Retrieve the last name.
	 * @return the last name
	 */
	public String getSurName() {
		return surName;
	}
	
	/**
	 * Store a new name
	 * @param first the first name
	 * @param last the last name
	 */
	public void setName(String firstName, String surName) {
		this.firstName = firstName;
		this.surName = surName;
	}

	/**
	 * @return the contact information
	 */
	public Contact getContactInformation() {
		return contact;
	}

	/**
	 * Set a phone number as contact information.
	 * @param number the phone number to set
	 */
	public void setContactPhoneNumber(int number) {
		this.contact = new PhoneNumber(number);
	}

	/**
	 * Set an email address as contact information.
	 * @param address the email address to set
	 */
	public void setContactEmailAddress(String address) {
		this.contact = new EmailAddress(address);
	}
	
	/**
	 * Set the person's gender.
	 * @param gender The gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	/**
	 * Check if a person is male.
	 * @return True in case the person has a male gender
	 */
	public boolean isMale() {
		return (this.gender == Gender.Male);
	}
	
	/**
	 * Check if a person is female.
	 * @return True in case the person has a female gender
	 */
	public boolean isFemale() {
		return (this.gender == Gender.Female);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Entry other) {
		// Compares two entries. Used to establish a sort order.
		if (surName.compareTo(other.surName) != 0) {
			return surName.compareTo(other.surName);
		} else {
			return firstName.compareTo(other.firstName);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer();
		
		// Name
		sb.append(this.firstName).append(" ").append(this.surName);
		
		// Gender
		sb.append(" (").append(this.isMale()?"M":"F").append("), ");
		
		// Contact
		if (this.contact instanceof PhoneNumber) {
			sb.append("phone: ").append(contact);
		} else if (this.contact instanceof EmailAddress) {
			sb.append("email: ").append(contact);
		}
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Entry))
			return false;
		Entry other = (Entry) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		return true;
	}
}
