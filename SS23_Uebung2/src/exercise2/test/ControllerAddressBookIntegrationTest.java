/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker, Theo Vassiliou and Diana Serbanescu
 * Technische Universität Berlin
 */
package exercise2.test;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import exercise2.addressbook.controller.AddressBookController;
import exercise2.addressbook.controller.AddressBookControllerImpl;
import exercise2.addressbook.controller.ParameterException;
import exercise2.addressbook.model.AddressBookModel;
import exercise2.addressbook.model.AddressBookModelImpl;
import exercise2.addressbook.model.SizeLimitReachedException;
import exercise2.addressbook.model.Entry;
import exercise2.addressbook.model.Gender;
import exercise2.addressbook.model.PhoneNumber;
import exercise2.addressbook.model.EmailAddress;

/**
 * Uebung 2 - Komponenten und Integrationstest
 * Integration Test für Addressbook und Controller.
 * 
 * Bitte Nummer der Gruppe eintragen: 23
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
public class ControllerAddressBookIntegrationTest {

	// Location of the address book file
	private static final File addressBookFile = new File("contacts.xml");
		
	/*
	 *  Aufgabe 4
	 *  Programmieren Sie einen Integrationstest für AddressBookModel und AddressBookController.
	 *  Testen Sie ob die Methoden des exercise2.addressbook.controller.AddressBookController Interface zu den erwarteten Resultate im Addressbuch führen.
	 *  Testen Sie intensiv und schreiben Sie MINDESTENS einen Testfall pro Methode des interfaces. Es sind Fehler zu finden.  
	 */
	
	// Model component for the test
	AddressBookModel model;
	
	// View component for the test
	AddressBookViewMockUp view;
	
	// Controller component for the test
	AddressBookController controller;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Instantiate and wire components
		this.model = new AddressBookModelImpl(addressBookFile);
		this.view = new AddressBookViewMockUp();
		this.controller = new AddressBookControllerImpl(model, view);
	}

	@Test
	public void testAddEntry() {
		try {
			this.controller.add("Max", "Mustermann", "M", "12345", null);
        } catch (ParameterException | SizeLimitReachedException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
		Entry entry = new Entry("Mustermann", "Max", Gender.Male, new PhoneNumber(12345));
		assertEquals(this.model.getEntries().size(), 1);
		assertTrue(this.model.getEntries().contains(entry));
	}
	
	@Test
	public void testAddDuplicateEntry() {
		try {
			this.controller.add("Max", "Mustermann", "M", "12345", null);
			this.controller.add("Max", "Mustermann", "F", null, "max@mustermann.de");
        } catch (ParameterException | SizeLimitReachedException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
		assertEquals(this.model.getEntries().size(), 1);
	}
	
	@Test
	public void testRemove() {
		try {
			this.model.load();
		} catch (IOException e) {
			fail("Unexpected exception thrown: " + e.getMessage());
		}
		Entry entry = new Entry("Karlo", "Kater", Gender.Male, new EmailAddress("karlo@knast.org"));
		assertTrue(model.getEntries().contains(entry));
		this.controller.remove(4);
		assertFalse(model.getEntries().contains(entry));
	}
	
	@Test
	public void testErase() {
		try {
			this.model.load();
		} catch (IOException e) {
			fail("Unexpected exception thrown: " + e.getMessage());
		}
		assertEquals(this.model.getEntries().size(), 9);
		this.controller.erase();
		assertEquals(this.model.getEntries().size(), 0);
	}
}
