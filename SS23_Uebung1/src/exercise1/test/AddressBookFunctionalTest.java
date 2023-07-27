/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Theo Vassiliou
 * Technische Universität Berlin
 */
package exercise1.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import exercise1.addressbook.model.AddressBook;
import exercise1.addressbook.model.Contact;
import exercise1.addressbook.model.EmailAddress;
import exercise1.addressbook.model.Entry;
import exercise1.addressbook.model.Gender;
import exercise1.addressbook.model.PhoneNumber;
import exercise1.addressbook.model.SizeLimitReachedException;

/**
 * Uebung 1 - Grundlagen des Testens mit JUnit
 * 
 * Bitte Nummer der Gruppe eintragen: 23
 * 
 * Bitte Gruppenmitglieder eintragen:
 * 
 * @author Ella Friederike Bredow
 * @author Hok Kai John Cheung
 * @author Sonja Höhmann
 * @author Luca Garriet Janßen
 * @author Niklas Markus Keitsch
 * @author Paul Michael Kilian
 * @author Jakob Krauskopf
 * @author Luca Benedict Lichterman
 * @author Hanna Leoni Riegel
 * @author Merlin Schumann
 */
public class AddressBookFunctionalTest {

	// The component under test
	private AddressBook addressBook;

	/*
	 * Aufgabe 3a) Schreiben Sie eine Methode zum Aufsetzen der Testumgebung
	 * ("Fixture"). Diese Methode soll automatisch vor jedem einzelnen JUnit
	 * Testfall ausgeführt werden. Innerhalb der Methode soll mindestens ein
	 * neues AddressBook Objekt angelegt und im Attribut "addressBook"
	 * gepeichert werden.
	 */
	@Before
	public void setUp() {
		this.addressBook = new AddressBook();
	}


	/*
	 * Aufgabe 3b) Schreiben Sie einen JUnit Testfall zum überprüfen der
	 * Funktionalität der addEntry() Methode.
	 */
	@Test
	public void testAddEntry() {
		try {
			Entry entry = new Entry("SurName", "FirstName", Gender.Male, null);
			
			assertFalse(this.addressBook.getEntries().contains(entry));
			
			assertTrue(this.addressBook.addEntry(entry));
			
			assertTrue(this.addressBook.getEntries().contains(entry));
			
			assertFalse(this.addressBook.addEntry(entry));
			
		} catch (SizeLimitReachedException e) {
			fail("size limit reached exception");
		}
	}


	/*
	 * Aufgabe 3c) Schreiben Sie einen JUnit Testfall zum überprüfen der
	 * Funktionalität der getEntry() Methode.
	 */
	@Test
	public void testGetEntry() {
		try {
			Entry entry = new Entry("SurName", "FirstName", Gender.Male, null);
			
			this.addressBook.addEntry(entry);
			
			assertEquals(entry,this.addressBook.getEntry("SurName", "FirstName"));
			
			assertNull(this.addressBook.getEntry("Non", "Exisiting"));
			
		} catch (SizeLimitReachedException e) {
			fail("size limit reached exception");
		}
	}

	
}
