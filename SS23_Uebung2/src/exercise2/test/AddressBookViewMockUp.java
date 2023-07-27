/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker, Theo Vassiliou and Diana Serbanescu
 * Technische Universität Berlin
 */
package exercise2.test;

import exercise2.addressbook.controller.AddressBookController;
import exercise2.addressbook.model.AddressBookAccess;
import exercise2.addressbook.view.AddressBookView;

/**
 * Uebung 2 - Komponenten und Integrationstest
 * Mock-Up für den AddressBookView
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
public class AddressBookViewMockUp implements AddressBookView {

	@Override
	public void create(AddressBookAccess model, AddressBookController controller) {
		return;
	}
	
	@Override
	public void refresh() {
		return;
	}
}
