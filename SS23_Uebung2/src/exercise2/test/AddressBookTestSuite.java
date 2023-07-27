package exercise2.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Uebung 2 - Komponenten und Integrationstest
 * TestSuite für Addressbook und Controller.
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

@RunWith(Suite.class)
@SuiteClasses({ AddressBookControllerTest.class, ControllerAddressBookIntegrationTest.class })
public class AddressBookTestSuite {
}
