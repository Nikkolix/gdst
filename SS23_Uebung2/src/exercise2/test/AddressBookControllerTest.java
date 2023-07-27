/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker, Theo Vassiliou and Diana Serbanescu
 * Technische Universität Berlin
 */
package exercise2.test;

import org.junit.*;
import static org.junit.Assert.*;

import exercise2.addressbook.controller.AddressBookController;
import exercise2.addressbook.controller.AddressBookControllerImpl;
import exercise2.addressbook.controller.ParameterException;
import exercise2.addressbook.model.SizeLimitReachedException;


/**
 * Uebung 2 - Komponenten und Integrationstest
 * Komponententests für den Controller
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
public class AddressBookControllerTest {
	
	/*
	 *  Aufgabe 3
	 *  Führen Sie im Rahmen eines Komponententests der Klasse exercise2.addressbook.controller.AddressBookControllerImpl einen Test der Methode add(...) durch.
	 *  Schreiben Sie für die model und view Komponenten Mock-Up Klassen und verwenden Sie dies im Komponententest der AddressBookController Komponente.
	 *  Testen Sie die add() Methode auf Herz und Nieren - es sind durchaus Fehler zu finden.
	 */
	
	// Model component for the test
	AddressBookModelMockUp model;
	
	// View component for the test
	AddressBookViewMockUp view;
	
	// Controller component for the test
	AddressBookController controller;
	
	/**
	 * Set up test system
	 */
	@Before
	public void setUp() {
		// Instantiate and wire components
		this.model = new AddressBookModelMockUp();
		this.view = new AddressBookViewMockUp();
		this.controller = new AddressBookControllerImpl(model, view);
	}
	
	@Test
	public void validInputPhoneM() {
		try {
			this.controller.add("Max", "Mustermann", "M", "12345", null);
        } catch (ParameterException | SizeLimitReachedException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
	}
	
	@Test
	public void validInputEmailM() {
		try {
			this.controller.add("Max", "Mustermann", "M", null, "max@mustermann.de");
        } catch (ParameterException | SizeLimitReachedException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
	}
	
	@Test
	public void validInputPhoneF() {
		try {
			this.controller.add("Max", "Mustermann", "F", "12345", null);
        } catch (ParameterException | SizeLimitReachedException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
	}
	
	@Test
	public void validInputEmailF() {
		try {
			this.controller.add("Max", "Mustermann", "F", null, "max@mustermann.de");
        } catch (ParameterException | SizeLimitReachedException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
	}
	
	@Test
	public void invalidFirstNameEmpty() {
		try {
			this.controller.add("", "Mustermann", "M", "12345", null);
			fail("Expected to have thrown: ParameterException");
        } catch (SizeLimitReachedException e) {
        	fail("Unexpected exception thrown: " + e.getMessage());
        } catch (ParameterException e) {}
	}
	
	@Test
	public void invalidLastNameEmpty() {
		try {
			this.controller.add("Max", "", "M", "12345", null);
			fail("Expected to have thrown: ParameterException");
        } catch (SizeLimitReachedException e) {
        	fail("Unexpected exception thrown: " + e.getMessage());
        } catch (ParameterException e) {}
	}
	
	@Test
	public void invalidFirstNameNull() {
		try {
			this.controller.add(null, "Mustermann", "M", "12345", null);
			fail("Expected to have thrown: ParameterException");
        } catch (SizeLimitReachedException e) {
        	fail("Unexpected exception thrown: " + e.getMessage());
        } catch (ParameterException e) {}
	}
	
	@Test
	public void invalidLastNameNull() {
		try {
			this.controller.add("Max", null, "M", "12345", null);
			fail("Expected to have thrown: ParameterException");
        } catch (SizeLimitReachedException e) {
        	fail("Unexpected exception thrown: " + e.getMessage());
        } catch (ParameterException e) {}
	}
	
	@Test
	public void invalidGender() {
		try {
			this.controller.add("Max", "Mustermann", "X", "12345", null);
			fail("Expected to have thrown: ParameterException");
        } catch (SizeLimitReachedException e) {
        	fail("Unexpected exception thrown: " + e.getMessage());
        } catch (ParameterException e) {}
	}
	
	@Test
	public void invalidGenderNonCapitalizedM() {
		try {
			this.controller.add("Max", "Mustermann", "m", "12345", null);
			fail("Expected to have thrown: ParameterException");
        } catch (SizeLimitReachedException e) {
        	fail("Unexpected exception thrown: " + e.getMessage());
        } catch (ParameterException e) {}
	}
	
	@Test
	public void invalidGenderNonCapitalizedF() {
		try {
			this.controller.add("Max", "Mustermann", "f", "12345", null);
			fail("Expected to have thrown: ParameterException");
        } catch (SizeLimitReachedException e) {
        	fail("Unexpected exception thrown: " + e.getMessage());
        } catch (ParameterException e) {}
	}
	
	@Test
	public void invalidGenderMF() {
		try {
			this.controller.add("Max", "Mustermann", "MF", "12345", null);
			fail("Expected to have thrown: ParameterException");
        } catch (SizeLimitReachedException e) {
        	fail("Unexpected exception thrown: " + e.getMessage());
        } catch (ParameterException e) {}
	}
	
	@Test
	public void invalidGenderEmpty() {
		try {
			this.controller.add("Max", "Mustermann", "", "12345", null);
			fail("Expected to have thrown: ParameterException");
        } catch (SizeLimitReachedException e) {
        	fail("Unexpected exception thrown: " + e.getMessage());
        } catch (ParameterException e) {}
	}
	
	@Test
	public void invalidGenderNull() {
		try {
			this.controller.add("Max", "Mustermann", null, "12345", null);
			fail("Expected to have thrown: ParameterException");
        } catch (SizeLimitReachedException e) {
        	fail("Unexpected exception thrown: " + e.getMessage());
        } catch (ParameterException e) {
        	
        } catch (NullPointerException e) {
        	fail("Unexpected exception thrown: " + e.getMessage());
        }
	}
	
	@Test
	public void invalidPhoneNotNumber() {
		try {
			this.controller.add("Max", "Mustermann", "M", "T12345", null);
			fail("Expected to have thrown: ParameterException");
        } catch (SizeLimitReachedException e) {
        	fail("Unexpected exception thrown: " + e.getMessage());
        } catch (ParameterException e) {
        	
        } catch (NumberFormatException e) {
        	fail("Unexpected exception thrown: " + e.getMessage());
        }
	}
	
	@Test
	public void invalidPhoneNegativ() {
		try {
			this.controller.add("Max", "Mustermann", "M", "-12345", null);
			fail("Expected to have thrown: ParameterException");
        } catch (SizeLimitReachedException e) {
        	fail("Unexpected exception thrown: " + e.getMessage());
        } catch (ParameterException e) {}
	}
	
	@Test
	public void invalidPhoneNull() {
		try {
			this.controller.add("Max", "Mustermann", "M", "0", null);
			fail("Expected to have thrown: ParameterException");
        } catch (SizeLimitReachedException e) {
        	fail("Unexpected exception thrown: " + e.getMessage());
        } catch (ParameterException e) {}
	}
	
	@Test
	public void invalidEmailAndPhoneSpecified() {
		try {
			this.controller.add("Max", "Mustermann", "M", "12345", "max@mustermann.de");
			fail("Expected to have thrown: ParameterException");
        } catch (SizeLimitReachedException e) {
        	fail("Unexpected exception thrown: " + e.getMessage());
        } catch (ParameterException e) {}
	}
	
	@Test
	public void invalidEmailNorPhoneSpecified() {
		try {
			this.controller.add("Max", "Mustermann", "M", null, null);
			fail("Expected to have thrown: ParameterException");
        } catch (SizeLimitReachedException e) {
        	fail("Unexpected exception thrown: " + e.getMessage());
        } catch (ParameterException e) {}
	}
	
	@Test
	public void sizeLimitExceptionThrown() {
		try {
			this.controller.add("Max", "Mustermann", "M", "12345", null);
        } catch (ParameterException | SizeLimitReachedException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
		try {
			this.controller.add("Max", "Mustermann", "M", "12345", null);
			fail("Expected to have thrown: SizeLimitReachedException");
        } catch (ParameterException e) {
        	fail("Unexpected exception thrown: " + e.getMessage());
        } catch (SizeLimitReachedException e) {}
	}
	
}
